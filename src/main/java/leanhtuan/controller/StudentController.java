package leanhtuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import leanhtuan.model.Student;
import leanhtuan.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listSinhVien", studentService.getAllSinhVien());
		return "index";
	}

	@GetMapping("/showNewSinhVienForm")
	public String showNewSinhVienForm(Model model) {
		// create model attribute to bind form data
		Student student = new Student();
		model.addAttribute("sinhvien", student);
		return "new_sinhvien";
	}

	@PostMapping("/saveSinhVien")
	public String saveSinhVien(@ModelAttribute("sinhvien") Student student) {
		// save employee to database
		studentService.saveSinhVien(student);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{masv}")
	public String showFormForUpdate(@PathVariable(value = "masv") Long masv, Model model) {
		// get sinhvien from the service
		Student student = studentService.getSinhVienById(masv);
		// set sinhven as a model attribute to pre-populate the form
		model.addAttribute("sinhvien", student);
		return "update_sinhvien";
	}

	@GetMapping("/deleteSinhVien/{masv}")
	public String deleteSinhVien(@PathVariable(value = "masv") Long masv) {
		// call delete sinhvien method
		this.studentService.deleteSinhVienById(masv);
		return "redirect:/";
	}

	@GetMapping("/searchSinhVien")
	public String searchSinhVien(Model model, @RequestParam(name = "tenkhoa", required = false) String tenkhoa,
			@RequestParam(name = "diemtin", required = false) Float diemtin) {
		List<Student> listSinhVien = studentService.searchSinhVien(tenkhoa, diemtin);
		for (Student student : listSinhVien) {
			// Tính toán trường "tinhtrang" dựa trên điểm thi
			float diemTin = student.getDiemtin();
			if (diemTin >= 5) {
				student.setDiemthi("Đỗ");
			} else {
				student.setDiemthi("Trượt");
			}
		}
		model.addAttribute("searchSinhVien", listSinhVien);
		return "search_list"; // Hoặc trả về trang danh sách tìm kiếm tùy ý
	}
}
