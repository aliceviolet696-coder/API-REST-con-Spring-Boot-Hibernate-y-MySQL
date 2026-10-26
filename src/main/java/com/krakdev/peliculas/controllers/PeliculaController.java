package com.krakdev.peliculas.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krakdev.peliculas.entidades.Pelicula;
import com.krakdev.peliculas.services.ServicioPelicula;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private ServicioPelicula servicioPelicula;

    @PostMapping
    public ResponseEntity<Pelicula> crear(@RequestBody Pelicula pelicula) {
        Pelicula nueva = servicioPelicula.crear(pelicula);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pelicula>> listar() {
        List<Pelicula> lista = servicioPelicula.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> buscarPorId(@PathVariable Long id) {
        Pelicula pelicula = servicioPelicula.buscarPorId(id);
        if (pelicula != null) {
            return ResponseEntity.ok(pelicula);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizar(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        Pelicula actualizada = servicioPelicula.actualizar(id, pelicula);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminada = servicioPelicula.eliminar(id);
        if (eliminada) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/genero")
    public ResponseEntity<List<Pelicula>> buscarPorGenero(@RequestParam String genero) {
        List<Pelicula> lista = servicioPelicula.buscarPorGenero(genero);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/disponible")
    public ResponseEntity<List<Pelicula>> buscarPorDisponible(@RequestParam boolean disponible) {
        List<Pelicula> lista = servicioPelicula.buscarPorDisponible(disponible);
        return ResponseEntity.ok(lista);
    }
}
