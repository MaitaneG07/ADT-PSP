package com.RetrofitApp.controller;

import com.RetrofitApp.modelo.entity.Grupo;
import com.RetrofitApp.modelo.service.GrupoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    private final GrupoService grupoService;

    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @Operation(summary = "Retorna el listado de Grupos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Grupos obtenidos correctamente"),
        @ApiResponse(responseCode = "204", description = "Grupos no encontrados"),
        @ApiResponse(responseCode = "400", description = "Búsqueda incorrecta"),
        @ApiResponse(responseCode = "401", description = "No está autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public List<Grupo> getAll() {
        return grupoService.findAll();
    }

    @Operation(summary = "Retorna el Grupo por id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Grupo obtenidos correctamente"),
        @ApiResponse(responseCode = "204", description = "Grupo no encontrados"),
        @ApiResponse(responseCode = "400", description = "Búsqueda incorrecta"),
        @ApiResponse(responseCode = "401", description = "No está autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Grupo> getById(@PathVariable Long id) {
        return grupoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crea el Grupos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Grupo creado correctamente"),
        @ApiResponse(responseCode = "204", description = "Grupo no encontrados"),
        @ApiResponse(responseCode = "400", description = "Búsqueda incorrecta"),
        @ApiResponse(responseCode = "401", description = "No está autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping
    public Grupo create(@RequestBody Grupo grupo) {
        return grupoService.save(grupo);
    }

    @Operation(summary = "Elimina el Grupo por id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Grupo eliminado correctamente"),
        @ApiResponse(responseCode = "204", description = "Grupo no encontrados"),
        @ApiResponse(responseCode = "400", description = "Búsqueda incorrecta"),
        @ApiResponse(responseCode = "401", description = "No está autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        grupoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
