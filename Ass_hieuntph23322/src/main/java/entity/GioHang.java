package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GioHang")
@AllArgsConstructor
@Data
public class GioHang {

//    List<GioHangChiTiet> gioHangChiTiets = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @OneToMany(mappedBy = "gioHang", fetch = FetchType.LAZY)
    private List<GioHangChiTiet> gioHangChiTiets = new ArrayList<>();

    @Column(name = "IdNV")
    private String idNV;

    @Column(name = "NgayTao")
    private BigDecimal ngayTao;

    @Column(name = "NgayThanhToan")
    private BigDecimal ngayThanhToan;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "TinhTrang")
    private Integer tinhTrang;


    public GioHang() {

    }


    public void addItem(GioHangChiTiet item) {
        // Kiểm tra xem sản phẩm đã có trong giỏ hàng chưa
        if(gioHangChiTiets != null){
            for (GioHangChiTiet i : gioHangChiTiets) {
                if (i.getId() == item.getId()) {
                    i.setSoLuong(i.getSoLuong() + 1);
                    return;
                }
            }
        }else{
            // Nếu chưa có, thêm sản phẩm mới vào giỏ hàng
            gioHangChiTiets.add(item);
        }


    }
}
