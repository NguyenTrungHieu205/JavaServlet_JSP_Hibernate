package servlet;

import entity.DongSanPham;
import entity.MauSac;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.MauSacRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletMauSac", value = {
        "/mau-sac/hien-thi",
        "/mau-sac/add",
        "/mau-sac/delete",
        "/mau-sac/update",
        "/mau-sac/detail"
})
public class ServletMauSac extends HttpServlet {
    MauSacRepository mauSacRepository;
    public ServletMauSac(){
        mauSacRepository = new MauSacRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            hienthiMauSac(request,response);
        }else if(uri.contains("delete")){
            deleteMauSac(request,response);
        }else if(uri.contains("detail")){
            detailMauSac(request,response);
        }
    }

    private void detailMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        MauSac s = mauSacRepository.getOne(id);
        request.setAttribute("listMX", s);
        request.getRequestDispatcher("/view/detail/MauSacDetail.jsp").forward(request, response);
    }

    private void deleteMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        mauSacRepository.deleteMauSac(id);
        response.sendRedirect("/mau-sac/hien-thi");
    }

    private void hienthiMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<MauSac> list = mauSacRepository.getAll();
        request.setAttribute("listMX", list);
        request.getRequestDispatcher("/view/MauSac.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            addMauSac(request,response);
        }else if(uri.contains("update")){
            updateMauSac(request,response);
        }
    }

    private void updateMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("pass");
        String ten = request.getParameter("name");
        MauSac cv = new MauSac(id,ma,ten);
        mauSacRepository.updateMauSac(cv);
        response.sendRedirect("/mau-sac/hien-thi");
    }

    private void addMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //String id = request.getParameter("id");
        String ma = request.getParameter("pass");
        String ten = request.getParameter("name");
        MauSac cv = new MauSac(ma,ten);
        mauSacRepository.addMauSac(cv);
        response.sendRedirect("/mau-sac/hien-thi");
    }
}
