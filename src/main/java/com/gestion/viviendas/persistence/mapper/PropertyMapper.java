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
            @Mapping(source = "direccion", target = "direction"),
            @Mapping(source = "disponibilidad", target = "availability"),
            @Mapping(source = "tipo", target = "type"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "capacidad", target = "capacity"),
            @Mapping(source = "usuario", target = "user"),
    })

    Property toProperty(Propiedad propiedad);
    List<Property> toProperties(List<Propiedad> propiedades);

    @InheritInverseConfiguration
    @Mapping(target = "alquileres", ignore = true)
    Propiedad toPropiedad(Property property);
}
