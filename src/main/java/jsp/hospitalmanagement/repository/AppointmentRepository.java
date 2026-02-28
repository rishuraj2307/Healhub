package jsp.hospitalmanagement.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jsp.hospitalmanagement.entity.Appointment;
import jsp.hospitalmanagement.entity.Doctor;
import jsp.hospitalmanagement.entity.Patient;
import jsp.hospitalmanagement.entity.Status;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	 List<Appointment> findByAppointmentDateTimeBetween(LocalDateTime start, LocalDateTime end);
	    List<Appointment> findByDoctor(Doctor doctor);
	    List<Appointment> findByPatient(Patient patient);

	    boolean existsByDoctorAndAppointmentDateTime(Doctor doctor, LocalDateTime appointmentDateTime);

	    boolean existsByPatientAndAppointmentDateTimeBetween(Patient patient, LocalDateTime start, LocalDateTime end);

	    List<Appointment> findByStatus(Status status);

	    Optional<Appointment> findByDoctorAndPatientAndAppointmentDateTimeBetween( Doctor doctor, Patient patient, LocalDateTime start, LocalDateTime end);
	    
	    @Query("SELECT DISTINCT a.doctor FROM Appointment a WHERE a.patient=:patient")
	    List<Doctor> findDoctorByPatient(@Param("patient")Patient patient);
	}




