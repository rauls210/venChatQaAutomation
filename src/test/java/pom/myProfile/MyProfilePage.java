package pom.myProfile;

import lombok.Getter;

@Getter
public class MyProfilePage {

    private final String btnTresPuntos = "//android.view.View[contains(@content-desc,'+12234567890')]/android.widget.ImageView";
    private final String lbMiPerfil = "//android.view.View[@content-desc='Mi perfil']";
    private final String lbNumTelefono = "//android.view.View[@content-desc='+12234567890']";
    private final String lbMiNombre = "//android.view.View[@content-desc='No eliminar']";
    private final String btnTresPuntosTwo = "//android.widget.ImageView[@index='2']";
    private final String inputNombre = "//android.widget.EditText";
    private final String btnGuardar = "//android.view.View[@content-desc='Guardar']";
    private final String lbNuevoNombre = "//android.view.View[@content-desc='Cambio el nombre']";
    private final String btnFoto = "//*/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.widget.ImageView";
    private final String btnFotoPerfil = "//android.widget.Button";

}