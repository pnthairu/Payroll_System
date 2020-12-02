package payroll.beans;

import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;
import payroll.controller.LocalDateAttributeConverter;

@Embeddable
@Data
@NoArgsConstructor
public class Employees {

	private int idEmployees;
	private String position;
	private String salary;
	@Convert(converter=LocalDateAttributeConverter.class)
	private LocalDate dateHired;
	private int empDepartment;
	private String firstName;
	private String lastName;

	/**
	 * A constructor with all but the date hired field.
	 * 
	 * @param id
	 * @param position
	 * @param salary
	 * @param empDepartment
	 * @param firstName
	 * @param lastName
	 */
	public Employees(int id, String position, String salary, int empDepartment, String firstName,
			String lastName) {
		this.idEmployees = id;
		this.position = position;
		this.salary = salary;
		this.empDepartment = empDepartment;
		this.firstName = firstName;
		this.lastName = lastName;

	}

	/**
	 * Constructor that takes in all the arguments.
	 * 
	 * @param id
	 * @param position
	 * @param salary
	 * @param dateHired
	 * @param empDepartment
	 * @param firstName
	 * @param lastName
	 */
	public Employees(int id, String position, String salary, LocalDate dateHired, int empDepartment,
			String firstName, String lastName) {
		this.idEmployees = id;
		this.position = position;
		this.salary = salary;
		this.dateHired = dateHired;
		this.empDepartment = empDepartment;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}

