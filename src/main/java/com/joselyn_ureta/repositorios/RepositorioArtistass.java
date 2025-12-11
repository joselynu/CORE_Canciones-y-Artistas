package com.joselyn_ureta.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joselyn_ureta.modelos.Artista;

@Repository
public interface RepositorioArtistass extends CrudRepository<Artista, Long> {
    List<Artista> findAll();
    
}
