package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import java.util.*;

public class US09Steps {
    
    private String usuario;
    private String informacionPersonal;
    private String rol;
    private String mensajeError;
    
    @Given("el {string} desea registrarse en la aplicación.")
    public void el_usuario_desea_registrarse(String usuario) {
        this.usuario = usuario;
        // Simular que el usuario desea registrarse
    }
    
    @And("se encuentra en el apartado de \"Registrarse\".")
    public void se_encuentra_en_apartado_registrarse() {
        // Simular que está en el apartado de registrarse
    }
    
    @When("complete el formulario de registro con su {string}.")
    public void complete_formulario_registro(String informacion) {
        this.informacionPersonal = informacion;
        // Simular completar formulario
    }
    
    @And("seleccione su rol en la aplicación entre \"Granjero\" o \"Asesor\".")
    public void seleccione_rol_aplicacion() {
        // Simular selección de rol
    }
    
    @And("los datos sean correctos según las validaciones establecidas.")
    public void datos_correctos_validaciones() {
        // Simular validación de datos
    }
    
    @Then("la cuenta se creará exitosamente.")
    public void cuenta_creara_exitosamente() {
        // Verificar que la cuenta se crea exitosamente
    }
    
    @Given("el {string} se encuentra en el apartado de \"Registrarse\".")
    public void el_usuario_se_encuentra_en_apartado_registrarse(String usuario) {
        this.usuario = usuario;
        // Simular que está en el apartado de registrarse
    }
    
    @When("ingrese los datos solicitados de manera errónea.")
    public void ingrese_datos_solicitados_erronea() {
        // Simular ingreso de datos erróneos
    }
    
    @Then("la cuenta no se creará.")
    public void cuenta_no_se_creara() {
        // Verificar que la cuenta no se crea
    }
    
    @And("recibirá un {string} en los datos ingresados.")
    public void recibira_mensaje_error(String mensaje) {
        this.mensajeError = mensaje;
        // Verificar que se recibe mensaje de error
    }
}
