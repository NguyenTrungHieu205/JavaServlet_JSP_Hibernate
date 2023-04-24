package servlet;

import entity.ChucVu;
import entity.CuaHang;
import entity.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ChucVuRepository;
import repository.CuaHangRepository;
import repository.NhanVienRepository;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

@WebServlet(name = "ServletNhanVien", value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/add",
        "/nhan-vien/delete",
        "/nhan-vien/update",
        "/nhan-vien/detail",
})
public class ServletNhanVien extends HttpServlet {
    NhanVienRepository nhanVienRepository;
    ChucVuRepository chucVuRepository;
    CuaHangRepository cuaHangRepository;

    public ServletNhanVien() {
        nhanVienRepository = new NhanVienRepository();
        chucVuRepository = new ChucVuRepository();
        cuaHangRepository = new CuaHangRepository();
    }
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            hienThiNhanVien(request, response);
        } else if (uri.contains("delete")) {
            deleteNhanVien(request, response);
        } else if (uri.contains("detail")) {
            detailNhanVien(request, response);
        }
    }

    private void detailNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhanVien s = nhanVienRepository.getOne(id);
        request.setAttribute("lisNV", s);
        String ngaySinh = simpleDateFormat.format(s.getNgaySinh());
        request.setAttribute("ngaySinh", ngaySinh);
        request.getRequestDispatcher("/view/detail/NhanVienDetail.jsp").forward(request, response);
    }

    private void deleteNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        nhanVienRepository.deleteNhanVien(id);
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    private void hienThiNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<NhanVien> list = nhanVienRepository.getAll();
        request.setAttribute("listNV", list);

        ArrayList<ChucVu> listCV = chucVuRepository.getAll();
        request.setAttribute("listCV", listCV);

        ArrayList<CuaHang> listCH = cuaHangRepository.getAll();
        request.setAttribute("listCH", listCH);


        request.getRequestDispatcher("/view/NhanVien.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            addNhanVien(request, response);
        } else if (uri.contains("update")) {
            updateNhanVien(request, response);
        }
    }

    private void updateNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        String name = request.getParameter("name");
        String firtname = request.getParameter("firtname");
        String lastname = request.getParameter("lastname");
        String gender = request.getParameter("gender");
        Date dateS = Date.valueOf(request.getParameter("date"));
        String address = request.getParameter("address");
        String phonenumber = request.getParameter("phonenumber");
        String password = request.getParameter("pass");
        String idCH = request.getParameter("idCH");
        CuaHang cuaHang = new CuaHang(idCH);
        String idCV = request.getParameter("idCV");
        ChucVu chucVu = new ChucVu(idCV);
        String idGuiBc = null;
        Integer status = Integer.parseInt(request.getParameter("status"));
        NhanVien nv = new NhanVien(id, pass, name, firtname, lastname, gender, dateS, address, phonenumber, password, cuaHang, chucVu, idGuiBc, status);
        nhanVienRepository.updateNhanVien(nv);
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    private void addNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        String name = request.getParameter("name");
        String firtname = request.getParameter("firtname");
        String lastname = request.getParameter("lastname");
        String gender = request.getParameter("gender");
        Date dateS = Date.valueOf(request.getParameter("date"));
        String address = request.getParameter("address");
        String phonenumber = request.getParameter("phonenumber");
        String password = request.getParameter("pass");
        String idCH = request.getParameter("idCH");
        CuaHang cuaHang = new CuaHang(idCH);
        String idCV = request.getParameter("idCV");
        ChucVu chucVu = new ChucVu(idCV);
        String idGuiBc = null;
        Integer status = Integer.parseInt(request.getParameter("status"));
        NhanVien nv = new NhanVien(pass, name, firtname, lastname, gender, dateS, address, phonenumber, password, cuaHang, chucVu, idGuiBc, status);
        nhanVienRepository.addNhanVien(nv);
        response.sendRedirect("/nhan-vien/hien-thi");
    }
}
