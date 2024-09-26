package com.gestion.viviendas.persistence;

import com.gestion.viviendas.domain.Rent;
import com.gestion.viviendas.domain.repository.RentRepository;
import com.gestion.viviendas.persistence.crud.AlquilerCrudRepository;
import com.gestion.viviendas.persistence.entity.Alquiler;
import com.gestion.viviendas.persistence.mapper.RentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class AlquilerRepository implements RentRepository {

    @Autowired
    private AlquilerCrudRepository alquilerCrudRepository;

    @Autowired
    private RentMapper mapper;


    @Override
    public List<Rent> getAll() {
        List<Alquiler> alquileres = (List<Alquiler>) alquilerCrudRepository.findAll();
        return mapper.toRents(alquileres);
    }

    @Override
    public Optional<Rent> getById(int rentId) {
        return alquilerCrudRepository.findById(rentId).map(alquiler -> mapper.toRent(alquiler));
    }

    @Override
    public Optional<List<Rent>> getByUser(int rentId) {
        List<Alquiler> alquileres = alquilerCrudRepository.findByIdUsuario(rentId);
        return Optional.of(mapper.toRents(alquileres));
    }

    @Override
    public Optional<List<Rent>> getByProperty(int propertyId) {
        List<Alquiler> alquileres = alquilerCrudRepository.findByIdPropiedad(propertyId);
        return Optional.of(mapper.toRents(alquileres));
    }

    @Override
    public Optional<List<Rent>> findByFechaInicioAfter(LocalDateTime currentDateTime) {
        List<Alquiler> alquileres = alquilerCrudRepository.findByFechaInicioAfter(currentDateTime);
        return Optional.of(mapper.toRents(alquileres));
    }

    @Override
    public Rent save(Rent rent) {
        Alquiler alquiler = mapper.toAlquiler(rent);
        return mapper.toRent(alquilerCrudRepository.save(alquiler));
    }

    @Override
    public void delete(int rentId) {
        alquilerCrudRepository.deleteById(rentId);
    }
}
