package jsp.hospitalmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jsp.hospitalmanagement.entity.Patient;
@Repository
public interface PatientRepository  extends JpaRepository<Patient, Long>{
	 Patient findByPhone(Long phone);
	    List<Patient> findByAgeGreaterThan(Integer age);
}
