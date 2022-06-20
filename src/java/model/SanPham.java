/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author
 */
public class SanPham implements Serializable {

    private int ma;
    private String ten, mota, anh;
    private int gia, soluong = 1;

    public SanPham(int ma, String ten, String mota, String anh, int gia, int soluong) {
        this.ma = ma;
        this.ten = ten;
        this.mota = mota;
        this.anh = anh;
        this.gia = gia;
        this.soluong = soluong;
    }

    public SanPham(String ten, String mota, String anh, int gia, int soluong) {
        this.ten = ten;
        this.mota = mota;
        this.anh = anh;
        this.gia = gia;
        this.soluong = soluong;
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

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "{" + "\"ma\":" + ma + ", \"ten\":" + "\"" + ten + "\"" + ", \"mota\":" + "\"" + mota + "\"" + ", \"anh\":" + "\"" + anh + "\"" + ", \"gia\":" + gia + ", \"soluong\":" + soluong + "}";
    }

}
