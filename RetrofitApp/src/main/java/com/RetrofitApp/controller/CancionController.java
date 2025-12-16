package com.RetrofitApp.controller;

import com.RetrofitApp.modelo.entity.Cancion;
import com.RetrofitApp.modelo.service.CancionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/canciones")
public class CancionController {

    private final CancionService cancionService;

    public CancionController(CancionService cancionService) {
        this.cancionService = cancionService;
    }

    @Operation(summary = "Retorna el listado de Canciones")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Canciones obtenidas correctamente"),
        @ApiResponse(responseCode = "204", description = "Canciones no encontradas"),
        @ApiResponse(responseCode = "400", description = "Búsqueda incorrecta"),
        @ApiResponse(responseCode = "401", description = "No está autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public List<Cancion> getAll() {
        return cancionService.findAll();
    }

    @Operation(summary = "Retorna la Canción por id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Canción obtenida correctamente"),
        @ApiResponse(responseCode = "204", description = "Canción no encontrada"),
        @ApiResponse(responseCode = "400", description = "Búsqueda incorrecta"),
        @ApiResponse(responseCode = "401", description = "No está autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Cancion> getById(@PathVariable Long id) {
        return cancionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crea la Canción")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Canción creada correctamente"),
        @ApiResponse(responseCode = "204", description = "Canción no encontrada"),
        @ApiResponse(responseCode = "400", description = "Búsqueda incorrecta"),
        @ApiResponse(responseCode = "401", description = "No está autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping
    public Cancion create(@RequestBody Cancion cancion) {
        return cancionService.save(cancion);
    }

    @Operation(summary = "Elimina la Canción por id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Canción eliminada correctamente"),
        @ApiResponse(responseCode = "204", description = "Canción no encontrada"),
        @ApiResponse(responseCode = "400", description = "Búsqueda incorrecta"),
        @ApiResponse(responseCode = "401", description = "No está autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cancionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
