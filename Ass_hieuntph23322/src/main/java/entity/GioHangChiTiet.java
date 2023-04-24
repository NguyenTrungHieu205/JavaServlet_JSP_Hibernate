package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "GioHangChiTiet")
@AllArgsConstructor
@Data
public class GioHangChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

//    @ManyToOne()
//    @JoinColumn(name = "IdChiTietSP")
//    private GioHangChiTiet gioHangChiTiet;
    @Column(name = "IdChiTietSP")
    private String tenSP;

    @ManyToOne()
    @JoinColumn(name = "IdGioHang")
    private GioHang gioHang;

    @Column(name = "SoLuong")
    private Integer soLuong = 1;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    @Column(name = "DonGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;

    public GioHangChiTiet() {

    }
}
