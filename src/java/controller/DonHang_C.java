/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import dao.DonHangDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DonHang;
import model.SanPham;

/**
 *
 * @author
 */
@WebServlet(name = "DonHang", urlPatterns = {"/don-hang"})
public class DonHang_C extends HttpServlet {

    private DonHangDAO DonHangDAO;

    public DonHang_C() {
        DonHangDAO = new DonHangDAO();
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

        List<SanPham> giohang = (List<SanPham>) session.getAttribute("cart");
        request.setAttribute("giohang", giohang);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/donhang.jsp");
        dispatcher.forward(request, response);
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
        try {
            taoDh(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DonHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void taoDh(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String ten = request.getParameter("ten");
        String diachi = request.getParameter("diachi");
        String sdt = request.getParameter("sdt");
        List<SanPham> giohang = (List<SanPham>) session.getAttribute("cart");
        String _giohang = new Gson().toJson(giohang);

        int tien = 0;
        for (SanPham i : giohang) {
            tien += i.getGia() * i.getSoluong();
        }

        DonHang _dh = new DonHang(ten, diachi, sdt, _giohang, tien);
        DonHangDAO.taoDh(_dh);
        session.setAttribute("cart", null);
        
//        List<DonHang> danhsachSp = DonHangDAO.danhSachDh();
//        request.setAttribute("danhSachDh", danhSachDh);
        response.sendRedirect("/btl-web");
    }

}
