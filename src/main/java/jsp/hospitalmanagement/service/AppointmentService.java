package jsp.hospitalmanagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.hospitalmanagement.dao.AppointmentDao;
import jsp.hospitalmanagement.dto.ResponseStructure;
import jsp.hospitalmanagement.entity.Appointment;
import jsp.hospitalmanagement.entity.Status;

@Service
public class AppointmentService {
	
	 @Autowired
	 private AppointmentDao appointmentDao;

	    public ResponseEntity<ResponseStructure<Appointment>> bookAppointment(Appointment appointment){
	        ResponseStructure<Appointment> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Appointment is booked");
	        response.setData(appointmentDao.bookAppointment(appointment));
	        return new ResponseEntity<ResponseStructure<Appointment>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAllAppointment(){
	        ResponseStructure<List<Appointment>> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Appointment is found");
	        response.setData(appointmentDao.fetchAllAppointment());
	        return new ResponseEntity<ResponseStructure<List<Appointment>>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<Appointment>> fetchAppointmentById(Long id){
	        ResponseStructure<Appointment> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Appointment is found");
	        response.setData(appointmentDao.fetchAppointmentById(id));
	        return new ResponseEntity<ResponseStructure<Appointment>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByDate(LocalDate date){
	        ResponseStructure<List<Appointment>> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Appointment is found");
	        response.setData(appointmentDao.fetchAppointmentByDate(date));
	        return new ResponseEntity<ResponseStructure<List<Appointment>>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByDoctor(Long id){
	        ResponseStructure<List<Appointment>> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Appointment is found");
	        response.setData(appointmentDao.fetchAppointmentByDoctor(id));
	        return new ResponseEntity<ResponseStructure<List<Appointment>>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByPatient(Long id){
	        ResponseStructure<List<Appointment>> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Appointment is found");
	        response.setData(appointmentDao.fetchAppointmentByPatient(id));
	        return new ResponseEntity<ResponseStructure<List<Appointment>>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByStatus(Status status){
	        ResponseStructure<List<Appointment>> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Appointment is found");
	        response.setData(appointmentDao.fetchAppointmentByStatus(status));
	        return new ResponseEntity<ResponseStructure<List<Appointment>>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<String>> cancelAppointment(Long id){
	        ResponseStructure<String> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Appointment is Cancelled");
	        response.setData(appointmentDao.cancelAppointment(id));
	        return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<Appointment>> updateAppointment(Long id){
	        ResponseStructure<Appointment> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Appointment is updated");
	        response.setData(appointmentDao.updateAppointment(id));
	        return new ResponseEntity<ResponseStructure<Appointment>>(response, HttpStatus.OK);
	    }
	}


