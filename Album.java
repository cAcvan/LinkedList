import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
     private String nombre;
     private String artista;
     private List<Cancion> arrayList;

     public Album(String nombre, String artista){
         this.artista=artista;
         this.nombre=nombre;
         arrayList=new ArrayList<Cancion>();
     }

     private Cancion findSong(String titulo){
         if(arrayList.contains(titulo))
             return arrayList.get(arrayList.indexOf(titulo));
         else
             return null;
     }

     public boolean addSong(String titulo, double duracion){
         Cancion c = findSong(titulo);
         if(c==null){
             Cancion a = new Cancion(titulo,duracion);
             arrayList.add(a);
             return true;
         }else
             return false;
     }

     public boolean addToPlayList(String titulo, LinkedList<Cancion> playlist){
         Cancion c = findSong(titulo);
         if(c!=null){
             playlist.add(c);
             return true;
         }else
             return false;
     }


    public boolean addToPlayList(int pista, LinkedList<Cancion> playlist) {
        int index = pista - 1;
        if (index >= 0 && index < arrayList.size()) {
            playlist.add(arrayList.get(index));
            return true;
        }
        return false;
    }
}

