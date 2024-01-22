package pom.register;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pom.login.LoginPage;
import steps.Hooks;

import static org.junit.Assert.assertTrue;

public class RegisterLogic extends Hooks {

    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    private static final Logger log = LogManager.getLogger(RegisterLogic.class);

    public void registroAppVenChat() {
        String step = "Registro en app de venChat";
        log.info(step);

        clickElement(registerPage.getBtnRegistro());
    }

    public void completoPerfil() {
        String step = "Completo mi perfil";
        log.info(step);

        clickElement(registerPage.getBtnImg());
        clickElement(registerPage.getBtnCamara());
        clickElement(registerPage.getBtnCamaraShot());
        clickElement(registerPage.getBtnConfirmFoto());
        clickElement(registerPage.getInputNombre());
        writeKeyboard("Raul Vlz");
        clickElement(registerPage.getInputDescrip());
        writeKeyboard("Automatizacion");
        hideKeyboard();
        //clickElement(registerPage.getCheckboxTyC());
        touchAndHold(0.15, 0.66);
        clickElement(loginPage.getBtnContinuar());
    }

    public void validoRegistroExitosa() {
        String step = "Valido que me registro de forma exitosa";
        log.info(step);

        assertTrue("No se visualiza el icono de Chats",
                elementIsDisplayed(loginPage.getIconVen()));
    }

    public void eliminoRegistro() {
        String step = "Elimino el registro";
        log.info(step);

        deleteRegister();
    }

    public void ingresoNumeroTelefonoRegistrado(String numero) {
        String step = "Ingreso un numero de telefono " + numero + " ya registrado";
        log.info(step);

        clickElement(loginPage.getBtnPais());
        clickElement(loginPage.getInputPais());
        write(loginPage.getInputPais(), "República Dominicana");
        clickElement(loginPage.getBtnPais());

        char[] aCaracteres = numero.toCharArray();

        for (char c : aCaracteres) {
            String locator = String.format("//android.widget.Button[@content-desc='%c']", c);
            clickElement(locator);
        }

        clickElement(loginPage.getBtnContinuar());
    }

    public void validoRegistroNumeroExiste() {
        String step = "Valido que ya esta registrado el numero de telefono";
        log.info(step);

        assertTrue("No se visualiza el popup de existe cuenta con el numero registrado",
                elementIsDisplayed(registerPage.getLbExisteRegNum()));
    }

    public void validoAceptarTerminosCondiciones() {
        String step = "Valido que me pida aceptar los terminos y condiciones";
        log.info(step);

        clickElement(registerPage.getInputNombre());
        writeKeyboard("Raul Vlz");
        clickElement(registerPage.getInputDescrip());
        writeKeyboard("Automatizacion");
        hideKeyboard();
        clickElement(loginPage.getBtnContinuar());

        assertTrue("No se visualiza el popup de acepte los terminos de uso",
                elementIsDisplayed(registerPage.getLbAceptaTyC()));
    }

    public void noIngresoNombre() {
        String step = "No ingreso el nombre";
        log.info(step);

        clickElement(registerPage.getInputNombre());
        clickElement(registerPage.getInputDescrip());
        writeKeyboard("Automatizacion");
        hideKeyboard();
        //clickElement(registerPage.getCheckboxTyC());
        touchAndHold(0.15, 0.66);
        clickElement(loginPage.getBtnContinuar());
    }

    public void validoNoIngresoNombre() {
        String step = "Valido que no se ingreso el nombre";
        log.info(step);

        assertTrue("No se visualiza el popup de ingresar nombre y apellido",
                elementIsDisplayed(registerPage.getLbNombre()));
    }

    public void noIngresoDescripcion() {
        String step = "No ingreso la descripcion";
        log.info(step);

        clickElement(registerPage.getInputNombre());
        writeKeyboard("Raul Vlz");
        hideKeyboard();
        //clickElement(registerPage.getCheckboxTyC());
        touchAndHold(0.15, 0.66);
        clickElement(loginPage.getBtnContinuar());
    }

    public void validoNoIngresoDescripcion() {
        String step = "Valido que no se ingreso la descripcion";
        log.info(step);

        assertTrue("No se visualiza el popup de ingreso descripcion",
                elementIsDisplayed(registerPage.getLbDescripcion()));
    }
}
