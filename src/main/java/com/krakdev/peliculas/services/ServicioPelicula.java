package com.krakdev.peliculas.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.krakdev.peliculas.entidades.Pelicula;
import com.krakdev.peliculas.repository.PeliculaRepository;

@Service
public class ServicioPelicula {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public Pelicula crear(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public List<Pelicula> listar() {
        return peliculaRepository.findAll();
    }

    public Pelicula buscarPorId(Long id) {
        Optional<Pelicula> peliculaOpt = peliculaRepository.findById(id);
        return peliculaOpt.orElse(null);
    }

    public Pelicula actualizar(Long id, Pelicula peliculaActualizada) {
        Optional<Pelicula> peliculaOpt = peliculaRepository.findById(id);
        if (peliculaOpt.isPresent()) {
            Pelicula peliculaExistente = peliculaOpt.get();
            peliculaExistente.setNombre(peliculaActualizada.getNombre());
            peliculaExistente.setDirector(peliculaActualizada.getDirector());
            peliculaExistente.setGenero(peliculaActualizada.getGenero());
            peliculaExistente.setDuracion(peliculaActualizada.getDuracion());
            peliculaExistente.setDisponible(peliculaActualizada.isDisponible());
            if (peliculaActualizada.getCalificacion() != null) {
                peliculaExistente.setCalificacion(peliculaActualizada.getCalificacion());
            }
            return peliculaRepository.save(peliculaExistente);
        }
        return null;
    }

    public boolean eliminar(Long id) {
        if (peliculaRepository.existsById(id)) {
            peliculaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Pelicula> buscarPorGenero(String genero) {
        return peliculaRepository.findByGenero(genero);
    }

    public List<Pelicula> buscarPorDisponible(boolean disponible) {
        return peliculaRepository.findByDisponible(disponible);
    }
}
