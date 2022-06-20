/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SanPhamDAO;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "ChiTietSanPham", urlPatterns = {"/san-pham"})
public class ChiTietSanPham extends HttpServlet {

    private SanPhamDAO SanPhamDAO;

    public ChiTietSanPham() {
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
            int ma = Integer.parseInt(request.getParameter("ma"));
            try {
                moTa(request, response, ma);
            } catch (SQLException ex) {
                throw new ServletException(ex);
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

    private void moTa(HttpServletRequest request, HttpServletResponse response, int id)
            throws SQLException, IOException, ServletException {
        SanPham sp = SanPhamDAO.spTheoMa(id);
        if (sp != null) {
            request.setAttribute("sanpham", sp);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/sanpham.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("trang-chu");
        }
    }
}
