package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.chat.ChatLogic;

public class ChatSteps {

    ChatLogic chatLogic = new ChatLogic();

    @When("Abro un nuevo chat {string}")
    public void abrirNuevoChat(String contacto) {
        chatLogic.abrirNuevoChat(contacto);
    }

    @Then("Valido que se creo un nuevo chat")
    public void validoCrearUnNuevoChat() {
        chatLogic.validoCrearUnNuevoChat();
    }

    @Then("Valido que visualizo la informacion del contacto: nro {string}, nombre {string}")
    public void validoVisualizarInformacionContacto(String numero, String nombre) {
        chatLogic.validoVisualizarInformacionContacto(numero, nombre);
    }

    @Then("Valido que pueda enviar mensajes modo seguro")
     public void validoEnviarMensajesModoSeguro() {
        chatLogic.validoEnviarMensajesModoSeguro();
    }

    @Then("Valido que pueda enviar mensajes modo confidencial")
    public void validoEnviarMensajesModoConfidencial() {
        chatLogic.validoEnviarMensajesModoConfidencial();
    }

    @Then("Valido que pueda citar un mensaje confidencial")
    public void validoCitarUnMensajeConfidencial() {
        chatLogic.validoCitarUnMensajeConfidencial();
    }

    @Then("Valido que pueda enviar mensajes modo borrado automatico")
    public void validoEnviarMensajesModoBorradoAutomatico() {
        chatLogic.validoEnviarMensajesModoBorradoAutomatico();
    }

    @Then("Valido que pueda citar un mensaje")
    public void validoCitarUnMensaje() {
        chatLogic.validoCitarUnMensaje();
    }

    @Then("Valido que pueda enviar notas de voz")
    public void validoEnviarNotasDeVoz() {
        chatLogic.validoEnviarNotasDeVoz();
    }

    @Then("Valido que pueda citar una nota de voz")
    public void validoCitarNotaDeVoz() {
        chatLogic.validoCitarNotaDeVoz();
    }

    @Then("Valido que pueda enviar fotos desde la galeria")
    public void validoEnviarFotosDesdeGaleria() {
        chatLogic.validoEnviarFotosDesdeGaleria();
    }

    @Then("Valido que pueda enviar fotos desde la camara")
    public void validoEnviarFotosDesdeCamara() {
        chatLogic.validoEnviarFotosDesdeCamara();
    }

    @Then("Valido que pueda citar una imagen")
    public void validoCitarUnaImagen() {
        chatLogic.validoCitarUnaImagen();
    }

    @Then("Valido que pueda enviar videos desde galeria")
    public void validoEnviarVideosDesdeGaleria() {
        chatLogic.validoEnviarVideosDesdeGaleria();
    }

    @Then("Valido que pueda citar un video")
    public void validoCitarVideo() {
        chatLogic.validoCitarVideo();
    }

    @Then("Valido que pueda enviar documentos")
    public void validoEnviarDocumentos() {
        chatLogic.validoEnviarDocumentos();
    }

    @Then("Valido que pueda citar un documento")
    public void validoCitarDocumentos() {
        chatLogic.validoCitarDocumentos();
    }

    @Then("Valido que se visualiza el archivo en la pantalla de archivos")
    public void validoVerPantallaArchivos() {
        chatLogic.validoVerPantallaArchivos();
    }

    @Then("Elimino el chat")
    public void eliminoElChat() {
       chatLogic.eliminarChat();
    }

    @Then("Bloqueo al contacto")
    public void bloquearContacto() {
       chatLogic.bloquearContacto();
    }

    @And("Desbloqueo al contacto")
    public void desbloquearContacto() {
        chatLogic.desbloquearContacto();
    }

    @And("Envio un mensaje seguro")
    public void EnviarMensaje() {
        chatLogic.EnviarMensaje();
    }

    @Then("Valido que pueda enviar un emoji")
    public void validoEnviarEmoji() {
        chatLogic.validoEnviarEmoji();
    }

    @Then("Valido que pueda enviar un gif")
    public void validoEnviarGif() {
        chatLogic.validoEnviarGif();
    }

    @Then("Valido que pueda enviar un sticker")
    public void validoEnviarSticker() {
        chatLogic.validoEnviarSticker();
    }

    @Then("Elimino un mensaje enviado para mi")
    public void eliminarMensajeEnviadoParaMi() {
        chatLogic.eliminarMensajeEnviadoParaMi();
    }

    @Then("Elimino un mensaje enviado para todos")
    public void eliminoUnMensajeEnviadoParaTodos() {
        chatLogic.eliminoUnMensajeEnviadoParaTodos();
    }
    @Then("Valido que pueda citar un emoji")
    public void validoCitarEmoji() {
        chatLogic.validoCitarEmoji();
    }

    @Then("Valido que pueda citar un gif")
    public void validoCitarGif() {
        chatLogic.validoCitarGif();
    }

    @Then("Valido que pueda citar un sticker")
    public void validoCitarSticker() {
        chatLogic.validoCitarSticker();
    }

    @Then("Valido eliminar el chat")
    public void validoEliminarChat() {
        chatLogic.validoEliminarChat();
    }


}