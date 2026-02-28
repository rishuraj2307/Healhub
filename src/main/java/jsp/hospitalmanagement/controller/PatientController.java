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
import jsp.hospitalmanagement.entity.Patient;
import jsp.hospitalmanagement.service.PatientService;

@Controller
@RequestMapping("/healhub/patient")
public class PatientController {
	 @Autowired
	    private PatientService patientService;

	    @PostMapping
	    public ResponseEntity<ResponseStructure<Patient>> registerPatient(@RequestBody Patient patient){
	        return patientService.registerPatient(patient);
	    }

	    @GetMapping("/all")
	    public ResponseEntity<ResponseStructure<List<Patient>>> fetchAll(){
	        return patientService.fetchAllPatient();
	    }

	    @GetMapping("/id/{id}")
	    public ResponseEntity<ResponseStructure<Patient>> fetchPatientById(@PathVariable Long id){
	        return patientService.fetchPatientById(id);
	    }

	    @GetMapping("/phone/{phone}")
	    public ResponseEntity<ResponseStructure<Patient>> fetchPatientByPhone(@PathVariable Long phone){
	        return patientService.fetchPatientByPhone(phone);
	    }

	    @GetMapping("/age/{age}")
	    public ResponseEntity<ResponseStructure<List<Patient>>> fetchPatientByAgeGreaterThan(@PathVariable Integer age){
	        return patientService.fetchPatientByAgeGreaterThan(age);
	    }

	    @PutMapping
	    public ResponseEntity<ResponseStructure<Patient>> updatePatient(@RequestBody Patient patient){
	        return patientService.updatePatient(patient);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<ResponseStructure<String>> deletePatient(@PathVariable Long id){
	        return patientService.deletePatient(id);
	    }
	    @GetMapping("/appointment/{id}")
	    public ResponseEntity<ResponseStructure<Patient>> fetchPatientByAppointment(@PathVariable Long id){
	        return patientService.fetchPatientByAppointment(id);
	    }

	    @GetMapping("/report/{id}")
	    public ResponseEntity<ResponseStructure<Patient>> fetchPatientByReport(@PathVariable Long id){
	        return patientService.fetchPatientByReport(id);
	    }
	}


