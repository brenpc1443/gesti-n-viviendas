package com.gestion.viviendas.persistence.mapper;

import com.gestion.viviendas.domain.Rent;
import com.gestion.viviendas.persistence.entity.Alquiler;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, PropertyMapper.class})
public interface RentMapper {

    @Mappings({
            @Mapping(source = "idAlquiler", target = "rentId"),
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "idPropiedad", target = "propertyId"),
            @Mapping(source = "fechaInicio", target = "startDate"),
            @Mapping(source = "fechaFin", target = "endDate"),
            @Mapping(source = "imagenComprobante", target = "proofImage"),
            @Mapping(source = "usuario", target = "user"),
            @Mapping(source = "propiedad", target = "property"),
    })

    Rent toRent(Alquiler alquiler);
    List<Rent> toRents(List<Alquiler> alquileres);

    @InheritInverseConfiguration
    Alquiler toAlquiler(Rent rent);
}
