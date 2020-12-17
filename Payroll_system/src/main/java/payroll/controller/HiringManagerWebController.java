package payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import payroll.beans.Employees;
import payroll.repository.EmployeeRepository;


@Controller
public class HiringManagerWebController {
	
	@Autowired
	EmployeeRepository repo;
	
	@GetMapping("HRView")
	public String HRView(Model model) {
		return "HiringManager";
	}
	
	@GetMapping("viewEveryOne")
	public String viewEveryOne(Model model) {
		model.addAttribute("employees", repo.findAll());
		return "HiringManagerEdit";
	}
	
	@GetMapping("viewAllEmployees")
	public String viewAllEmployees(Model model) {
		model.addAttribute("employees", repo.findAll());
		return "HiringManagerEdit";
	}
	
	@GetMapping("/inputEmployees")
	public String inputEmployees(Model model) {
		Employees c = new Employees();
		model.addAttribute("newEmployees", c);
		return "HiringManagerDataInput";
	}
	
	@PostMapping("/inputEmployees")
	public String inputEmployees(@ModelAttribute Employees c, Model model) {
		repo.save(c);
		return viewAllEmployees(model);
	}

	@GetMapping("/edit/{id}")
	public String showUpdateEmployees(@PathVariable("id") long id, Model model) {
		Employees c = repo.findById(id).orElse(null);
		model.addAttribute("newEmployees", c);
		return "HiringManagerDataInput";
	}

	@PostMapping("/update/{id}")
	public String reviseEmployees(Employees c, Model model) {
		repo.save(c);
		return viewAllEmployees(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Employees c = repo.findById(id).orElse(null);
	    repo.delete(c);
	    return viewAllEmployees(model);
	}
	
	@GetMapping("/searchEmployee")
	public String returnSearchEmployee() {
		return "searchEmployee";
	}
	
	@PostMapping("/searchById{id}")
	public String searchById(@Param("id") long id, Model model) {
		Employees c = repo.findById(id).orElse(null);
		model.addAttribute("newEmployees", c);
		return "HiringManagerDataInput";
	}
	
	@PostMapping("/searchByLastName{last_name}")
	public String searchByLastName(@Param("lastName") String lastName, Model model) {
		Employees c = repo.search(lastName);
		model.addAttribute("employees", c);
		return "HiringManagerEdit";
	}
	
}
