package com.RetrofitApp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RetrofitApp.modelo.entity.Usuario;
import com.RetrofitApp.modelo.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Operation(summary = "Retorna el listado de usuarios")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuarios obtenidos correctamente"),
        @ApiResponse(responseCode = "204", description = "Usuarios no encontrados"),
        @ApiResponse(responseCode = "400", description = "Búsqueda incorrecta"),
        @ApiResponse(responseCode = "401", description = "No está autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public List<Usuario> getAll() {
        return usuarioService.findAll();
    }

    @Operation(summary = "Retorna el usuario buscado por id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario obtenidos correctamente"),
        @ApiResponse(responseCode = "204", description = "Usuario no encontrados"),
        @ApiResponse(responseCode = "400", description = "Búsqueda incorrecta"),
        @ApiResponse(responseCode = "401", description = "No está autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id) {
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crea el usuario")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario creado correctamente"),
        @ApiResponse(responseCode = "204", description = "Usuario no encontrados"),
        @ApiResponse(responseCode = "400", description = "Búsqueda incorrecta"),
        @ApiResponse(responseCode = "401", description = "No está autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @Operation(summary = "Elimina el usuario por el id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario eliminado correctamente"),
        @ApiResponse(responseCode = "204", description = "Usuario no encontrados"),
        @ApiResponse(responseCode = "400", description = "Búsqueda incorrecta"),
        @ApiResponse(responseCode = "401", description = "No está autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
