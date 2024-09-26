package com.codelogic.MultiUserAuth.Controller;



import com.codelogic.MultiUserAuth.Model.Test;
import com.codelogic.MultiUserAuth.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
 
@RequestMapping("/test")
//@CrossOrigin(origins = "http://localhost:4200")
public class TestController {

    @Autowired
    private TestService testService;

    //when ever add new hospital
    @PostMapping("/addTest")
    public Test addTest(@RequestBody Test test)
    {
        return testService.addTest(test);
    }

    //more than 1 hospital
        @PostMapping("/addTests")
        public List<Test> addAllTests(@RequestBody List<Test> tests)
        {
            return testService.addAllTests(tests);
        }
        //get plan by hospital name

        @GetMapping("/getTestByName/{name}")
        public Test getTestByName(@PathVariable String name)
        {
            return testService.getTestByName(name);
        }

         // Update hospital
        @PutMapping("/updateTest")
        public Test updateTest(@RequestBody Test test) {
            return testService.updateTest(test);
        }
     // Delete plan
        @DeleteMapping("/deleteTestById/{id}")
        public boolean deleteTestByID(@PathVariable int id) {
            return testService.deleteTestByID(id);
        }
     // Get all hospital
        @GetMapping("/getAll")
        public List<Test> getAllTest() {
            return testService.getAllTests();
        }

 
}