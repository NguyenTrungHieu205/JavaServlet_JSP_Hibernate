package servlet;

import entity.ChucVu;
import entity.DongSanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.DongSPRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletDongSP", value = {
        "/dong-sp/hien-thi",
        "/dong-sp/add",
        "/dong-sp/delete",
        "/dong-sp/update",
        "/dong-sp/detail"
})
public class ServletDongSP extends HttpServlet {
    DongSPRepository dongSPRepository;
    public ServletDongSP(){dongSPRepository = new DongSPRepository();};
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            hienthiDongSP(request,response);
        }else if(uri.contains("delete")){
            deleteDongSP(request,response);
        }else if(uri.contains("detail")){
            detailDongSP(request,response);
        }
    }

    private void detailDongSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DongSanPham s = dongSPRepository.getOne(id);
        request.setAttribute("listDSP", s);
        request.getRequestDispatcher("/view/detail/DongSPDetail.jsp").forward(request, response);
    }

    private void deleteDongSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        dongSPRepository.deleteDongSanPham(id);
        response.sendRedirect("/dong-sp/hien-thi");
    }

    private void hienthiDongSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<DongSanPham> list = dongSPRepository.getAll();
        request.setAttribute("listDSP", list);
        request.getRequestDispatcher("/view/DongSP.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            addDongSP(request,response);
        }else if(uri.contains("update")){
            updateDongSP(request,response);
        }
    }

    private void updateDongSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("pass");
        String ten = request.getParameter("name");
        DongSanPham cv = new DongSanPham(id,ma,ten);
        dongSPRepository.updateDongSanPham(cv);
        response.sendRedirect("/dong-sp/hien-thi");
    }

    private void addDongSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //String id = request.getParameter("id");
        String ma = request.getParameter("pass");
        String ten = request.getParameter("name");
        DongSanPham cv = new DongSanPham(ma,ten);
        dongSPRepository.addDongSanPham(cv);
        response.sendRedirect("/dong-sp/hien-thi");
    }
}
