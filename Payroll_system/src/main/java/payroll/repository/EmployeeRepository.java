package payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import payroll.beans.Employees;

@Repository
public interface EmployeeRepository extends JpaRepository <Employees, Long>{

}

