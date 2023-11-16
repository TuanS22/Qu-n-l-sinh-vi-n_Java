package leanhtuan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leanhtuan.model.Student;
import leanhtuan.repository.StudentRepository;

@Service
public class StudentServiceImpl  implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllSinhVien(){
		List<Student> students = studentRepository.findAll();
		for (Student student : students) {
       	 float diemTin = student.getDiemtin();
       	 if (diemTin >= 5) {
       		student.setDiemthi("Đỗ");
	            } else {
	            	student.setDiemthi("Trượt");
	            }
       }
       return students;
	}
	
	@Override
	public void saveSinhVien(Student student) {
		this.studentRepository.save(student);
	}
	
	@Override
	public Student getSinhVienById(Long masv) {
		Optional<Student> optional = studentRepository.findById(masv);
		Student student = null;
		if(optional.isPresent()) {
			student = optional.get();
		}else {
			throw new RuntimeException(" Sinh Vien not found for id : " + masv);
		}
		return student;
	}
	
	@Override
	public void deleteSinhVienById(Long masv) {
		this.studentRepository.deleteById(masv);
	}
	
	@Override
	public List<Student> searchSinhVien(String tenkhoa, Float diemtin) {
		if(tenkhoa != null && diemtin != null) {
			return studentRepository.findByTenkhoaAndDiemtinLessThanEqual(tenkhoa, diemtin);
		}else if ((tenkhoa != null || !tenkhoa.trim().isEmpty()) && diemtin == null) {
			return studentRepository.findByTenkhoa(tenkhoa);
		}else if((tenkhoa == null || tenkhoa.trim().isEmpty()) && diemtin != null) {
			return studentRepository.findByDiemtinLessThanEqual(diemtin);
		}else {
			return getAllSinhVien();
		}
	}
}
