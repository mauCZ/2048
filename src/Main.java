import packageb.Tablero;
import packagea.TableroConsola;

public class Main {
  public static void main(String[] args){

    Tablero tablero = new Tablero();
    TableroConsola consola = new TableroConsola(tablero);
    consola.correr();

  }
}
