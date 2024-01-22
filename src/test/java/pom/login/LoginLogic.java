package pom.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pom.group.GroupPage;
import steps.Hooks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginLogic extends Hooks {

    LoginPage loginPage = new LoginPage();
    GroupPage groupPage = new GroupPage();
    private static final Logger log = LogManager.getLogger(LoginLogic.class);

    public void inicioAppVenChat() {
        String step = "Inicio sesion en app de venChat";
        log.info(step);

        clickElement(loginPage.getBtnIniciarSesion());
    }

    public void ingresoNumero(String numero) {
        String step = "Ingreso el numero de telefono " + numero;
        log.info(step);

        clickElement(loginPage.getBtnPais());
        clickElement(loginPage.getInputPais());
        write(loginPage.getInputPais(), "República Dominicana");
        clickElement(loginPage.getBtnPais());

        char[] aCaracteres = numero.toCharArray();

        for (char c : aCaracteres) {
            String locator = String.format(loginPage.getBtnNumero(), c);
            clickElement(locator);
        }

        clickElement(loginPage.getBtnContinuar());
    }

    public void ingresoCodigo(String codigo) {
        String step = "Ingreso el codigo " + codigo;
        log.info(step);

        elementIsDisplayed(loginPage.getLbIngCodigo());

        char[] aCaracteres = codigo.toCharArray();

        for (char c : aCaracteres) {
            String locator = String.format(loginPage.getBtnNumero(), c);
            clickElement(locator);
        }

        clickElement(loginPage.getBtnContinuar());
    }

    public void validoLogueoExitoso() {
        String step = "Valido que me logueo de forma exitosa";
        log.info(step);

        assertTrue("No se visualiza el icono de Chats",
                            elementIsDisplayed(loginPage.getIconVen()));
    }

    public void validoNumeroNoRegistrado() {
        String step = "Valido que el numero de telefono no esta registrado";
        log.info(step);

        assertEquals("Los elemento no coinciden", "No existe una cuenta registrada con este número de teléfono.",
                textFromElementAttribute(loginPage.getLbNumIncorrecto()));
    }

    public void noIngresoNumero() {
        String step = "No ingreso el numero de telefono";
        log.info(step);

        clickElement(loginPage.getBtnContinuar());
    }

    public void validoNoIngresoNumero() {
        String step = "Valido que no se ingreso un numero de telefono";
        log.info(step);

        assertEquals("Los elemento no coinciden", "Introduzca un número de teléfono y seleccione su país para continuar",
                textFromElementAttribute(loginPage.getLbNoNumero()));
    }

    public void validoNumeroIncompleto() {
        String step = "Valido que el numero de telefono esta incompleto";
        log.info(step);

        assertEquals("Los elemento no coinciden", "No existe una cuenta registrada con este número de teléfono.",
                textFromElementAttribute(loginPage.getLbNumIncompleto()));
    }

    public void validoCodigoIncorrecto() {
        String step = "Valido que el codigo es incorrecta";
        log.info(step);

        assertEquals("Los elemento no coinciden", "El código de 6 digitos es incorrecto, intentelo de nuevo",
                textFromElementAttribute(loginPage.getLbCodIncorrecto()));
    }

    public void noIngresoCodigo() {
        String step = "No ingreso el codigo";
        log.info(step);

        elementIsDisplayed(loginPage.getLbPantallaOTP());
        clickElement(loginPage.getBtnContinuar());
    }

    public void validoNoIngresoCodigo() {
        String step = "Valido que no se ingreso el codigo";
        log.info(step);

        assertEquals("Los elemento no coinciden", "Introduzca el código de 6 dígitos enviado por SMS",
                textFromElementAttribute(loginPage.getLbNoCodigo()));
    }

    public void validoCodigoIncompleto() {
        String step = "Valido que el codigo esta incompleto";
        log.info(step);

        assertEquals("Los elemento no coinciden", "Introduzca el código de 6 dígitos enviado por SMS",
                textFromElementAttribute(loginPage.getLbNoCodigo()));
    }

    public void validoCerroSesion() {
        String step = "Valido que se cerro la sesion";
        log.info(step);

        clickElement(groupPage.getBtnBorrarGrupo());
        clickElement(loginPage.getBtnCerrarSesion());

        assertTrue("No se visualiza el boton iniciar sesion",
                elementIsDisplayed(loginPage.getBtnIniciarSesion()));
    }
}
