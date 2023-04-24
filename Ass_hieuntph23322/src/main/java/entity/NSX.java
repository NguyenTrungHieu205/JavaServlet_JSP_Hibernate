package entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "NSX")
public class NSX {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @OneToMany(mappedBy = "nsx", fetch = FetchType.LAZY)
    private List<ChiTietSanPham> chiTietSanPhams;

    public NSX() {
    }

    public NSX(String id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }

    public NSX(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public NSX(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
