package Entidades;

public class Artista {

    private String nombre;
    private String apellido;
    private String paisNacimiento;

    public Artista(String nombre, String apellido, String paisNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.paisNacimiento = paisNacimiento;
    }

    public static boolean sonIguales(Artista a1, Artista a2) {

        return a1.nombre.equals(a2.nombre)
                && a1.apellido.equals(a2.apellido)
                && a1.paisNacimiento.equals(a2.paisNacimiento);

    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getArtista() {
        return this.nombre + " " + this.apellido + " - " + this.paisNacimiento;
    }

}