package leanhtuan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import leanhtuan.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByTenkhoaAndDiemtinLessThanEqual(String tenkhoa, Float diemtin);
	List<Student> findByDiemtinLessThanEqual(Float diemtin);
	List<Student> findByTenkhoa(String tenkhoa);
}
