package jsp.hospitalmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jsp.hospitalmanagement.entity.Department;
import jsp.hospitalmanagement.entity.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findBySpecialization(String specialization);
    List<Doctor> findByDepartment(Department department);
}
