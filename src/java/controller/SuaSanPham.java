/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SanPham;

/**
 *
 * @author
 */
@WebServlet(name = "SuaSanPham", urlPatterns = {"/sua"})
public class SuaSanPham extends HttpServlet {

    private SanPhamDAO SanPhamDAO;
    private int ma;

    public SuaSanPham() {
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
        if (request.getParameter("ma") != null) {
            int _ma = Integer.parseInt(request.getParameter("ma"));
            ma = _ma;
            try {
                moTa(request, response, _ma);
            } catch (SQLException ex) {
            }
        } else {
            response.sendRedirect("quan-tri");
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
        try {
            suaSp(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SuaSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void suaSp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int _ma = ma;
        String ten = request.getParameter("ten");
        String mota = request.getParameter("mota");
        String anh = request.getParameter("anh");
        int gia = Integer.parseInt(request.getParameter("gia"));
        int soluong = 1;

        SanPham sp = new SanPham(ma, ten, mota, anh, gia, soluong);
        SanPhamDAO.suaSp(sp);
        response.sendRedirect("quan-tri");
    }

    private void moTa(HttpServletRequest request, HttpServletResponse response, int id)
            throws SQLException, IOException, ServletException {
        SanPham sp = SanPhamDAO.spTheoMa(id);
        if (sp != null) {
            request.setAttribute("sanpham", sp);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/sua-sp.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("quan-tri");
        }
    }
}
