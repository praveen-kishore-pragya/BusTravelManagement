package com.project.dbms_mini_project_backend.repository;

import com.project.dbms_mini_project_backend.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BusRepository extends JpaRepository<Bus, Long> {

}
