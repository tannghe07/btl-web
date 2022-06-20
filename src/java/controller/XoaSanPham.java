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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author
 */
@WebServlet(name = "XoaSanPham", urlPatterns = {"/xoa"})
public class XoaSanPham extends HttpServlet {

    private SanPhamDAO SanPhamDAO;

    public XoaSanPham() {
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
            try {
                xoaSp(request, response);
                response.sendRedirect("quan-tri");

            } catch (SQLException ex) {
                Logger.getLogger(XoaSanPham.class.getName()).log(Level.SEVERE, null, ex);
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
    }

    private boolean xoaSp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int ma = Integer.parseInt(request.getParameter("ma"));
        boolean xoa = SanPhamDAO.xoaSp(ma);
        return xoa;
    }
}
