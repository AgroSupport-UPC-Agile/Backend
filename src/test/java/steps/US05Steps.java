package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import java.util.*;

public class US05Steps {
    
    private String granjero;
    private String citaAsesoria;
    private int calificacion;
    private String comentario;
    
    @Given("el {string} con poca experiencia desea hacer un feedback referente al servicio del asesor.")
    public void el_granjero_con_poca_experiencia_desea_hacer_feedback(String granjero) {
        this.granjero = granjero;
        // Simular que el granjero desea hacer feedback
    }
    
    @And("se encuentra en la vista de historial de asesorías.")
    public void se_encuentra_en_vista_historial_asesorias() {
        // Simular que está en la vista de historial de asesorías
    }
    
    @And("selecciona una {string} sin reseña.")
    public void selecciona_una_asesoria_sin_resena(String citaAsesoria) {
        this.citaAsesoria = citaAsesoria;
        // Simular selección de cita asesoría
    }
    
    @When("haga clic en el botón \"Calificar Servicio\" en la interfaz.")
    public void haga_clic_en_boton_calificar_servicio() {
        // Simular clic en botón calificar servicio
    }

    @Then("el sistema le permitirá asignarle un {string} y reseñar {string} del servicio del asesor.")
    public void el_sistema_le_permitirá_asignarle_calificacion_y_resenar_comentario(String calificacion, String comentario) {
        // Implementar la lógica para verificar que el sistema permite asignar calificación y reseña
        // Por ejemplo:
        // verificarAsignacionCalificacion(calificacion);
        // verificarRegistroComentario(comentario);
    }
    
    @Given("el {string} con poca experiencia no desea dar feedback al asesor referente al servicio.")
    public void el_granjero_con_poca_experiencia_no_desea_dar_feedback(String granjero) {
        this.granjero = granjero;
        // Simular que el granjero no desea dar feedback
    }
    
    @When("haga clic en el botón \"Omitir Calificación\" en la interfaz.")
    public void haga_clic_en_boton_omitir_calificacion() {
        // Simular clic en botón omitir calificación
    }
    
    @Then("el sistema le permitirá omitir la reseña.")
    public void sistema_permitira_omitir_resena() {
        // Verificar que se permite omitir la reseña
    }

}
