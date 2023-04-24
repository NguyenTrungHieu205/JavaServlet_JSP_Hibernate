package servlet;

import entity.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

@WebServlet(name = "ServletChiTietSP", value = {
        "/chi-tiet-san-pham/hien-thi",
        "/chi-tiet-san-pham/add",
        "/chi-tiet-san-pham/delete",
        "/chi-tiet-san-pham/update",
        "/chi-tiet-san-pham/detail"


})
public class ServletChiTietSP extends HttpServlet {
    ChiTietSPRepository chiTietSPRepository;
    SanPhamRepository sanPhamRepository;
    MauSacRepository mauSacRepository;
    NSXRepository nsxRepository;
    DongSPRepository dongSPRepository;
    public ServletChiTietSP(){
        chiTietSPRepository = new ChiTietSPRepository();
        sanPhamRepository = new SanPhamRepository();
        mauSacRepository = new MauSacRepository();
        nsxRepository = new NSXRepository();
        dongSPRepository = new DongSPRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            hienthiChiTietSP(request,response);
        }else if(uri.contains("delete")){
            deleteChiTieSP(request,response);
        }else if(uri.contains("detail")){
            detailChiTietSP(request,response);
       }

    }

    private void detailChiTietSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChiTietSanPham s = chiTietSPRepository.getOne(id);
        request.setAttribute("listSP", s);
        request.getRequestDispatcher("/view/detail/ChiTietSanPhamDetail.jsp").forward(request, response);
    }

    private void deleteChiTieSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        chiTietSPRepository.deleteChiTietSanPham(id);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi");
    }


    private void hienthiChiTietSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ChiTietSanPham> list = chiTietSPRepository.getAll();
        request.setAttribute("listCTSP", list);

        ArrayList<SanPham> listSP = sanPhamRepository.getAll();
        request.setAttribute("listSP", listSP);

        ArrayList<MauSac> listMS = mauSacRepository.getAll();
        request.setAttribute("listMX", listMS);

        ArrayList<NSX> listNSX = nsxRepository.getAll();
        request.setAttribute("listNSX", listNSX);

        ArrayList<DongSanPham> listDSP = dongSPRepository.getAll();
        request.setAttribute("listDSP", listDSP);

        request.getRequestDispatcher("/view/ChiTietSanPham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            addChiTietSanPham(request,response);
        }else if(uri.contains("update")){
            updateChiTietSanPham(request,response);
        }
    }

    private void updateChiTietSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String idSP = request.getParameter("idSP");
        SanPham sanPham = new SanPham(idSP);
        String idNSX = request.getParameter("idNSX");
        NSX nsx = new NSX(idNSX);
        String idMX = request.getParameter("idMX");
        MauSac mauSac = new MauSac(idMX);
        String idDSP = request.getParameter("idDSP");
        DongSanPham dongSanPham = new DongSanPham(idDSP);
        Integer namBH = Integer.parseInt(request.getParameter("date"));
        String moTa = request.getParameter("status");
        Integer number = Integer.parseInt(request.getParameter("number"));
        BigDecimal giaNhap = BigDecimal.valueOf(Long.valueOf(request.getParameter("getMoney")));
        BigDecimal giaBan = BigDecimal.valueOf(Long.valueOf(request.getParameter("outMoney")));
        ChiTietSanPham sp = new ChiTietSanPham(id,sanPham,nsx,dongSanPham,mauSac,namBH,moTa,number,giaNhap,giaBan);
        chiTietSPRepository.updateCTSP(sp);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi");
    }

    private void addChiTietSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idSP = request.getParameter("idSP");
        SanPham sanPham = new SanPham(idSP);
        String idNSX = request.getParameter("idNSX");
        NSX nsx = new NSX(idNSX);
        String idMX = request.getParameter("idMX");
        MauSac mauSac = new MauSac(idMX);
        String idDSP = request.getParameter("idDSP");
        DongSanPham dongSanPham = new DongSanPham(idDSP);
        Integer namBH = Integer.parseInt(request.getParameter("date"));
        String moTa = request.getParameter("status");
        Integer number = Integer.parseInt(request.getParameter("number"));
        BigDecimal giaNhap = BigDecimal.valueOf(Long.valueOf(request.getParameter("getMoney")));
        BigDecimal giaBan = BigDecimal.valueOf(Long.valueOf(request.getParameter("outMoney")));
        ChiTietSanPham sp = new ChiTietSanPham(sanPham,nsx,dongSanPham,mauSac,namBH,moTa,number,giaNhap,giaBan);
        chiTietSPRepository.addCTSP(sp);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi");
    }
}
