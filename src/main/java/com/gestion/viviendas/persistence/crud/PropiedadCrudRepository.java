package com.gestion.viviendas.persistence.crud;

import com.gestion.viviendas.persistence.entity.Propiedad;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropiedadCrudRepository extends CrudRepository<Propiedad, Integer> {

    List<Propiedad> findByIdUsuario(int idUsuario);

    @Query("SELECT p FROM Propiedad p WHERE " +
            "(:precio IS NULL OR p.precio <= :precio) AND " +
            "(:ciudad IS NULL OR p.ciudad = :ciudad) AND " +
            "(:tipo IS NULL OR p.tipo = :tipo) AND " +
            "(:capacidad IS NULL OR p.capacidad >= :capacidad) AND " +
            "(:nroHabitaciones IS NULL OR p.nroHabitaciones = :nroHabitaciones)")
    List<Propiedad> filter(
            Double precio,
            String ciudad,
            String tipo,
            Integer capacidad,
            Integer nroHabitaciones);

}
