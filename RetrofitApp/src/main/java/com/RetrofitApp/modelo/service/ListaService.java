package com.RetrofitApp.modelo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RetrofitApp.modelo.entity.Lista;
import com.RetrofitApp.modelo.repository.ListaRepository;

@Service
public class ListaService {

    private final ListaRepository listaRepository;

    public ListaService(ListaRepository listaRepository) {
        this.listaRepository = listaRepository;
    }

    public List<Lista> findAll() {
        return listaRepository.findAll();
    }

    public Optional<Lista> findById(Long id) {
        return listaRepository.findById(id);
    }

    public Lista save(Lista lista) {
        return listaRepository.save(lista);
    }

    public void deleteById(Long id) {
        listaRepository.deleteById(id);
    }
}
