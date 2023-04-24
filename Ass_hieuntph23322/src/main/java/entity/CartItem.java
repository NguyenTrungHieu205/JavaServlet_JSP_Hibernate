package entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartItem {
    private String id;
    private String ten;
    private Integer soLuong = 1;
    private BigDecimal giaBan;

    public CartItem() {
    }

    public CartItem(String id, String ten, Integer soLuong, BigDecimal giaBan) {
        this.id = id;
        this.ten = ten;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }
    @Override
    public String toString() {
        return "CartItem{" +
                "productId='" + id + '\'' +
                ", productName='" + ten + '\'' +
                ", soluong=" + soLuong + '\'' +
                ", giaban=" + giaBan +
                '}';
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }
}
