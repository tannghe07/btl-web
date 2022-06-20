/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SanPhamDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.SanPham;

/**
 *
 * @author
 */
@WebServlet(name = "CapNhatGioHang", urlPatterns = {"/cap-nhat-gio-hang"})
public class CapNhatGioHang extends HttpServlet {

    private SanPhamDAO SanPhamDAO;

    public CapNhatGioHang() {
        SanPhamDAO = new SanPhamDAO();
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (request.getParameter("ma") != null) {
            int ma = Integer.parseInt(request.getParameter("ma"));
            SanPham sp = SanPhamDAO.spTheoMa(ma);

            if (sp != null) {
                List<SanPham> cart = (List<SanPham>) session.getAttribute("cart");
                if (cart == null) {
                    List<SanPham> newCart = new ArrayList<>();
                    newCart.add(sp);
                    session.setAttribute("cart", newCart);

                } else {
                    cart.add(sp);
                    for (int i = 0; i < cart.size(); i++) {
                        int soluong = cart.get(i).getSoluong();
                        for (int j = i + 1; j < cart.size(); j++) {
                            if (cart.get(i).getMa() == cart.get(j).getMa()) {
                                soluong++;
                                cart.remove(j);
                                j--;
                                cart.get(i).setSoluong(soluong);
                            }
                        }
                    }
                    session.setAttribute("cart", cart);

                }
                
                response.sendRedirect("gio-hang");
                
            } else {
                response.sendRedirect("trang-chu");
            }
        } else {
            response.sendRedirect("trang-chu");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
