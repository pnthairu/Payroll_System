package payroll.beans;

import java.time.LocalDate;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Manager {
	private int idManager;
	private String position;
	private String salary;
	private LocalDate dateHired;
	private int managerDepartment;
	private String firstName;
	private String lastName;
	
	
	/**
	 * A constructor with all but the date hired field.
	 * @param id
	 * @param position
	 * @param salary
	 * @param managerDepartment
	 * @param firstName
	 * @param lastName
	 */
	public Manager(int id, String position, String salary, int managerDepartment, String firstName, String lastName) {
		super();
		this.idManager = id;
		this.position = position;
		this.salary = salary;
		this.managerDepartment = managerDepartment;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	
	
	/**
	 * Constructor that takes in all the arguments.
	 * @param id
	 * @param position
	 * @param salary
	 * @param dateHired
	 * @param managerDepartment
	 * @param firstName
	 * @param lastName
	 */
	public Manager(int id, String position, String salary, LocalDate dateHired, int managerDepartment, String firstName, String lastName) {
		super();
		this.idManager = id;
		this.position = position;
		this.salary = salary;
		this.dateHired = dateHired;
		this.managerDepartment = managerDepartment;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
