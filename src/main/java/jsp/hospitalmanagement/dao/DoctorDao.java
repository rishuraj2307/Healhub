package jsp.hospitalmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.hospitalmanagement.entity.Appointment;
import jsp.hospitalmanagement.entity.Department;
import jsp.hospitalmanagement.entity.Doctor;
import jsp.hospitalmanagement.entity.Patient;
import jsp.hospitalmanagement.exception.IdNotFoundException;
import jsp.hospitalmanagement.exception.NoDataFoundException;
import jsp.hospitalmanagement.repository.DoctorRepository;
import jsp.hospitalmanagement.repository.AppointmentRepository;


@Repository
public class DoctorDao {
	@Autowired
    private DoctorRepository doctorRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;

    @Autowired
    private DepartmentDao departmentDao;
    
    @Autowired
    private PatientDao patientDao;

    public Doctor addDoctor(Doctor doctor){
        Department department = departmentDao.fetchDepartmentByDepartmentName(doctor.getDepartment().getDepartmentName());
        doctor.setDepartment(department);
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctor(){
        List<Doctor> doctors = doctorRepository.findAll();
        if(!doctors.isEmpty())
            return doctors;
        else
            throw new NoDataFoundException("No Doctor is added yet");
    }

    public Doctor fetchDoctorById(Long id){
        Optional<Doctor> opt = doctorRepository.findById(id);
        if(opt.isPresent())
            return opt.get();
        else
            throw new IdNotFoundException("No Doctor is found with id : "+id);
    }

    public List<Doctor> fetchDoctorBySpecialization(String specialization){
        List<Doctor> doctors = doctorRepository.findBySpecialization(specialization);
        if(!doctors.isEmpty())
            return doctors;
        else
            throw new NoDataFoundException("No Doctor is found with this specialization : "+specialization);
    }

    public List<Doctor> fetchDoctorByDepartment(String departmentName){
        Department department = departmentDao.fetchDepartmentByDepartmentName(departmentName);
        List<Doctor> doctors = doctorRepository.findByDepartment(department);
        if(!doctors.isEmpty())
            return doctors;
        else
            throw new NoDataFoundException("No Doctor is found with this department : "+department);
    }

    public Doctor updateDoctor(Doctor doctor){
        if(doctor.getDoctorId() == null)
            throw new IdNotFoundException("Id cannot be null");
        Doctor oldDoctor = fetchDoctorById(doctor.getDoctorId());
        Department department = departmentDao.fetchDepartmentByDepartmentName(doctor.getDepartment().getDepartmentName());
        doctor.setDepartment(department);
        return doctorRepository.save(doctor);
    }

    public String deleteDoctor(Long id){
        Doctor doctor = fetchDoctorById(id);
        doctorRepository.delete(doctor);
        return "success";
    }
    public List<Doctor> fetchDoctorByPatient(Long id){
        Patient patient = patientDao.fetchPatientById(id);
        List<Doctor> doctors = appointmentRepository.findDoctorByPatient(patient);
        if(!doctors.isEmpty())
            return doctors;
        else
            throw new NoDataFoundException("No doctor is found for this patient");
    }

    public Doctor fetchDoctorByAppointment(Long id){
        Optional<Appointment> opt = appointmentRepository.findById(id);
        if(opt.isPresent()) {
            Appointment appointment = opt.get();
            return appointment.getDoctor();
        }
        else
            throw new NoDataFoundException("No Doctor is found for this Appointment");
    }
    public List<Doctor> fetchDoctorByAvailableDay(String day){
        List<Doctor> doctors =  doctorRepository.findAll()
                .stream()
                .filter(d -> d.getAvailableDay() != null &&
                        d.getAvailableDay().contains(day))
                .toList();
        if(!doctors.isEmpty())
            return doctors;
        else
            throw new NoDataFoundException("No Doctor is Available on this day");
    }
}


	


