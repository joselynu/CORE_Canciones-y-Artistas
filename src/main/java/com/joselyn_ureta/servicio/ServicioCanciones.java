package com.joselyn_ureta.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joselyn_ureta.modelos.Cancion;
import com.joselyn_ureta.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {
    @Autowired
    private RepositorioCanciones repoCanciones;

    public List<Cancion> obtenerTodasLasCanciones(){
        return this.repoCanciones.findAll();
    }
    public Cancion obtenerCancionPorId(Long id) {
        return repoCanciones.findById(id).orElse(null);
    }

    public Cancion agregarCancion(Cancion cancion) {
        return repoCanciones.save(cancion);
    }

    public Cancion actualizaCancion(Cancion cancion) {
        return repoCanciones.save(cancion);
    }

    public void eliminaCancion(Long id) {
        repoCanciones.deleteById(id);
    }
}
