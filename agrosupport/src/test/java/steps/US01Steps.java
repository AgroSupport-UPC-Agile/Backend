package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.*;
import java.util.*;

public class US01Steps {

    private String granjero;
    private List<String> asesoresMostrados;

    @Given("que {string} accede a la aplicación")
    public void que_granjero_accede_a_la_aplicacion(String granjero) {
        this.granjero = granjero;
        // Simular acceso a la aplicación
    }

    @When("selecciona la opción \"Catálogo de asesores\"")
    public void selecciona_la_opcion_catalogo_de_asesores() {
        // Simular selección de la opción
    }

    @Then("el sistema muestra la lista de asesores disponibles: {string}")
    public void el_sistema_muestra_la_lista_de_asesores_disponibles(String listaDeAsesores) {
        this.asesoresMostrados = Arrays.asList(listaDeAsesores.split(",\\s*"));
        // Aquí podrías agregar aserciones según la lógica de tu app
    }


}