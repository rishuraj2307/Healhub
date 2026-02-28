package jsp.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jsp.hospitalmanagement.entity.Prescription;
@Repository
public interface PrescriptionRepository  extends JpaRepository<Prescription, Long>{

}
