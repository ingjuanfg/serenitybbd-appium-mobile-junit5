package com.ingjuanfg.stepdefinitions;

import com.ingjuanfg.interactions.Crear;
import com.ingjuanfg.tasks.EscribirDetalles;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.ingjuanfg.userinterfaces.CrearNotaPage.VOLVER_HOME_NOTA;
import static com.ingjuanfg.userinterfaces.HomeNotasPage.TITULO_NOTA_HOME;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@ExtendWith(SerenityJUnit5Extension.class)
public class CrearNotasStepDefinition {

    @Test
    @DisplayName("Crear una nota importante")
    public void elUsuarioEsAdministrador() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Juan").attemptsTo(
                Crear.notaNueva(),
                EscribirDetalles.paraNotaNueva()
                        .conTitulo("Lista de Mercado")
                        .contenido("Arroz y Pollo").build(),
                WaitUntil.the(VOLVER_HOME_NOTA, isVisible()).then(Click.on(VOLVER_HOME_NOTA)),
                Ensure.that(TITULO_NOTA_HOME.of("Lista de Mercado")).isDisplayed()
        );
    }
}
