package com.gestion.viviendas.web.controller;

import com.gestion.viviendas.domain.Rent;
import com.gestion.viviendas.domain.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rents")
public class RentController {

    @Autowired
    private RentService rentService;

    @GetMapping("/all")
    public List<Rent> getAll(){
        return rentService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Rent> getById(@PathVariable("id") int rentId){
        return rentService.getById(rentId);
    }

    @GetMapping("/user/{id}")
    public Optional<List<Rent>> getByUser(@PathVariable("id") int userId){
        return rentService.getByUser(userId);
    }

    @GetMapping("/property/{id}")
    public Optional<List<Rent>> getByProperty(@PathVariable("id") int propertyId){
        return rentService.getByProperty(propertyId);
    }

    @GetMapping("/dateafter")
    public Optional<List<Rent>> findByFechaInicioAfter(
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime currentDateTime
    ){
        return rentService.findByFechaInicioAfter(currentDateTime);
    }

    @PostMapping("/")
    public Rent save(@RequestBody Rent rent){
        return rentService.save(rent);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int rentId){
        return rentService.delete(rentId);
    }
}
