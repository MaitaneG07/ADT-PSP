package com.RetrofitApp.modelo.repository;

import com.RetrofitApp.modelo.entity.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepository extends JpaRepository<Cancion, Long> {
}
