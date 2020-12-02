package payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import payroll.beans.Employees;
import payroll.repository.HiringManagerRepository;


@Controller
public class HiringManagerWebController {
	
	@Autowired
	HiringManagerRepository repo;
	
	@GetMapping({ "/", "viewAllEmployees" })
	public String viewAllEmployees(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewEmployees(model);
		}
		
		model.addAttribute("employees", repo.findAll());
		return "HiringManager";
	}
	
	@GetMapping("/inputEmployees")
	public String addNewEmployees(Model model) {
		Employees c = new Employees();
		model.addAttribute("newEmployees", c);
		return "HiringManagerDataInput";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateEmployees(@PathVariable("id") long id, Model model) {
		Employees c = repo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT: " + c.toString());
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

}
