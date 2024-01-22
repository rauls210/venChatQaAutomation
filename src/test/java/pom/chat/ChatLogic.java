package pom.chat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import steps.Hooks;

import static org.junit.Assert.*;

public class ChatLogic extends Hooks{

    ChatPage chatPage = new ChatPage();
    private static final Logger log = LogManager.getLogger(ChatLogic.class);

    public void abrirNuevoChat(String contacto){
        String step = "Abro un nuevo chat " + contacto;
        log.info(step);

        clickElement(chatPage.getBtnLapizNuevoMensaje());
        clickElement(chatPage.getBtnLupa());
        clickElement(chatPage.getInputBusqueda());
        write(chatPage.getInputBusqueda(), contacto);
        hideKeyboard();
        clickElement(chatPage.getBtnContactoIndex0());
        elementIsDisplayed(chatPage.getBtnAdjuntar());

        aux = contacto;
    }

    public void validoCrearUnNuevoChat(){
        String step = "Valido que se creo un nuevo chat";
        log.info(step);

        String lbContacto = String.format(chatPage.getLbContacto(), aux);

        assertEquals("El nombre del contacto no coincide", aux, textFromElementAttribute(lbContacto));
    }

    public void validoVisualizarInformacionContacto(String numero, String nombre){
        String step = "Valido que visualizo la informacion del contacto: nro: " + numero +", nombre: " + nombre;
        log.info(step);

        elementIsDisplayed(chatPage.getBtnMenu3Puntos());
        clickElement(chatPage.getBtnMenu3Puntos());
        elementIsDisplayed(chatPage.getBtnVerContacto());
        clickElement(chatPage.getBtnVerContacto());

        boolean numTlf = elementIsDisplayed(String.format(chatPage.getLb_numeroContacto(), numero));
        boolean name = elementIsDisplayed(String.format(chatPage.getLb_nombreContacto(), nombre));

        assertTrue("No se visualiza el numero de telefono", numTlf);
        assertTrue("No se visualiza el nombre del contacto", name);
    }

    public void validoEnviarMensajesModoSeguro() {
        String step = "Valido que pueda enviar mensajes modo seguro";
        log.info(step);

        clickElement(chatPage.getInputMensaje());
        write(chatPage.getInputMensaje(), "Este es un mensaje seguro");
        clickElement(chatPage.getBtnEnviar());
        elementIsDisplayed(chatPage.getLbMensajeSeguro());

        assertEquals("No se encontro un mensaje seguro",1, bringMeAllElements(chatPage.getLbMensajeSeguro()).size());
    }

    public void validoCitarUnMensaje(){
        String step = "Valido que pueda citar un mensaje";
        log.info(step);

        clickElement(chatPage.getInputMensaje());
        write(chatPage.getInputMensaje(), "Este es un mensaje seguro");
        clickElement(chatPage.getBtnEnviar());
        hideKeyboard();
        swipe(0.40, 0.90, 0.8 ,0.90);

        boolean boton = elementIsDisplayed(chatPage.getBtnCancelarRespuestaMensaje());

        assertTrue("No se visualiza Boton Cancelar cita", boton);
    }

    public void validoEnviarMensajesModoConfidencial() {
        String step = "Valido que pueda enviar mensajes modo confidencial";
        log.info(step);

        clickElement(chatPage.getBtnCambiarModo());
        clickElement(chatPage.getBtnConfidencial());
        clickElement(chatPage.getInputMensaje());
        write(chatPage.getInputMensaje(), "Este es un mensaje confidencial");
        clickElement(chatPage.getBtnEnviar());
        elementIsDisplayed(chatPage.getLbMensajeConfidencial());

        assertEquals("No se encontro un mensaje confidencial",2, bringMeAllElements(chatPage.getLbMensajeConfidencial()).size());
    }

