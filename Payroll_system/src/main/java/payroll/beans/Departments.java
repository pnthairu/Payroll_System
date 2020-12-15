package payroll.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Departments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDepartments;
	private String name;
}
