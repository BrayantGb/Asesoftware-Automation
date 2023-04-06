package co.com.asesoftware.prueba.enums;

public enum Resourses {
    USER("user"),
    URL_PAGE("url_home_page"),
    ELEMENTO_ENCONTRADO("Estos son algunos inmuebles sugeridos para ti"),
    EMAIL("Email"),
    PASSWORD("Password")
    ;

    private String resourses;
    Resourses(String resourses){this.resourses = resourses;}

    public String getResourses(){return resourses;}
}
