package co.com.asesoftware.prueba.stepdefinitions;

import co.com.asesoftware.prueba.exceptions.InformacionNoEncontrada;
import co.com.asesoftware.prueba.models.DataExcel;
import co.com.asesoftware.prueba.models.Respuesta;
import co.com.asesoftware.prueba.questions.MensajeRespuesta;
import co.com.asesoftware.prueba.tasks.Finaliza;
import co.com.asesoftware.prueba.tasks.Login;
import co.com.asesoftware.prueba.tasks.Logueo;
import co.com.asesoftware.prueba.tasks.ObtenerData;
import co.com.asesoftware.prueba.utils.Conversion;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Shared;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;

import static co.com.asesoftware.prueba.enums.Resourses.ELEMENTO_ENCONTRADO;
import static co.com.asesoftware.prueba.enums.Resourses.USER;
import static co.com.asesoftware.prueba.exceptions.InformacionNoEncontrada.MENSAJE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class LoginSteps {

    @Managed(driver = "firefox")
    WebDriver herBrowser;
    Actor user = Actor.named(USER.getResourses());

    @Shared
    Respuesta respuestaHome;
    @Shared
    DataExcel dataExcel;
    @Dado("El usuario ingresa a la pagina")
    public void ElUsuarioIngresaALaPagina(){
        user.can(BrowseTheWeb.with(herBrowser));
        }

    @Cuando("el usuario diligencia los campos necesario {int}")
    public void elUsuarioDiligenciaLosCamposNecesarioIdPrueba(Integer IdPrueba) {
        user.attemptsTo(ObtenerData.deUsuario(IdPrueba));
        user.attemptsTo(Login.deUsuario(Conversion.usuario(dataExcel),herBrowser));
        user.attemptsTo(Logueo.exitoso(herBrowser));
    }

    @Entonces("se valida que haya un logueo exitoso")
    public void seValidaQueHayaUnLogueoExitoso() {
        user.should(seeThat(MensajeRespuesta.es(respuestaHome.getLogueoExitoso()), Matchers.equalTo(ELEMENTO_ENCONTRADO.getResourses()))
                .orComplainWith(InformacionNoEncontrada.class,MENSAJE));
    }

    @Y("despues de loguearse cierra la sesion")
    public void despuesDeLoguearseCierraLaSesion() {
        user.attemptsTo(Finaliza.sesion(herBrowser));
    }

}
