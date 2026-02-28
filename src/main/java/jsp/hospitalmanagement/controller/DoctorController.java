package jsp.hospitalmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.hospitalmanagement.dto.ResponseStructure;
import jsp.hospitalmanagement.entity.Doctor;
import jsp.hospitalmanagement.service.DoctorService;

@RestController
@RequestMapping("/healhub/doctor")
public class DoctorController {
	 @Autowired
	    private DoctorService doctorService;

	    @PostMapping
	    public ResponseEntity<ResponseStructure<Doctor>> addDoctor(@RequestBody Doctor doctor){
	        return doctorService.addDoctor(doctor);
	    }

	    @GetMapping("/all")
	    public ResponseEntity<ResponseStructure<List<Doctor>>> getAllDoctor(){
	        return doctorService.getAllDoctor();
	    }

	    @GetMapping("/id/{id}")
	    public ResponseEntity<ResponseStructure<Doctor>> fetchDoctorById(@PathVariable Long id){
	        return doctorService.fetchDoctorById(id);
	    }

	    @GetMapping("/specialization/{specialization}")
	    public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorBySpecialization(@PathVariable String specialization){
	        return doctorService.fetchDoctorBySpecialization(specialization);
	    }

	    @GetMapping("/department/{departmentName}")
	    public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorByDepartment(@PathVariable String departmentName){
	        return doctorService.fetchDoctorByDepartment(departmentName);
	    }

	    @PutMapping
	    public ResponseEntity<ResponseStructure<Doctor>> updateDoctor(@RequestBody Doctor doctor){
	        return doctorService.updateDoctor(doctor);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<ResponseStructure<String>> deleteDoctor(@PathVariable Long id){
	        return doctorService.deleteDoctor(id);
	    }
	    @GetMapping("/patient/{id}")
	    public ResponseEntity<ResponseStructure<List<Doctor>>> fetchByDoctorByPatient(@PathVariable Long id){
	        return doctorService.fetchDoctorByPatient(id);
	    }

	    @GetMapping("/appointment/{id}")
	    public ResponseEntity<ResponseStructure<Doctor>> fetchDoctorByAppointment(@PathVariable Long id){
	        return doctorService.fetchDoctorByAppointment(id);
	    }
	    @GetMapping("/day/{day}")
	    public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorByAvailableDay(@PathVariable String day){
	        return doctorService.fetchDoctorByAvailableDay(day);
	    }
	}


