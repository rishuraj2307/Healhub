package jsp.hospitalmanagement.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jsp.hospitalmanagement.entity.Appointment;
import jsp.hospitalmanagement.entity.Doctor;
import jsp.hospitalmanagement.entity.MedicalRecord;
import jsp.hospitalmanagement.entity.Patient;
import jsp.hospitalmanagement.entity.Status;
import jsp.hospitalmanagement.exception.AppointmentNotCompletedException;
import jsp.hospitalmanagement.exception.IdNotFoundException;
import jsp.hospitalmanagement.exception.NoDataFoundException;
import jsp.hospitalmanagement.repository.MedicalRecordRepository;

@Service
public class MedicalRecordDao {
	 @Autowired
	    private AppointmentDao appointmentDao;

	    @Autowired
	    private DoctorDao doctorDao;

	    @Autowired
	    private PatientDao patientDao;

	    @Autowired
	    private MedicalRecordRepository recordRepository;

	    public MedicalRecord createRecord(MedicalRecord record){

	        Doctor doctor = doctorDao.fetchDoctorById(record.getDoctor().getDoctorId());
	        Patient patient = patientDao.fetchPatientById(record.getPatient().getPatientId());

	        LocalDateTime startOfDay = record.getVisitDate().atStartOfDay();
	        LocalDateTime endOfDay = record.getVisitDate().atTime(23,59,59);

	        Appointment appointment = appointmentDao.fetchByAppointmentForMedicalReport(doctor, patient, startOfDay, endOfDay);

	        if(appointment.getStatus() != Status.COMPLETED)
	            throw new AppointmentNotCompletedException("Medical record can be created only after appointment completion");
	        record.setDoctor(doctor);
	        record.setPatient(patient);
	        return recordRepository.save(record);
	    }

	    public List<MedicalRecord> fetchAllReport(){
	        List<MedicalRecord> reports = recordRepository.findAll();
	        if(!reports.isEmpty())
	            return reports;
	        else
	            throw new NoDataFoundException("No report is found is DB");
	    }

	    public MedicalRecord fetchReportById(Long id){
	        Optional<MedicalRecord> opt = recordRepository.findById(id);
	        if(opt.isPresent())
	            return opt.get();
	        else
	            throw new IdNotFoundException("Id not Match in DB");
	    }

	    public List<MedicalRecord> fetchReportByPatient(Long id){
	        Patient patient = patientDao.fetchPatientById(id);
	        List<MedicalRecord> reports = recordRepository.findByPatient(patient);
	        if(!reports.isEmpty())
	            return reports;
	        else
	            throw new NoDataFoundException("No report is found is DB");
	    }


	    public List<MedicalRecord> fetchReportByDoctor(Long id){
	        Doctor doctor = doctorDao.fetchDoctorById(id);
	        List<MedicalRecord> reports = recordRepository.findByDoctor(doctor);
	        if(!reports.isEmpty())
	            return reports;
	        else
	            throw new NoDataFoundException("No report is found is DB");
	    }
	    
	    public MedicalRecord fetchReportByAppointment(Long id){
	        Appointment appointment = appointmentDao.fetchAppointmentById(id);
	        Doctor doctor = appointment.getDoctor();
	        Patient patient = appointment.getPatient();
	        LocalDate visitDate = appointment.getAppointmentDateTime().toLocalDate();
	        Optional<MedicalRecord> opt =  recordRepository.findByDoctorAndPatientAndVisitDate(doctor, patient, visitDate);
	        if(opt.isPresent())
	            return opt.get();
	        else
	            throw new NoDataFoundException("No Report is found for appointment");
	    }

	    public List<MedicalRecord> fetchReportByVisitDate(LocalDate visitDate){
	        List<MedicalRecord> reports = recordRepository.findByVisitDate(visitDate);
	        if(!reports.isEmpty())
	            return reports;
	        else
	            throw new NoDataFoundException("No reports found for given date");
	    }
	  

	}

