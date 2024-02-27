package com.platform.edu.Controller;

import com.platform.edu.Entity.Courseservice;
import com.platform.edu.service.Course_serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private Course_serviceimpl servicec;

    @GetMapping("/course")
    public List<Courseservice> getCourse(){
        return servicec.getCourse();
    }
    //    @GetMapping("/course/{id}")
//    public Course CourseId(@PathVariable int id){
//        return servicec.CourseByid(id);
//    }
//    @GetMapping("/courseheading/{heading}")
//    public Course Names(@PathVariable String heading){
//        return servicec.Coursebyheading(heading);
//    }
    @GetMapping("/getcourse")
    public ResponseEntity<Courseservice> getvalue(@RequestParam Map<String,String> course){
        Courseservice course1 = servicec.getValueByParam(course);
        if (course1 !=null){
            return ResponseEntity.ok(course1);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addcourse")
    public Courseservice addcourse(@RequestBody Courseservice course){
        return servicec.saveCourse(course);
    }
    @PostMapping("/addcourses")
    public List<Courseservice> addcourses(@RequestBody List<Courseservice> courses){
        return servicec.saveCourses(courses);
    }
    @PutMapping("/update/{id}")
    public Courseservice updatecourse(@PathVariable int id ,@RequestBody Courseservice course){
        return servicec.updatecourse(course);
    }
    @DeleteMapping("/delete/{id}")
    public String deletecourse(@PathVariable int id){
        return servicec.delectCourse(id);

    }
}
