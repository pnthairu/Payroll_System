package payroll.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import payroll.beans.Employees;

@Repository
public interface EmployeeRepository extends JpaRepository <Employees, Long>{

	@Query(nativeQuery = true, value="SELECT * FROM employees e WHERE LOWER(e.last_name) = LOWER(?1)")
	public Employees search(String last_name);
	
	@Query(nativeQuery = true, value="SELECT * FROM employees e WHERE LOWER(e.emp_department) = ?1")
	public List<Employees> searchByDepartment(String department);

}

