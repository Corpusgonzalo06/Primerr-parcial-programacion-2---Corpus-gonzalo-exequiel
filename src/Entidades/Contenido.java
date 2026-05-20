package Entidades;

import java.util.Random;

public abstract class Contenido implements Comparable<Contenido> {

    protected Artista artista;
    protected String titulo;
    protected int duracion;
    protected int likes;

    protected static Random generadorLikes;

    static {
        Contenido.generadorLikes = new Random();
    }

    public Contenido(String titulo, int duracion, Artista artista) {

        this.titulo = titulo;
        this.duracion = duracion;
        this.artista = artista;
    }

    public Contenido(String titulo, int duracion,
            String nombreArtista,
            String apellidoArtista,
            String paisArtista) {

        this(titulo, duracion,
                new Artista(nombreArtista, apellidoArtista, paisArtista));
    }

    public int getLikes() {

        if (this.likes == 0) {
            this.likes = Contenido.generadorLikes.nextInt(1000000) + 1;
        }

        return this.likes;
    }

    private static String mostrar(Contenido c) {

        return "Titulo: " + c.titulo
                + " - Artista: " + c.artista.getArtista()
                + " - Duracion: " + c.duracion
                + " - Likes: " + c.getLikes();
    }

    public static boolean sonIguales(Contenido c1, Contenido c2) {

        return c1.titulo.equals(c2.titulo)
                && Artista.sonIguales(c1.artista, c2.artista);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj != null && obj instanceof Contenido) {

            Contenido aux = (Contenido) obj;

            return Contenido.sonIguales(this, aux);
        }

        return false;
    }

    @Override
    public String toString() {

        return Contenido.mostrar(this);
    }

    @Override
    public int compareTo(Contenido otro) {

        int comparacionApellido = this.artista.getApellido()
                .compareTo(otro.artista.getApellido());

        if (comparacionApellido == 0) {

            int comparacionNombre = this.artista.getNombre()
                    .compareTo(otro.artista.getNombre());

            if (comparacionNombre == 0) {

                return this.titulo.compareTo(otro.titulo);
            }

            return comparacionNombre;
        }

        return comparacionApellido;
    }

}