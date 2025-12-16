package com.RetrofitApp.controller;

import com.RetrofitApp.modelo.entity.Lista;
import com.RetrofitApp.modelo.service.ListaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listas")
public class ListaController {

    private final ListaService listaService;

    public ListaController(ListaService listaService) {
        this.listaService = listaService;
    }

    @Operation(summary = "Retorna el listado de Listas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Listas obtenidas correctamente"),
        @ApiResponse(responseCode = "204", description = "Listas no encontradas"),
        @ApiResponse(responseCode = "400", description = "Búsqueda incorrecta"),
        @ApiResponse(responseCode = "401", description = "No está autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public List<Lista> getAll() {
        return listaService.findAll();
    }

    @Operation(summary = "Retorna la lista por el id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista obtenidas correctamente"),
        @ApiResponse(responseCode = "204", description = "Lista no encontrada"),
        @ApiResponse(responseCode = "400", description = "Búsqueda incorrecta"),
        @ApiResponse(responseCode = "401", description = "No está autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Lista> getById(@PathVariable Long id) {
        return listaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crea la lista")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista creada correctamente"),
        @ApiResponse(responseCode = "204", description = "Lista no encontrada"),
        @ApiResponse(responseCode = "400", description = "Búsqueda incorrecta"),
        @ApiResponse(responseCode = "401", description = "No está autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping
    public Lista create(@RequestBody Lista lista) {
        return listaService.save(lista);
    }

    @Operation(summary = "Elimina la lista por id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista eliminada correctamente"),
        @ApiResponse(responseCode = "204", description = "Lista no encontrada"),
        @ApiResponse(responseCode = "400", description = "Búsqueda incorrecta"),
        @ApiResponse(responseCode = "401", description = "No está autorizado"),
        @ApiResponse(responseCode = "403", description = "Acceso prohibido"),
        @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        listaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
