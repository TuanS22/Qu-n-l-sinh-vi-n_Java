package leanhtuan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "t_sinhvien")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "masv")
	 private Long masv;
	@Column(name = "hoten")
	 private String hoten;
	 @Column(name = "tenkhoa")
	 private String tenkhoa;
	 @Column(name = "gioitinh")
	 private String gioitinh;
	 @Column(name = "diemtin")
	 private float diemtin;
	 
	 @Transient
	 private String diemthi;

	public Student() {
		super();
	}

	public Student(String hoten, String tenkhoa, String gioitinh, float diemtin, String diemthi) {
		super();
		this.hoten = hoten;
		this.tenkhoa = tenkhoa;
		this.gioitinh = gioitinh;
		this.diemtin = diemtin;
		this.diemthi = diemthi;
	}

	public Student(Long masv, String hoten, String tenkhoa, String gioitinh, float diemtin, String diemthi) {
		super();
		this.masv = masv;
		this.hoten = hoten;
		this.tenkhoa = tenkhoa;
		this.gioitinh = gioitinh;
		this.diemtin = diemtin;
		this.diemthi = diemthi;
	}

	public Long getMasv() {
		return masv;
	}

	public void setMasv(Long masv) {
		this.masv = masv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getTenkhoa() {
		return tenkhoa;
	}

	public void setTenkhoa(String tenkhoa) {
		this.tenkhoa = tenkhoa;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public float getDiemtin() {
		return diemtin;
	}

	public void setDiemtin(float diemtin) {
		this.diemtin = diemtin;
	}

	public String getDiemthi() {
		return diemthi;
	}

	public void setDiemthi(String diemthi) {
		this.diemthi = diemthi;
	}
	 
	 
}
