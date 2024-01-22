package pom.login;

import lombok.Getter;

@Getter
public class LoginPage {

    private final String btnIniciarSesion = "//android.widget.Button[contains(@content-desc,'Iniciar sesión')]";
    private final String btnPais = "//*/android.widget.ImageView";
    private final String inputPais = "//*/android.view.View[1]/android.view.View/android.view.View/android.widget.EditText";
    private final String btnNumero = "//android.widget.Button[@content-desc='%c']";
    private final String btnContinuar = "//android.widget.Button[@content-desc='Continuar']";
    private final String lbPantallaOTP = "//android.view.View[@content-desc='Introduzca el código de 6 dígitos enviado por SMS']";
    private final String lbIngCodigo = "//android.view.View[@content-desc='Introduzca el código de 6 dígitos enviado por SMS']";
    private final String iconVen = "//*/android.view.View/android.widget.ImageView[1]";
    private final String lbNumIncorrecto = "//android.view.View[@content-desc='No existe una cuenta registrada con este número de teléfono.']";
    private final String lbNoNumero = "//android.widget.ImageView[@content-desc='Introduzca un número de teléfono y seleccione su país para continuar']";
    private final String lbNumIncompleto = "//android.view.View[@content-desc='No existe una cuenta registrada con este número de teléfono.']";
    private final String lbCodIncorrecto = "//android.view.View[@content-desc='El código de 6 digitos es incorrecto, intentelo de nuevo']";
    private final String lbNoCodigo = "//android.widget.ImageView[@content-desc='Introduzca el código de 6 dígitos enviado por SMS']";
    private final String btnCerrarSesion = "//android.view.View[@content-desc='Cerrar sesión']";

}