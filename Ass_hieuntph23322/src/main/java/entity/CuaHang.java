package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CuaHang")
public class CuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "Ma")
    private String Ma;

    @Column(name = "Ten")
    private String Ten;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "ThanhPho")
    private String thanhPho;

    @Column(name = "QuocGia")
    private String QuocGia;

    @OneToMany(mappedBy = "cuaHang", fetch = FetchType.LAZY)
    private List<NhanVien> nhanViens;

    public CuaHang() {
    }

    public CuaHang(String id) {
        this.id = id;
    }

    public CuaHang(String id, String ma, String ten, String diaChi, String thanhPho, String quocGia) {
        this.id = id;
        Ma = ma;
        Ten = ten;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        QuocGia = quocGia;
    }

    public CuaHang(String ma, String ten, String diaChi, String thanhPho, String quocGia) {
        Ma = ma;
        Ten = ten;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        QuocGia = quocGia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String ma) {
        Ma = ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getQuocGia() {
        return QuocGia;
    }

    public void setQuocGia(String quocGia) {
        QuocGia = quocGia;
    }
}
