package jsp.hospitalmanagement.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jsp.hospitalmanagement.dto.ResponseStructure;
import jsp.hospitalmanagement.entity.MedicalRecord;
import jsp.hospitalmanagement.service.MedicalRecordService;

@Controller
@RequestMapping("/healhub/record")
public class MedicalRecordController {
	 @Autowired
	    private MedicalRecordService recordService;

	    @PostMapping
	    public ResponseEntity<ResponseStructure<MedicalRecord>> createReport(@RequestBody MedicalRecord record){
	        return recordService.createReport(record);
	    }

	    @GetMapping("/all")
	    public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchAllReport(){
	        return recordService.fetchAllReport();
	    }


	    @GetMapping("/id/{id}")
	    public ResponseEntity<ResponseStructure<MedicalRecord>> fetchReportById(@PathVariable Long id){
	        return recordService.fetchReportById(id);
	    }


	    @GetMapping("/patient/{id}")
	    public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchReportByPatient(@PathVariable Long id){
	        return recordService.fetchReportByPatient(id);
	    }


	    @GetMapping("/doctor/{id}")
	    public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchReportByDoctor(@PathVariable Long id){
	        return recordService.fetchReportByDoctor(id);
	    }
	    @GetMapping("/appointment/{id}")
	    public ResponseEntity<ResponseStructure<MedicalRecord>> fetchReportByAppointment(@PathVariable Long id){
	        return recordService.fetchReportByAppointment(id);
	    }

	    @GetMapping("/visitDate/{date}")
	    public ResponseEntity<ResponseStructure<List<MedicalRecord>>> fetchReportByVisitDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
	        return recordService.fetchReportByVisitDate(date);
	    }
	    
	}

