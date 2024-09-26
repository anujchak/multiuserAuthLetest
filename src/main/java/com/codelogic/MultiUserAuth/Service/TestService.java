package com.codelogic.MultiUserAuth.Service;

import com.codelogic.MultiUserAuth.Model.Test;
import com.codelogic.MultiUserAuth.Repository.TestRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.logging.Logger;
 
@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;
 
    public Test addTest(Test test) {
        return testRepository.save(test);
    }
 
    public List<Test> addAllTests(List<Test> tests) {
        return  testRepository.saveAll(tests);
    }
    public Test getTestByID(int id) {
         return testRepository.findById(id).orElse(null);
     }
    public Test getTestByName(String name) {
        return testRepository.findByName(name);
    }


    public Test updateTest(Test test)
    {
    	Test existingPLA = testRepository.findById(test.getId()).orElse(null);
        System.out.println(test);
        if(existingPLA == null) {
            System.out.println("Test not found");
            return  testRepository.save(test);
        }else  {

         
            existingPLA.setName(test.getName());
            existingPLA.setTdescription(test.getTdescription());
            existingPLA.setUnit(test.getUnit());
            existingPLA.setPrice(test.getPrice());
            existingPLA.setRange(test.getRange());
            testRepository.save(existingPLA);
        }
        return test;
    }
    public boolean deleteTestByID(int id) {
        Test existingPLA = testRepository.getById(id);
        if(existingPLA != null) {
            testRepository.deleteById(id);
            return true;
        }
        return false;
    }
 
    public List<Test>getAllTests()
    {
        return testRepository.findAll();
    }
 
}