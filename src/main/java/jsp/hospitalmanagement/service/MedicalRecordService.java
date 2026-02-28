package jsp.hospitalmanagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.hospitalmanagement.dao.MedicalRecordDao;
import jsp.hospitalmanagement.dto.ResponseStructure;
import jsp.hospitalmanagement.entity.MedicalRecord;

@Service
public class MedicalRecordService {
	 @Autowired
	    private MedicalRecordDao recordDao;

	    public ResponseEntity<ResponseStructure<MedicalRecord>> createReport(MedicalRecord record){
	        ResponseStructure<MedicalRecord> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Record is created");
	        response.setData(recordDao.createRecord(record));
	        return new ResponseEntity<ResponseStructure<MedicalRecord>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchAllReport(){
	        ResponseStructure<List<MedicalRecord>> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Record is found");
	        response.setData(recordDao.fetchAllReport());
	        return new ResponseEntity<ResponseStructure<List<MedicalRecord>>>(response, HttpStatus.OK);
	    }


	    public ResponseEntity<ResponseStructure<MedicalRecord>> fetchReportById(Long id){
	        ResponseStructure<MedicalRecord> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Record is found");
	        response.setData(recordDao.fetchReportById(id));
	        return new ResponseEntity<ResponseStructure<MedicalRecord>>(response, HttpStatus.OK);
	    }


	        public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchReportByPatient(Long id){
	        ResponseStructure<List<MedicalRecord>> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Record is found");
	        response.setData(recordDao.fetchReportByPatient(id));
	        return new ResponseEntity<ResponseStructure<List<MedicalRecord>>>(response, HttpStatus.OK);
	      }


	    public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchReportByDoctor(Long id){
	        ResponseStructure<List<MedicalRecord>> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Record is found");
	        response.setData(recordDao.fetchReportByDoctor(id));
	        return new ResponseEntity<ResponseStructure<List<MedicalRecord>>>(response, HttpStatus.OK);
	    }
	    public ResponseEntity<ResponseStructure<MedicalRecord>> fetchReportByAppointment(Long id){
	        ResponseStructure<MedicalRecord> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Record is found");
	        response.setData(recordDao.fetchReportByAppointment(id));
	        return new ResponseEntity<ResponseStructure<MedicalRecord>>(response, HttpStatus.OK);
	    }

	    public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchReportByVisitDate(LocalDate visitDate){
	        ResponseStructure<List<MedicalRecord>> response = new ResponseStructure<>();
	        response.setStatusCode(HttpStatus.OK.value());
	        response.setMessage("Record is found");
	        response.setData(recordDao.fetchReportByVisitDate(visitDate));
	        return new ResponseEntity<ResponseStructure<List<MedicalRecord>>>(response, HttpStatus.OK);
	    }
	    
	}

