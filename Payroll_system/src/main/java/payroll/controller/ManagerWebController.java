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
import payroll.repository.DepartmentsRepository;
import payroll.repository.EmployeeRepository;


@Controller
public class ManagerWebController {

	@Autowired
	EmployeeRepository repo;
	
	@Autowired
	DepartmentsRepository drepo;
	
	@GetMapping("managerView")
	public String managerView(Model model) {
		model.addAttribute("departments", drepo.findAll());
		return "Manager";
	}
	
	
	@GetMapping("/searchByDepartment/{id}")
	public String searchByDepartment(@PathVariable("id") String id, Model model) {
		model.addAttribute("employees", repo.searchByDepartment(id));
		return "DepartmentByEmployees";
	}

	@GetMapping("/managerUpdateEmployee/{id}")
	public String managerUpdateEmployee(@PathVariable("id") long id, Model model) {
		Employees c = repo.findById(id).orElse(null);
		model.addAttribute("employees", c);
		return "ManagerEditing";
	}
	
	@PostMapping("/managerUpdateEmp/{id}")
	public String managerUpdateEmp(Employees c, Model model) {
		repo.save(c);
		return managerView(model);
	}
}
