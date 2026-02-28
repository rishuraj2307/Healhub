package jsp.hospitalmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jsp.hospitalmanagement.dto.ResponseStructure;
import jsp.hospitalmanagement.entity.Department;
import jsp.hospitalmanagement.service.DepartmentService;

@Controller
@RequestMapping("/healhub/department")
public class DepartmentController {
	
	 	@Autowired
	    private DepartmentService departmentService;

	    @PostMapping
	    public ResponseEntity<ResponseStructure<Department>> createDepartment(@RequestBody Department department){
	        return departmentService.saveDepartment(department);
	    }

	    @GetMapping("/all")
	    public ResponseEntity<ResponseStructure<List<Department>>> fetchAllDepartment(){
	        return departmentService.fetchAllDepartment();
	    }

	    @GetMapping("/id/{id}")
	    public ResponseEntity<ResponseStructure<Department>> fetchDepartmentById(@PathVariable Long id){
	        return departmentService.fetchDepartmentById(id);
	    }

	    @PutMapping
	    public ResponseEntity<ResponseStructure<Department>> updateDepartment(@RequestBody Department department){
	        return departmentService.updateDepartment(department);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<ResponseStructure<String>> deleteDepartment(@PathVariable Long id){
	        return departmentService.deleteDepartment(id);
	    }

	    @GetMapping("/name/{name}")
	    public ResponseEntity<ResponseStructure<Department>> fetchDepartmentByDepartmentName(@PathVariable String name){
	        return departmentService.fetchDepartmentByDepartmentName(name);
	    }
	}
