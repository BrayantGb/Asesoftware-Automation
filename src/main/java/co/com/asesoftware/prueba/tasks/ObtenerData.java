package co.com.asesoftware.prueba.tasks;

import co.com.asesoftware.prueba.models.DataExcel;
import co.com.asesoftware.prueba.utils.EnviarData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Shared;

public class ObtenerData implements Task {
    @Shared
    DataExcel dataExcel;

    private int idPrueba;
    public ObtenerData(int idPrueba) {this.idPrueba = idPrueba;}


    @Override
    public <T extends Actor> void performAs(T actor) {
        dataExcel.setDeDatos(EnviarData.dePrueba(idPrueba));
    }

    public static ObtenerData deUsuario(int idPrueba){return Tasks.instrumented(ObtenerData.class,idPrueba);
    }
}
