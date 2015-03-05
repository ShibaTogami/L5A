import java.util.Random;
import java.util.Scanner;


public class TestPersonaje {

  public static void main(String[] args) {
    // Test de creación
    String[] nombres = {"Genshin", "Saiga", "Hideki", "Hida"};
    Personaje[] personajes = new Personaje[nombres.length];
    Random semilla = new Random();
    for (int i = 0; i < nombres.length; i++) // para cada nombre
    {
      try {
        personajes[i] = new Personaje(nombres[i], truncado(semilla.nextInt()));
      } catch (TurnoException e) {
        // System.out.println(personajes[i]+" \nno se pudo crear por el turno.");
        // e.printStackTrace();
      }
    }
    System.out.println("Personajes Creados:");
    arreglaArray(personajes);
    for (Personaje auxiliar : personajes) {
      System.out.println(auxiliar);
    }
    // test de modificación
    for (Personaje auxiliar : personajes) {
      if (auxiliar != null) {
        System.out.println("\nPrueba de curso de combate:");
        System.out.println("\nAntes de modificar" + auxiliar);

        auxiliar.cursoCombate(truncaDado(semilla.nextInt()));

        System.out.println("\nDespues de modificar" + auxiliar);
      }
    }

  }

  public static int truncado(int numero) {
    while (numero > 100) {
      numero = numero / 10;
    }
    return numero;
  }

  public static int truncaDado(int numero) {
    while (numero > 10 || numero < -10) {
      numero = numero / 10;
    }
    return numero;

  }

  public static void arreglaArray(Object[] array) // este método pone los huecos llenos del array
                                                  // primero
  {
    // primero buscamos el primer hueco vacio
    int primerovacio = 0;
    while (array[primerovacio] != null) {
      primerovacio++;
    }
    // buscamos huecos llenos y los vamos asignando a los vacios
    for (int marca = primerovacio; marca < array.length; marca++) {
      if (array[marca] != null) // si encontramos uno lleno
      {
        array[primerovacio] = array[marca]; // lo asignamos al primer hueco
        array[marca] = null; // lo quitamos de su lugar original
        primerovacio++; // apuntamos al siguiente vacio
      }// si nos encontramos uno vacio, simplemente pasamos al siguiente
       // ya se encargara el propio bucle, ayudado por primerovacio de irlo llenando
    }
  }
}
