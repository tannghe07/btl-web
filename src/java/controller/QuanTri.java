/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DonHangDAO;
import dao.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
import model.DonHang;
import model.SanPham;

/**
 *
 * @author
 */
@WebServlet(name = "QuanTri", urlPatterns = {"/quan-tri"})
public class QuanTri extends HttpServlet {
    
    private SanPhamDAO SanPhamDAO;
    private DonHangDAO DonHangDAO;
    public QuanTri() {
        SanPhamDAO = new SanPhamDAO();
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
        try {
            dsSanPham(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(QuanTri.class.getName()).log(Level.SEVERE, null, ex);
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
            taoSp(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(QuanTri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void dsSanPham(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<SanPham> danhsachSp = SanPhamDAO.danhSachSp();
        
        List<DonHang> dsDonHang = DonHangDAO.danhSachDh();

        request.setAttribute("danhsachSp", danhsachSp);
        request.setAttribute("dsDonHang", dsDonHang);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/quantri.jsp");
        dispatcher.forward(request, response);
    }
    
    private void taoSp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String ten = request.getParameter("ten");
        String mota = request.getParameter("mota");
        String anh = request.getParameter("anh");
        int gia = Integer.parseInt(request.getParameter("gia"));
        int soluong = 1;
        SanPham _sp = new SanPham(ten, mota, anh, gia, soluong);

        SanPhamDAO.taoSp(_sp);

        List<SanPham> danhsachSp = SanPhamDAO.danhSachSp();
        request.setAttribute("danhsachSp", danhsachSp);
        System.out.println(request.getRequestURL());
        response.sendRedirect("quan-tri");
    }
    
}
