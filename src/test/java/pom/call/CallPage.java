package pom.call;

import lombok.Getter;

@Getter
public class CallPage {

    private final String btnLlamadas = "//*[contains(@content-desc,'Llamadas')]";
    private final String btnLlamada = "//*/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[3]";
    private final String btnLlamadaContacto = "(//android.widget.ImageView[@index='1'])[1]";
    private final String lbLlamando = "//android.widget.ImageView[contains(@content-desc, 'Llamando')]";
    private final String btnVideollamada = "//android.widget.ImageView[@index='2']";

}