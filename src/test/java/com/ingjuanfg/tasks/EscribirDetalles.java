package com.ingjuanfg.tasks;

import com.ingjuanfg.models.Nota;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.ingjuanfg.userinterfaces.CrearNotaPage.*;
import static com.ingjuanfg.utils.AccionesConstantes.GUARDAR;

public class EscribirDetalles implements Task {
    private String tituloNota;
    private String contenidoNota;

    public EscribirDetalles(String nombreApp, String contenidoNota){
        this.tituloNota = nombreApp;
        this.contenidoNota = contenidoNota;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Enter.theValue(tituloNota).into(CAMPO_TITULO_NOTA),
                Enter.theValue(contenidoNota).into(CAMPO_CONTENIDO_NOTA),
                Click.on(BOTON_ACCION_NOTA.of(GUARDAR))
        );
    }

    public static Nota paraNotaNueva(){
        return new Nota();
    }
}
