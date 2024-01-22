package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.contact.ContactLogic;

public class ContactSteps {

    ContactLogic contactLogic = new ContactLogic();

    @When("Busco al contacto {string} en contactos")
    public void buscoAlContactoEnContactos(String contacto) {
        contactLogic.buscoContactoContactos(contacto);
    }

    @Then("Valido que se encontro el contacto")
    public void validoQueSeEncontroElContacto() {
        contactLogic.validoEncontroContacto();
    }

    @Then("Valido que no se encontro el contacto")
    public void validoQueNoSeEncontroElContacto() {
        contactLogic.validoNoEncontroContacto();
    }

    @And("Realizo la llamada en contacto")
    public void realizoLaLlamadaEnContacto() {
        contactLogic.realizoLlamadaContacto();
    }

    @And("Realizo la videollamada en contacto")
    public void realizoLaVideollamadaEnContacto() {
        contactLogic.realizoVideollamadaContacto();
    }
}