package com.gestion.viviendas.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "PROPIEDAD")
public class Propiedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_propiedad")
    private Integer idPropiedad;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nro_titulo")
    private String nroTitulo;

    private String descripcion;

    private String ciudad;

    private String ubicacion;

    private double precio;

    private String disponibilidad;

    private String imagen;

    private String tipo;

    private Integer capacidad;

    @Column(name = "nro_habitaciones")
    private Integer nroHabitaciones;

    @Column(name = "caract_adicionales")
    private String caractAdicionales;

    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Usuario usuario;

    @OneToMany(mappedBy = "propiedad")
    private List<Alquiler> alquileres;

    public Integer getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(Integer idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNroTitulo() {
        return nroTitulo;
    }

    public void setNroTitulo(String nroTitulo) {
        this.nroTitulo = nroTitulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getNroHabitaciones() {
        return nroHabitaciones;
    }

    public void setNroHabitaciones(Integer nroHabitaciones) {
        this.nroHabitaciones = nroHabitaciones;
    }

    public String getCaractAdicionales() {
        return caractAdicionales;
    }

    public void setCaractAdicionales(String caractAdicionales) {
        this.caractAdicionales = caractAdicionales;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }
}