package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import java.util.*;

public class US10Steps {
    
    private String usuario;
    private String credenciales;
    private String mensajeError;
    private int intentosFallidos;
    
    @Given("el {string} desea acceder a su cuenta registrada.")
    public void el_usuario_desea_acceder_cuenta(String usuario) {
        this.usuario = usuario;
        // Simular que el usuario desea acceder a su cuenta
    }
    
    @And("se encuentra en el apartado de \"Iniciar Sesión\".")
    public void se_encuentra_en_apartado_iniciar_sesion() {
        // Simular que está en el apartado de iniciar sesión
    }
    
    @When("introduzca sus {string} correctamente.")
    public void introduzca_credenciales_correctamente(String credenciales) {
        this.credenciales = credenciales;
        // Simular introducción de credenciales correctas
    }
    
    @Then("será redireccionado a su vista de usuario.")
    public void sera_redireccionado_vista_usuario() {
        // Verificar que es redireccionado a su vista de usuario
    }
    
    @When("introduzca sus {string} incorrectamente.")
    public void introduzca_credenciales_incorrectamente(String credenciales) {
        this.credenciales = credenciales;
        this.intentosFallidos++;
        // Simular introducción de credenciales incorrectas
    }
    
    @Then("no se le permitirá acceso a su cuenta.")
    public void no_permitira_acceso_cuenta() {
        // Verificar que no se permite acceso a la cuenta
    }
    
    @And("recibirá un {string}.")
    public void recibira_mensaje_error(String mensaje) {
        this.mensajeError = mensaje;
        // Verificar que recibe mensaje de error
    }
    
    @And("se encuentra en el apartado de \"Iniciar sesión\".")
    public void se_encuentra_en_apartado_iniciar_sesion_alt() {
        // Simular que está en el apartado de iniciar sesión (alternativo)
    }
    
    @And("siga errando hasta alcanzar el número máximo de intentos permitidos \\(tres intentos).")
    public void siga_errando_hasta_alcanzar_maximo_intentos() {
        this.intentosFallidos = 3;
        // Simular alcanzar el máximo de intentos permitidos
    }
    
    @Then("recibirá un {string}.")
    public void recibira_mensaje_excedido_intentos(String mensaje) {
        this.mensajeError = mensaje;
        // Verificar que recibe mensaje de exceso de intentos
    }
    
    @And("su cuenta será bloqueada temporalmente.")
    public void cuenta_bloqueada_temporalmente() {
        // Verificar que la cuenta es bloqueada temporalmente
    }
}
