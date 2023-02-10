import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Album {
    private String nombre;
    private String artista;
    private ArrayList<Song> canciones;

    public Album (String Nombre , String Artista){
        nombre=Nombre;
        artista=Artista;
        canciones= new ArrayList<Song>();
    }

    public boolean addSong (String titulo , double duracion){
            if(findSong(titulo) == null){
                Song nueva = new Song(titulo , duracion);
                if (canciones.add(nueva)){
                    System.out.println("Se ha añadido correctamente");
                    return true;
                }
                else {
                    System.out.println("No se ha añadido correctamente");
                    return false;
                }
            }
            else {
                System.out.println("La canción ya estaba en la lista con anterioridad, no se ha añadido nada");
                return false;
            }
    }

    private Song findSong (String titulo){


        //for (int i = 0; i < canciones.size() ; i = i+1){
        for (Song e: canciones){
            if (e.getTitulo().equalsIgnoreCase(titulo)){
                System.out.println("Ya esxiste esta canción");
                return e;
            }

        }
        return null;
    }

    public boolean addToPlayList (int numeroPista , LinkedList<Song> lista_Reproduccion){

        if(canciones.size() < numeroPista){
           System.out.println("El numero de canción introducido supera la cantidad total de opciones de la lista");
           return false;
        }

       else {
            if(lista_Reproduccion.add(canciones.get(numeroPista ))){
                System.out.println("La canción existe, y se ha añadido correctamente a lista de reproducciones");
                return true;
            }
            else {
                System.out.println("La cancion exite, pero no se ha añadido correctamente a la lista de reproducciones");
                return false;
            }

        }
    }

    public boolean addToPlayList (String titul, LinkedList<Song> lista_Reproduccion){

        if (findSong(titul) == null ){
           System.out.println("No se ha encontrado la canción " + titul);
            return false;
        }


        else {
            if(lista_Reproduccion.add(findSong(titul))){
                System.out.println("Se ha añadido Correctamente ");
                return true;
            }
            else {
                System.out.println("La canción existe pero no se ha podido añadir a la lista de reproducciones indicada");
                return false;
            }

        }





    }


}
