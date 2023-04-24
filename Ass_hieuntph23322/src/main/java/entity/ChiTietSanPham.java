package entity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "ChiTietSP")
public class ChiTietSanPham {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    @JoinColumn(name = "IdSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdNsx")
    private NSX nsx;

    @ManyToOne
    @JoinColumn(name = "IdDongSp")
    private DongSanPham dongSanPham;

    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;

    @Column(name = "NamBH")
    private Integer namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

//    @OneToMany(mappedBy = "gioHangChiTiet", fetch = FetchType.LAZY)
//    private List<GioHangChiTiet> gioHangChiTiets;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(SanPham sanPham, NSX nsx, DongSanPham dongSanPham, MauSac mauSac, Integer namBH, String moTa, Integer soLuongTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.sanPham = sanPham;
        this.nsx = nsx;
        this.dongSanPham = dongSanPham;
        this.mauSac = mauSac;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public ChiTietSanPham(String id, SanPham sanPham, NSX nsx, DongSanPham dongSanPham, MauSac mauSac, Integer namBH, String moTa, Integer soLuongTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.id = id;
        this.sanPham = sanPham;
        this.nsx = nsx;
        this.dongSanPham = dongSanPham;
        this.mauSac = mauSac;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public NSX getNsx() {
        return nsx;
    }

    public void setNsx(NSX nsx) {
        this.nsx = nsx;
    }

    public DongSanPham getDongSanPham() {
        return dongSanPham;
    }

    public void setDongSanPham(DongSanPham dongSanPham) {
        this.dongSanPham = dongSanPham;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public Integer getNamBH() {
        return namBH;
    }

    public void setNamBH(Integer namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }
}
