package pom.group;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pom.chat.ChatPage;
import pom.register.RegisterPage;
import steps.Hooks;
import static org.junit.Assert.*;

public class GroupLogic extends Hooks {

    GroupPage groupPage = new GroupPage();
    ChatPage chatPage = new ChatPage();
    RegisterPage registerPage = new RegisterPage();
    private static final Logger log = LogManager.getLogger(GroupLogic.class);

    public void creoGrupo1Participante(String nombre, String participante) {
        String step = "Creo un grupo llamado " + nombre + " con el participante " + participante;
        log.info(step);

        clickElement(groupPage.getBtnGrupos());
        clickElement(groupPage.getBtnMenu3PuntosMain());
        clickElement(groupPage.getBtnNuevoGrupoDesde3Puntos());
        clickElement(groupPage.getBtnLupa());
        clickElement(groupPage.getInputBusqueda());
        write(groupPage.getInputBusqueda(), participante);

        String locatorParticipante = String.format(groupPage.getElementoDeLaLista(), participante);

        clickElement(locatorParticipante);
        clickElement(groupPage.getBtnTerminarAgregarIntegrantes());
        clickElement(groupPage.getEditTNombreDelGrupo());
        write(groupPage.getEditTNombreDelGrupo(), nombre);
        clickElement(groupPage.getEditTDescripcionGrupo());
        write(groupPage.getEditTDescripcionGrupo(), "Algo interesante");
        clickElement(groupPage.getBtnTerminarCrearGrupo());

        String locatorNombreGrupo = String.format(groupPage.getViewNombre(), nombre);
        boolean nombreGrupoDisplayed = elementIsDisplayed(locatorNombreGrupo);

        assertTrue("No se visualiza nombre del grupo",nombreGrupoDisplayed);
        aux=nombre;
    }

    public void validoCreacionGrupo(){
        String step = "Valido se creo el grupo";
        log.info(step);

        boolean inputMensajeDisplayed = elementIsDisplayed(groupPage.getInputMensaje());

        assertTrue("No se encuentra escribir mensaje", inputMensajeDisplayed);
    }

    public void validoInformacionIntegrantePoseeNumeroDesdeGrupo(String nombre , String numero) {
        String step = "Valido informacion de " + nombre + " que posee el numero " + numero + "desde grupo";
        log.info(step);

        String vistaIntegrante = String.format(groupPage.getElementoDeLaLista(), nombre);

        clickElement(vistaIntegrante);
        clickElement(groupPage.getBtnInformacionContacto());

        String vistaNombre = String.format(groupPage.getViewNombre(), nombre);
        String vistaNumero = String.format(groupPage.getViewNombre(), numero);
        boolean nombreDisplayed = elementIsDisplayed(vistaNombre);
        boolean numeroDisplayed = elementIsDisplayed(vistaNumero);

        assertTrue("No es visible el nombre del contacto", nombreDisplayed);
        assertTrue("No es visible el numero del contacto", numeroDisplayed);

        navigateBack();
        navigateBack();

        boolean inputMensajeDisplayed = elementIsDisplayed(groupPage.getInputMensaje());

        assertTrue("No se volvio a la pantalla de chat de grupo", inputMensajeDisplayed);
    }

    public void cambioNombreGrupo(String nuevoNombre){
        String step = "Cambio el nombre del grupo a " + nuevoNombre;
        log.info(step);

        elementIsDisplayed(groupPage.getBtnMenu3PuntosDesdeInfoGrupo());
        clickElement(groupPage.getBtnMenu3PuntosDesdeInfoGrupo());
        clickElement(groupPage.getBtnCambiarNombreDelGrupo());
        clickElement(groupPage.getEditTCambiarNombreGrupo());
        write(groupPage.getEditTCambiarNombreGrupo(),nuevoNombre);
        clickElement(groupPage.getBtnConfirmarCambioDeNombre());
    }

    public void validoCambioNombreGrupo(String nuevoNombre){
        String step = "Valido se cambio el nombre del grupo a " + nuevoNombre;
        log.info(step);

        String vistaNombre = String.format(groupPage.getViewNombre(), nuevoNombre);
        boolean nombreDisplayed = elementIsDisplayed(vistaNombre);

        assertTrue("No es visible el nombre del contacto", nombreDisplayed);

        navigateBack();
    }

