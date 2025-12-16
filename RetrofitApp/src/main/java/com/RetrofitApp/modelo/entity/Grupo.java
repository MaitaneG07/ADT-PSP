package com.RetrofitApp.modelo.entity;

import java.time.LocalDate;
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
@Table(name = "T_Grupo")
public class Grupo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private LocalDate fecha; 
    
    // Un grupo tiene muchas canciones
    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    private List<Cancion> canciones = new ArrayList<>();
    
    public Grupo() {}
    
    public Grupo(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
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
    
    public LocalDate getFecha() {
        return fecha;
    }
    
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public List<Cancion> getCanciones() {
        return canciones;
    }
    
    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
    
    // Métodos helper
    public void addCancion(Cancion cancion) {
        canciones.add(cancion);
        cancion.setGrupo(this);
    }
    
    public void removeCancion(Cancion cancion) {
        canciones.remove(cancion);
        cancion.setGrupo(null);
    }
}