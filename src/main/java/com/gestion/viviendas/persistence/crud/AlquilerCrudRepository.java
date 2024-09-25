package com.gestion.viviendas.persistence.crud;

import com.gestion.viviendas.persistence.entity.Alquiler;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AlquilerCrudRepository extends CrudRepository<Alquiler, Integer>{

    List<Alquiler> findByIdUsuario (int idUsuario);

    List<Alquiler> findByIdPropiedad (int idPropiedad);

    List<Alquiler> findByFechaInicioAfter(LocalDateTime currentDateTime);


}
