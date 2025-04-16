package com.project.dbms_mini_project_backend.controller;

import com.project.dbms_mini_project_backend.entity.Bus;
import com.project.dbms_mini_project_backend.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.dbms_mini_project_backend.repository.BusRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/buses")
@CrossOrigin(origins = "*")
public class BusController {

    @Autowired
    private final BusRepository busRepository;

    @Autowired
    private BusService busService;

    public BusController(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @GetMapping
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

//    @PutMapping("/api/buses/{id}")
//    public ResponseEntity<Bus> updateBus(@PathVariable Long id, @RequestBody Bus updatedBus) {
//        Optional<Bus> busOptional = busRepository.findById(id);
//        if (busOptional.isPresent()) {
//            Bus existingBus = busOptional.get();
//            existingBus.setRoute(updatedBus.getRoute());
//            existingBus.setDepartureTime(updatedBus.getDepartureTime());
//            existingBus.setArrivalTime(updatedBus.getArrivalTime());
//            return ResponseEntity.ok(busRepository.save(existingBus));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @PutMapping("/api/buses/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable Long id, @RequestBody Bus updatedBus) {
        Bus savedBus = busService.updateBus(id, updatedBus);
        if(savedBus != null)
            return ResponseEntity.ok(savedBus);
        else
            return ResponseEntity.notFound().build();
    }



}

