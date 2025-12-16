package com.RetrofitApp.modelo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RetrofitApp.modelo.entity.Grupo;
import com.RetrofitApp.modelo.repository.GrupoRepository;

@Service
public class GrupoService {

    private final GrupoRepository grupoRepository;

    public GrupoService(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    public List<Grupo> findAll() {
        return grupoRepository.findAll();
    }

    public Optional<Grupo> findById(Long id) {
        return grupoRepository.findById(id);
    }

    public Grupo save(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    public void deleteById(Long id) {
        grupoRepository.deleteById(id);
    }
}
