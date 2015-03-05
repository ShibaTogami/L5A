import java.util.Comparator;
import java.util.Random;

// clase básica de personaje, muy reducida, sólo para gestión de turnos.
public class Personaje {
  String nombre;
  int turno;

  public Personaje(String nombre, int turno) throws TurnoException {
    if (turno < 0) {
      throw new TurnoException("El turno no puede ser negativo");
    } else {
      this.nombre = nombre;
      this.turno = turno;
    }
  }

  public String getNombre() {
    return nombre;
  }

  public int getTurno() {
    return turno;
  }

  public void modificarTurno(int nuevoturno) {
    this.turno = nuevoturno;
  }

  public void cursoCombate(int resultadoDado) // ajusta el turno con el valor obtenido en el dado
  {
    if (turno - resultadoDado < 0) {
      this.modificarTurno(0);
    } else {
      this.modificarTurno(turno - resultadoDado);
    }
  }

  public String toString() {
    return ("\nPersonaje: " + nombre + "\nTurno: " + turno);
  }

}

