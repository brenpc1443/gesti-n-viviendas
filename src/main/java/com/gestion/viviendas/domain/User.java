package com.gestion.viviendas.domain;

import com.gestion.viviendas.persistence.entity.Usuario;
import com.gestion.viviendas.persistence.type.RolUser;

public class User {

    private int userId;
    private String name;
    private String lastName;
    private String userName;
    private String phone;
    private String password;
    //private RolUser rol;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //public RolUser getRol() {
    //    return rol;
    //}

    //public void setRol(RolUser rol) {
    //    this.rol = rol;
    //}
}
