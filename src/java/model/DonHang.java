/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author
 */
public class DonHang implements Serializable {

    private int ma;
    private String ten, diachi, sdt;
    private String sanpham;
    private int tien;
    private String thoigian;

    public DonHang(int ma, String ten, String diachi, String sdt, String sanpham, int tien, String thoigian) {
        this.ma = ma;
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.sanpham = sanpham;
        this.tien = tien;
        this.thoigian = thoigian;
    }

    public DonHang(String ten, String diachi, String sdt, String sanpham, int tien) {
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.sanpham = sanpham;
        this.tien = tien;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getSanpham() {
        return sanpham;
    }

    public void setSanpham(String sanpham) {
        this.sanpham = sanpham;
    }

    public int getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }
    
    
    
    @Override
    public String toString() {
        return "{" + "\"ma\":" + ma + ", \"ten\":" + "\"" + ten + "\"" + ", \"diachi\":" + "\"" + diachi + "\"" + ", \"sdt\":" + "\"" + sdt + "\"" + ", \"sanpham\":" + sanpham + ", \"tien\":" + tien + ", \"thoigian\":" + "\"" + thoigian + "\"" + "}";
    }

}
