import java.util.*;

public class Main {


    public  static void Menu () {
        System.out.println("0 - Para salir de la lista de reproducción");
        System.out.println("1 - Reproducir la siguiente canción de la lista");
        System.out.println("2 - Reproducir la canción previa de la lista");
        System.out.println("3 - Repetir la canción actual");
        System.out.println("4 - Imprimir la lista de canciones en la playlist");
        System.out.println("5 - Volver a imprimir el menu");
        System.out.println("6. Eliminar la canción actual");
        System.out.println("7.Masterización");
    }

    public static void printPlayList (LinkedList<Song> item){

            Iterator<Song> it = item.iterator();
            while (it.hasNext()) {
                System.out.println("Titulo: " + it.next());
            }
            System.out.println("-----");

    }

    public static void nextSong ( Song Siguiente){

            System.out.println("Se esta reproduciendo la canción " + Siguiente.toString());

    }



    public static  void previousSong (Song cancion_Previa){

            System.out.println("Se esta reproduciendo la canción " + cancion_Previa.toString());


    }



    public static void repeat (Song Repetir){
        System.out.println("Se esta reproduciendo la canción " + Repetir.toString());
    }




    public static void Play (LinkedList<Song> item){
        Scanner sc6= new Scanner(System.in);
        Scanner sc7 = new Scanner(System.in);
        Scanner sc8 = new Scanner(System.in);

       ListIterator<Song> Pista = item.listIterator();
        Menu();
        printPlayList(item);
        System.out.println("Dime el nombre de la canción quieres escuchar");
        String nombre = sc6.nextLine();
        Song cancion_actual = null;
        boolean condicion = false;
        while (Pista.hasNext()){
            cancion_actual= Pista.next();
            if (cancion_actual.getTitulo().equalsIgnoreCase(nombre)){
                System.out.println("Se esta reproduciendo la canción " + cancion_actual.getTitulo());
                condicion=true;
                break;
            }


        }


        if (condicion == false){
                printPlayList(item);
                Pista = item.listIterator();
                cancion_actual=Pista.next();
            System.out.println("No se ha encontado la canción indicada se reproducirá la primera canción por defecto:" + cancion_actual.getTitulo());


        }




        int opcion;
        boolean continuar=true;



        do{
            try {


            System.out.println("Elige una opción: ");
            opcion = sc7.nextInt();


            switch (opcion) {
                case 0:
                    continuar = false;
                    break;

                case 1:

                    if (Pista.hasNext()) {
                        cancion_actual = Pista.next();
                    } else {
                        Pista = item.listIterator();
                        cancion_actual = Pista.next();
                    }
                    nextSong(cancion_actual);


                    break;
                case 2:


                    if (Pista.hasPrevious()) {
                        Pista.previous();
                        if (Pista.hasPrevious()) {
                            Pista.previous();
                        }
                        cancion_actual = Pista.next();
                        previousSong(cancion_actual);
                    } else {
                        System.out.println("No hay canción previa, ya estas en el principio de la fila.");


                    }

                    break;
                case 3:
                    repeat(cancion_actual);
                    break;
                case 4:
                    printPlayList(item);
                    break;

                case 5:
                    Menu();
                    break;

                case 6:

                    if (item.isEmpty()) {
                        System.out.println("No se pueden eliminar mas canciones, porque ya no hay más");
                        break;
                    }
                    System.out.println("Se eliminó la canción: " + cancion_actual.getTitulo());

                    Pista.remove();
                    if (Pista.hasNext()) {
                        cancion_actual = Pista.next();

                    }
                    if (Pista.hasPrevious()) {
                        cancion_actual = Pista.previous();

                    } else {
                        System.out.println("Ya no quedan más canciones en la Play List");
                        cancion_actual = null;

                    }
                    break;
                case 7:
                    Collections.sort( item );
                    printPlayList(item);
                    break;


                default:
                    System.out.println("La opción marcada no se encuentra entre la ista de posibilidades, por favor introduce otra opción");
                    break;



            }
            }catch (InputMismatchException e){
                System.out.println("No está permitido poner letras");
                LinkedList<Song>item2 ;
                item2=item;
                Play(item2);

            }catch (IndexOutOfBoundsException j){
                System.out.println("No puedes poner ese número");

            }
        }while(continuar);


    }



    public static void main(String[] args) {
        Scanner sc3 = new Scanner(System.in);
        Scanner sc4 = new Scanner(System.in);

        ArrayList<Album> misAlbumes = new ArrayList<Album>();
        //Albumes
        Album Javier = new Album("La cara oculta" , "Antonio Molina");
        Album Julio = new Album("Que bonito es vivir" , "Julio Iglesias");
        misAlbumes.add(Javier);
        misAlbumes.add(Julio);
        misAlbumes.add(new Album("Te quiero" , "Vanesa martín"));

        //Canciones que añades a los albumes
        misAlbumes.get(0).addSong("Subeme la radio" , 2.45);
        misAlbumes.get(0).addSong("Son" , 2.00);
        Julio.addSong("Despacito" , 3.45);
        Javier.addSong("Beeesame" , 2.30);
        Julio.addSong("Se te ve" , 3.00);


        LinkedList <Song> Reproducciones1 = new LinkedList<Song>();

        //Las canciones que hay en los albumes y que añades a la lista de reproducción
        misAlbumes.get(0).addToPlayList("Son" , Reproducciones1);
        misAlbumes.get(1).addToPlayList(0, Reproducciones1);
        misAlbumes.get(1).addToPlayList(1 , Reproducciones1);
        misAlbumes.get(0).addToPlayList("Subeme la radio" , Reproducciones1);
        misAlbumes.get(0).addToPlayList("Beeesame" , Reproducciones1);


      //  Collections.sort( Reproducciones1 );

        Play(Reproducciones1);


    }
}