    public void validoCitarUnMensajeConfidencial() {
        String step = "Valido que pueda citar mensajes modo confidencial";
        log.info(step);

        clickElement(chatPage.getBtnCambiarModo());
        clickElement(chatPage.getBtnConfidencial());
        clickElement(chatPage.getInputMensaje());
        write(chatPage.getInputMensaje(), "Este es un mensaje confidencial");
        clickElement(chatPage.getBtnEnviar());
        hideKeyboard();
        elementIsDisplayed(chatPage.getLbMensajeConfidencial());

        swipe(0.40, 0.90, 0.8 ,0.90);

        elementIsDisplayed(chatPage.getLblCitaConfidencial());
        clickElement(chatPage.getInputMensaje());
        write(chatPage.getInputMensaje(), "Citando mensaje oculto");
        clickElement(chatPage.getBtnEnviar());

        boolean cita = elementIsDisplayed(chatPage.getLblCitaConfidencial());

        assertTrue("No se encontro el elemento citado", cita);
    }

    public void validoEnviarMensajesModoBorradoAutomatico() {
        String step = "Valido que pueda enviar mensajes modo borrado automatico";
        log.info(step);

        clickElement(chatPage.getBtnCambiarModo());
        clickElement(chatPage.getBtnBorradoAuto());
        clickElement(chatPage.getInputMensaje());
        write(chatPage.getInputMensaje(), "Este es un mensaje borrado automatico");
        clickElement(chatPage.getBtnEnviar());
        elementIsDisplayed(chatPage.getLbMensajeBorradoAuto());

        assertEquals("No se encontro un mensaje borrado automatico",2, bringMeAllElements(chatPage.getLbMensajeBorradoAuto()).size());
    }

    public void validoEnviarNotasDeVoz() {
        String step = "Valido que pueda enviar notas de voz";
        log.info(step);

        clickAndHold(chatPage.getBtnGrabar_Audio());

        boolean audio = elementIsDisplayed(chatPage.getLbMensajeDeVoz());

        assertTrue("No se encontro la nota de voz", audio);
    }

    public void validoCitarNotaDeVoz() {
        String step = "Valido que pueda citar una nota de voz";
        log.info(step);

        clickAndHold(chatPage.getBtnGrabar_Audio());
        elementIsDisplayed(chatPage.getLbMensajeDeVoz());

        swipe(0.40, 0.90, 0.8 ,0.90);

        elementIsDisplayed(chatPage.getLblCitaDeVoz());
        clickElement(chatPage.getInputMensaje());
        write(chatPage.getInputMensaje(), "Citando nota de voz");
        clickElement(chatPage.getBtnEnviar());

        boolean cita = elementIsDisplayed(chatPage.getLblCitaDeVoz());

        assertTrue("No se encontro el elemento citado", cita);
    }

    public void validoEnviarFotosDesdeGaleria(){
        String step = "Valido que pueda enviar fotos desde la galeria";
        log.info(step);

        clickElement(chatPage.getBtnAdjuntar());
        clickElement(chatPage.getBtnAdjuntarFotos());
        clickElement(chatPage.getBtnDesdeGaleria());

        if(elementIsDisplayed(chatPage.getBtn3PuntosMasOpciones())) {
            clickElement(chatPage.getBtn3PuntosMasOpciones());
            if(elementIsDisplayed(chatPage.getBtn3PuntosExplorar())) {
                clickElement(chatPage.getBtn3PuntosExplorar());
            }else {
                navigateBack();
            }
        }

        loadFile("src/main/resources/files/ven.png", "/sdcard/VenTest/ven.png");

        clickElement(chatPage.getBtnPrimerArchivo());
        clickElement(chatPage.getBtn_OK_Foto_Edit());
        clickElement(chatPage.getBtn_Enviar_Foto());

        boolean foto = elementIsDisplayed(chatPage.getLbMensajeFoto());

        assertTrue("No se encontro la imagen", foto);
    }

