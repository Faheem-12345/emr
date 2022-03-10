package com.emr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emr.model.Patient;
import com.emr.repository.PatientRepository;
import com.emr.service.PatientService;

@RestController
@RequestMapping("/fhir")
public class PatientController {
	
	
	@Autowired
	  PatientService patientService;
	@Autowired
	PatientRepository patientRepository;
	
	 @GetMapping("/getpatients")
	  public List<String> getPatients() {
		return patientService.getPatientss();
	  }
	
	
//	@PostMapping("/patient")
//	  public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
//		ResponseEntity<Patient> patients=patientService.savePatient(patient);
//	      return patients;
//	  }
//	
//	 @GetMapping("/patients")
//	  public ResponseEntity<List<Patient>> getAllPatients() {
//		 ResponseEntity<List<Patient>> patients=patientService.getPatient();
//	      return patients;
//	  }
	 
	 @GetMapping("/getpatient/{id}")
	  public String  getPatientById(@PathVariable("id") long id) {
	     
	  return patientService.findPatientById(id);
	  }
	 
//	 @DeleteMapping("/patient/{id}")
//	  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
//	    try {
//	    	patientRepository.deleteById(id);
//	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	    } catch (Exception e) {
//	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
//	  }

}