    public void abroInformacionGrupo(){
        String step = "Abro informacion del grupo";
        log.info(step);

        elementIsDisplayed(groupPage.getBtnMenu3PuntosChat());
        clickElement(groupPage.getBtnMenu3PuntosChat());
        clickElement(groupPage.getBtnInfoGrupo());
    }

    public void validoAgregarContactoGrupo(String nombre) {
        String step = "Valido puedo agregar a " + nombre + " dentro del grupo";
        log.info(step);

        elementIsDisplayed(groupPage.getBtnMenu3PuntosDesdeInfoGrupo());
        clickElement(groupPage.getBtnMenu3PuntosDesdeInfoGrupo());
        clickElement(groupPage.getBtnAgregarParticipante());
        clickElement(groupPage.getBtnLupa());
        clickElement(groupPage.getInputBusqueda());
        write(groupPage.getInputBusqueda(),nombre);

        String contactoEncontrado = String.format(groupPage.getElementoDeLaLista(), nombre);

        clickElement(contactoEncontrado);
        clickElement(groupPage.getBtnTerminarAgregarParticipante());

        String vistaIntegrante = String.format(groupPage.getElementoDeLaLista(), nombre);

        boolean integranteDisplayed = elementIsDisplayed(vistaIntegrante);

        assertTrue("No se encontro " + nombre + " en el grupo", integranteDisplayed);

        navigateBack();
    }

    public void abrirArchivosgrupo(){
        String step = "Abro los archivos del grupo";
        log.info(step);

        clickElement(groupPage.getBtnMenu3PuntosChat());
        clickElement(groupPage.getBtnArchivos());

        boolean noArchivosDisplayed = elementIsDisplayed(groupPage.getNoSeHanEncontradoArchivos());

        assertTrue("No se encontro el mensaje no se han encontrado archivos", noArchivosDisplayed);

        navigateBack();
    }


    public void eliminoIntegranteGrupo(String nombre){
        String step = "Elimino a " + nombre + " del grupo";
        log.info(step);

        String vistaIntegrante = String.format(groupPage.getElementoDeLaLista(), nombre);

        clickElement(vistaIntegrante);
        clickElement(groupPage.getBtnEliminarIntegranteDelGrupo());
    }

    public void validoIntegranteNoEstaEnGrupo(String nombre){
        String step = "Valido " + nombre + " no esta en el grupo";
        log.info(step);

        String vistaIntegrante = String.format(groupPage.getElementoDeLaLista(), nombre);
        boolean integranteDisplayed = elementIsDisplayed(vistaIntegrante);

        assertFalse("Se encontro un contacto llamado " + nombre + " dentro del grupo", integranteDisplayed);

        navigateBack();
    }

    public void abroChatGrupalLLamado(String nombre){
        String step = "Abro chat grupal llamado " + nombre;
        log.info(step);

        clickElement(groupPage.getBtnGrupos());
        clickElement(groupPage.getBtnLupaBusqueda());
        elementIsDisplayed(groupPage.getVistaImageView());
        clickElement(groupPage.getInputBusqueda());
        write(groupPage.getInputBusqueda(), nombre);

        String btngrupo = String.format(groupPage.getElementoDeLaLista(), nombre);

        clickElement(btngrupo);
    }

    public void validoNoPuedoAgregarParticipanteSinSerAdministrador(){
        String step = "Valido no puedo agregar una persona a un grupo sin ser administrador";
        log.info(step);

        clickElement(groupPage.getBtnMenu3PuntosDesdeInfoGrupo());

        boolean agregarParticipanteDisplayed = elementIsDisplayed(groupPage.getBtnAgregarParticipante());

        assertFalse("El boton agregar participante esta visible", agregarParticipanteDisplayed);

        navigateBack();
    }

    public void validoNoPuedoEliminarIntegranteNoSiendoAdministrador(String nombre){
        String step = "Valido no puedo eliminar a " + nombre + " del grupo sin ser administrador";
        log.info(step);

        String contacto = String.format(groupPage.getElementoDeLaLista(), nombre);

        swipe(0.50,0.90,0.50,0.30);
        elementIsDisplayed(contacto);
        clickElement(contacto);

        boolean btnEliminarIntegranteDisplayed = elementIsDisplayed(groupPage.getBtnEliminarIntegranteDelGrupo());

        assertFalse("El boton eliminar participante es visible", btnEliminarIntegranteDisplayed);

        navigateBack();
        navigateBack();
    }

