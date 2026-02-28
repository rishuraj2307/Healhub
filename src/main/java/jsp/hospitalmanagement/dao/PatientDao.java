package jsp.hospitalmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.hospitalmanagement.entity.Appointment;
import jsp.hospitalmanagement.entity.MedicalRecord;
import jsp.hospitalmanagement.entity.Patient;
import jsp.hospitalmanagement.exception.IdNotFoundException;
import jsp.hospitalmanagement.exception.NoDataFoundException;
import jsp.hospitalmanagement.repository.AppointmentRepository;
import jsp.hospitalmanagement.repository.MedicalRecordRepository;
import jsp.hospitalmanagement.repository.PatientRepository;

@Repository
public class PatientDao {
	 	@Autowired
	   	private PatientRepository patientRepository;
	 	
	 	@Autowired
	 	private AppointmentRepository appointmentRepository;
	 	
	 	@Autowired
	 	private MedicalRecordRepository recordRepository;

	    public Patient registerPatient(Patient patient){
	        return patientRepository.save(patient);
	    }

	    public List<Patient> fetchAll(){
	        List<Patient> patients = patientRepository.findAll();
	        if(!patients.isEmpty())
	            return patients;
	        else
	            throw new NoDataFoundException("Patients record is empty");
	    }

	    public Patient fetchPatientById(Long id){
	        Optional<Patient> opt = patientRepository.findById(id);
	        if(opt.isPresent())
	            return opt.get();
	        else
	            throw new IdNotFoundException("No record is found with id : "+id);
	    }

	    public Patient fetchPatientByPhone(Long phone){
	        Patient patient = patientRepository.findByPhone(phone);
	        if(patient != null)
	            return patient;
	        else
	            throw new NoDataFoundException("No Patient is found with phone : "+phone);
	    }

	    public List<Patient> fetchPatientByAgeGreaterThan(Integer age){
	        List<Patient> patients = patientRepository.findByAgeGreaterThan(age);
	        if(!patients.isEmpty())
	            return patients;
	        else
	            throw new NoDataFoundException("No Patient is found whose age is greater than "+age);
	    }

	    public Patient updatePatient(Patient patient){
	        if(patient.getPatientId() == null)
	            throw new IdNotFoundException("Id can not be null");
	        Patient OldPatient = fetchPatientById(patient.getPatientId());
	        return patientRepository.save(patient);
	    }

	    public String deletePatient(Long id){
	        Patient patient = fetchPatientById(id);
	        patientRepository.delete(patient);
	        return "success";
	    }
	    public Patient fetchPatientByAppointment(Long id){
	        Optional<Appointment> opt = appointmentRepository.findById(id);
	        if(opt.isPresent()){
	            Appointment appointment = opt.get();
	            return appointment.getPatient();
	        } else
	            throw new IdNotFoundException("No Appointment is found for this id");

	    }

	    public Patient fetchPatientByReport(Long id){
	        Optional<MedicalRecord> opt = recordRepository.findById(id);
	        if(opt.isPresent()){
	            MedicalRecord report = opt.get();
	            return report.getPatient();
	        }else
	            throw new IdNotFoundException("No Report is found for this id");
	    }
	    
	    
	}


