package pom.contact;

import lombok.Getter;

@Getter
public class ContactPage {

    private final String btnConfig = "//*/android.view.View/android.view.View/android.view.View/android.widget.ImageView[3]";
    private final String btnContacto = "//android.widget.ImageView[@content-desc='Contactos']";
    private final String btnBuscarContac = "//*/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView";
    private final String inputBuscarContac = "//*/android.view.View/android.view.View/android.view.View/android.widget.EditText";
    private final String lbContacto = "//android.widget.ImageView[@index='0']";
    private final String lbNoContacto = "//android.view.View[@content-desc='No hay contactos de VenChat']";
    private final String lbContactoTwo = "//android.widget.ImageView[contains(@content-desc,'%1$s')]";
    private final String btnLlamada = "//*/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]";
    private final String btnVideollamada = "//*/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]";

}