package jsp.hospitalmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.hospitalmanagement.dao.DoctorDao;
import jsp.hospitalmanagement.dto.ResponseStructure;
import jsp.hospitalmanagement.entity.Doctor;
@Service
public class DoctorService {
	 @Autowired
	    private DoctorDao doctorDao;

	    public ResponseEntity<ResponseStructure<Doctor>> addDoctor(Doctor doctor){
	        ResponseStructure<Doctor> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Doctor is added");
	        response.setData(doctorDao.addDoctor(doctor));
	        return new ResponseEntity<ResponseStructure<Doctor>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<List<Doctor>>> getAllDoctor(){
	        ResponseStructure<List<Doctor>> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Doctor is found");
	        response.setData(doctorDao.getAllDoctor());
	        return new ResponseEntity<ResponseStructure<List<Doctor>>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<Doctor>> fetchDoctorById(Long id){
	        ResponseStructure<Doctor> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Doctor is found with id : "+id);
	        response.setData(doctorDao.fetchDoctorById(id));
	        return new ResponseEntity<ResponseStructure<Doctor>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorBySpecialization(String specialization){
	        ResponseStructure<List<Doctor>> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Doctor is found with specialization : "+specialization);
	        response.setData(doctorDao.fetchDoctorBySpecialization(specialization));
	        return new ResponseEntity<ResponseStructure<List<Doctor>>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorByDepartment(String departmentName){
	        ResponseStructure<List<Doctor>> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Doctor is found with department : "+departmentName);
	        response.setData(doctorDao.fetchDoctorByDepartment(departmentName));
	        return new ResponseEntity<ResponseStructure<List<Doctor>>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<Doctor>> updateDoctor(Doctor doctor){
	        ResponseStructure<Doctor> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Doctor is updated.");
	        response.setData(doctorDao.updateDoctor(doctor));
	        return new ResponseEntity<ResponseStructure<Doctor>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<String>> deleteDoctor(Long id){
	        ResponseStructure<String> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Doctor is deleted.");
	        response.setData(doctorDao.deleteDoctor(id));
	        return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.OK);
	    }
	    public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorByPatient(Long  id){
	        ResponseStructure<List<Doctor>> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Doctor is found for this patient ");
	        response.setData(doctorDao.fetchDoctorByPatient(id));
	        return new ResponseEntity<ResponseStructure<List<Doctor>>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<Doctor>> fetchDoctorByAppointment(Long id){
	        ResponseStructure<Doctor> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Doctor is found.");
	        response.setData(doctorDao.fetchDoctorByAppointment(id));
	        return new ResponseEntity<ResponseStructure<Doctor>>(response, HttpStatus.OK);
	    }
	    
	    public ResponseEntity<ResponseStructure<List<Doctor>>> fetchDoctorByAvailableDay(String  day){
	        ResponseStructure<List<Doctor>> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Doctor is found for this day ");
	        response.setData(doctorDao.fetchDoctorByAvailableDay(day));
	        return new ResponseEntity<ResponseStructure<List<Doctor>>>(response, HttpStatus.OK);
	    }
	}


	



