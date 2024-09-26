package com.codelogic.MultiUserAuth.Controller;

import com.codelogic.MultiUserAuth.Model.Hospital;
import com.codelogic.MultiUserAuth.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
 
@RequestMapping("/hospital")
//@CrossOrigin(origins = "http://localhost:4200")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    //when ever add new hospital
    @PostMapping("/addHospital")
    public Hospital addHospital(@RequestBody Hospital hospital)
    {
        return hospitalService.addHospital(hospital);
    }

    //more than 1 hospital
        @PostMapping("/addHospitals")
        public List<Hospital> addAllHospitals(@RequestBody List<Hospital> hospitals)
        {
            return hospitalService.addAllHospitals(hospitals);
        }
        //get plan by hospital name

        @GetMapping("/getHospitalByName/{name}")
        public Hospital getHospitalByName(@PathVariable String name)
        {   System.out.println("hospital");
        
            return hospitalService.getHospitalByName(name);
        }

         // Update hospital
        @PutMapping("/updateHospital")
        public Hospital updateHospital(@RequestBody Hospital hospital) {
            return hospitalService.updateHospital(hospital);
        }
     // Delete plan
        @DeleteMapping("/deleteHospitalById/{id}")
        public boolean deleteHospitalByID(@PathVariable int id) {
            return hospitalService.deleteHospitalByID(id);
        }
     // Get all hospital
        @GetMapping("/getAll")
        public List<Hospital> getAllHospital() {
            return hospitalService.getAllHospitals();
        }

 
}