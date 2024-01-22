package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.myProfile.MyProfileLogic;

public class MyProfileSteps {

    MyProfileLogic myProfileLogic = new MyProfileLogic();

    @When("Ingreso a mi perfil")
    public void ingresoAMiPerfil() {
        myProfileLogic.ingresoMiPerfil();
    }

    @Then("Valido que estoy en mi perfil")
    public void validoQueEstoyEnMiPerfil() {
        myProfileLogic.validoEstoyMiPerfil();
    }

    @When("Modifico el nombre de mi perfil {string}")
    public void modificoElNombreDeMiPerfil(String nombre) {
        myProfileLogic.modificoNombreMiPerfil(nombre);
    }

    @Then("Valido que se edito el nombre de mi perfil")
    public void validoQueSeEditoElNombreDeMiPerfil() {
        myProfileLogic.validoEditoNombreMiPerfil();
    }

    @Then("Valido que se visualiza la foto de perfil")
    public void validoQueSeVisualizaLaFotoDePerfil() {
        myProfileLogic.validoVisualizaFotoPerfil();
    }
}