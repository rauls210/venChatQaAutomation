package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.register.RegisterLogic;

public class RegisterSteps {

    RegisterLogic registerLogic = new RegisterLogic();

    @Given("Registro en app de venChat")
    public void registroEnAppDeVenChat() {
        registerLogic.registroAppVenChat();
    }

    @And("Completo mi perfil")
    public void completoMiPerfil() {
        registerLogic.completoPerfil();
    }

    @Then("Valido que me registro de forma exitosa")
    public void validoQueMeRegistroDeFormaExitosa() {
        registerLogic.validoRegistroExitosa();
    }

    @And("Elimino el registro")
    public void eliminoElRegistro() {
        registerLogic.eliminoRegistro();
    }

    @When("Ingreso el numero de telefono {string} ya registrado")
    public void ingresoElNumeroDeTelefonoYaRegistrado(String numero) {
        registerLogic.ingresoNumeroTelefonoRegistrado(numero);
    }

    @Then("Valido que ya esta registrado el numero de telefono")
    public void validoQueYaEstaRegistradoElNumeroDeTelefono() {
        registerLogic.validoRegistroNumeroExiste();
    }

    @Then("Valido que me pida aceptar los terminos y condiciones")
    public void validoQueMePidaAceptarLosTerminosYCondiciones() {
        registerLogic.validoAceptarTerminosCondiciones();
    }

    @And("No ingreso el nombre")
    public void noIngresoElNombre() {
        registerLogic.noIngresoNombre();
    }

    @Then("Valido que no se ingreso el nombre")
    public void validoQueNoSeIngresoElNombre() {
        registerLogic.validoNoIngresoNombre();
    }

    @And("No ingreso la descripcion")
    public void noIngresoLaDescripcion() {
        registerLogic.noIngresoDescripcion();
    }

    @Then("Valido que no se ingreso la descripcion")
    public void validoQueNoSeIngresoLaDescripcion() {
        registerLogic.validoNoIngresoDescripcion();
    }
}