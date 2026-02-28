package jsp.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jsp.hospitalmanagement.entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	Department findByDepartmentName(String name);
	}


