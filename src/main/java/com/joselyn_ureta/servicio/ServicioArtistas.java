package com.joselyn_ureta.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joselyn_ureta.modelos.Artista;
import com.joselyn_ureta.repositorios.RepositorioArtistass;

@Service
public class ServicioArtistas {
    
    @Autowired
    private RepositorioArtistass repositorioArtistass;


    public List<Artista> obtenerTodosLosArtistas(){
        return repositorioArtistass.findAll();
    }

    public Artista obtenerArtistaPorId(Long id) {
        Optional<Artista> artistaOptional = repositorioArtistass.findById(id);
        if (artistaOptional.isPresent()) {
            return artistaOptional.get();
        }
        return null;
    }

    public Artista agregarArtista(Artista artista) {
        return repositorioArtistass.save(artista);
    } 


}
