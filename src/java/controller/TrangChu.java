/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SanPhamDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "TrangChu", urlPatterns = {"/"})
public class TrangChu extends HttpServlet {

    private SanPhamDAO SanPhamDAO;
    public TrangChu() {
        SanPhamDAO = new SanPhamDAO();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        try {
            dsSanPham(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
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

//    private void dsSanPham(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        List<SanPham> danhsachSp = SanPhamDAO.danhSachSp();
//        request.setAttribute("danhsachSp", danhsachSp);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/index.jsp");
//        dispatcher.forward(request, response);
//    }
    private void dsSanPham(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<SanPham> danhsachSp = SanPhamDAO.danhSachSp();
        request.setAttribute("danhsachSp", danhsachSp);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/index.jsp");
        dispatcher.forward(request, response);
    }
    
}