    public void validoEnviarFotosDesdeCamara(){
        String step = "Valido que pueda enviar fotos desde la camara";
        log.info(step);

        clickElement(chatPage.getBtnAdjuntar());
        clickElement(chatPage.getBtnAdjuntarFotos());
        clickElement(chatPage.getBtnDesdeCamara());
        clickElement(chatPage.getBtn_Tomar_Foto_Camara());
        clickElement(chatPage.getBtn_OK_Foto_Edit());
        clickElement(chatPage.getBtn_Enviar_Foto());

        boolean mensaje = elementIsDisplayed(chatPage.getLbMensajeFoto());

        assertTrue("No se encontro la imagen", mensaje);
    }

    public void validoCitarUnaImagen() {
        String step = "Valido que pueda citar una imagen";
        log.info(step);

        clickElement(chatPage.getBtnAdjuntar());
        clickElement(chatPage.getBtnAdjuntarFotos());
        clickElement(chatPage.getBtnDesdeCamara());
        clickElement(chatPage.getBtn_Tomar_Foto_Camara());
        clickElement(chatPage.getBtn_OK_Foto_Edit());
        clickElement(chatPage.getBtn_Enviar_Foto());

        elementIsDisplayed(chatPage.getLbMensajeFoto());

        swipe(0.40, 0.90, 0.8 ,0.90);

        elementIsDisplayed(chatPage.getLblCitaImagen());
        clickElement(chatPage.getInputMensaje());
        write(chatPage.getInputMensaje(), "Citando imagen");
        clickElement(chatPage.getBtnEnviarCitaFotoVideo());

        boolean cita = elementIsDisplayed(chatPage.getLblCitaImagen());

        assertTrue("No se encontro el elemento citado", cita);
    }

    public void validoEnviarVideosDesdeGaleria() {
        String step = "Valido que pueda enviar videos desde galeria";
        log.info(step);

        clickElement(chatPage.getBtnAdjuntar());
        clickElement(chatPage.getBtnAdjuntarVideo());
        clickElement(chatPage.getBtnDesdeGaleria());

        if(elementIsDisplayed(chatPage.getBtn3PuntosMasOpciones())) {
            clickElement(chatPage.getBtn3PuntosMasOpciones());
            if(elementIsDisplayed(chatPage.getBtn3PuntosExplorar())){
                clickElement(chatPage.getBtn3PuntosExplorar());
            }else {
                navigateBack();
            }
        }

        loadFile("src/main/resources/files/ven.mp4", "/sdcard/VenTest/ven.mp4");

        clickElement(chatPage.getBtnPrimerArchivo());
        clickElement(chatPage.getBtn_aceptarAdjunto());
        clickElement(chatPage.getBtn_enviarAdjunto());
        clickElement(chatPage.getBtnMensajeConVideo());

        boolean mensaje = elementIsDisplayed(chatPage.getLbMensajeVideo());

        navigateBack();
        navigateBack();

        assertTrue("No se encontro el video", mensaje);
    }

    public void validoCitarVideo() {
        String step = "Valido que pueda citar un video";
        log.info(step);

        clickElement(chatPage.getBtnAdjuntar());
        clickElement(chatPage.getBtnAdjuntarVideo());
        clickElement(chatPage.getBtnDesdeGaleria());

        if(elementIsDisplayed(chatPage.getBtn3PuntosMasOpciones())) {
            clickElement(chatPage.getBtn3PuntosMasOpciones());
            if(elementIsDisplayed(chatPage.getBtn3PuntosExplorar())){
                clickElement(chatPage.getBtn3PuntosExplorar());
            }else {
                navigateBack();
            }
        }

        loadFile("src/main/resources/files/ven.mp4", "/sdcard/VenTest/ven.mp4");

        clickElement(chatPage.getBtnPrimerArchivo());
        clickElement(chatPage.getBtn_aceptarAdjunto());
        clickElement(chatPage.getBtn_enviarAdjunto());
        elementIsDisplayed(chatPage.getBtnMensajeConVideo());

        swipe(0.40, 0.90, 0.8 ,0.90);

        elementIsDisplayed(chatPage.getLblCitaVideo());
        clickElement(chatPage.getInputMensaje());
        write(chatPage.getInputMensaje(), "Citando video");
        clickElement(chatPage.getBtnEnviarCitaFotoVideo());

        boolean cita = elementIsDisplayed(chatPage.getLblCitaVideo());

        assertTrue("No se encontro el elemento citado", cita);
    }

