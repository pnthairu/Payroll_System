package payroll.beans;

import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import payroll.controller.LocalDateAttributeConverter;

@Data
@Entity
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String position;
	private String salary;
	@Convert(converter=LocalDateAttributeConverter.class)
	private LocalDate dateHired;
	private String empDepartment;
	private String firstName;
	private String lastName;
	private String hours;

}

