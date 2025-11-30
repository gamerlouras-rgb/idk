package com.upt.lp.Equipa15.entity;

import jakarta.persistence.Entity;

@Entity
public class Movie extends Media {

    private int duration; // duração em minutos

    public Movie() {}

    // Construtor de conveniência (opcional)
    public Movie(String title, String description, int release_year, int duration) {
        this.setTitle(title);
        this.setDescription(description);
        this.setRelease_year(release_year);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // (Opcional) métodos que expõem user herdado
    // Caso não tenhas, podes adicionar wrappers, mas aqui assumo que não são necessários.
}
