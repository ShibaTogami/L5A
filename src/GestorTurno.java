import java.io.IOException;
import java.util.*;



public class GestorTurno {

  public static void main(String[] args) throws TurnoException {
    System.out.println("GESTOR DE TURNOS");
    List<Personaje> personajes; // array que gestionara los personajes
    int numjugadores = 0;
    Scanner teclado = new Scanner(System.in);
    while (numjugadores <= 0) // obtenemos el numero de jugadores
    {
      System.out.println("Introduzca el numero de jugadores: ");
      numjugadores = teclado.nextInt();

    }
    personajes = new ArrayList<Personaje>(numjugadores);// asignamos tamaño a la lista
    for (int jugador = 0; jugador < numjugadores; jugador++) {// tomamos datos de cada personaje
      System.out.println("Introduzca el nombre del personaje: ");
      String nombre = teclado.next();
      System.out.println("Introduzca el turno de " + nombre + ": ");
      int turno = teclado.nextInt();
      while (turno < 0) {
        System.out.println("El turno no debe ser negativo");
        System.out.println("Introduzca el turno de " + nombre + ": ");
        turno = teclado.nextInt();
      }
      personajes.add(new Personaje(nombre, turno));// añadimos el personaje a la lista
    }
    ordenarLista(personajes);
    while (!teclado.nextLine().equals("fin")) //mientras no se teclee fin
    { 
      rotacion (personajes); //se genera una rotación tras otra
      curso(personajes); //se ajusta, si procede el curso de combate
    }
    teclado.close();
  }

  public static void ordenarLista(List<Personaje> personajes) // función que ordena la lista descendentemente por turno
  {
    Comparator<Personaje> comparador = new PersonajeComparator();
    Collections.sort(personajes, comparador); //verificar como se usa y crean comparadores
  }
  
  public static void rotacion (List<Personaje> personajes) //metodo que hace una rotación entera de personaje
  {
    
    Scanner enter=new Scanner(System.in);
    for (Personaje personajeAuxiliar : personajes)
    {
      System.out.println("Turno de: "+personajeAuxiliar.getNombre());
      enter.nextLine();
      
    }
    enter.close();
  }
  public static void curso (List<Personaje> personajes) //metodo que consulta si procede ajustar curso de combate
  {
    Scanner respuesta = new Scanner (System.in);
    String res="";
    for (Personaje personajeAuxiliar : personajes)
    {
      System.out.println("¿Hay que ajustar el curso de combate de "+personajeAuxiliar.getNombre()+"?");
      res=respuesta.next();
      while (!res.equals("si") && !res.equalsIgnoreCase("no") ) //mientras que la respuesta NO sea si o no
      {
        System.out.println("Respuesta incorrecta\n¿Hay que ajustar el curso de combate de "+personajeAuxiliar.getNombre()+"?");
        res=respuesta.next();
      }
      if (res.equals("si")) //si hay que ajustar el curso de combate
      {
        System.out.println("Introduzca el resultado del dado:");
        personajeAuxiliar.cursoCombate(respuesta.nextInt());
      }
    }
    respuesta.close();
  }
  
}
