package com.RetrofitApp.modelo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RetrofitApp.modelo.entity.Cancion;
import com.RetrofitApp.modelo.repository.CancionRepository;

@Service
public class CancionService {

    private final CancionRepository cancionRepository;

    public CancionService(CancionRepository cancionRepository) {
        this.cancionRepository = cancionRepository;
    }

    public List<Cancion> findAll() {
        return cancionRepository.findAll();
    }

    public Optional<Cancion> findById(Long id) {
        return cancionRepository.findById(id);
    }

    public Cancion save(Cancion cancion) {
        return cancionRepository.save(cancion);
    }

    public void deleteById(Long id) {
        cancionRepository.deleteById(id);
    }
}