    public void validoEnviarDocumentos() {
        String step = "Valido que pueda enviar documentos";
        log.info(step);

        clickElement(chatPage.getBtnAdjuntar());
        clickElement(chatPage.getBtnAdjuntarDocumentos());

        loadFile("src/main/resources/files/ven.pdf", "/sdcard/VenTest/ven.pdf");

        clickElement(chatPage.getBtnArchBuscar());
        write(chatPage.getLblArchInput(), "ven.pdf");

        navigateBack();

        clickElement(chatPage.getBtnPrimerArchivo());

        boolean mensaje = elementIsDisplayed(chatPage.getLbMensajeDocPDF());

        assertTrue("No se encontro el documento", mensaje);
    }

    public void validoCitarDocumentos() {
        String step = "Valido que pueda citar documentos";
        log.info(step);

        clickElement(chatPage.getBtnAdjuntar());
        clickElement(chatPage.getBtnAdjuntarDocumentos());

        loadFile("src/main/resources/files/ven.pdf", "/sdcard/VenTest/ven.pdf");

        clickElement(chatPage.getBtnArchBuscar());
        write(chatPage.getLblArchInput(), "ven.pdf");

        navigateBack();

        clickElement(chatPage.getBtnPrimerArchivo());
        elementIsDisplayed(chatPage.getLbMensajeDocPDF());

        swipe(0.40, 0.90, 0.8 ,0.90);

        elementIsDisplayed(chatPage.getLblCitaDocumento());
        clickElement(chatPage.getInputMensaje());
        write(chatPage.getInputMensaje(), "Citando documento");
        clickElement(chatPage.getBtnEnviar());

        boolean cita = elementIsDisplayed(chatPage.getLblCitaDocumento());

        assertTrue("No se encontro el elemento citado", cita);
    }

    public void validoVerPantallaArchivos(){
        String step = "Valido que se visualiza el archivo en la pantalla de archivos";
        log.info(step);

        clickElement(chatPage.getBtnAdjuntar());
        clickElement(chatPage.getBtnAdjuntarDocumentos());

        loadFile("src/main/resources/files/ven.pdf", "/sdcard/VenTest/ven.pdf");

        clickElement(chatPage.getBtnArchBuscar());
        write(chatPage.getLblArchInput(), "ven.pdf");

        navigateBack();

        clickElement(chatPage.getBtnPrimerArchivo());
        elementIsDisplayed(chatPage.getLbMensajeDocPDF());
        clickElement(chatPage.getBtnMenu3Puntos());
        clickElement(chatPage.getBtnArchivos());

        boolean archivo = elementIsDisplayed(chatPage.getLblArchivoEnviado());
        
        assertTrue("No se encontro el documento", archivo);

        navigateBack();
    }

    public void eliminarChat() {
        String step = "Elimino el chat";
        log.info(step);

        hideKeyboard();
        navigateBack();

        String chatReciente = String.format(chatPage.getLblChatReciente(), aux);

        clickAndHold(chatReciente);
        clickElement(chatPage.getBtnEliminarChat());
        clickElement(chatPage.getBtnAceptarEliminar());
        elementIsDisplayed(chatPage.getBtnLapizNuevoMensaje());
    }

    public void validoEliminarChat() {
        String step = "Valido eliminar el chat";
        log.info(step);

        hideKeyboard();
        navigateBack();

        String chatReciente = String.format(chatPage.getLblChatReciente(), aux);

        clickAndHold(chatReciente);
        clickElement(chatPage.getBtnEliminarChat());
        clickElement(chatPage.getBtnAceptarEliminar());

        boolean chat = elementIsDisplayed(chatReciente);

        assertFalse("Se visualiza el chat con " + aux, chat);
    }

