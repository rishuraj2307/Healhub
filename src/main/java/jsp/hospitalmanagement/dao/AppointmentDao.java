package jsp.hospitalmanagement.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jsp.hospitalmanagement.dto.ResponseStructure;
import jsp.hospitalmanagement.entity.Appointment;
import jsp.hospitalmanagement.entity.Doctor;
import jsp.hospitalmanagement.entity.Patient;
import jsp.hospitalmanagement.entity.Status;
import jsp.hospitalmanagement.exception.DoctorNotAvailableException;
import jsp.hospitalmanagement.exception.IdNotFoundException;
import jsp.hospitalmanagement.exception.NoDataFoundException;
import jsp.hospitalmanagement.exception.PatientAlreadyHasAppointmentException;
import jsp.hospitalmanagement.repository.AppointmentRepository;
import jsp.hospitalmanagement.service.AppointmentService;
@Repository
public class AppointmentDao {
	 	@Autowired
	    private AppointmentRepository appointmentRepository;

	    @Autowired
	    private DoctorDao doctorDao;

	    @Autowired
	    private PatientDao patientDao;

	    public Appointment bookAppointment(Appointment appointment){
	        Doctor doctor = doctorDao.fetchDoctorById(appointment.getDoctor().getDoctorId());
	        Patient patient = patientDao.fetchPatientById(appointment.getPatient().getPatientId());

	        boolean isDoctorBusy = appointmentRepository.existsByDoctorAndAppointmentDateTime(doctor, appointment.getAppointmentDateTime());
	        if(isDoctorBusy)
	            throw new DoctorNotAvailableException("Doctor already has an appointment at this time");
	        LocalDate date = appointment.getAppointmentDateTime().toLocalDate();
	        LocalDateTime startOfDay = date.atStartOfDay();
	        LocalDateTime endOfDay = date.atTime(23,59,59);
	        boolean patientHasAppointment = appointmentRepository.existsByPatientAndAppointmentDateTimeBetween(patient, startOfDay, endOfDay);
	        if(patientHasAppointment)
	            throw new PatientAlreadyHasAppointmentException("Patient already has an appointment on this day");

	        appointment.setDoctor(doctor);
	        appointment.setPatient(patient);
	        appointment.setStatus(Status.BOOKED);
	        return appointmentRepository.save(appointment);
	    }

	    public List<Appointment> fetchAllAppointment(){
	        List<Appointment> appointments = appointmentRepository.findAll();
	        if(!appointments.isEmpty())
	            return appointments;
	        else
	            throw new NoDataFoundException("No Appointment is Booked yet");
	    }

	    public Appointment fetchAppointmentById(Long id){
	        Optional<Appointment> opt = appointmentRepository.findById(id);
	        if(opt.isPresent())
	            return opt.get();
	        else
	            throw new IdNotFoundException("No Appointment is found with id : "+id);
	    }

	    public List<Appointment> fetchAppointmentByDate(LocalDate date){
	        LocalDateTime startOfDay = date.atStartOfDay();
	        LocalDateTime endOfDay = date.atTime(23, 59, 59);

	        List<Appointment> appointments = appointmentRepository.findByAppointmentDateTimeBetween(startOfDay, endOfDay);
	        if(!appointments.isEmpty())
	            return appointments;
	        else
	            throw new NoDataFoundException("No Appointment date : "+date);
	    }

	    public List<Appointment> fetchAppointmentByDoctor(Long id){
	        Doctor doctor = doctorDao.fetchDoctorById(id);
	        List<Appointment> appointments = appointmentRepository.findByDoctor(doctor);
	        if(!appointments.isEmpty())
	            return appointments;
	        else
	            throw new NoDataFoundException("No Appointment for Doctor");
	    }

	    public List<Appointment> fetchAppointmentByPatient(Long id){
	        Patient patient = patientDao.fetchPatientById(id);
	        List<Appointment> appointments = appointmentRepository.findByPatient(patient);
	        if(!appointments.isEmpty())
	            return appointments;
	        else
	            throw new NoDataFoundException("No Appointment for Patient");
	    }

	    public List<Appointment> fetchAppointmentByStatus(Status status){
	        List<Appointment> appointments = appointmentRepository.findByStatus(status);
	        if(!appointments.isEmpty())
	            return appointments;
	        else
	            throw new NoDataFoundException("No Appointment for Status");
	    }


	    public String cancelAppointment(Long id){
	        Appointment appointment = fetchAppointmentById(id);
	        if (appointment.getStatus() != Status.BOOKED)
	            throw new RuntimeException("Appointment on cancel for booked status");
	        appointmentRepository.delete(appointment);
	        return "success";
	    }

	    public Appointment updateAppointment(Long id){
	        Appointment appointment = fetchAppointmentById(id);
	        appointment.setStatus(Status.COMPLETED);
	        return appointmentRepository.save(appointment);
	    }

	    public Appointment fetchByAppointmentForMedicalReport(Doctor doctor, Patient patient, LocalDateTime start, LocalDateTime end){
	        Optional<Appointment> opt = appointmentRepository.findByDoctorAndPatientAndAppointmentDateTimeBetween(doctor, patient, start, end);
	        if(opt.isPresent())
	            return opt.get();
	        else
	            throw new NoDataFoundException("No Appointment is found with this doctor and patient on this day ");
	    }




	}





