package com.RetrofitApp.modelo.entity;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_Usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String apellido;
    
    @Column(nullable = false, unique = true)
    private String login;
    
    @Column(nullable = false)
    private String password;
    
    // Un usuario tiene muchas listas
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lista> listas = new ArrayList<>();
    
    public Usuario() {}
    
    public Usuario(String nombre, String apellido, String login, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.login = login;
        this.password = password;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
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
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public List<Lista> getListas() {
        return listas;
    }
    
    public void setListas(List<Lista> listas) {
        this.listas = listas;
    }
    
    public void addLista(Lista lista) {
        listas.add(lista);
        lista.setUsuario(this);
    }
    
    public void removeLista(Lista lista) {
        listas.remove(lista);
        lista.setUsuario(null);
    }
}