package leanhtuan.service;

import java.util.List;

import leanhtuan.model.Student;

public interface StudentService {
	List<Student> getAllSinhVien();
	void saveSinhVien(Student student);
	Student getSinhVienById(Long masv);
	void deleteSinhVienById(Long masv);
	List<Student> searchSinhVien(String tenkhoa, Float diemtin);
}
