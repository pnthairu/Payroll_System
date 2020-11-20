package payroll.beans;

import javax.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Hr {
	private int id;
	private String salary;
	private String dateHired;
	private int man_deparment;
	private String fname;
	private String lname;
	
	/**
	 * Making a new HR without an offial date hired
	 * @param id
	 * @param man_deparment
	 * @param fname
	 * @param lname
	 */
	public Hr(int id, int man_deparment, String fname, String lname) {
		super();
		this.id = id;
		this.man_deparment = man_deparment;
		this.fname = fname;
		this.lname = lname;
	}
	
	/**
	 * 
	 * @param id
	 * @param salary
	 * @param dateHired
	 * @param man_deparment
	 * @param fname
	 * @param lname
	 */
	public Hr(int id, String salary, String dateHired, int man_deparment, String fname, String lname) {
		super();
		this.id = id;
		this.salary = salary;
		this.dateHired = dateHired;
		this.man_deparment = man_deparment;
		this.fname = fname;
		this.lname = lname;
	}
	
	
	
	
}
