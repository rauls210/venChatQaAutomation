package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.withoutPermission.WithoutPermissionLogic;

public class WithoutPermissionSteps {

    WithoutPermissionLogic withoutPermissionLogic = new WithoutPermissionLogic();

    @When("Abro la lista de contactos")
    public void abroLaListaDeContactos() {
        withoutPermissionLogic.abroListaContactos();
    }

    @Then("Valido que se visualiza el mensaje pidiendo acceso")
    public void validoQueSeVisualizaElMensajePidiendoAcceso() {
        withoutPermissionLogic.validoVisualizaMensajePidiendoAcceso();
    }

    @Given("Inicio sesion en app de venChat sin dar permisos")
    public void inicioSesionEnAppDeVenChatSinDarPermisos() {
        withoutPermissionLogic.inicioSesionAppVenChatSinPermisos();
    }

    @When("Abro un chat reciente")
    public void abroUnChatReciente() {
        withoutPermissionLogic.abroChatReciente();
    }

    @And("Envio una foto desde la galeria")
    public void envioUnaFotoDesdeLaGaleria() {
        withoutPermissionLogic.envioFotoDesdeGaleria();
    }

    @And("Envio un video desde la galeria")
    public void envioUnVideoDesdeLaGaleria() {
        withoutPermissionLogic.envioVideoDesdeGaleria();
    }

    @And("Envio una foto desde la camara")
    public void envioUnaFotoDesdeLaCamara() {
        withoutPermissionLogic.envioFotoDesdeCamara();
    }

    @When("Ingreso a un grupo")
    public void ingresoAUnGrupo() {
        withoutPermissionLogic.ingresoGrupo();
    }

    @Then("Valido que se visualiza el mensaje pidiendo acceso a la camara")
    public void validoQueSeVisualizaElMensajePidiendoAccesoALaCamara() {
        withoutPermissionLogic.validoVisualizaMensajePidiendoAccesoCamara();
    }

    @And("Comparto mi ubicacion por chat")
    public void compartoMiUbicacionPorChat() {
        withoutPermissionLogic.compartoUbicacionChat();
    }

    @And("Abro la camara")
    public void abroLaCamara() {
        withoutPermissionLogic.abroCamara();
    }

    @Then("Valido que se visualiza el mensaje pidiendo acceso a la ubicacion")
    public void validoQueSeVisualizaElMensajePidiendoAccesoALaUbicacion() {
        withoutPermissionLogic.validoVisualizaMensajePidiendoAccesoUbicacion();
    }

    @And("Abro agregar participante")
    public void abroAgregarParticipante() {
        withoutPermissionLogic.abroAgregarParticipante();
    }

    @Then("Valido que se visualiza el mensaje pidiendo acceso a los contactos")
    public void validoQueSeVisualizaElMensajePidiendoAccesoALosContactos() {
        withoutPermissionLogic.validoVisualizaMensajePidiendoAccesoContactos();
    }

    @And("Realizo una llamada")
    public void realizoUnaLlamada() {
        withoutPermissionLogic.realizoLlamada();
    }

    @And("Realizo una videollamada")
    public void realizoUnaVideoLlamada() {
        withoutPermissionLogic.realizoVideoLlamada();
    }

    @And("Envio un mensaje")
    public void envioUnMensaje() {
        withoutPermissionLogic.envioMensaje();
    }

    @When("Creo un grupo sin permisos")
    public void creoUnGrupoSinPermisos() {
        withoutPermissionLogic.creoGrupoSinPermisos();
    }

    @Then("Valido que se visualiza el mensaje pidiendo acceso a las llamadas")
    public void validoQueSeVisualizaElMensajePidiendoAccesoALasLlamadas() {
        withoutPermissionLogic.validoVisualizaMensajePidiendoAccesoLlamadas();
    }

    @And("Envio una nota de voz")
    public void envioUnaNotaDeVoz() {
        withoutPermissionLogic.envioNotaDeVoz();
    }

    @And("Envio un documento")
    public void envioUnDocumento() {
        withoutPermissionLogic.envioDocumento();
    }

    @When("Abro mi perfil")
    public void abroMiPerfil() {
        withoutPermissionLogic.abroMiPerfil();
    }

    @And("Cambio mi foto desde la camara")
    public void cambioMiFotoDesdeLaCamara() {
        withoutPermissionLogic.cambioMiFotoDesdeCamara();
    }

    @And("Cambio mi foto desde la galeria")
    public void cambioMiFotoDesdeLaGaleria() {
        withoutPermissionLogic.cambioMiFotoDesdeGaleria();
    }

    @Given("Registrar cuenta en app de venChat sin dar permisos")
    public void registrarCuentaEnAppDeVenChatSinDarPermisos() {
        withoutPermissionLogic.registrarCuentaAppDeVenChatSinPermisos();
    }

    @When("Agrego al registro una foto desde la camara")
    public void agregoAlRegistroUnaFotoDesdeLaCamara() {
        withoutPermissionLogic.agregoAlRegistroFotoDesdeCamara();
    }

    @When("Agrego al registro una foto desde la galeria")
    public void agregoAlRegistroUnaFotoDesdeLaGaleria() {
        withoutPermissionLogic.agregoAlRegistroFotoDesdeGaleria();
    }
}
