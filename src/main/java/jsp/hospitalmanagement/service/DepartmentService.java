package jsp.hospitalmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.hospitalmanagement.dao.DepartmentDao;
import jsp.hospitalmanagement.dto.ResponseStructure;
import jsp.hospitalmanagement.entity.Department;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	public ResponseEntity<ResponseStructure<Department>>saveDepartment(Department department){
		ResponseStructure<Department> response=new ResponseStructure<Department>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("department is saved");
		response.setData(departmentDao.saveDepartment(department));
		return new ResponseEntity<ResponseStructure<Department>>(response,HttpStatus.OK);
	}
	 public ResponseEntity<ResponseStructure<List<Department>>> fetchAllDepartment(){
	        ResponseStructure<List<Department>> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Department is found");
	        response.setData(departmentDao.fetchAllDepartment());
	        return new ResponseEntity<ResponseStructure<List<Department>>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<Department>> fetchDepartmentById(Long id){
	        ResponseStructure<Department> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Department is found");
	        response.setData(departmentDao.fetchDepartmentById(id));
	        return new ResponseEntity<ResponseStructure<Department>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<Department>> updateDepartment(Department department){
	        ResponseStructure<Department> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Department is updated");
	        response.setData(departmentDao.updateDepartment(department));
	        return new ResponseEntity<ResponseStructure<Department>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<String>> deleteDepartment(Long id){
	        ResponseStructure<String> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Department is deleted");
	        response.setData(departmentDao.deleteDepartment(id));
	        return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<Department>> fetchDepartmentByDepartmentName(String name){
	        ResponseStructure<Department> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Department is found");
	        response.setData(departmentDao.fetchDepartmentByDepartmentName(name));
	        return new ResponseEntity<ResponseStructure<Department>>(response, HttpStatus.OK);
	    }

	}



