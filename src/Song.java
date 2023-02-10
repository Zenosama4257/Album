public class Song implements Comparable<Song> {
    private String titulo;
    double duracion;

    public Song (String Titulo , double Duracion){
        titulo=Titulo;
        duracion=Duracion;
    }

    public String getTitulo (){
        return titulo;
    }

    @Override
    public String toString() {
        return titulo + ": " + duracion;
    }

    @Override
    public int compareTo(Song o) {
        return titulo.compareTo(o.getTitulo());
    }
}