    public void eliminoGrupoLlamado(String nombre){
        String step = "Elimino el grupo llamado: " + nombre;
        log.info(step);

        hideKeyboard();

        navigateBack();

        clickElement(groupPage.getBtnGrupos());

        String grupo = String.format(groupPage.getElementoDeLaLista(), nombre);

        elementIsDisplayed(grupo);
        clickAndHold(grupo);
        elementIsDisplayed(groupPage.getBtnEliminarGrupo());
        clickElement(groupPage.getBtnEliminarGrupo());

        if(elementIsDisplayed(groupPage.getCboxEliminarElGrupoParaTodos())){
            clickElement(groupPage.getCboxEliminarElGrupoParaTodos());
            clickElement(groupPage.getBtnConfirmarEliminarGrupo());
        }else{
            clickElement(groupPage.getBtnEliminarGrupoUnicoIntegrante());
        }
    }

    public void validoNoExisteGrupoLlamado(String nombre){
        String step = "Valido que no existe un grupo llamado " + nombre;
        log.info(step);

        clickElement(groupPage.getBtnGrupos());
        clickElement(groupPage.getBtnLupaBusqueda());
        elementIsDisplayed(groupPage.getVistaImageView());
        clickElement(groupPage.getInputBusqueda());
        write(groupPage.getInputBusqueda(), nombre);

        String grupoBuscado = String.format(groupPage.getElementoDeLaLista(), nombre);
        boolean grupoDisplayed = elementIsDisplayed(grupoBuscado);

        assertFalse("Se encontro un grupo llamado "+nombre, grupoDisplayed);
    }

    public void agregaContactoBloqueado(String contactoBloqueado){
        String step = "intenta agregar un nuevo integrante al grupo que esta bloqueado";
        log.info(step);

        clickElement(groupPage.getBtnMenu3PuntosDesdeInfoGrupo());
        clickElement(groupPage.getBtnAgregarParticipante());
        clickElement(groupPage.getBtnLupa());
        clickElement(groupPage.getInputBusqueda());
        write(groupPage.getInputBusqueda(),contactoBloqueado);

        String contactoEncontrado = String.format(groupPage.getElementoDeLaLista(), contactoBloqueado);

        elementIsDisplayed(contactoEncontrado);
        clickElement(contactoEncontrado);

        boolean contactoBloqueadoDisplayed = elementIsDisplayed(groupPage.getLbNoagregarContactoBloqueado());

        assertTrue("El contacto seleccionado no esta bloqueado y se puede agregar al grupo", contactoBloqueadoDisplayed);

        navigateBack();
        navigateBack();
        navigateBack();
    }

    public void validoPuedoAbandonarGrupoPoseeDosAdministradores(String nombre){
        String step = "Valido que puedo abandonar el grupo que posee dos administradores";
        log.info(step);

        navigateBack();
        navigateBack();

        clickElement(groupPage.getBtnGrupos());

        String grupo = String.format(groupPage.getElementoDeLaLista(), nombre);

        elementIsDisplayed(grupo);
        clickAndHold(grupo);
        elementIsDisplayed(groupPage.getBtnEliminarGrupo());
        clickElement(groupPage.getBtnEliminarGrupo());

        boolean eliminarGrupoDisplayed = elementIsDisplayed(groupPage.getBtnConfirmarEliminarGrupo());

        assertTrue("No se visualiza el boton eliminar grupo" , eliminarGrupoDisplayed);
    }

