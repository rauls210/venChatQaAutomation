package pom.withoutPermission;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import steps.Hooks;

import static org.junit.Assert.*;

public class WithoutPermissionLogic extends Hooks {

    WithoutPermissionPage withoutPermissionPage = new WithoutPermissionPage();

    private static final Logger log = LogManager.getLogger(WithoutPermissionLogic.class);

    public void inicioSesionAppVenChatSinPermisos() {
        String step = "Inicio sesion en app de venChat sin dar permisos";
        log.info(step);

        while (elementIsDisplayed(withoutPermissionPage.getBtnRechazar())) {
            clickElement(withoutPermissionPage.getBtnRechazar());
        }

        clickElement(withoutPermissionPage.getBtnIniciarSesion());
    }

    public void registrarCuentaAppDeVenChatSinPermisos() {
        String step = "Registrar cuenta en app de venChat sin dar permisos";
        log.info(step);

        while (elementIsDisplayed(withoutPermissionPage.getBtnRechazar())) {
            clickElement(withoutPermissionPage.getBtnRechazar());
        }

        clickElement(withoutPermissionPage.getBtnRegistro());
    }

    public void abroListaContactos() {
        String step = "Abro la lista de contactos";
        log.info(step);

        clickElement(withoutPermissionPage.getBtn3Puntos());
        clickElement(withoutPermissionPage.getBtnContactos());
    }

    public void validoVisualizaMensajePidiendoAcceso() {
        String step = "Valido que se visualiza el mensaje pidiendo acceso";
        log.info(step);

        // rechaza nuevamente los permisos
        try {
            while (elementIsDisplayed(withoutPermissionPage.getBtnRechazar())) {
                clickElement(withoutPermissionPage.getBtnRechazar());
            }
        } catch (NoSuchElementException e) {
            log.info("Permisos Rechazados");
        }

        boolean prueba = elementIsDisplayed(withoutPermissionPage.getLblWarning());
        boolean prueba2 = elementIsDisplayed(withoutPermissionPage.getLblWarning2());

        // aqui abajo debe estar el popup que arroja venchat
        assertTrue("No se visualiza el aviso", (prueba || prueba2));
    }

    public void abroChatReciente() {
        String step = "Abro un chat reciente";
        log.info(step);

        clickElement(withoutPermissionPage.getBtnLupaBusqueda());
        elementIsDisplayed(withoutPermissionPage.getBtnChatReciente());
        clickElement(withoutPermissionPage.getBtnChatReciente());
        clickElement(withoutPermissionPage.getBntCancelar());
    }

    public void envioFotoDesdeGaleria() {
        String step = "Envio una foto desde la galeria";
        log.info(step);

        clickElement(withoutPermissionPage.getBtnAdjuntar());
        clickElement(withoutPermissionPage.getBtnAdjuntarFoto());
        clickElement(withoutPermissionPage.getBtnDesdeGaleria());
    }

    public void envioVideoDesdeGaleria() {
        String step = "Envio un video desde la galeria";
        log.info(step);

        clickElement(withoutPermissionPage.getBtnAdjuntar());
        clickElement(withoutPermissionPage.getBtnAdjuntarVideo());
        clickElement(withoutPermissionPage.getBtnDesdeGaleria());
    }

    public void envioFotoDesdeCamara() {
        String step = "Envio una foto desde la camara";
        log.info(step);

        clickElement(withoutPermissionPage.getBtnAdjuntar());
        clickElement(withoutPermissionPage.getBtnAdjuntarFoto());
        clickElement(withoutPermissionPage.getBtnDesdeCamara());
    }

    public void ingresoGrupo() {
        String step = "Ingreso a un grupo";
        log.info(step);

        clickElement(withoutPermissionPage.getBtnGrupos());
        clickElement(withoutPermissionPage.getBtnLupaBusqueda());
        elementIsDisplayed(withoutPermissionPage.getVistaImageView());
        clickElement(withoutPermissionPage.getInputBusqueda());
        write(withoutPermissionPage.getInputBusqueda(), "No eliminar");

        String btngrupo = String.format(withoutPermissionPage.getElementoDeLaLista(), "No eliminar");

        clickElement(btngrupo);
        clickElement(withoutPermissionPage.getBntCancelar());
        elementIsDisplayed(withoutPermissionPage.getInputMensaje());
    }

    public void abroCamara() {
        String step = "Abro la camara";
        log.info(step);

        clickElement(withoutPermissionPage.getBtnAdjuntar());
        clickElement(withoutPermissionPage.getBtnAdjuntarFotos());
        clickElement(withoutPermissionPage.getBtnDesdeCamara());
    }

    public void validoVisualizaMensajePidiendoAccesoCamara() {
        String step = "Valido que se visualiza el mensaje pidiendo acceso a la camara";
        log.info(step);

        boolean validation =  elementIsDisplayed(withoutPermissionPage.getPreguntaAbrirCamara());

        assertTrue("No se visualiza el mensaje de solicitud apertura camara", validation);

        while (elementIsDisplayed(withoutPermissionPage.getBtnRechazar())){
            clickElement(withoutPermissionPage.getBtnRechazar());
        }
    }

    public void compartoUbicacionChat() {
        String step = "Comparto mi ubicacion por chat";
        log.info(step);

        clickElement(withoutPermissionPage.getBtnAdjuntar());
        clickElement(withoutPermissionPage.getBtnAdjuntarUbicacion());

        if (elementIsDisplayed(withoutPermissionPage.getBtnRechazar())) {
            clickElement(withoutPermissionPage.getBtnRechazar());
        }
    }

