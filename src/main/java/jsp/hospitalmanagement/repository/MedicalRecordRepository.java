package jsp.hospitalmanagement.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jsp.hospitalmanagement.entity.Doctor;
import jsp.hospitalmanagement.entity.MedicalRecord;
import jsp.hospitalmanagement.entity.Patient;
@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
	 List<MedicalRecord> findByPatient(Patient patient);
	 List<MedicalRecord> findByDoctor(Doctor doctor);
	 Optional<MedicalRecord> findByDoctorAndPatientAndVisitDate(Doctor doctor, Patient patient, LocalDate visitDate);
	 List<MedicalRecord> findByVisitDate(LocalDate visitDate); 
	 
	}


