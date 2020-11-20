package payroll.beans;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Departments {
	private int idDepartments;
	private String name;
}
