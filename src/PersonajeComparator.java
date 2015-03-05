import java.util.Comparator;
import java.util.Random;


public class PersonajeComparator implements Comparator<Personaje>
{
  public PersonajeComparator ()
  {
    super();
  }

  public int compare(Personaje personaje1, Personaje personaje2) 
  {
    int resultado=0; //inicializamos resultado
    if(personaje1.getTurno()>personaje2.getTurno()) //y el primero tiene mayor turno
    {
      resultado--; //personaje1 va antes
    }
    else if(personaje1.getTurno()<personaje2.getTurno()) // en caso contrario 
    {
      resultado++; //va antes personaje2
    }
    else //si los turnos son iguales haremos una tirada aleatoria
    {
      Random semilla=new Random();
      if (semilla.nextInt()<semilla.nextInt()) //si el primer numero es menor que el segundo
      {
        resultado--; //va primero personaje1
      }
      else
      {
        resultado++;
      }
    }
    return resultado;//si tienen el mismo turno entonces no modificamos resultado.
  }

}
