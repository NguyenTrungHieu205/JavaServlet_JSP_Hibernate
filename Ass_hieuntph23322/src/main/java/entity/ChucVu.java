package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ChucVu")
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "Ma")
    private String Ma;

    @Column(name = "Ten")
    private String Ten;

    @OneToMany(mappedBy = "chucVu", fetch = FetchType.LAZY)
    private List<NhanVien> nhanViens;

    public ChucVu() {
    }

    public ChucVu(String id) {
        this.id = id;
    }

    public ChucVu(String id, String ma, String ten) {
        this.id = id;
        Ma = ma;
        Ten = ten;
    }

    public ChucVu(String ma, String ten) {
        Ma = ma;
        Ten = ten;
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
}
