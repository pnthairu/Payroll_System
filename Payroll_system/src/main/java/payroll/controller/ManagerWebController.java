package payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import payroll.beans.Employees;
import payroll.repository.EmployeeRepository;


@Controller
public class ManagerWebController {

	@Autowired
	EmployeeRepository repo;
	
	@GetMapping("managerView")
	public String managerView(Model model) {
		return "Manager";
	}
	
	@PostMapping("searchByDepartment")
	public String searchByDepartment(@Param("department") int department, Model model) {
		model.addAttribute("employees", repo.searchByDepartment(department));
		return "DepartmentByEmployees";
	}
	
	@GetMapping("/managerEdit/{id}")
	public String managerEdit(@PathVariable("id") long id, Model model) {
		Employees c = repo.findById(id).orElse(null);
		model.addAttribute("newEmployees", c);
		return "DepartmentByEmployees";
	}

	@PostMapping("/managerUpdateEmployee/{id}")
	public String managerUpdateEmployee(Employees c, Model model) {
		repo.save(c);
		return "ManagerEditing";
	}
}
