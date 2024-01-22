package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.call.CallLogic;

public class CallSteps {

    CallLogic callLogic = new CallLogic();

    @When("Busco al contacto {string} en nueva llamada")
    public void buscoAlContactoEnNuevaLlamada(String contacto) {
        callLogic.buscoContactoNuevaLlamada(contacto);;
    }

    @And("Realizo la llamada en nueva llamada")
    public void realizoLaLlamadaEnNuevaLlamada() {
        callLogic.realizoLlamadaNuevaLlamada();
    }

    @And("Realizo la videollamada en nueva llamada")
    public void realizoLaVideollamadaEnNuevaLlamada() {
        callLogic.realizoVideollamadaNuevaLlamada();
    }

    @Then("Valido que se realizo la llamada")
    public void validoQueSeRealizoLaLlamada() {
        callLogic.validoRealizoLlamada();
    }

    @Then("Valido que se realizo la videollamada")
    public void validoQueSeRealizoLaVideollamada() {
        callLogic.validoRealizoVideollamada();
    }
}
