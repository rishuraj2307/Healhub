package jsp.hospitalmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.hospitalmanagement.dao.PatientDao;
import jsp.hospitalmanagement.dto.ResponseStructure;
import jsp.hospitalmanagement.entity.Patient;

@Service
public class PatientService {
	 @Autowired
	    private PatientDao patientDao;

	    public ResponseEntity<ResponseStructure<Patient>> registerPatient(Patient patient){
	        ResponseStructure<Patient> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Patient registered");
	        response.setData(patientDao.registerPatient(patient));
	        return new ResponseEntity<ResponseStructure<Patient>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<List<Patient>>> fetchAllPatient(){
	        ResponseStructure<List<Patient>> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Patient found");
	        response.setData(patientDao.fetchAll());
	        return new ResponseEntity<ResponseStructure<List<Patient>>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<Patient>> fetchPatientById(Long id){
	        ResponseStructure<Patient> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Patient found");
	        response.setData(patientDao.fetchPatientById(id));
	        return new ResponseEntity<ResponseStructure<Patient>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<Patient>> fetchPatientByPhone(Long phone){
	        ResponseStructure<Patient> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Patient found");
	        response.setData(patientDao.fetchPatientByPhone(phone));
	        return new ResponseEntity<ResponseStructure<Patient>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<List<Patient>>> fetchPatientByAgeGreaterThan(Integer age){
	        ResponseStructure<List<Patient>> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Patient found");
	        response.setData(patientDao.fetchPatientByAgeGreaterThan(age));
	        return new ResponseEntity<ResponseStructure<List<Patient>>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<Patient>> updatePatient(Patient patient){
	        ResponseStructure<Patient> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Patient is updated");
	        response.setData(patientDao.updatePatient(patient));
	        return new ResponseEntity<ResponseStructure<Patient>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<String>> deletePatient (Long id){
	        ResponseStructure<String> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Patient is deleted");
	        response.setData(patientDao.deletePatient(id));
	        return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.OK);
	    }
	    public ResponseEntity<ResponseStructure<Patient>> fetchPatientByAppointment(Long id){
	        ResponseStructure<Patient> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Patient is found");
	        response.setData(patientDao.fetchPatientByAppointment(id));
	        return new ResponseEntity<ResponseStructure<Patient>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<Patient>> fetchPatientByReport(Long id){
	        ResponseStructure<Patient> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Patient is found");
	        response.setData(patientDao.fetchPatientByReport(id));
	        return new ResponseEntity<ResponseStructure<Patient>>(response, HttpStatus.OK);
	    }
	}


