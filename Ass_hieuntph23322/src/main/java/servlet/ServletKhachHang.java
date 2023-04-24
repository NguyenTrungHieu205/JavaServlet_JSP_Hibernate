package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.KhachHangRepository;
import entity.KhachHang;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

@WebServlet(name = "ServletKhachHang", value = {"/khach-hang/hien-thi",
        "/khach-hang/add",
        "/khach-hang/delete",
        "/khach-hang/update",
        "/khach-hang/detail"})
public class ServletKhachHang extends HttpServlet {
    KhachHangRepository khachHangRepository;
    public ServletKhachHang(){
        khachHangRepository = new KhachHangRepository();
    }
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            hienthiKH(request,response);
        }else if(uri.contains("delete")){
            deleteKH(request,response);
        }else if(uri.contains("detail")){
            detailKH(request,response);
        }
    }

    private void detailKH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        KhachHang s = khachHangRepository.getOne(id);
        request.setAttribute("listKH", s);
        String ngaySinh = simpleDateFormat.format(s.getNgaySinh());
        request.setAttribute("ngaySinh", ngaySinh);
        request.getRequestDispatcher("/view/detail/KhachHangDetail.jsp").forward(request, response);
    }

    private void deleteKH(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        khachHangRepository.deleteKhachHang(id);
        response.sendRedirect("/khach-hang/hien-thi");
    }

    private void hienthiKH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<KhachHang> list = khachHangRepository.getAll();
        request.setAttribute("listKH", list);
        request.getRequestDispatcher("/view/KhachHang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            addKhachHang(request,response);
        }else if(uri.contains("update")){
            updateKhachHang(request,response);
        }
    }

    private void updateKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("pass");
        String name = request.getParameter("name");
        String fistname = request.getParameter("fistname");
        String lastname = request.getParameter("lastname");
        Date date = Date.valueOf(request.getParameter("date")) ;
        String phonenumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String password = request.getParameter("password");
        KhachHang kh = new KhachHang(id,ma,name,fistname,lastname,date,phonenumber,address,city,country,password);
        khachHangRepository.updateKhachHang(kh);
        response.sendRedirect("/khach-hang/hien-thi");
    }

    private void addKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //String id = request.getParameter("id");
        String ma = request.getParameter("pass");
        String name = request.getParameter("name");
        String fistname = request.getParameter("fistname");
        String lastname = request.getParameter("lastname");
        Date date = Date.valueOf(request.getParameter("date")) ;
        String phonenumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String password = request.getParameter("password");
        KhachHang kh = new KhachHang(ma,name,fistname,lastname,date,phonenumber,address,city,country,password);
        khachHangRepository.addKhachHang(kh);
        response.sendRedirect("/khach-hang/hien-thi");
    }
}