    public void bloquearContacto() {
        String step = "Bloqueo al contacto";
        log.info(step);

        clickElement(chatPage.getInputMensaje());
        write(chatPage.getInputMensaje(), "mensaje");
        clickElement(chatPage.getBtnEnviar());
        elementIsDisplayed(chatPage.getLbMensajeSeguro());
        clickElement(chatPage.getBtnMenu3Puntos());
        clickElement(chatPage.getBtnBloquear());
        clickElement(chatPage.getBtnBloquear());

        boolean input = elementIsDisplayed(chatPage.getInputMensaje());

        assertFalse("No se ha bloqueado correctamente, input visible", input);
    }

    public void desbloquearContacto() {
        String step = "Desbloqueo al contacto";
        log.info(step);

        clickElement(chatPage.getBtnMenu3Puntos());
        clickElement(chatPage.getBtnDesbloquear());

        boolean input = elementIsDisplayed(chatPage.getInputMensaje());

        assertTrue("No se ha desbloqueado correctamente, input no visible", input);
    }

    public void EnviarMensaje() {
        String step = "Envio un mensaje";
        log.info(step);

        clickElement(chatPage.getInputMensaje());
        write(chatPage.getInputMensaje(), "Nuevo mensaje");
        clickElement(chatPage.getBtnEnviar());
    }

    public void validoEnviarEmoji() {
        String step = "Valido que pueda enviar un Emoji ";
        log.info(step);

        clickElement(chatPage.getBtnEmojistickers());
        clickElement(chatPage.getLbEmojis());
        elementIsDisplayed(chatPage.getBtnEmojisMenuCarita());
        clickElement(chatPage.getBtnEmojisMenuCarita());
        clickElement(chatPage.getBtnEmojicarita());
        clickElement(chatPage.getBtnEnviar());

        boolean emoji = elementIsDisplayed(chatPage.getLbEmojiCaritaenviado());

        assertTrue("No se encontro el emoji", emoji);
    }

    public void validoCitarEmoji(){
        String step = "Valido que pueda citar un emoji";
        log.info(step);

        clickElement(chatPage.getBtnEmojistickers());
        clickElement(chatPage.getLbEmojis());
        elementIsDisplayed(chatPage.getBtnEmojisMenuCarita());
        clickElement(chatPage.getBtnEmojisMenuCarita());
        clickElement(chatPage.getBtnEmojicarita());
        clickElement(chatPage.getBtnEnviar());
        elementIsDisplayed(chatPage.getLbEmojiCaritaenviado());
        clickElement(chatPage.getLblTecladoNormal());

        hideKeyboard();

        swipe(0.40, 0.90, 0.8 ,0.90);

        elementIsDisplayed(chatPage.getLblCitaEmoji());
        clickElement(chatPage.getInputMensaje());
        write(chatPage.getInputMensaje(), "Citando emoji");
        clickElement(chatPage.getBtnEnviar());

        boolean cita = elementIsDisplayed(chatPage.getLblCitaEmoji());

        assertTrue("No se encontro el elemento citado", cita);
    }

    public void validoEnviarGif() {
        String step = "Valido que pueda enviar un Gif ";
        log.info(step);

        clickElement(chatPage.getBtnEmojistickers());
        clickElement(chatPage.getLbGifStickers());
        elementIsDisplayed(chatPage.getBtnMenuGif());
        clickElement(chatPage.getBtnMenuGif());
        clickElement(chatPage.getBtnGif());

        boolean gif = elementIsDisplayed(chatPage.getLbGifStck());

        assertTrue("No se encontro el gif", gif);
    }


