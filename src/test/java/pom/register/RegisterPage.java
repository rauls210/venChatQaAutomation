package pom.register;

import lombok.Getter;

@Getter
public class RegisterPage {

    private final String btnRegistro = "//android.widget.Button[@content-desc='Regístrate']";
    private final String btnImg = "(//*/android.view.View)[7]";
    private final String btnCamara = "//android.view.View[@content-desc='Cámara']";
    private final String btnCamaraShot = "(//android.widget.Button)[2]";
    private final String btnConfirmFoto = "//android.widget.Button[@content-desc='Crop']";
    private final String inputNombre = "//*/android.view.View/android.view.View[2]/android.widget.EditText[1]";
    private final String inputDescrip = "//*/android.view.View/android.widget.ScrollView/android.widget.EditText[2]";
    private final String checkboxTyC = "//android.widget.CheckBox";
    private final String btnContinuar = "//android.widget.Button[@content-desc='Continuar']";
    private final String lbExisteRegNum = "//android.view.View[@content-desc='Ya existe una cuenta registrada con este número de teléfono.']";
    private final String lbAceptaTyC = "//android.widget.ImageView[@content-desc='Acepte los términos de uso']";
    private final String lbNombre = "//android.view.View[@content-desc='Escribe al menos un nombre y un apellido. Deben tener mínimo dos caracteres cada uno, sin números o caracteres especiales.']";
    private final String lbDescripcion = "//android.view.View[@content-desc='Escribe una descripción.']";

}