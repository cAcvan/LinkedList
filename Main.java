import java.util.*;

public class Main {
    public static void printPlayList(LinkedList<Cancion> playlist) {
        ListIterator<Cancion> iterator = playlist.listIterator();
        while (iterator.hasNext()) {
            System.out.println("Reproduciendo: " + iterator.next().toString());
        }
    }

    public static void play(LinkedList<Cancion> playlist) {
        Scanner sc = new Scanner(System.in);
        ListIterator<Cancion> iterator = playlist.listIterator();
        boolean direccionAdelante = true;
        boolean salir = false;
        boolean reproduciendo = true;

        if (playlist.isEmpty()) {
            System.out.println("No hay canciones en la lista de reproducción.");
            return;
        } else {
            System.out.println("Reproduciendo: " + iterator.next().toString());
            printMenu();
        }

        while (!salir && reproduciendo) {
            int opcion = 0;
            if (!direccionAdelante) {
                if (iterator.hasNext()) {
                    iterator.next();
                }
                direccionAdelante = true;
            }

            try{
                opcion = sc.nextInt();
                switch (opcion) {
                    case 0:
                        System.out.println("Saliendo de la lista de reproducción.");
                        salir = true;
                        break;
                    case 1:
                        if (iterator.hasNext()) {
                            System.out.println("Reproduciendo siguiente canción: " + iterator.next().toString());
                        } else {
                            System.out.println("Ya estás al final de la lista de reproducción.");
                            reproduciendo = false;
                        }
                        break;
                    case 2:
                        if (iterator.hasPrevious()) {
                            System.out.println("Reproduciendo canción anterior: " + iterator.previous().toString());
                        } else {
                            System.out.println("Ya estás al inicio de la lista de reproducción.");
                            reproduciendo = false;
                        }
                        break;
                    case 3:
                        System.out.println("Reproduciendo nuevamente la canción actual.");
                        break;
                    case 4:
                        printPlayList(playlist);
                        break;
                    case 5:
                        printMenu();
                        break;
                    default: System.out.println("Opción no válida.");
                }
            }catch (InputMismatchException e){
                System.out.println("Ingresa valores válidos.");
                sc.next();
            }
        }
    }
    public static void printMenu() {
        System.out.println("Opciones:");
        System.out.println("0 - Salir de la lista de reproducción");
        System.out.println("1 - Reproducir siguiente canción en la lista");
        System.out.println("2 - Reproducir la canción previa de la lista");
        System.out.println("3 - Repetir la canción actual");
        System.out.println("4 - Imprimir la lista de canciones en la playlist");
        System.out.println("5 - Volver a imprimir el menú.");
    }

    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<>();

        Album album1 = new Album("Album1", "Artista1");
        album1.addSong("Cancion1", 4.5);
        album1.addSong("Cancion2", 3.7);
        album1.addSong("Cancion3", 5.2);
        albums.add(album1);

        Album album2 = new Album("Album2", "Artista2");
        album2.addSong("CancionA", 3.2);
        album2.addSong("CancionB", 4.0);
        album2.addSong("CancionC", 6.1);
        albums.add(album2);

        LinkedList<Cancion> playlist = new LinkedList<>();
        album1.addToPlayList(1, playlist);
        album2.addToPlayList("CancionB", playlist);
        album1.addToPlayList(3, playlist);

        printPlayList(playlist);
        play(playlist);
    }
}