    public void validoNoPuedoAbandonarElGrupoDondeSoyUnicoAdministradorSinAgregarOtroAdministrador(String nombre) {
        String step = "Valido no puedo abandonar el grupo " + nombre + " donde soy unico administrador sin agregar otro administrador";
        log.info(step);

        clickElement(groupPage.getBtnMenu3PuntosChat());
        elementIsDisplayed(groupPage.getBtnInfoGrupo());
        elementIsDisplayed(groupPage.getBtnArchivos());

        navigateBack();
        navigateBack();

        String grupo = String.format(groupPage.getElementoDeLaLista(), nombre);

        clickElement(groupPage.getBtnGrupos());
        clickAndHold(grupo);
        elementIsDisplayed(groupPage.getBtnEliminarGrupo());
        clickElement(groupPage.getBtnEliminarGrupo());

        boolean unicoAdminDisplayed = elementIsDisplayed(groupPage.getLbmensajeUnicoAdmin());
        boolean infoGrupoEliminarDisplayed = elementIsDisplayed(groupPage.getBtnInfoGrupoEliminar());

        assertTrue("No se muestra el mensaje de unico admin", unicoAdminDisplayed);
        assertTrue("No se muestra el boton informacion de grupo", infoGrupoEliminarDisplayed);
    }

    public void buscarChatGrupo(String nombre){
        String step = "Busca el chat grupal de pruebas " + nombre;
        log.info(step);

        clickElement(groupPage.getBtnGrupos());
        clickElement(groupPage.getBtnLupaBusqueda());
        clickElement(groupPage.getInputBusqueda());
        write(groupPage.getInputBusqueda(), nombre);
    }

    public void creoNuevoGrupoLlamadoIntregrantes(String nombre, String participante1, String participante2 ){
        String step = "Creo un nuevo grupo llamado " + nombre + " con los integrantes " + participante1 + " y " + participante2;
        log.info(step);

        clickElement(groupPage.getBtnGrupos());
        clickElement(groupPage.getBtnMenu3PuntosMain());
        clickElement(groupPage.getBtnNuevoGrupoDesde3Puntos());
        clickElement(groupPage.getBtnLupa());
        clickElement(groupPage.getInputBusqueda());
        write(groupPage.getInputBusqueda(), participante1);

        String contactoParticipante1 = String.format(groupPage.getElementoDeLaLista(), participante1);

        clickElement(contactoParticipante1);

        String contactoParticipante2 = String.format(groupPage.getElementoDeLaLista(), participante2);

        clickElement(groupPage.getBtnLimpiarBusqueda());
        clickElement(groupPage.getInputBusqueda());
        write(groupPage.getInputBusqueda(), participante2);

        elementIsDisplayed(contactoParticipante2);
        clickElement(contactoParticipante2);

        elementIsDisplayed(groupPage.getBtnTerminarAgregarIntegrantes());
        clickElement(groupPage.getBtnTerminarAgregarIntegrantes());
        clickElement(groupPage.getEditTNombreDelGrupo());
        write(groupPage.getEditTNombreDelGrupo(),nombre);
        clickElement(groupPage.getEditTDescripcionGrupo());
        write(groupPage.getEditTDescripcionGrupo(),"Algo interesante");
        clickElement(groupPage.getBtnTerminarCrearGrupo());
    }

    public void hagoIntegranteAdministradorGrupo(String nombre){
        String step = "Hago al integrante " + nombre + " administrador";
        log.info(step);

        String contactoNuevoAdmin = String.format(groupPage.getElementoDeLaLista(), nombre);

        clickElement(contactoNuevoAdmin);
        clickElement(groupPage.getBtnHacerAdministradorGrupo());
    }

    public void validoHay2AdministradoresGrupo(){
        String step = "Valido hay 2 administradores en el grupo";
        log.info(step);

        String administradores = String.format(groupPage.getVistaVariosAdministradores(), "2");
        boolean administradoresDisplayed = elementIsDisplayed(administradores);

        assertTrue("No hay 2 administradores en el grupo", administradoresDisplayed);

        navigateBack();
    }

    public void creoNuevoGrupo(String asunto) {
        String step = "Creo el nuevo grupo " + asunto;
        log.info(step);

        clickElement(groupPage.getBtnGrupo());
        clickElement(groupPage.getBtnNuevoGrupo());
        clickElement(groupPage.getLbContacto());
        clickElement(groupPage.getBtnSigNuevoGrupo());
        clickElement(groupPage.getBtnImgCamara());
        clickElement(groupPage.getBtnGaleria());

        if(elementIsDisplayed(chatPage.getBtn3PuntosMasOpciones())) {
            clickElement(chatPage.getBtn3PuntosMasOpciones());
            if(elementIsDisplayed(chatPage.getBtn3PuntosExplorar())){
                clickElement(chatPage.getBtn3PuntosExplorar());
            }else {
                navigateBack();
            }
        }
        loadFile("src/main/resources/files/1.jpg", "/storage/emulated/0/1.jpg");
        clickElement(chatPage.getBtnPrimerArchivo());
      /*  clickElement(groupPage.getBtnGaleriaTwo());
        clickElement(groupPage.getBtnImagen());*/
        clickElement(registerPage.getBtnConfirmFoto());
        clickElement(groupPage.getInputAsunto());
        write(groupPage.getInputAsunto(), asunto);
        clickElement(groupPage.getInputDescripsion());
        write(groupPage.getInputDescripsion(), "QA automation");
        clickElement(groupPage.getBtnFinalizar());

        aux = asunto;
    }

