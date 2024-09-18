package com.gestion.viviendas.persistence;

import com.gestion.viviendas.persistence.crud.PropiedadCrudRepository;
import com.gestion.viviendas.persistence.entity.Propiedad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PropiedadRepository {

    @Autowired
    private PropiedadCrudRepository propiedadCrudRepository;

    public List<Propiedad> getAll() {
        return (List<Propiedad>) propiedadCrudRepository.findAll();
    }

    public Optional<Propiedad> getById(int idPropiedad) {
        return (Optional<Propiedad>) propiedadCrudRepository.findById(idPropiedad);
    }

    public List<Propiedad> getByUsuario(int idUsuario) {
        return propiedadCrudRepository.findByIdUsuario(idUsuario);
    }

    /*
    public List<Propiedad> getByDisponibilidad(String disponibilidad) {
        return propiedadCrudRepository.findByDisponibilidad(disponibilidad);
    }
    */

    public List<Propiedad> getByCapacidadBetween(int min, int max) {
        return propiedadCrudRepository.findByCapacidadBetween(min, max);
    }

    public List<Propiedad> getByTipo(String tipo) {
        return propiedadCrudRepository.findByTipo(tipo);
    }

    public Propiedad save(Propiedad propiedad) {
        return propiedadCrudRepository.save(propiedad);
    }

    public void delete(int idPropiedad) {
        propiedadCrudRepository.deleteById(idPropiedad);
    }
}
