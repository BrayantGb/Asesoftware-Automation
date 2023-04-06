package co.com.asesoftware.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Finaliza implements Task {

    private WebDriver webDriver;

    public Finaliza(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        webDriver.findElement(By.xpath("/html/body/app-root/app-home/section[1]/lib-cc-header/header/div/nav[2]/button/div/a/div")).click();
        webDriver.findElement(By.xpath("//p//a[contains(.,'Cerrar sesión')]")).click();
    }

    public static Finaliza sesion(WebDriver webDriver){return Tasks.instrumented(Finaliza.class, webDriver);
    }

}
