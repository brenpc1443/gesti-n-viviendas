package com.gestion.viviendas.domain.repository;

import com.gestion.viviendas.domain.Rent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RentRepository {

    List<Rent> getAll();
    Optional<Rent> getById(int rentId);
    Optional<List<Rent>> getByUser(int userId);
    Optional<List<Rent>> getByProperty(int propertyId);
    /*List<Rent> findByUsuario_IdUsuarioAndFechaInicioBetween(
            int userId,
            LocalDateTime startDate,
            LocalDateTime endDate
    );*/
    Optional<List<Rent>> findByFechaInicioAfter(LocalDateTime currentDateTime);
    Rent save(Rent rent);
    void delete(int rentId);
}
