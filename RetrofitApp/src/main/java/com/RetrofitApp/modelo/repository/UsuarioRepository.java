package com.RetrofitApp.modelo.repository;

import com.RetrofitApp.modelo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
