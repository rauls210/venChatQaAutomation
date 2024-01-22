package pom.chat;

import lombok.Getter;

@Getter
public class ChatPage {
    //home
    private final String btnLapizNuevoMensaje="//android.widget.Button[@index='4']";
    private final String btnLupa = "//*/android.view.View/android.widget.ImageView";
    private final String inputBusqueda = "//android.widget.EditText";
    private final String BtnContactoIndex0 = "//android.widget.ImageView[@index='0']";
    private final String btnEliminarChat = "//*/android.view.View/android.widget.ImageView[2]";
    private final String btnAceptarEliminar = "//android.widget.Button[@content-desc='Eliminar']";
    private final String lblChatReciente = "//android.widget.ImageView[contains(@content-desc,'%1$s')]";

    //chat
    private final String lbMensajeReciente = "//android.view.View[4]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View";
    private final String lbMensajeSeguro = "//android.view.View[4]/android.view.View[1]/android.view.View[1]/android.view.View[2]/*";
    private final String lbMensajeConfidencial ="//android.view.View[4]/android.view.View[1]/android.view.View[1]/android.view.View[2]/*";
    private final String lbMensajeBorradoAuto ="//android.view.View[4]/android.view.View[1]/android.view.View[1]/android.view.View[2]/*";
    private final String lbMensajeDeVoz = "//android.view.View[1]/android.view.View[2]/android.widget.SeekBar";
    private final String lbMensajeFoto = "//android.view.View[1]/android.view.View[2]/android.widget.ImageView";
    private final String lbMensajeVideo  = "//android.view.View[contains(@content-desc,'00:00 / ')]";
    private final String btnArchivos = "//android.widget.Button[@content-desc='Archivos']";
    private final String btnBloquear = "//android.widget.Button[@content-desc='Bloquear']";
    private final String btnDesbloquear = "//android.widget.Button[@content-desc='Desbloquear']";
    private final String btnCambiarModo = "//android.widget.EditText/android.view.View";
    private final String btnConfidencial = "//android.view.View[@content-desc='Modo confidencial']";
    private final String btnBorradoAuto = "//android.view.View[@content-desc='Modo borrado automático']";
    private final String btnCancelarRespuestaMensaje = "//android.view.View[contains(@content-desc , 'Tú')]/android.widget.Button";
    private final String btnAdjuntar = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.Button[1]";
    private final String btnDesdeCamara="//android.view.View[@content-desc='Cámara']";
    private final String btnDesdeGaleria="//android.view.View[@content-desc='Galería']";
    private final String btnAdjuntarFotos="//android.view.View[@content-desc='Foto']";
    private final String btnAdjuntarVideo="//android.view.View[@content-desc='Video']";
    private final String btnAdjuntarDocumentos="//android.view.View[@content-desc='Documentos']";
    private final String btnGrabar_Audio="//android.view.View/android.view.View[4]/android.view.View[3]";
    private final String btnEmojistickers = "//android.view.View/android.view.View[4]/android.view.View[2]";
    private final String lbEmojis = "//android.widget.Button[@content-desc='Emoji']";
    private final String lbGifStickers = "//android.widget.Button[@content-desc='Gifs & Stickers']";
    private final String btnEmojisMenuCarita ="//android.view.View[@content-desc='Pestaña 2 de 9']";
    private final String btnMenuGif ="//android.view.View[@content-desc='GIFs\n" + "Pestaña 1 de 2']";
    private final String btnMenuStickers ="//android.view.View[@content-desc='Stickers\n" + "Pestaña 2 de 2']";
    private final String lbEmojiCaritaenviado ="//android.view.View[contains(@content-desc,'\uD83D\uDE00')]";
    private final String lbGifStck ="//android.widget.ImageView[contains(@content-desc,'m.')]";
    private final String lblTecladoNormal="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]";
    private final String btnEmojicarita ="//android.view.View[@content-desc='\uD83D\uDE00']";
    private final String btnGif = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]";
    private final String btnSticker = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]";
    private final String btnCerrar = "//android.view.View[@content-desc='Cerrar']";
    private final String lblCitaDeVoz = "//android.view.View[contains(@content-desc, 'AUDIO')]";
    private final String lblCitaConfidencial = "//android.view.View[@content-desc='Mensaje oculto']";
    private final String lblCitaDocumento =  "//android.view.View[contains(@content-desc, 'DOCUMENTO')]";
    private final String lblCitaVideo =  "//android.widget.ImageView[contains(@content-desc, 'VIDEO')]";
    private final String lblCitaImagen =  "//android.widget.ImageView[contains(@content-desc, 'IMAGEN')]";
    private final String lblCitaEmoji=  "//android.view.View[contains(@content-desc, '\uD83D\uDE00')]";
    private final String lblCitaGif =  "//android.view.View[contains(@content-desc, 'https')]";
    private final String lblCitaSticker =  "//android.view.View[contains(@content-desc, 'https')]";
    private final String btnEliminarMensaje = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]";
    private final String btnConfirmarEliminarMensajeTodos = "//android.widget.Button[@content-desc='Eliminar para todos']";
    private final String btnConfirmarEliminarMensajeParaMi = "//android.widget.Button[@content-desc='Eliminar para mí']";
    private final String LblMsjEliminadoParaTodos="//android.view.View[contains(@content-desc,'Eliminaste este mensaje')]";
    private final String lbMensajeDocPDF = "//android.view.View[1]/android.view.View[2]/android.widget.ImageView[@content-desc='ven.pdf\n" + "1.086 KB']";
    private final String inputMensaje = "//android.widget.EditText";
    private final String btnEnviar =  "//*/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.ImageView";
    private final String btnEnviarCitaFotoVideo =  "//*/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.ImageView[2]";
    private final String Btn_Tomar_Foto_Camara="//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[2]";
    private final String Btn_OK_Foto_Edit="//android.widget.Button[@content-desc='Crop']";
    private final String Btn_Enviar_Foto="//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[2]";
    private final String btnMenu3Puntos = "//*/android.view.View[3]";
    private final String btnVerContacto = "//android.widget.Button[@content-desc='Ver contacto']";
    private final String lb_nombreContacto = "//*[@content-desc='%s']";
    private final String lb_numeroContacto = "//*[@content-desc='%s']";
    private final String lblArchivoEnviado = "//*[contains(@content-desc, 'ven.pdf')]";
    private final String btn_aceptarAdjunto = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[2]";
    private final String btn_enviarAdjunto = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[2]";
    private final String btnMensajeConVideo = "//android.view.View[2]/android.widget.ImageView";

    //archivos
    private final String btnPrimerArchivo = "(//*[@resource-id='com.google.android.documentsui:id/icon_thumb'])[1]";
    private final String btnArchBuscar = "//android.widget.Button[@content-desc='Buscar']";
    private final String lblArchInput = "//*[contains(@text,'Buscar')]";
    private final String btn3PuntosMasOpciones="//android.widget.ImageView[@content-desc='Más opciones']";
    private final String btn3PuntosExplorar="//android.widget.TextView[@resource-id='com.google.android.providers.media.module:id/title']";
    private final String lbContacto = "//android.view.View[contains(@content-desc,'%1$s')]";
}