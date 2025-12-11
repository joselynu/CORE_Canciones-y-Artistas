package com.joselyn_ureta.modelos;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="canciones")

public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(min=5, message="El título debe tener al menos 5 caracteres")
    private String titulo;

    @Size(min=3, message= "El álbum debe tener al menos 3 carácteres")
    private String album;

    @Size(min=3, message = "El género debe tener al menos 3 caracteres")
    private String genero;

    @Size(min=3, message="El idioma  debe tener al menos 3 caracteres")
    private String idioma;

    @CreationTimestamp
    @Column(name="fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;
    
    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="artista_id")
    private Artista artista;

    public Cancion() {

    }
//getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getAlbum() {
        return album;
    }


    public void setAlbum(String album) {
        this.album = album;
    }


    public String getGenero() {
        return genero;
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }


    public String getIdioma() {
        return idioma;
    }


    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }


    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public Artista getArtista() {
    return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }


}
