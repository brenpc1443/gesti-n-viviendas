package com.gestion.viviendas.domain.service;

import com.gestion.viviendas.domain.Rent;
import com.gestion.viviendas.domain.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RentService {

    @Autowired
    private RentRepository rentRepository;

    public List<Rent> getAll(){
        return rentRepository.getAll();
    }

    public Optional<Rent> getById(int rentId){
        return rentRepository.getById(rentId);
    }

    public Optional<List<Rent>> getByUser(int userId){
        return rentRepository.getByUser(userId);
    }

    public Optional<List<Rent>> getByProperty(int propertyId){
        return rentRepository.getByProperty(propertyId);
    }

    public Optional<List<Rent>> findByFechaInicioAfter(LocalDateTime currentDateTime){
        return rentRepository.findByFechaInicioAfter(currentDateTime);
    }

    public Rent save(Rent rent){
        return rentRepository.save(rent);
    }

    public boolean delete(int rentId){
        return getById(rentId).map(rent -> {
            rentRepository.delete(rentId);
            return true;
        }).orElse(false);
    }
}
