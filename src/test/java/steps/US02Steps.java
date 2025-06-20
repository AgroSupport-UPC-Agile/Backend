package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import java.util.*;

public class US02Steps {
    
    private String granjero;
    private String asesorSeleccionado;
    private String informacion;
    private int errorCode;
    private String mensajeError;

    @Given("el {string} con poca experiencia quiere ver {string} de un asesor.")
    public void el_granjero_con_poca_experiencia_quiere_ver_informacion(String granjero, String informacion) {
        this.granjero = granjero;
        this.informacion = informacion;
        // Simular que el granjero quiere ver información
    }

    @And("se encuentra en el apartado del \"Catálogo de Asesores\" en su dispositivo móvil.")
    public void se_encuentra_en_el_apartado_de_catalogo_asesores() {
        // Simular que está en el catálogo de asesores
    }

    @When("seleccione al {string} de un asesor en la interfaz móvil.")
    public void seleccione_al_cuadro_de_un_asesor(String asesor) {
        this.asesorSeleccionado = asesor;
        // Simular selección del asesor
    }

    @Then("el sistema le mostrará la {string} del asesor como nombre, experiencia, calificación y reseñas de manera optimizada para móvil.")
    public void el_sistema_le_mostrara_la_informacion_del_asesor(String informacion) {
        // Verificar que se muestra la información correcta
    }

    @And("se encuentra en el apartado de \"Asesores\" en su dispositivo móvil.")
    public void se_encuentra_en_el_apartado_de_asesores() {
        // Simular que está en el apartado de asesores
    }

    @And("se encuentre con un {int} al cargar la información.")
    public void se_encuentre_con_un_error_al_cargar_informacion(Integer errorCode) {
        this.errorCode = errorCode;
        // Simular error al cargar información
    }

    @Then("el sistema le mostrará un {string} de error de carga en la interfaz móvil.")
    public void el_sistema_le_mostrara_un_mensaje_de_error(String mensaje) {
        this.mensajeError = mensaje;
        // Verificar que se muestra el mensaje de error
    }

    @Given("el {string} con poca experiencia quiere ver {string} relevante del asesor.")
    public void el_con_poca_experiencia_quiere_ver_informacion_relevante_del_asesor(String granjero, String informacion) {
        this.granjero = granjero;
        this.informacion = informacion;
        // Simular que el granjero quiere ver información relevante
    }
    @Then("el sistema le mostrará un No encontrado de error de carga en la interfaz móvil.")
    public void el_sistema_le_mostrará_un_no_encontrado_de_error_de_carga_en_la_interfaz_móvil() {
        this.mensajeError = "No encontrado";
        // Aquí puedes simular la verificación del mensaje de error
    }
    @Then("el sistema le mostrará un Error interno de error de carga en la interfaz móvil.")
    public void el_sistema_le_mostrará_un_error_interno_de_error_de_carga_en_la_interfaz_móvil() {
        this.mensajeError = "Error interno";
        // Aquí puedes simular la verificación del mensaje de error
    }
}
