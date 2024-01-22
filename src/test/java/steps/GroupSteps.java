package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.group.GroupLogic;

public class GroupSteps {

    GroupLogic groupLogic = new GroupLogic();
    @When("Creo un grupo llamado {string} con el participante {string}")
    public void creoGrupo1Participante(String nombre, String participante) {
        groupLogic.creoGrupo1Participante(nombre, participante);
    }

    @And("Valido se creo el grupo")
    public void validoCreacionGrupo() {
        groupLogic.validoCreacionGrupo();
    }

    @Then("Valido informacion de {string} que posee el numero {string} desde grupo")
    public void validoInformacionIntegrantePoseeNumeroDesdeGrupo(String nombre, String numero) {
        groupLogic.validoInformacionIntegrantePoseeNumeroDesdeGrupo(nombre , numero);
    }

    @And("Cambio el nombre del grupo a {string}")
    public void cambioNombreGrupo(String nombre) {
        groupLogic.cambioNombreGrupo(nombre);
    }

    @Then("Valido se cambio el nombre del grupo a {string}")
    public void validoCambioNombreGrupo(String nombre) {
        groupLogic.validoCambioNombreGrupo(nombre);
    }

    @Then("Valido puedo agregar a {string} al grupo")
    public void validoAgregarContactoGrupo(String nombre) {
        groupLogic.validoAgregarContactoGrupo(nombre);
    }

    @And("Abro informacion del grupo")
    public void abroInformacionGrupo() {
        groupLogic.abroInformacionGrupo();
    }

    @Then("Abro los archivos del grupo")
    public void abrirArchivosgrupo() {
        groupLogic.abrirArchivosgrupo();
    }

    @And("Elimino {string} del grupo")
    public void eliminoIntegranteGrupo(String nombre) {
        groupLogic.eliminoIntegranteGrupo(nombre);
    }

    @When("Abro chat grupal llamado {string}")
    public void abroChatGrupalLLamado(String nombre) {
        groupLogic.abroChatGrupalLLamado(nombre);
    }

    @Then("Valido no puedo agregar una persona a un grupo sin ser administrador")
    public void validoNoPuedoAgregarUnaPersonaAUnGrupoSinSerAdministrador() {
        groupLogic.validoNoPuedoAgregarParticipanteSinSerAdministrador();
    }

    @Then("Valido no puedo eliminar {string} del grupo no siendo administrador")
    public void validoNoPuedoEliminarIntegranteNoSiendoAdministrador(String nombre) {
        groupLogic.validoNoPuedoEliminarIntegranteNoSiendoAdministrador(nombre);
    }

    @And("Elimino el grupo llamado {string}")
    public void eliminoGrupoLlamado(String nombre) {
        groupLogic.eliminoGrupoLlamado(nombre);
    }

    @Then("Valido que no puedo agregar a la persona {string} a un grupo si esta bloqueado")
    public void validoQueNoPuedoAgregarALaPersonaAUnGrupoSiEstaBloqueado(String nombre) {
        groupLogic.agregaContactoBloqueado(nombre);
    }

    @Then("Valido que puedo abandonar el grupo {string} que posee dos administradores")
    public void validoPuedoAbandonarGrupoPoseeDosAdministradores(String nombre) {
        groupLogic.validoPuedoAbandonarGrupoPoseeDosAdministradores(nombre);
    }

    @When("Busco chat de grupo llamado {string}")
    public void buscarChatGrupo(String nombre) {
        groupLogic.buscarChatGrupo(nombre);
    }

    @When("Creo un nuevo grupo llamado {string} con los integrantes {string} y {string}")
    public void creoUnNuevoGrupoLlamadoConLosIntegrantesY(String nombre, String participante1, String participante2) {
        groupLogic.creoNuevoGrupoLlamadoIntregrantes(nombre, participante1, participante2);
    }

    @And("Hago al integrante {string} administrador del grupo")
    public void hagoAlIntegranteAdministradorDelGrupo(String nombre) {
        groupLogic.hagoIntegranteAdministradorGrupo(nombre);
    }

    @Then("Valido no existe un grupo llamado {string}")
    public void validoNoExisteGrupoLlamado(String nombre) {
        groupLogic.validoNoExisteGrupoLlamado(nombre);
    }

    @Then("Valido {string} no esta en el Grupo")
    public void validoIntegranteNoEstaGrupo(String nombre) {
        groupLogic.validoIntegranteNoEstaEnGrupo(nombre);
    }

    @Then("Valido hay 2 admministradores en el grupo")
    public void validoHay2AdministradoresGrupo() {
        groupLogic.validoHay2AdministradoresGrupo();
    }

    @Then("Valido no puedo abandonar el grupo {string} donde soy unico administrador sin agregar otro administrador")
    public void validoNoPuedoAbandonarElGrupoDondeSoyUnicoAdministradorSinAgregarOtroAdministrador(String nombre) {
        groupLogic.validoNoPuedoAbandonarElGrupoDondeSoyUnicoAdministradorSinAgregarOtroAdministrador(nombre);
    }

    @When("Creo un nuevo grupo sin asunto")
    public void creoUnNuevoGrupoSinAsunto() {
        groupLogic.creoNuevoGrupoSinAsunto();
    }

    @Then("Valido que no se ingreso el asunto")
    public void validoQueNoSeIngresoElAsunto() {
        groupLogic.validoNoIngresoAsunto();
    }

    @When("Creo el nuevo grupo {string}")
    public void creoElNuevoGrupo(String asunto) {
        groupLogic.creoNuevoGrupo(asunto);
    }

    @And("Salir y eliminar el grupo para mi")
    public void salirYEliminarElGrupoParaMi() {
        groupLogic.salirEliminarGrupoMi();
    }

    @Then("Valido que se elimino el grupo")
    public void validoQueSeEliminoElGrupo() {
        groupLogic.validoEliminoGrupo();
    }

    @When("Modifico la descripcion del grupo a {string}")
    public void modificoLaDescripcionDelGrupoA(String descripcion) {
        groupLogic.modificoDescripcionGrupo(descripcion);
    }

    @Then("Valido que se modifico la descripcion del grupo")
    public void validoQueSeModificoLaDescripcionDelGrupo() {
        groupLogic.validoModificoDescripcionGrupo();
    }

    @And("Elimino el nuevo grupo para todos usando swipe")
    public void eliminoElNuevoGrupoParaTodosUsandoSwipe() {
        groupLogic.eliminoNuevoGrupoTodosSwipe();
    }

}
