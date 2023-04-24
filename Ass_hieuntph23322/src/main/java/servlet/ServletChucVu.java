package servlet;

import entity.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ChucVuRepository;
import entity.ChucVu;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletChucVu", value = {"/chuc-vu/hien-thi",
            "/chuc-vu/add",
            "/chuc-vu/update",
            "/chuc-vu/delete",
            "/chuc-vu/detail"})
public class ServletChucVu extends HttpServlet {
    ChucVuRepository chucVuRepository;
    public ServletChucVu(){
        chucVuRepository = new ChucVuRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            hienThiCV(request,response);
        }else if(uri.contains("delete")){
            deleteCV(request,response);
        }else if(uri.contains("detail")){
            detailCV(request,response);
        }
    }

    private void detailCV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChucVu s = chucVuRepository.getOne(id);
        request.setAttribute("cv", s);
        request.getRequestDispatcher("/view/detail/ChucVuDetail.jsp").forward(request, response);
    }

    private void deleteCV(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        chucVuRepository.deleteChucVu(id);
        response.sendRedirect("/chuc-vu/hien-thi");
    }

    private void hienThiCV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ChucVu> list = chucVuRepository.getAll();
        request.setAttribute("listCV", list);
        request.getRequestDispatcher("/view/ChucVu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            //String id = request.getParameter("id");
            String ma = request.getParameter("pass");
            String ten = request.getParameter("name");
            ChucVu cv = new ChucVu(ma,ten);
            chucVuRepository.addChucVu(cv);
            response.sendRedirect("/chuc-vu/hien-thi");
        }else if(uri.contains("update")){
            String id = request.getParameter("id");
            String ma = request.getParameter("pass");
            String ten = request.getParameter("name");
            ChucVu cv = new ChucVu(id,ma,ten);
            chucVuRepository.updateChucVu(cv);
            response.sendRedirect("/chuc-vu/hien-thi");
        }
    }
}
