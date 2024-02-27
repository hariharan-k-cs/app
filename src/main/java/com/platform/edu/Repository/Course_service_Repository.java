package com.platform.edu.Repository;

import com.platform.edu.Entity.Courseservice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Course_service_Repository extends JpaRepository<Courseservice,Integer> {

    Courseservice findByheading(String value);
}