    public void creoNuevoGrupoSinAsunto() {
        String step = "Creo un nuevo grupo sin asunto";
        log.info(step);

        clickElement(groupPage.getBtnGrupo());
        clickElement(groupPage.getBtnNuevoGrupo());
        clickElement(groupPage.getLbContacto());
        clickElement(groupPage.getBtnSigNuevoGrupo());
        clickElement(groupPage.getBtnFinalizar());
    }

    public void validoNoIngresoAsunto() {
        String step = "Valido que no se ingreso el asunto";
        log.info(step);

        assertEquals("No se visualiza el popup que pide agregar el asunto", "Añada asunto al grupo",
                textFromElementAttribute(groupPage.getLbAgregarAsunto()));
    }

    public void validoEliminoGrupo() {
        String step = "Valido que se elimino el grupo";
        log.info(step);

        String eliminarGrupo = String.format(groupPage.getLbGrupo(), aux);

        assertFalse("Se encuentra el grupo", elementIsDisplayed(eliminarGrupo));
    }

    public void salirEliminarGrupoMi() {
        String step = "Salir y eliminar el grupo para mi";
        log.info(step);

        elementIsDisplayed(groupPage.getLbAsunto());
        navigateBack();
        clickElement(groupPage.getBtnGrupo());
        touchAndHolElement(groupPage.getLbEquipoCalidad());
        clickElement(groupPage.getBtnBorrarGrupo());
        clickElement(groupPage.getBtnInfGrupo());
        clickElement(groupPage.getBtnParticipante());
        clickElement(groupPage.getBtnAdminGrupo());
        navigateBack();
        clickElement(groupPage.getBtnBorrarGrupo());
        clickElement(groupPage.getBtnEliminarGrupoTwo());
    }

    public void modificoDescripcionGrupo(String descripcion) {
        String step = "Modifico la descripcion del grupo a " + descripcion;
        log.info(step);

        clickElement(groupPage.getBtnGrupo());
        touchAndHolElement(groupPage.getBtnPruebaManual());
        clickElement(groupPage.getBtnBorrarGrupo());
        clickElement(groupPage.getBtnInfGrupo());
        clickElement(groupPage.getBtnAnadeDescrip());
        clickElement(groupPage.getInputGrupo());
        clearElement(groupPage.getInputGrupo());
        writeKeyboard(descripcion);
        clickElement(groupPage.getBtnConfirmar());

        aux = descripcion;
    }

    public void validoModificoDescripcionGrupo() {
        String step = "Valido que se modifico la descripcion del grupo";
        log.info(step);

        assertEquals("No se modifico la descripcion de grupo", aux,
                textFromElementAttribute(groupPage.getBtnAnadeDescrip()));

        clickElement(groupPage.getBtnAnadeDescrip());
        clickElement(groupPage.getInputGrupo());
        clearElement(groupPage.getInputGrupo());
        writeKeyboard("Prueba de descripcion");
        clickElement(groupPage.getBtnConfirmar());
    }

    public void eliminoNuevoGrupoTodosSwipe() {
        String step = "Elimino el nuevo grupo para todos usando swipe";
        log.info(step);

        elementIsDisplayed(groupPage.getLbAsunto());
        navigateBack();
        clickElement(groupPage.getBtnGrupo());
        clickElement(groupPage.getBtnGrupo());
        swipe(0.5,0.20, 0.3, 0.20);
        clickElement(groupPage.getBtnEliminar());
        clickElement(groupPage.getCheckBoxEliminarGrupo());
        clickElement(groupPage.getBtnEliminarGrupoTwo());
    }
}