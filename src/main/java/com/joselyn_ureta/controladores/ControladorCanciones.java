package com.joselyn_ureta.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.joselyn_ureta.modelos.Artista;
import com.joselyn_ureta.modelos.Cancion;
import com.joselyn_ureta.servicio.ServicioArtistas;
import com.joselyn_ureta.servicio.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {

    @Autowired
    private ServicioCanciones servicio;
    @Autowired
    private ServicioArtistas servicioArtistas;

    @GetMapping("/canciones")
    public String desplegarCanciones(Model model) {
        model.addAttribute("listaCanciones", servicio.obtenerTodasLasCanciones());
        return "canciones.jsp";
    }
    

    @GetMapping("/canciones/detalle/{id}")
    public String desplegarDetalleCancion(@PathVariable ("id") Long id, Model model) {
        model.addAttribute("cancion", servicio.obtenerCancionPorId(id));
        return "detalleCancion.jsp";
    }

    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(Model modelo) {
        modelo.addAttribute("cancion", new Cancion());
        modelo.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
        return "agregarCancion.jsp";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(
            @Valid @ModelAttribute("cancion") Cancion cancion,
            BindingResult result,
            Model model)  {



        if  (result.hasErrors()) {
            model.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
            return "agregarCancion.jsp";
        }


        Long idArtista = cancion.getArtista().getId();
        Artista artista = servicioArtistas.obtenerArtistaPorId(idArtista);
        cancion.setArtista(artista);


        servicio.agregarCancion(cancion);
        return "redirect:/canciones";
    
        }

    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model model) {
    
        Cancion cancionActual = servicio.obtenerCancionPorId(idCancion);

        if (cancionActual == null) {
            return "redirect:/canciones";
        }

        model.addAttribute("cancion", cancionActual);
        return "editarCancion.jsp";
    }

    @PostMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(
            @PathVariable("idCancion") Long idCancion,
            @Valid @ModelAttribute("cancion") Cancion cancion,
            BindingResult result,
            Model model) {

        if (result.hasErrors()){
            model.addAttribute("cancion", cancion);
            return "editarCancion.jsp";
        }

        cancion.setId(idCancion);
        servicio.actualizaCancion(cancion);

        return  "redirect:/canciones";
        }

        @GetMapping("/canciones/eliminar/{idCancion}")
        public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
            servicio.eliminaCancion(idCancion);
            return "redirect:/canciones";
        }

}