    public void validoCitarGif(){
        String step = "Valido que pueda citar un gif";
        log.info(step);

        clickElement(chatPage.getBtnEmojistickers());
        clickElement(chatPage.getLbGifStickers());
        elementIsDisplayed(chatPage.getBtnMenuGif());
        clickElement(chatPage.getBtnMenuGif());
        clickElement(chatPage.getBtnGif());
        elementIsDisplayed(chatPage.getLbGifStck());
        clickElement(chatPage.getLblTecladoNormal());

        navigateBack();

        swipe(0.40, 0.90, 0.8 ,0.90);

        elementIsDisplayed(chatPage.getLblCitaGif());
        clickElement(chatPage.getInputMensaje());
        write(chatPage.getInputMensaje(), "Citando GIF");
        clickElement(chatPage.getBtnEnviar());

        boolean cita = elementIsDisplayed(chatPage.getLblCitaGif());

        assertTrue("No se encontro el elemento citado", cita);
    }

    public void validoEnviarSticker() {
        String step = "Valido que pueda enviar un Sticker";
        log.info(step);

        clickElement(chatPage.getBtnEmojistickers());
        clickElement(chatPage.getLbGifStickers());
        elementIsDisplayed(chatPage.getBtnMenuStickers());
        clickElement(chatPage.getBtnMenuStickers());
        clickElement(chatPage.getBtnSticker());

        boolean sticker = elementIsDisplayed(chatPage.getLbGifStck());

        assertTrue("No se encontro el sticker", sticker);
    }

    public void validoCitarSticker(){
        String step = "Valido que pueda citar un Sticker";
        log.info(step);

        clickElement(chatPage.getBtnEmojistickers());
        clickElement(chatPage.getLbGifStickers());
        elementIsDisplayed(chatPage.getBtnMenuStickers());
        clickElement(chatPage.getBtnMenuStickers());
        clickElement(chatPage.getBtnSticker());
        elementIsDisplayed(chatPage.getLbGifStck());
        clickElement(chatPage.getLblTecladoNormal());

        hideKeyboard();

        swipe(0.40, 0.90, 0.8 ,0.90);

        elementIsDisplayed(chatPage.getLblCitaSticker());
        clickElement(chatPage.getInputMensaje());
        write(chatPage.getInputMensaje(), "Citando Sticker");
        clickElement(chatPage.getBtnEnviar());

        boolean cita = elementIsDisplayed(chatPage.getLblCitaSticker());

        assertTrue("No se encontro el elemento citado", cita);
    }

    public void eliminarMensajeEnviadoParaMi() {
        String step = "Elimino un mensaje enviado para mi";
        log.info(step);

        clickElement(chatPage.getInputMensaje());
        write(chatPage.getInputMensaje(), "Mensaje");
        clickElement(chatPage.getBtnEnviar());
        clickAndHold(chatPage.getLbMensajeReciente());
        clickElement(chatPage.getBtnCerrar());
        clickElement(chatPage.getBtnEliminarMensaje());
        clickElement(chatPage.getBtnConfirmarEliminarMensajeParaMi());

        boolean mensaje = elementIsDisplayed(chatPage.getLbMensajeReciente());

        assertFalse("El mensaje enviado se encuentra en pantalla", mensaje);
    }
    public void eliminoUnMensajeEnviadoParaTodos() {
        String step = "Elimino un mensaje enviado para todos";
        log.info(step);

        clickElement(chatPage.getInputMensaje());
        write(chatPage.getInputMensaje(), "Mensaje");
        clickElement(chatPage.getBtnEnviar());
        clickAndHold(chatPage.getLbMensajeReciente());
        clickElement(chatPage.getBtnCerrar());
        clickElement(chatPage.getBtnEliminarMensaje());
        clickElement(chatPage.getBtnConfirmarEliminarMensajeTodos());

        boolean mensaje = elementIsDisplayed(chatPage.getLblMsjEliminadoParaTodos());

        assertTrue("No se ve el mensaje eliminado para todos",mensaje);
    }
}