package com.emr.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.emr.model.Patient;
import com.emr.repository.PatientRepository;
import com.google.gson.Gson;

@Service
public class PatientService {

	private final RestTemplate restTemplate;

	@Autowired

	public PatientService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<String> getPatientss() {

		String s = restTemplate.getForObject("http://54.196.205.112/fhir/Patient", String.class);
//	    System.out.println(s);
		JSONObject jsonObject = new JSONObject(s);
		JSONArray ja_data = jsonObject.getJSONArray("entry");
		int length = ja_data.length();
//	    System.out.println(length);

		JSONObject jObj3 = null;
		JSONArray ja_data3 = null;
		JSONArray ja_data4 = null;
		List<String> listString = null;
		List<String> terms = null;
		List<String> finalData = null;
		
		for (int i = 0; i < length; i++) {
			JSONObject jObj = ja_data.getJSONObject(i);

			JSONObject jObj2 = jObj.getJSONObject("resource");
//	        System.out.println(jObj2.getString("id"));
//	        if(jObj2.getString("gender")!=null){
//	        	 System.out.println("");
//	        }
	       
//	        System.out.println(jObj2.getString("birthDate"));
			JSONArray ja_data1 = jObj2.getJSONArray("name");
//	        System.out.println(ja_data1);

			JSONArray ja = new JSONArray(ja_data1);
			JSONObject jo = ja.getJSONObject(0);
//			int len = ja_data1.length();
//			for (int j = 0; j < len; j++) {
//				jObj3 = ja_data1.getJSONObject(j);
////	        	System.out.println(jObj3);
//				ja_data3 = jObj3.getJSONArray("given");
////	        	System.out.println(ja_data3);
//			}
			terms = new ArrayList();
			terms.add(jo.toString());
//			terms.add(ja_dayList<String>();
//			terms.add(jObj2.getString("id"));
//			terms.add(ja_daata3.getString(1));
//			terms.add(jObj2.getString("gender"));
//			terms.add(jObj2.getString("birthDate"));

//			System.out.println(jo);
			return terms;
		}
		System.out.println(terms);

		return terms;
	}

	@Autowired
	PatientRepository patientRepository;
	private JSONArray ja_data4;

	public ResponseEntity<Patient> savePatient(Patient patient) {

		Patient patients = patientRepository.save(patient);
		return new ResponseEntity<>(patients, HttpStatus.CREATED);

	}

	public ResponseEntity<List<Patient>> getPatient() {
		List<Patient> patients = new ArrayList<Patient>();
		patientRepository.findAll().forEach(patients::add);
		return new ResponseEntity<>(patients, HttpStatus.OK);
	}

	public String findPatientById(long id) {
		String s = restTemplate.getForObject("http://54.196.205.112/fhir/Patient/" + id, String.class);

		JSONObject jsonObject = new JSONObject(s);
//		JSONArray ja_data = jsonObject.getJSONArray("entry");
//		int length = ja_data.length();
//	    System.out.println(jsonObject.getString("id"));
//	    System.out.println(jsonObject.getString("gender"));
//	    System.out.println(jsonObject.getString("birthDate"));
		JSONArray ja_data1 = jsonObject.getJSONArray("name");
//	    System.out.println(ja_data1);

		JSONArray ja = new JSONArray(ja_data1);
		JSONObject jo = ja.getJSONObject(0);
//	    jo.put("ja_data1", ja_data1);
//		int len = ja_data1.length();
//		for (int j = 0; j < 1; j++) {
//			JSONObject jObj3 = ja_data1.getJSONObject(j);
////        	System.out.println(jObj3);
//			ja_data4 = jObj3.getJSONArray("given");
////        	System.out.println(ja_data4);
//		}
//

		System.out.println(" ");
		System.out.println(jo);
//		
//		String json = new Gson().toJson(terms);
////finalData=finalData+terms;
////		System.out.println(terms);
//		
//		System.out.println(json);
//		

		return jo.toString();
	}

}
