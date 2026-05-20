package Entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;

public class BibliotecaStreaming {

    private int capacidad;
    private Collection<Contenido> contenidos;

    public BibliotecaStreaming() {

        this.capacidad = 3;
        this.contenidos = new ArrayList<>();
    }

    public BibliotecaStreaming(int capacidad) {

        this.capacidad = capacidad;
        this.contenidos = new ArrayList<>();
    }

    private boolean sonIguales(Contenido c) {

        for (Contenido aux : this.contenidos) {

            if (aux.equals(c)) {
                return true;
            }
        }

        return false;
    }

    public void agregar(Contenido c) {

        if (this.contenidos.size() >= this.capacidad) {

            System.out.println("No hay lugar disponible.");

        } else if (this.sonIguales(c)) {

            System.out.println("El contenido ya existe.");

        } else {

            this.contenidos.add(c);
            System.out.println("Contenido agregado correctamente.");
        }
    }

    private int getDuracionContenido(TipoContenido tipo) {

        switch (tipo) {

            case CANCIONES:
                return this.getDuracionCanciones();

            case PODCASTS:
                return this.getDuracionPodcasts();

            case TODOS:
                return this.getDuracionTotal();

            default:
                return 0;
        }
    }

    private int getDuracionCanciones() {

        int total = 0;

        for (Contenido aux : this.contenidos) {

            if (aux instanceof Cancion) {

                total += ((Cancion) aux).getDuracionConPublicidad();
            }
        }

        return total;
    }

    private int getDuracionPodcasts() {

        int total = 0;

        for (Contenido aux : this.contenidos) {

            if (aux instanceof Podcast) {

                total += ((Podcast) aux).getDuracionConPublicidad();
            }
        }

        return total;
    }

    private int getDuracionTotal() {

        return this.getDuracionCanciones()
                + this.getDuracionPodcasts();
    }

    private void ordenar() {

        ArrayList<Contenido> lista =
                (ArrayList<Contenido>) this.contenidos;

        Collections.sort(lista);
    }

    @Override
    public String toString() {

        this.ordenar();

        String mensaje = "";

        mensaje += "Cantidad de contenidos: "
                + this.contenidos.size() + "\n\n";

        for (Contenido aux : this.contenidos) {

            mensaje += aux.toString() + "\n";
        }

        mensaje += "\nDuracion canciones: "
                + this.getDuracionContenido(TipoContenido.CANCIONES);

        mensaje += "\nDuracion podcasts: "
                + this.getDuracionContenido(TipoContenido.PODCASTS);

        mensaje += "\nDuracion total: "
                + this.getDuracionContenido(TipoContenido.TODOS);

        return mensaje;
    }

}