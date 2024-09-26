package com.gestion.viviendas.persistence.crud;

import com.gestion.viviendas.persistence.entity.Propiedad;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropiedadCrudRepository extends CrudRepository<Propiedad, Integer> {

    List<Propiedad> findByIdUsuario (int idUsuario);

    //List<Propiedad> findByDisponibilidad (String disponibilidad);

    List<Propiedad> findByCapacidadBetween (int min, int max);

    List<Propiedad> findByTipo (String tipo);
}
