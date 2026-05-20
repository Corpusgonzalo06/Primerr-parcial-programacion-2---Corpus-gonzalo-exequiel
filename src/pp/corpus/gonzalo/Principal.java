package pp.corpus.gonzalo;
import Entidades.*;

public class Principal {

    public static void main(String[] args) {

        BibliotecaStreaming miBiblioteca = new BibliotecaStreaming(5);

        Artista a1 = new Artista("Paul", "McCartney", "Reino Unido");
        Artista a2 = new Artista("Michael", "Jackson", "Estados Unidos");
        Artista a3 = new Artista("Daddy", "Yankee", "Puerto Rico");

        Cancion c1 = new Cancion(
                "Hey Jude",
                426,
                a1,
                GeneroMusical.ROCK,
                CalidadAudio.ALTA);

        Cancion c2 = new Cancion(
                "Thriller",
                360,
                a2,
                GeneroMusical.POP,
                CalidadAudio.MEDIA);

        Cancion c3 = new Cancion(
                "Gasolina",
                240,
                a3,
                GeneroMusical.REGGAETON,
                CalidadAudio.BAJA);

        Podcast p1 = new Podcast(
                "Codigo Moderno",
                3600,
                "Lucas",
                "Perez",
                "Argentina",
                TipoPodcast.TECNOLOGIA);

        Podcast p2 = new Podcast(
                "Charlas del Futuro",
                2700,
                "Santiago",
                "Lopez",
                "Chile",
                TipoPodcast.ENTRETENIMIENTO);

        Podcast p3 = new Podcast(
                "Aprendiendo Java",
                1800,
                "Facundo",
                "Rocha",
                "Argentina",
                TipoPodcast.EDUCACION);

        miBiblioteca.agregar(c1);
        miBiblioteca.agregar(p1);
        miBiblioteca.agregar(c2);

        System.out.println("");
        System.out.println("Intentando agregar contenido repetido...");

        Cancion c4 = new Cancion(
                "Hey Jude",
                426,
                a1,
                GeneroMusical.ROCK,
                CalidadAudio.ALTA);

        miBiblioteca.agregar(c4);

        miBiblioteca.agregar(p2);
        miBiblioteca.agregar(c3);

        System.out.println("");
        System.out.println("Intentando agregar contenido sin lugar...");

        miBiblioteca.agregar(p3);

        Podcast p4 = new Podcast(
                "Código Moderno",
                3600,
                "Lucas",
                "Perez",
                "Argentina",
                TipoPodcast.TECNOLOGIA);

        System.out.println("");
        System.out.println("Pruebas equals:");

        System.out.println(c1.equals(c1));
        System.out.println(c1.equals(c4));
        System.out.println(c1.equals(c2));
        System.out.println(p1.equals(p3));
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p4));

        System.out.println("");
        System.out.println("Información de la Biblioteca:\n");

        System.out.println(miBiblioteca);

    }

}