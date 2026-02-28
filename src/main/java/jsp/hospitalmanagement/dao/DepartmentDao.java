package jsp.hospitalmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.hospitalmanagement.entity.Department;
import jsp.hospitalmanagement.exception.IdNotFoundException;
import jsp.hospitalmanagement.exception.NoDataFoundException;
import jsp.hospitalmanagement.repository.DepartmentRepository;

@Repository
public class DepartmentDao {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}
	 public List<Department> fetchAllDepartment(){
	        List<Department> departments = departmentRepository.findAll();
	        if(!departments.isEmpty())
	            return departments;
	        else
	            throw new NoDataFoundException("Department is empty");
	    }

	    public Department fetchDepartmentById(Long id){
	        Optional<Department> opt = departmentRepository.findById(id);
	        if(opt.isPresent())
	            return opt.get();
	        else
	            throw new IdNotFoundException("No Department is found with id : "+id);
	    }

	    public Department updateDepartment(Department department){
	        if(department.getDepartmentId() == null)
	            throw new IdNotFoundException("Id cannot be null");
	        Department OldDepartment = fetchDepartmentById(department.getDepartmentId());
	        return departmentRepository.save(department);
	    }

	    public String deleteDepartment(Long id){
	        Department department = fetchDepartmentById(id);
	        departmentRepository.delete(department);
	        return "success";
	    }

	    public Department fetchDepartmentByDepartmentName(String name){
	        Department department = departmentRepository.findByDepartmentName(name);
	        if(department != null)
	            return department;
	        else
	            throw new NoDataFoundException("No Department found with name : "+name);
	    }

	}



