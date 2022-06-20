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
import model.DonHang;

/**
 *
 * @author
 */
public class DonHangDAO {
    private String url = "jdbc:mysql://localhost:3306/btl-web?enabledTLSProtocols=TLSv1.2";
    private String user = "root";
    private String pass = "root";
    
    private static String TAO_DH = "INSERT INTO donhang" + "  (ten, diachi, sdt, sanpham, tien) VALUES "
            + " (?, ?, ?, ?, ?);";
    private static String DS_DH = "select * from donhang";
    
    public DonHangDAO() {
        
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
    
    public void taoDh(DonHang dh) throws SQLException {
        try ( Connection connection = ketNoi();  PreparedStatement preparedStatement = connection.prepareStatement(TAO_DH)) {
            preparedStatement.setString(1, dh.getTen());
            preparedStatement.setString(2, dh.getDiachi());
            preparedStatement.setString(3, dh.getSdt());
            preparedStatement.setString(4, dh.getSanpham());
            preparedStatement.setInt(5, dh.getTien());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public List<DonHang> danhSachDh() {
        List<DonHang> donHangs = new ArrayList<>();
        try {
            Connection connection = ketNoi();
            PreparedStatement preparedStatement = connection.prepareStatement(DS_DH);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int ma = rs.getInt("ma");
                String ten = rs.getString("ten");
                String diachi = rs.getString("diachi");
                String sdt = rs.getString("sdt");
                String sanpham = rs.getString("sanpham");
                int tien = Integer.parseInt(rs.getString("tien"));
                String thoigian = rs.getString("ngay");
                donHangs.add(new DonHang(ma, ten, diachi, sdt, sanpham, tien, thoigian));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return donHangs;
    }
}
