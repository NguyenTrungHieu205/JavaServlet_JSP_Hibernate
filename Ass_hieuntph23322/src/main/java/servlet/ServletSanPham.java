package servlet;

import entity.NSX;
import entity.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.SanPhamRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletSanPham", value = {
        "/san-pham/hien-thi",
        "/san-pham/add",
        "/san-pham/delete",
        "/san-pham/update",
        "/san-pham/detail",
})
public class ServletSanPham extends HttpServlet {
    SanPhamRepository sanPhamRepository;
    public ServletSanPham(){
        sanPhamRepository = new SanPhamRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            hienthiSP(request, response);
        }else if(uri.contains("delete")){
            deleteSP(request,response);
        }else if(uri.contains("detail")){
            detailSP(request,response);
        }
    }

    private void detailSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham s = sanPhamRepository.getOne(id);
        request.setAttribute("listSP", s);
        request.getRequestDispatcher("/view/detail/SanPhamDetail.jsp").forward(request, response);
    }

    private void deleteSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        sanPhamRepository.deleteSanPham(id);
        response.sendRedirect("/san-pham/hien-thi");
    }

    private void hienthiSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<SanPham> list = sanPhamRepository.getAll();
        request.setAttribute("listSP", list);
        request.getRequestDispatcher("/view/SanPham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            addSP(request, response);
        }else if(uri.contains("update")){
            updateSP(request,response);
        }
    }

    private void updateSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("pass");
        String ten = request.getParameter("name");
        SanPham cv = new SanPham(id,ma,ten);
        sanPhamRepository.updateSanPham(cv);
        response.sendRedirect("/san-pham/hien-thi");
    }

    private void addSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //String id = request.getParameter("id");
        String ma = request.getParameter("pass");
        String ten = request.getParameter("name");
        SanPham cv = new SanPham(ma,ten);
        sanPhamRepository.addSanPham(cv);
        response.sendRedirect("/san-pham/hien-thi");
    }
}
