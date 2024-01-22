package pom.contact;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import steps.Hooks;

import static org.junit.Assert.assertEquals;

public class ContactLogic extends Hooks {

    ContactPage contactPage = new ContactPage();
    private static final Logger log = LogManager.getLogger(ContactLogic.class);

    public void buscoContactoContactos(String contacto) {
        String step = "Busco al contacto " + contacto + " en contactos";
        log.info(step);

        clickElement(contactPage.getBtnConfig());
        clickElement(contactPage.getBtnContacto());
        clickElement(contactPage.getBtnBuscarContac());
        clickElement(contactPage.getInputBuscarContac());
        write(contactPage.getInputBuscarContac(), contacto);

        aux = contacto;
    }

    public void validoEncontroContacto() {
        String step = "Valido que se encontro el contacto";
        log.info(step);

        assertEquals("No se encontro el contacto", aux + "\n" +
                "+11234567890", textFromElementAttribute(contactPage.getLbContacto()));
    }

    public void validoNoEncontroContacto() {
        String step = "Valido que no se encontro el contacto";
        log.info(step);

        assertEquals("No se muestra el mensaje de no hay contacto", "No hay contactos de VenChat",
                textFromElementAttribute(contactPage.getLbNoContacto()));
    }

    public void realizoLlamadaContacto() {
        String step = "Realizo la llamada en contacto";
        log.info(step);

        String contacto = String.format(contactPage.getLbContactoTwo(), aux);

        clickElement(contacto);
        clickElement(contactPage.getBtnLlamada());
    }

    public void realizoVideollamadaContacto() {
        String step = "Realizo la videollamada en contacto";
        log.info(step);

        String contacto = String.format(contactPage.getLbContactoTwo(), aux);

        clickElement(contacto);
        clickElement(contactPage.getBtnVideollamada());
    }
}
