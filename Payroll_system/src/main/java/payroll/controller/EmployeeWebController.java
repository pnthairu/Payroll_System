package payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import payroll.beans.Employees;
import payroll.repository.EmployeeRepository;

@Controller
public class EmployeeWebController {

	@Autowired
	EmployeeRepository repo;
	
	@GetMapping("employeeView")
	public String employeeView(Model model) {
		return "EmployeeHome";
	}
	
	@GetMapping("/searchByEmpId{id}")
	public String searchByEmpId(@Param("id") long id, Model model) {
		Employees c = repo.findById(id).orElse(null);
		model.addAttribute("newEmployees", c);
		return "EmployeeHome";
	}
	
	@PostMapping("/searchByEmpId{id}")
	public String searchByEmpId(Employees c, Model model) {
		model.addAttribute("newEmployees", c);
		return "EmployeeHome";
	}
}
