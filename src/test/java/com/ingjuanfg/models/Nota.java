package com.ingjuanfg.models;

import com.ingjuanfg.tasks.EscribirDetalles;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Nota {
    private String tituloNota;
    private String contenidoNota;

    public Nota conTitulo(String tituloNota) {
        this.tituloNota = tituloNota;
        return this;
    }

    public Nota contenido(String contenidoNota) {
        this.contenidoNota = contenidoNota;
        return this;
    }

    public EscribirDetalles build() {
        return instrumented(EscribirDetalles.class, tituloNota, contenidoNota);
    }
}

