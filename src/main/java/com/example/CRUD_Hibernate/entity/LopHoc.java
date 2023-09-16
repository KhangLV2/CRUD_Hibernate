package com.example.CRUD_Hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lop_hoc")
public class LopHoc {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_lop")
    private String maLop;

    @Column(name = "ten_lop")
    private String tenLop;

    @Column(name = "so_luong_sv")
    private Integer soLuong;

    @Column(name = "toa")
    private String toa;

    public LopHoc() {
    }

    public LopHoc(Long id, String maLop, String tenLop, Integer soLuong, String toa) {
        this.id = id;
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.soLuong = soLuong;
        this.toa = toa;
    }

    public LopHoc(String maLop, String tenLop, Integer soLuong, String toa) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.soLuong = soLuong;
        this.toa = toa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getToa() {
        return toa;
    }

    public void setToa(String toa) {
        this.toa = toa;
    }

    @Override
    public String toString() {
        return "LopHoc{" +
                "id=" + id +
                ", maLop='" + maLop + '\'' +
                ", tenLop='" + tenLop + '\'' +
                ", soLuong=" + soLuong +
                ", toa='" + toa + '\'' +
                '}';
    }
}
