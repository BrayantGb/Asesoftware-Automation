package co.com.asesoftware.prueba.tasks;

import co.com.asesoftware.prueba.models.Respuesta;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Shared;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logueo implements Task {

    @Shared
    Respuesta respuestaHome;

    private WebDriver webDriver;

    public Logueo(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String respuesta = webDriver.findElement(By.xpath("//h1[contains(.,' Estos son algunos inmuebles sugeridos para ti ')]")).getText();
        respuestaHome.setLogueoExitoso(respuesta);
    }

    public static Logueo exitoso(WebDriver webDriver){return Tasks.instrumented(Logueo.class, webDriver);
    }
}
