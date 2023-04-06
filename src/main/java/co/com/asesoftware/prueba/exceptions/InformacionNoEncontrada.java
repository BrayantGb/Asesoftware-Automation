package co.com.asesoftware.prueba.exceptions;

public class InformacionNoEncontrada extends AssertionError{

    public static final String MENSAJE = "La informacion encontrada no hizo match";
    public InformacionNoEncontrada(String message, Throwable cause){
        super(message, cause);
    }
}
