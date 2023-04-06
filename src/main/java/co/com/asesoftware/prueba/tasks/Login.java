package co.com.asesoftware.prueba.tasks;

import co.com.asesoftware.prueba.interactions.Click;
import co.com.asesoftware.prueba.interactions.Type;
import co.com.asesoftware.prueba.interactions.WaitElement;
import co.com.asesoftware.prueba.models.DatosLogin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static co.com.asesoftware.prueba.userinterfaces.LoginPage.*;

public class Login implements Task {

    private DatosLogin datosLogin;
    private WebDriver webDriver;

    public Login(DatosLogin datosLogin,WebDriver webDriver){
        this.datosLogin = datosLogin;
        this.webDriver = webDriver;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        webDriver.findElement(By.xpath("//button[contains(.,'Cerrar')]")).click();
        webDriver.findElement(By.xpath("//a//span[contains(.,'Ingresar')]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"mat-input-3\"]")).click();
        actor.attemptsTo(
                Type.on(CAMPO_CORREO_ELECTRONICO, datosLogin.getCorreoElectronico()),
                WaitElement.visible(CAMPO_CONTRASENA),
                Type.on(CAMPO_CONTRASENA, datosLogin.getContrasena()),
                WaitElement.visible(BOTON_INICIO_SESION)
        );
        webDriver.findElement(By.xpath("//button//span[contains(.,'Iniciar sesión')]")).click();
    }

    public static Login deUsuario(DatosLogin datosLogin,WebDriver webDriver){return Tasks.instrumented(Login.class, datosLogin, webDriver);
    }

}
