package payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import payroll.beans.Employees;
import payroll.repository.EmployeeRepository;

@Controller
public class EmployeeWebController {

	@Autowired
	EmployeeRepository repo;
	
	@GetMapping("employeeView")
	public String employeeView(Model model) {
		Employees c = new Employees();
		model.addAttribute("newEmployees", c);
		return "EmployeeHome";
	}
	
	@GetMapping("/empSearchByID{id}")
	public String searchByEmpId(Model model) {
		return "EmployeeHome";
		
	}
	
	@PostMapping("/empSearchByID{id}")
	public String searchByEmpId(@ModelAttribute("newEmployees") Employees a, @Param("id") long id, Model model) {
		a = repo.findById(id).orElse(null);
		return searchByEmpId(model.addAttribute("newEmployees", a));
	}
}
