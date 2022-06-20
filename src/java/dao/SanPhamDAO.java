/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;

/**
 *
 * @author
 */
public class SanPhamDAO {
    private String url = "jdbc:mysql://localhost:3306/btl-web?enabledTLSProtocols=TLSv1.2";
    private String user = "root";
    private String pass = "root";

    private static String TAO_SP = "INSERT INTO sanpham" + "  (ten, anh, mota, gia, soluong) VALUES "
            + " (?, ?, ?, ?, ?);";

    private static String TIM_SP_THEO_MA = "select * from sanpham where ma =?";
    private static String LAY_TAT_CA_SP = "select * from sanpham";
    private static String XOA_SP = "delete from sanpham where ma = ?;";
    private static String SUA_SP = "update sanpham set ten = ?,anh= ?, mota =?, gia =?, soluong =? where ma = ?;";
    
    public SanPhamDAO() {
        
    }
    
    protected Connection ketNoi() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    
    public void taoSp(SanPham sp) throws SQLException {
        System.out.println(TAO_SP);
        // try-with-resource statement will auto close the connection.
        try ( Connection connection = ketNoi();  PreparedStatement preparedStatement = connection.prepareStatement(TAO_SP)) {
            preparedStatement.setString(1, sp.getTen());
            preparedStatement.setString(2, sp.getAnh());
            preparedStatement.setString(3, sp.getMota());
            preparedStatement.setInt(4, sp.getGia());
            preparedStatement.setInt(5, sp.getSoluong());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public SanPham spTheoMa(int ma) {
        SanPham sp = null;
        
        try ( Connection connection = ketNoi();
                  PreparedStatement preparedStatement = connection.prepareStatement(TIM_SP_THEO_MA);) {
            preparedStatement.setInt(1, ma);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String ten = rs.getString("ten");
                String anh = rs.getString("anh");
                String mota = rs.getString("mota");
                int gia = Integer.parseInt(rs.getString("gia"));
                int soluong = Integer.parseInt(rs.getString("soluong"));
                sp = new SanPham(ma, ten, mota, anh, gia, soluong);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sp;
    }
    
    public List<SanPham> danhSachSp() {
        List<SanPham> sanPhams = new ArrayList<>();
        try {
            Connection connection = ketNoi();
            PreparedStatement preparedStatement = connection.prepareStatement(LAY_TAT_CA_SP);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int ma = rs.getInt("ma");
                String ten = rs.getString("ten");
                String anh = rs.getString("anh");
                String mota = rs.getString("mota");
                int gia = Integer.parseInt(rs.getString("gia"));
                int soluong = Integer.parseInt(rs.getString("soluong"));
                sanPhams.add(new SanPham(ma, ten, mota, anh, gia, soluong));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sanPhams;
    }
    
    public boolean xoaSp(int ma) throws SQLException {
        boolean rowDeleted;
        try ( Connection connection = ketNoi();  PreparedStatement statement = connection.prepareStatement(XOA_SP);) {
            statement.setInt(1, ma);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
    public boolean suaSp(SanPham sp) throws SQLException {
        boolean rowUpdated;
        try ( Connection connection = ketNoi();  PreparedStatement statement = connection.prepareStatement(SUA_SP);) {
            statement.setString(1, sp.getTen());
            statement.setString(2, sp.getAnh());
            statement.setString(3, sp.getMota());
            statement.setDouble(4, sp.getGia());
            statement.setDouble(5, sp.getSoluong());
            statement.setInt(6, sp.getMa());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
