package co.com.asesoftware.prueba.utils;

import co.com.asesoftware.prueba.models.DataExcel;
import co.com.asesoftware.prueba.models.DatosLogin;

import static co.com.asesoftware.prueba.enums.Resourses.EMAIL;
import static co.com.asesoftware.prueba.enums.Resourses.PASSWORD;

public class Conversion {

    private Conversion(){}



    public static DatosLogin usuario(DataExcel dataExcel){
        DatosLogin datosLogin = new DatosLogin();
        datosLogin.setCorreoElectronico(dataExcel.getSetDeDatos().get(0).get(EMAIL.getResourses()));
        datosLogin.setContrasena(dataExcel.getSetDeDatos().get(0).get(PASSWORD.getResourses()));
        return datosLogin;
    }
}
