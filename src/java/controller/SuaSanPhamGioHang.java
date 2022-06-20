/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SanPhamDAO;
import java.io.IOException;
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
@WebServlet(name = "SuaSanPhamGioHang", urlPatterns = {"/sua-so-luong"})
public class SuaSanPhamGioHang extends HttpServlet {

    private SanPhamDAO SanPhamDAO;

    public SuaSanPhamGioHang() {
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

        if (request.getParameter("ma") != null && request.getParameter("hanhdong") != null) {
            int ma = Integer.parseInt(request.getParameter("ma"));
            int hanhdong = Integer.parseInt(request.getParameter("hanhdong"));
            // 1: tang
            // 2: giam
            // 3: xoa

            List<SanPham> giohang = (List<SanPham>) session.getAttribute("cart");

            if (hanhdong == 3) {
                for (int i = 0; i < giohang.size(); i++) {
                    if (giohang.get(i).getMa() == ma) {
                        giohang.remove(i);
                    }
                }
            }

            if (hanhdong == 1) {
                for (int i = 0; i < giohang.size(); i++) {
                    if (giohang.get(i).getMa() == ma) {
                        int soluong = giohang.get(i).getSoluong();
                        int _soluong = soluong + 1;
                        giohang.get(i).setSoluong(_soluong);
                    }
                }
            }

            if (hanhdong == 2) {
                for (int i = 0; i < giohang.size(); i++) {
                    if (giohang.get(i).getMa() == ma) {
                        int soluong = giohang.get(i).getSoluong();
                        if (soluong == 1) {
                            giohang.remove(i);
                        } else {
                            int _soluong = soluong - 1;
                            giohang.get(i).setSoluong(_soluong);
                        }
                    }
                }
            }

            session.setAttribute("cart", giohang);
            response.sendRedirect("gio-hang");
        } else {
            response.sendRedirect("gio-hang");
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
