package pom.group;

import lombok.Getter;

@Getter
public class GroupPage {

    //Home
    private final String btnGrupos = "//android.widget.ImageView[@content-desc='Grupos\n" +"Pestaña 2 de 3']";
    private final String btnMenu3PuntosMain = "//*/android.view.View/android.widget.ImageView[3]";
    private final String btnNuevoGrupoDesde3Puntos = "//android.widget.ImageView[@content-desc='Nuevo grupo']";
    private final String btnLupaBusqueda = "//*/android.view.View/android.widget.ImageView[2]";
    private final String vistaImageView = "//android.widget.ImageView";
    private final String btnEliminarGrupo = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[3]";
    private final String cboxEliminarElGrupoParaTodos = "//android.widget.CheckBox[@content-desc='Eliminar el grupo para todos']";
    private final String btnConfirmarEliminarGrupo = "//android.widget.Button[@content-desc='Eliminar grupo']";
    private final String btnEliminarGrupoUnicoIntegrante = "//android.widget.Button[@content-desc='Eliminar grupo']";
    private final String LbmensajeUnicoAdmin = "//android.view.View[contains(@content-desc,'Usted es el único administrador de este grupo; asigne un nuevo administrador antes de abandonar el grupo.')]";
    private final String btnInfoGrupoEliminar = "//android.widget.Button[@content-desc='Información del grupo']";

    //Contactos
    private final String elementoDeLaLista = "//android.widget.ImageView[contains(@content-desc,'%s')]";
    private final String btnLupa = "//*/android.view.View/android.widget.ImageView";
    private final String inputBusqueda = "//android.widget.EditText";
    private final String btnTerminarAgregarParticipante = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView";
    private final String lbNoagregarContactoBloqueado = "//android.view.View[contains(@content-desc,'No puedes agregar un miembro con un contacto bloqueado')]";
    private final String btnLimpiarBusqueda = "//android.widget.EditText/android.widget.Button";

    //Creacion grupo
    private final String btnTerminarAgregarIntegrantes = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button";
    private final String editTNombreDelGrupo = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.EditText[1]";
    private final String editTDescripcionGrupo = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.EditText[2]";
    private final String btnTerminarCrearGrupo = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button";

    //Informacion grupo
    private final String btnInformacionContacto = "//android.widget.Button[@content-desc='Información de contacto']";
    private final String btnHacerAdministradorGrupo = "//android.widget.Button[@content-desc='Hacer administrador del grupo']";
    private final String btnEliminarIntegranteDelGrupo = "//android.widget.Button[@content-desc='Eliminar del grupo']";
    private final String btnMenu3PuntosDesdeInfoGrupo = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]";
    private final String btnCambiarNombreDelGrupo = "//android.widget.Button[@content-desc='Cambiar nombre de grupo']";
    private final String editTCambiarNombreGrupo = "//android.widget.EditText";
    private final String btnConfirmarCambioDeNombre = "//android.widget.Button";
    private final String btnAgregarParticipante = "//android.widget.Button[@content-desc='Agregar participante']";
    private final String vistaVariosAdministradores = "(//android.view.View[@content-desc='Administrador'])[%s]";

    //de chatpage
    private final String viewNombre = "//android.view.View[contains(@content-desc,'%s')]";
    private final String inputMensaje = "//android.widget.EditText";
    private final String btnMenu3PuntosChat = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]";
    private final String btnArchivos = "//android.widget.Button[@content-desc='Archivos']";
    private final String noSeHanEncontradoArchivos = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View";
    private final String btnInfoGrupo = "//android.widget.Button[@content-desc='Información del grupo']";

    private final String btnGrupo = "//*[contains(@content-desc,'Grupos')]";
    private final String btnNuevoGrupo = "//android.widget.Button[@index='4']";
    private final String lbContacto = "//android.widget.ImageView[@index='0']";
    private final String btnSigNuevoGrupo = "(//android.widget.Button)[2]";
    private final String btnImgCamara = "//*/android.view.View[3]/android.view.View/android.view.View/android.widget.Button";
    private final String btnGaleria = "//android.view.View[@content-desc='Galería']";
    private final String btnGaleriaTwo = "//android.widget.TextView[@content-desc='Galería']";
    private final String btnImagen = "//android.widget.FrameLayout[@content-desc='Botón']/android.widget.FrameLayout[1]/android.widget.ImageView";
    private final String inputAsunto = "(//android.widget.EditText)[1]";
    private final String inputDescripsion = "(//android.widget.EditText)[2]";
    private final String btnFinalizar = "//android.widget.Button[@index='1']";
    private final String lbAgregarAsunto = "//android.widget.ImageView[@content-desc='Añada asunto al grupo']";
    private final String lbGrupo = "//*[contains(@content-desc,'%1$s')]";
    private final String lbAsunto = "//android.view.View[@content-desc='Equipo de Calidad']";
    private final String btnVolverGrupo = "(//android.view.View[@index='3'])[1]";
    private final String lbEquipoCalidad = "//*[contains(@content-desc,'Equipo de Calidad')]";
    private final String btnBorrarGrupo = "//*/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[3]";
    private final String btnInfGrupo = "//*[@content-desc='Información del grupo']";
    private final String btnParticipante = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View[6]/android.view.View/android.view.View[1]";
    private final String btnAdminGrupo = "//android.widget.Button[@content-desc='Hacer administrador del grupo']";
    private final String btnEliminarGrupoTwo = "//android.widget.Button[@content-desc='Eliminar grupo']";
    private final String btnPruebaManual = "//*[contains(@content-desc,'Prueba manual')]";
    private final String btnAnadeDescrip = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View[@index='7']";
    private final String inputGrupo = "//android.widget.EditText";
    private final String btnConfirmar = "//android.widget.Button";
    private final String btnEliminar = "//android.widget.Button[@content-desc='Eliminar']";
    private final String checkBoxEliminarGrupo = "//android.widget.CheckBox[@content-desc='Eliminar el grupo para todos']";
}