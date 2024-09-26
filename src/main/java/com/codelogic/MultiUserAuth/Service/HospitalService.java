package com.codelogic.MultiUserAuth.Service;

import com.codelogic.MultiUserAuth.Model.Hospital;
import com.codelogic.MultiUserAuth.Repository.HospitalRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.logging.Logger;
 
@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;
 
    public Hospital addHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }
 
    public List<Hospital> addAllHospitals(List<Hospital> hospitals) {
        return  hospitalRepository.saveAll(hospitals);
    }
    public Hospital getHospitalByID(int id) {
         return hospitalRepository.findById(id).orElse(null);
     }
    public Hospital getHospitalByName(String name) {
        return hospitalRepository.findByName(name);
    }


    public Hospital updateHospital(Hospital hospital)
    {
        Hospital existingPLA = hospitalRepository.findById(hospital.getId()).orElse(null);
        System.out.println(hospital);
        if(existingPLA == null) {
            System.out.println("Hospital not found");
            return  hospitalRepository.save(hospital);
        }else  {

         
            existingPLA.setName(hospital.getName());
            existingPLA.setHdescription(hospital.getHdescription());
            existingPLA.setAddress(hospital.getAddress());
            existingPLA.setContact(hospital.getContact());
            existingPLA.setAppointment(hospital.getAppointment());
            hospitalRepository.save(existingPLA);
        }
        return hospital;
    }
    public boolean deleteHospitalByID(int id) {
        Hospital existingPLA = hospitalRepository.getById(id);
        if(existingPLA != null) {
            hospitalRepository.deleteById(id);
            return true;
        }
        return false;
    }
 
    public List<Hospital>getAllHospitals()
    {
        return hospitalRepository.findAll();
    }
 
}