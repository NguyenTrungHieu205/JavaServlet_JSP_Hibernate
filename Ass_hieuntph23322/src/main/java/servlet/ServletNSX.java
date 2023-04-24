package servlet;

import entity.MauSac;
import entity.NSX;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.NSXRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletNSX", value = {
        "/nha-san-xuat/hien-thi",
        "/nha-san-xuat/add",
        "/nha-san-xuat/delete",
        "/nha-san-xuat/update",
        "/nha-san-xuat/detail",
})
public class ServletNSX extends HttpServlet {
    NSXRepository nsxRepository;
    public ServletNSX(){
        nsxRepository = new NSXRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            hienthiNSX(request, response);
        }else if(uri.contains("delete")){
            deleteNSX(request,response);
        }else if(uri.contains("detail")){
            detailNSX(request,response);
        }
    }

    private void detailNSX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NSX s = nsxRepository.getOne(id);
        request.setAttribute("listN", s);
        request.getRequestDispatcher("/view/detail/NSXDetail.jsp").forward(request, response);
    }

    private void deleteNSX(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        nsxRepository.deleteNSX(id);
        response.sendRedirect("/nha-san-xuat/hien-thi");
    }

    private void hienthiNSX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<NSX> list = nsxRepository.getAll();
        request.setAttribute("listNSX", list);
        request.getRequestDispatcher("/view/NSX.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            addNSX(request,response);
        }else if(uri.contains("update")){
            updateNSX(request,response);
        }
    }

    private void updateNSX(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("pass");
        String ten = request.getParameter("name");
        NSX cv = new NSX(id,ma,ten);
        nsxRepository.updateNSX(cv);
        response.sendRedirect("/nha-san-xuat/hien-thi");
    }

    private void addNSX(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //String id = request.getParameter("id");
        String ma = request.getParameter("pass");
        String ten = request.getParameter("name");
        NSX cv = new NSX(ma,ten);
        nsxRepository.addNSX(cv);
        response.sendRedirect("/nha-san-xuat/hien-thi");
    }
}
