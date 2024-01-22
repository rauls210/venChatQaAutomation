package pom.call;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pom.contact.ContactPage;
import steps.Hooks;

import static org.junit.Assert.*;

public class CallLogic extends Hooks {

    CallPage callPage = new CallPage();
    ContactPage contactPage = new ContactPage();
    private static final Logger log = LogManager.getLogger(CallLogic.class);

    public void buscoContactoNuevaLlamada(String contacto) {
        String step = "Busco al contacto " + contacto + " en nueva llamada";
        log.info(step);

        clickElement(callPage.getBtnLlamadas());
        clickElement(callPage.getBtnLlamada());
        clickElement(contactPage.getBtnBuscarContac());
        clickElement(contactPage.getInputBuscarContac());
        write(contactPage.getInputBuscarContac(), contacto);

        aux = contacto;
    }

    public void realizoLlamadaNuevaLlamada() {
        String step = "Realizo la llamada en nueva llamada";
        log.info(step);

        clickElement(callPage.getBtnLlamadaContacto());
    }

    public void validoRealizoLlamada() {
        String step = "Valido que se realizo la llamada";
        log.info(step);

        String llamada = textFromElementAttribute(callPage.getLbLlamando());

        assertTrue("No se realizo la llamada al contacto " + aux, llamada.contains(aux));
    }

    public void realizoVideollamadaNuevaLlamada() {
        String step = "Realizo la videollamada en nueva llamada";
        log.info(step);

        clickElement(callPage.getBtnVideollamada());
    }

    public void validoRealizoVideollamada() {
        String step = "Valido que se realizo la videollamada";
        log.info(step);

        String videollamada = textFromElementAttribute(callPage.getLbLlamando());

        assertTrue("No se realizo la videollamada al contacto " + aux, videollamada.contains(aux));
    }
}