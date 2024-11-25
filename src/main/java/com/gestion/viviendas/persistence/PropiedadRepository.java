package com.gestion.viviendas.persistence;

import com.gestion.viviendas.domain.Property;
import com.gestion.viviendas.domain.repository.PropertyRepository;
import com.gestion.viviendas.persistence.crud.PropiedadCrudRepository;
import com.gestion.viviendas.persistence.entity.Propiedad;
import com.gestion.viviendas.persistence.mapper.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PropiedadRepository implements PropertyRepository {

    @Autowired
    private PropiedadCrudRepository propiedadCrudRepository;

    @Autowired
    private PropertyMapper mapper;

    @Override
    public List<Property> getAll() {
        List<Propiedad> propiedades = (List<Propiedad>) propiedadCrudRepository.findAll();
        return mapper.toProperties(propiedades);
    }

    @Override
    public Optional<Property> getById(int propertyId) {
        return propiedadCrudRepository.findById(propertyId).map(propiedad -> mapper.toProperty(propiedad));
    }

    @Override
    public Optional<List<Property>> getByUser(int userId) {
        List<Propiedad> propiedades = propiedadCrudRepository.findByIdUsuario(userId);
        return Optional.of(mapper.toProperties(propiedades));
    }

    @Override
    public Optional<List<Property>> filter(Double precio,
            String ciudad,
            String tipo,
            Integer capacidad,
            Integer nroHabitaciones) {
        List<Propiedad> propiedades = propiedadCrudRepository.filter(precio, ciudad, tipo, capacidad, nroHabitaciones);
        return Optional.of(mapper.toProperties(propiedades));
    }

    @Override
    public Property save(Property property) {
        Propiedad propiedad = mapper.toPropiedad(property);
        return mapper.toProperty(propiedadCrudRepository.save(propiedad));
    }

    @Override
    public void delete(int propertyId) {
        propiedadCrudRepository.deleteById(propertyId);
    }
}
