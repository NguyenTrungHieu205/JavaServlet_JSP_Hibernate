package servlet;

import entity.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ChiTietSPRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "ServletHienThi", value = {
        "/trang-chu",
        "/trang-cua-toi",
        "/login",
        "/detailChiTiet",
        "/gio-hang/cart",
        "/gio-hang/addGH",
        "/san-pham"
})
public class ServletHienThi extends HttpServlet {
    ChiTietSPRepository chiTietSPRepository;
    public ServletHienThi(){
        chiTietSPRepository = new ChiTietSPRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("trang-chu")){
            ArrayList<ChiTietSanPham> list = chiTietSPRepository.getAll();
            request.setAttribute("listCTSP", list);
            request.getRequestDispatcher("/view/TrangChu.jsp").forward(request,response);
        }else if(uri.contains("trang-cua-toi")){
            request.getRequestDispatcher("/view/TrangCuaToi.jsp").forward(request,response);
        }else if(uri.contains("san-pham")){
            ArrayList<ChiTietSanPham> list = chiTietSPRepository.getAll();
            request.setAttribute("listCTSP", list);
            request.getRequestDispatcher("/view/viewSanPhamBH.jsp").forward(request,response);
        }else if(uri.contains("login")){
            request.getRequestDispatcher("/view/login.jsp").forward(request,response);
        }else if(uri.contains("cart")){
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");//
            request.setAttribute("cart", cart);
            request.getRequestDispatcher("/view/cart.jsp").forward(request, response);
        }else if(uri.contains("addGH")){
            String productId = request.getParameter("id");
            ChiTietSanPham sanPham = chiTietSPRepository.getOne(productId);
            // Tạo đối tượng CartItem
            CartItem item = new CartItem();
            item.setId(productId);
            item.setTen(sanPham.getSanPham().getTen());
            //item.setSoLuong(1);
            item.setGiaBan(sanPham.getGiaBan());
            // Lấy giỏ hàng từ session
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");//
            // Nếu giỏ hàng chưa được tạo, tạo mới nó
            if (cart == null) {
                cart = new Cart();//
                session.setAttribute("cart", cart);
            }
            // Thêm sản phẩm vào giỏ hàng
            cart.addItem(item);
            // Chuyển hướng người dùng đến trang giỏ hàng
            response.sendRedirect("/gio-hang/cart");
            System.out.println(item);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