    public void validoVisualizaMensajePidiendoAccesoUbicacion() {
        String step = "Valido que se visualiza el mensaje pidiendo acceso a la ubicacion";
        log.info(step);

        boolean validation =  elementIsDisplayed(withoutPermissionPage.getPreguntaCompartirUbicacion());

        assertTrue("No se visualiza la solicitud de compartir ubicacion", validation);
    }

    public void abroAgregarParticipante() {
        String step = "Abro agregar participante";
        log.info(step);

        elementIsDisplayed(withoutPermissionPage.getBtnMenu3PuntosChat());
        clickElement(withoutPermissionPage.getBtnMenu3PuntosChat());
        clickElement(withoutPermissionPage.getBtnInfoGrupo());
        elementIsDisplayed(withoutPermissionPage.getBtnMenu3PuntosDesdeInfoGrupo());
        clickElement(withoutPermissionPage.getBtnMenu3PuntosDesdeInfoGrupo());
        clickElement(withoutPermissionPage.getBtnAgregarParticipante());
    }

    public void validoVisualizaMensajePidiendoAccesoContactos() {
        String step = "Valido que se visualiza el mensaje pidiendo acceso a los contactos";
        log.info(step);

        boolean validation =  elementIsDisplayed(withoutPermissionPage.getPreguntaAccederContactos());

        assertTrue("No se visualiza la solicitud de acceder contactos",validation);

        while (elementIsDisplayed(withoutPermissionPage.getBtnRechazar())){
            clickElement(withoutPermissionPage.getBtnRechazar());
        }
    }

    public void realizoLlamada() {
        String step = "Realizo una llamada";
        log.info(step);

        elementIsDisplayed(withoutPermissionPage.getBtnLlamada());
        clickElement(withoutPermissionPage.getBtnLlamada());
    }

    public void realizoVideoLlamada() {
        String step = "Realizo una videollamada";
        log.info(step);

        elementIsDisplayed(withoutPermissionPage.getBtnLlamada());
        clickElement(withoutPermissionPage.getBtnVideoLLamada());
    }

    public void validoVisualizaMensajePidiendoAccesoLlamadas() {
        String step = "Valido que se visualiza el mensaje pidiendo acceso a las llamadas";
        log.info(step);

        while (elementIsDisplayed(withoutPermissionPage.getBtnRechazar())){
            clickElement(withoutPermissionPage.getBtnRechazar());
        }

        boolean validation = elementIsDisplayed(withoutPermissionPage.getLblWarning());

        assertTrue("No se visualiza el mensaje de error inesperado",validation);
    }

    public void envioMensaje() {
        String step = "Envio un mensaje";
        log.info(step);

        clickElement(withoutPermissionPage.getInputMensaje());
        write(withoutPermissionPage.getInputMensaje(), "Mensaje sin permisos");
        clickElement(withoutPermissionPage.getBtnEnviar());
    }

    public void creoGrupoSinPermisos() {
        String step = "Creo un grupo sin permisos";
        log.info(step);

        clickElement(withoutPermissionPage.getBtnGrupos());
        clickElement(withoutPermissionPage.getBtn3Puntos());
        clickElement(withoutPermissionPage.getBtnNuevoGrupoDesde3Puntos());
        clickElement(withoutPermissionPage.getBtnPermitir());
        clickElement(withoutPermissionPage.getBtnChatReciente());
        clickElement(withoutPermissionPage.getBtnTerminarAgregarIntegrantes());
        clickElement(withoutPermissionPage.getBtnIngresarFotoPerfilGrupo());
        clickElement(withoutPermissionPage.getBtnDesdeCamara());
    }

    public void envioNotaDeVoz() {
        String step = "Grabo una nota de voz";
        log.info(step);

        clickAndHold(withoutPermissionPage.getBtnGrabarNota());
    }

    public void envioDocumento() {
        String step = "Envio un documento";
        log.info(step);

        clickElement(withoutPermissionPage.getBtnAdjuntar());
        clickElement(withoutPermissionPage.getBtnAdjuntarDocumento());
    }

    public void abroMiPerfil() {
        String step = "Abro mi perfil";
        log.info(step);

        clickElement(withoutPermissionPage.getBtn3Puntos());
        clickElement(withoutPermissionPage.getBtnPerfil());
    }

    public void cambioMiFotoDesdeCamara() {
        String step = "Cambio mi foto desde la camara";
        log.info(step);

        clickElement(withoutPermissionPage.getBtn3PuntosPerfil());
        clickElement(withoutPermissionPage.getBtnEditar());
        clickElement(withoutPermissionPage.getBtnCambiarFoto());
        clickElement(withoutPermissionPage.getBtnDesdeCamara());
    }

    public void cambioMiFotoDesdeGaleria() {
        String step = "Cambio mi foto desde la galeria";
        log.info(step);

        clickElement(withoutPermissionPage.getBtn3PuntosPerfil());
        clickElement(withoutPermissionPage.getBtnEditar());
        clickElement(withoutPermissionPage.getBtnCambiarFoto());
        clickElement(withoutPermissionPage.getBtnDesdeGaleria());
    }

    public void agregoAlRegistroFotoDesdeCamara() {
        String step = "Agrego al registro una foto desde la camara";
        log.info(step);

        clickElement(withoutPermissionPage.getBtnAgregarFoto());
        clickElement(withoutPermissionPage.getBtnDesdeCamara());
    }

    public void agregoAlRegistroFotoDesdeGaleria() {
        String step = "Agrego al registro una foto desde la galeria";
        log.info(step);

        clickElement(withoutPermissionPage.getBtnAgregarFoto());
        clickElement(withoutPermissionPage.getBtnDesdeGaleria());
    }
}