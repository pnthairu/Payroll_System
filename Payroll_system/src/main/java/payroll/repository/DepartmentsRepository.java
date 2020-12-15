package payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import payroll.beans.Departments;
import payroll.beans.Employees;

@Repository
public interface DepartmentsRepository  extends JpaRepository <Departments, Long>{

	@Query(nativeQuery = true, value="SELECT * FROM departments")
	public List<Departments> searchByDepartment();
}
