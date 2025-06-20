package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import java.util.*;

public class US04Steps {
    
    private String granjero;
    private String asesor;
    private String horarioDisponible;
    private String boton;
    private String mensajeConfirmacion;
    private int errorCode;
    private String mensajeError;
    
    @Given("el {string} con poca experiencia desea programar una cita.")
    public void el_granjero_con_poca_experiencia_desea_programar_cita(String granjero) {
        this.granjero = granjero;
        // Simular que el granjero desea programar una cita
    }
    
    @And("se encuentra en el apartado de \"Horarios Disponibles\" del perfil de un {string} en su dispositivo móvil.")
    public void se_encuentra_en_apartado_horarios_disponibles(String asesor) {
        this.asesor = asesor;
        // Simular que está en el apartado de horarios disponibles
    }
    
    @When("seleccione un {string}.")
    public void seleccione_un_horario_disponible(String horario) {
        this.horarioDisponible = horario;
        // Simular selección de horario
    }
    
    @And("complete los campos solicitados.")
    public void complete_los_campos_solicitados() {
        // Simular completar campos
    }
    
    @And("haga clic en el {string} \"Reservar Cita\".")
    public void haga_clic_en_boton_reservar_cita(String boton) {
        this.boton = boton;
        // Simular clic en botón
    }
    
    @Then("el sistema le mostrará un {string} de confirmación.")
    public void sistema_mostrara_mensaje_confirmacion(String mensaje) {
        this.mensajeConfirmacion = mensaje;
        // Verificar que se muestra el mensaje de confirmación
    }
    
    @And("se encuentra en el apartado de \"Horarios Disponibles\" del perfil de un asesor.")
    public void se_encuentra_en_apartado_horarios_disponibles_asesor() {
        // Simular que está en el apartado de horarios disponibles
    }
    
    @And("se encuentra un {int} técnico o de conexión que impide completar la programación.")
    public void se_encuentra_un_error_tecnico(Integer error) {
        this.errorCode = error;
        // Simular error técnico
    }
    
    @Then("el sistema le mostrará un {string} de error.")
    public void sistema_mostrara_mensaje_error(String mensaje) {
        this.mensajeError = mensaje;
        // Verificar que se muestra el mensaje de error
    }
}
