package pom.withoutPermission;

import lombok.Getter;

@Getter
public class WithoutPermissionPage {

    //Home
    private final String btnGrupos = "//android.widget.ImageView[@content-desc='Grupos\n" +"Pestaña 2 de 3']";
    private final String primerGrupo = "//android.widget.ImageView[@index='0']";
    private final String btnLupaBusqueda = "//*/android.view.View/android.widget.ImageView[2]";
    private final String btnLapizNuevoMensaje="//android.widget.Button[@index='4']";
    private final String btnChatReciente = "//android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]";
    private final String btn3Puntos = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[3]";
    private final String btnContactos = "//android.widget.ImageView[@content-desc='Contactos']";
    private final String btnNuevoGrupoDesde3Puntos = "//android.widget.ImageView[@content-desc='Nuevo grupo']";
    private final String btnPerfil = "//android.widget.ImageView[@index=1]";

    //Perfil
    private final String btn3PuntosPerfil = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView";
    private final String btnEditar = "//android.view.View[@content-desc='Editar']";
    private final String btnCambiarFoto = "//android.view.View[@content-desc='Cambiar foto']";

    //ChatPage
    private final String inputMensaje = "//android.widget.EditText";
    private final String btnAdjuntar = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.Button[1]";
    private final String btnDesdeCamara="//android.view.View[@content-desc='Cámara']";
    private final String btnAdjuntarFotos="//android.view.View[@content-desc='Foto']";
    private final String btnAdjuntarUbicacion = "//android.view.View[@content-desc='Ubicación']";
    private final String btnMiUbicacion = "//android.widget.ImageView[@content-desc='Mi ubicación']";
    private final String btnAdjuntarFoto = "//android.view.View[@content-desc='Foto']";
    private final String btnAdjuntarVideo = "//android.view.View[@content-desc='Video']";
    private final String btnAdjuntarDocumento = "//android.view.View[@content-desc='Documentos']";
    private final String btnDesdeGaleria = "//android.view.View[@content-desc='Galería']";
    private final String bntCancelar = "//android.widget.Button[@content-desc='Cancelar']";
    private final String btnLlamada = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]";
    private final String btnVideoLLamada = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]";
    private final String btnEnviar =  "//*/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.ImageView";
    private final String btnGrabarNota = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[3]";

    //Permisos
    private final String btnIniciarSesion = "//android.widget.Button[@content-desc='Iniciar sesión']";
    private final String btnPermitir = "//android.widget.Button[@text='PERMITIR']";
    private final String btnRegistro = "//android.widget.Button[@content-desc='Regístrate']";
    private final String btnAgregarFoto = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View";
    private final String btnRechazar = "//android.widget.Button[@text='NO PERMITIR']";
    private final String lblWarning = "//android.view.View[contains(@content-desc,'Ocurrió un error inesperado')]";
    private final String lblWarning2 =  "//android.widget.ImageView[@content-desc='Se ha rechazado el permiso a los contactos multiples veces, debes activarlo manualmente.']";
    private final String preguntaAbrirCamara = "//android.widget.TextView[@text='¿Permitir que VenChat-dev tome fotos y grabe videos?']";
    private final String preguntaCompartirUbicacion = "//android.widget.TextView[@text='¿Permitir que VenChat-dev acceda a la ubicación de este dispositivo?']";
    private final String preguntaAccederContactos = "//android.widget.TextView[@text='¿Permitir que VenChat-dev acceda a tus contactos?']";
    private final String btnActivar = "//android.widget.Button[@content-desc='Activar']";
    private final String btnCancelar = "//android.widget.Button[@content-desc='Cancelar']";

    //Grupo
    private final String inputBusqueda = "//android.widget.EditText";
    private final String vistaImageView = "//android.widget.ImageView";
    private final String elementoDeLaLista = "//android.widget.ImageView[contains(@content-desc,'%s')]";
    private final String btnMenu3PuntosDesdeInfoGrupo = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]";
    private final String btnAgregarParticipante = "//android.widget.Button[@content-desc='Agregar participante']";
    private final String btnMenu3PuntosChat = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]";
    private final String btnInfoGrupo = "//android.widget.Button[@content-desc='Información del grupo']";
    private final String btnTerminarAgregarIntegrantes = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button";
    private final String btnIngresarFotoPerfilGrupo = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.Button";
}
