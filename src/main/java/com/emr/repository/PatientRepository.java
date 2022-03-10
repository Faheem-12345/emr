package com.emr.repository;

import org.springframework.data.repository.CrudRepository;

import com.emr.model.Patient;

public interface PatientRepository  extends CrudRepository<Patient, Long> {

}
