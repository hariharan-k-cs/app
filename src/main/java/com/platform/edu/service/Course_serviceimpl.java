package com.platform.edu.service;

import com.platform.edu.Entity.Courseservice;
import com.platform.edu.Repository.Course_service_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Course_serviceimpl implements course_service{
    @Autowired
    private Course_service_Repository Repository;
    @Override
    public Courseservice saveCourse(Courseservice course){
        return Repository.save(course);
    }
    @Override
    public List<Courseservice> saveCourses(List<Courseservice> course){
        return Repository.saveAll(course);
    }
    @Override
    public List<Courseservice>getCourse(){
        return Repository.findAll();
    }
    @Override
    public String delectCourse(int id){
        Repository.deleteById(id);
        return  "item delect id " + id;
    }
    public Courseservice getValueByParam(Map<String,String> course) {
        Courseservice user = null;
        for (Map.Entry<String, String> entry : course.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            switch (key) {
                case "id":
                    user = Repository.findById(Integer.parseInt(value)).orElse(null);
                    break;
                case "heading":
                    user = Repository.findByheading(value);
                    break;
            }

        }

        return user;
    }
    @Override
    public Courseservice updatecourse(Courseservice course){
        Courseservice existingCourse = Repository.findById(course.getId()).orElse(null);
        existingCourse.setTitle(course.getTitle());
        existingCourse.setHeading(course.getHeading());
        existingCourse.setCourse_Details(course.getCourse_Details());
        existingCourse.setPaid(course.isPaid());
        existingCourse.setRating(course.getRating());
        return  Repository.save(existingCourse);


    }
}
