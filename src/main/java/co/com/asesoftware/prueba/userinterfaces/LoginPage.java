package co.com.asesoftware.prueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    public static final Target CAMPO_CORREO_ELECTRONICO = Target.the("Type correo electronico").located(By.xpath("//*[@id=\"mat-input-3\"]"));
    public static final Target CAMPO_CONTRASENA = Target.the("Type contrasena").located(By.xpath("//*[@id=\"mat-input-4\"]"));
    public static final Target BOTON_INICIO_SESION = Target.the("Boton inicio de sesion").located(By.xpath("//button//span[contains(.,'Iniciar sesión')]"));




}
