package pom.myProfile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pom.contact.ContactPage;
import steps.Hooks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyProfileLogic extends Hooks {

    MyProfilePage myProfilePage = new MyProfilePage();
    ContactPage contactPage = new ContactPage();
    private static final Logger log = LogManager.getLogger(MyProfileLogic.class);

    public void ingresoMiPerfil() {
        String step = "Ingreso a mi perfil";
        log.info(step);

        clickElement(contactPage.getBtnConfig());
        clickElement(myProfilePage.getBtnTresPuntos());
    }

    public void validoEstoyMiPerfil() {
        String step = "Valido que estoy en mi perfil";
        log.info(step);

        assertTrue("No estoy en la pantalla mi perfil",
                elementIsDisplayed(myProfilePage.getLbMiPerfil()));
        assertEquals("Los elemento no coinciden", "+12234567890",
                textFromElementAttribute(myProfilePage.getLbNumTelefono()));
    }

    public void modificoNombreMiPerfil(String nombre) {
        String step = "Modifico el nombre de mi perfil " + nombre;
        log.info(step);

        clickElement(contactPage.getBtnConfig());
        clickElement(myProfilePage.getBtnTresPuntos());

        String miNombre = textFromElementAttribute(myProfilePage.getLbMiNombre());

        clickElement(myProfilePage.getBtnTresPuntosTwo());
        touchAndHold(0.6,0.1);
        clickElement(myProfilePage.getInputNombre());
        write(myProfilePage.getInputNombre(), nombre);
        clickElement(myProfilePage.getBtnGuardar());

        aux = nombre;
        auxTwo = miNombre;
    }

    public void validoEditoNombreMiPerfil() {
        String step = "Valido que se edito el nombre de mi perfil";
        log.info(step);

        assertEquals("No se modifico el nombre", aux,
                textFromElementAttribute(myProfilePage.getLbNuevoNombre()));

        clickElement(myProfilePage.getBtnTresPuntosTwo());
        touchAndHold(0.6,0.1);
        clickElement(myProfilePage.getInputNombre());
        write(myProfilePage.getInputNombre(), auxTwo);
        clickElement(myProfilePage.getBtnGuardar());
    }

    public void validoVisualizaFotoPerfil() {
        String step = "Valido que se visualiza la foto de perfil";
        log.info(step);

        clickElement(myProfilePage.getBtnFoto());

        assertTrue("No estoy la foto de mi perfil",
                elementIsDisplayed(myProfilePage.getBtnFotoPerfil()));
    }
}
