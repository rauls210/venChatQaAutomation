package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.login.LoginLogic;

public class LoginSteps {

    LoginLogic loginLogic = new LoginLogic();

    @Given("Inicio sesion en app de venChat")
    public void inicioSesionEnAppDeVenChat() {
        loginLogic.inicioAppVenChat();
    }

    @When("Ingreso el numero de telefono {string}")
    public void ingresoElNumeroDeTelefono(String numero) {
        loginLogic.ingresoNumero(numero);
    }

    @And("Ingreso el codigo {string}")
    public void ingresoElCodigo(String codigo) {
        loginLogic.ingresoCodigo(codigo);
    }

    @Then("Valido que me logueo de forma exitosa")
    public void validoQueMeLogueoDeFormaExitosa() {
        loginLogic.validoLogueoExitoso();
    }

    @Then("Valido que el numero de telefono no esta registrado")
    public void validoQueElNumeroDeTelefonoNoEstaRegistrado() {
        loginLogic.validoNumeroNoRegistrado();
    }

    @When("No ingreso el numero de telefono")
    public void noIngresoElNumeroDeTelefono() {
        loginLogic.noIngresoNumero();
    }

    @Then("Valido que no se ingreso un numero de telefono")
    public void validoQueNoSeIngresoUnNumeroDeTelefono() {
        loginLogic.validoNoIngresoNumero();
    }

    @Then("Valido que el numero de telefono esta incompleto")
    public void validoQueElNumeroDeTelefonoEstaIncompleto() {
        loginLogic.validoNumeroIncompleto();
    }

    @Then("Valido que el codigo es incorrecta")
    public void validoQueElCodigoEsIncorrecta() {
        loginLogic.validoCodigoIncorrecto();
    }

    @And("No ingreso el codigo")
    public void noIngresoElCodigo() {
        loginLogic.noIngresoCodigo();
    }

    @Then("Valido que no se ingreso el codigo")
    public void validoQueNoSeIngresoElCodigo() {
        loginLogic.validoNoIngresoCodigo();
    }

    @Then("Valido que el codigo esta incompleto")
    public void validoQueElCodigoEstaIncompleto() {
        loginLogic.validoCodigoIncompleto();
    }

    @Then("Valido que se cerro la sesion")
    public void validoQueSeCerroLaSesion() {
        loginLogic.validoCerroSesion();
    }
}