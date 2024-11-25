package com.gestion.viviendas.persistence.mapper;

import com.gestion.viviendas.domain.Property;
import com.gestion.viviendas.persistence.entity.Propiedad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface PropertyMapper {

    @Mappings({
            @Mapping(source = "idPropiedad", target = "propertyId"),
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "nroTitulo", target = "nTitle"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "ciudad", target = "city"),
            @Mapping(source = "ubicacion", target = "ubication"),
            @Mapping(source = "precio", target = "price"),
            @Mapping(source = "disponibilidad", target = "availability"),
            @Mapping(source = "imagen", target = "image"),
            @Mapping(source = "tipo", target = "type"),
            @Mapping(source = "capacidad", target = "capacity"),
            @Mapping(source = "nroHabitaciones", target = "nRooms"),
            @Mapping(source = "caractAdicionales", target = "additioFeatures"),
            @Mapping(source = "usuario", target = "user"),
    })

    Property toProperty(Propiedad propiedad);
    List<Property> toProperties(List<Propiedad> propiedades);

    @InheritInverseConfiguration
    @Mapping(target = "alquileres", ignore = true)
    Propiedad toPropiedad(Property property);
}