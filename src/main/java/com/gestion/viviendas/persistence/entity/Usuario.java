package com.gestion.viviendas.persistence.entity;

import com.gestion.viviendas.persistence.type.RolUser;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    private String nombre;

    private String apellido;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    private String telefono;

    private String contraseña;

    //@Enumerated(EnumType.STRING)
    //private RolUser rol;

    @OneToMany(mappedBy = "usuario")
    private List<Propiedad> propiedades;

    @OneToMany(mappedBy = "usuario")
    private List<Alquiler> alquileres;


    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario; // Corrigiendo el error
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //public RolUser getRol() {
    //    return rol;
    //}

    //public void setRol(RolUser rol) {
    //    this.rol = rol;
    //}

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<Propiedad> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }
}
