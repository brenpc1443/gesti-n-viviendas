package com.gestion.viviendas.persistence;

import com.gestion.viviendas.persistence.crud.AlquilerCrudRepository;
import com.gestion.viviendas.persistence.entity.Alquiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlquilerRepository {

    @Autowired
    private AlquilerCrudRepository alquilerCrudRepository;

    public List<Alquiler> getAll() {
        return (List<Alquiler>) alquilerCrudRepository.findAll();
    }

    public Optional<Alquiler> getById(int idAlquiler) {
        return (Optional<Alquiler>) alquilerCrudRepository.findById(idAlquiler);
    }

    public List<Alquiler> getByUsuario(int idUsuario) {
        return alquilerCrudRepository.findByIdUsuario(idUsuario);
    }

    public List<Alquiler> getByPropiedad(int idPropiedad) {
        return alquilerCrudRepository.findByIdPropiedad(idPropiedad);
    }

    public Alquiler save(Alquiler alquiler) {
        return alquilerCrudRepository.save(alquiler);
    }

    public void delete(int idAlquiler) {
        alquilerCrudRepository.deleteById(idAlquiler);
    }
}
