package jsp.hospitalmanagement.controller;

import java.time.LocalDate;
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
import jsp.hospitalmanagement.entity.Appointment;
import jsp.hospitalmanagement.entity.Status;
import jsp.hospitalmanagement.service.AppointmentService;

@Controller
@RequestMapping("/healhub/appointment")
public class AppointmentController {
	 	@Autowired
	    private AppointmentService appointmentService;

	    @PostMapping
	    public ResponseEntity<ResponseStructure<Appointment>> bookAppointment(@RequestBody Appointment appointment){
	        return appointmentService.bookAppointment(appointment);
	    }

	    @GetMapping("/all")
	    public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAllAppointment(){
	        return appointmentService.fetchAllAppointment();
	    }

	    @GetMapping("/id/{id}")
	    public ResponseEntity<ResponseStructure<Appointment>> fetchAppointmentById(@PathVariable Long id){
	        return appointmentService.fetchAppointmentById(id);
	    }

	    @GetMapping("/date/{date}")
	    public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByDate(@PathVariable LocalDate date){
	        return appointmentService.fetchAppointmentByDate(date);
	    }

	    @GetMapping("/doctor/{id}")
	    public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByDoctor(@PathVariable Long id){
	        return appointmentService.fetchAppointmentByDoctor(id);
	    }

	    @GetMapping("/patient/{id}")
	    public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByPatient(@PathVariable Long id){
	        return appointmentService.fetchAppointmentByPatient(id);
	    }

	    @GetMapping("/status/{status}")
	    public ResponseEntity<ResponseStructure<List<Appointment>>> fetchAppointmentByStatus(@PathVariable Status status){
	        return appointmentService.fetchAppointmentByStatus(status);
	    }

	    @DeleteMapping("/cancel/{id}")
	    public ResponseEntity<ResponseStructure<String>> cancelAppointment(@PathVariable Long id){
	        return appointmentService.cancelAppointment(id);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<ResponseStructure<Appointment>> updateAppointment(@PathVariable Long id){
	        return appointmentService.updateAppointment(id);
	    }



	}


