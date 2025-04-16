package com.project.dbms_mini_project_backend.service;

import com.project.dbms_mini_project_backend.entity.Bus;
import com.project.dbms_mini_project_backend.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    public Bus updateBus(Long id, Bus updatedBus) {
        Bus existing = busRepository.findById(id).orElseThrow();
        existing.setRoute(updatedBus.getRoute());
        existing.setDepartureTime(updatedBus.getDepartureTime());
        existing.setArrivalTime(updatedBus.getArrivalTime());
        return busRepository.save(existing);
    }


}
