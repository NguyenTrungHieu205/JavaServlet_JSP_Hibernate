package servlet;

import entity.ChucVu;
import entity.CuaHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.CuaHangRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletCuaHang", value = {"/cua-hang/hien-thi",
            "/cua-hang/add",
            "/cua-hang/delete",
            "/cua-hang/update",
            "/cua-hang/detail"})
public class ServletCuaHang extends HttpServlet {
    CuaHangRepository cuaHangRepository;
    public ServletCuaHang(){
        cuaHangRepository = new CuaHangRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            hienThiCuaHang(request,response);
        }else if(uri.contains("delete")){
            deleteCuaHang(request,response);
        }else if(uri.contains("detail")){
            detailCuaHang(request,response);
        }
    }

    private void detailCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CuaHang s = cuaHangRepository.getOne(id);
        request.setAttribute("listCH", s);
        request.getRequestDispatcher("/view/detail/CuaHangDetail.jsp").forward(request, response);
    }

    private void deleteCuaHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        cuaHangRepository.deleteCuaHang(id);
        response.sendRedirect("/cua-hang/hien-thi");
    }

    private void hienThiCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<CuaHang> list = cuaHangRepository.getAll();
        request.setAttribute("listCH", list);
        request.getRequestDispatcher("/view/CuaHang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            addCuaHang(request,response);
        }else if(uri.contains("update")){
            updateCuaHang(request,response);
        }
    }

    private void updateCuaHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("pass");
        String ten = request.getParameter("name");
        String diaChi = request.getParameter("address");
        String thanhPho = request.getParameter("city");
        String quocGia = request.getParameter("country");
        CuaHang cv = new CuaHang(id,ma,ten,diaChi,thanhPho,quocGia);
        cuaHangRepository.updateCuaHang(cv);
        response.sendRedirect("/cua-hang/hien-thi");
    }

    private void addCuaHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //String id = request.getParameter("id");
        String ma = request.getParameter("pass");
        String ten = request.getParameter("name");
        String diaChi = request.getParameter("address");
        String thanhPho = request.getParameter("city");
        String quocGia = request.getParameter("country");
        CuaHang cv = new CuaHang(ma,ten,diaChi,thanhPho,quocGia);
        cuaHangRepository.addCuaHang(cv);
        response.sendRedirect("/cua-hang/hien-thi");
    }
}
