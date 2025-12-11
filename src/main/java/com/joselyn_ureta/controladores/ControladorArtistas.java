package com.joselyn_ureta.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.joselyn_ureta.modelos.Artista;
import com.joselyn_ureta.servicio.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {
    
    @Autowired
    private ServicioArtistas servicioArtistas;

    @GetMapping("/artistas")
    public String desplegarArtistas(Model model) {
        model.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
        return "artistas.jsp";
    }

    @GetMapping("/artistas/detalle/{idArtista}")
    public String desplegarDetalleArtista(@PathVariable("idArtista") Long idArtista,
    Model model){
    Artista artista =servicioArtistas.obtenerArtistaPorId(idArtista);
    model.addAttribute("artista", artista);
    return "detalleArtista.jsp";
    }

    @GetMapping("/artistas/formulario/agregar/{idArtista}")
    public String formularioAgregarArtista(
        @PathVariable("idArtista") Long idArtista, 
        Model model){

        model.addAttribute("artista", new Artista());
        return "agregarArtista.jsp";
        }

    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(
        @Valid Artista artista,
        BindingResult result,
        Model model
    ) {
        if (result.hasErrors()) {
            return "agregarArtista.jsp";
        }
        servicioArtistas.agregarArtista(artista);
        return "redirect:/artistas";
    }
}
