package com.platform.edu.service;

import com.platform.edu.Entity.Courseservice;
import java.util.List;
import java.util.Map;
public interface course_service {
    public Courseservice saveCourse(Courseservice course);
    public List<Courseservice> saveCourses(List<Courseservice> course);
    public List<Courseservice>getCourse();
    public Courseservice getValueByParam(Map<String,String> course);
    public String delectCourse(int id);
    public Courseservice updatecourse(Courseservice course);
}
