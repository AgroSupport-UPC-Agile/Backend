package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import java.util.*;

public class US03Steps {
    
    private String granjero;
    private String asesorElegido;
    private List<String> horariosDisponibles;
    private String boton;
    private String mensajeError;
    
    @Given("el {string} con poca experiencia desea visualizar los {string} de un {string}.")
    public void el_granjero_con_poca_experiencia_desea_visualizar_horarios(String granjero, String horarios, String asesor) {
        this.granjero = granjero;
        this.asesorElegido = asesor;
        // Simular que el granjero desea ver horarios
    }
    
    @And("se encuentra viendo la información del perfil de un asesor en su dispositivo móvil.")
    public void se_encuentra_viendo_informacion_perfil_asesor() {
        // Simular que está viendo el perfil del asesor
    }
    
    @When("haga clic en el {string} \"Reservar Cita\" en la interfaz móvil.")
    public void haga_clic_en_boton_reservar_cita(String boton) {
        this.boton = boton;
        // Simular clic en botón de reservar cita
    }
    
    @Then("el sistema le mostrará una interfaz con los {string}.")
    public void sistema_mostrara_interfaz_con_horarios(String horarios) {
        this.horariosDisponibles = Arrays.asList(horarios.split(",\\s*"));
        // Verificar que se muestran los horarios disponibles
    }
    
    @And("el asesor no tenga horarios disponibles.")
    public void el_asesor_no_tenga_horarios_disponibles() {
        // Simular que el asesor no tiene horarios disponibles
    }
    
    @Then("el sistema le mostrará un {string} de error \"El asesor no tiene horarios disponibles\" en la interfaz móvil.")
    public void sistema_mostrara_mensaje_error(String mensaje) {
        this.mensajeError = mensaje;
        // Verificar que se muestra el mensaje de error
    }
}
