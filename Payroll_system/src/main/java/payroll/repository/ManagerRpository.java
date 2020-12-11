package payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import payroll.beans.Employees;
import payroll.beans.Manager;

@Repository
public interface ManagerRpository  extends JpaRepository <Manager, Long>{

}
