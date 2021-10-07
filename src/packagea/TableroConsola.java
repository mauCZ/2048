package packagea;
import packageb.Tablero;
import java.util.Scanner;

public class TableroConsola {
  private Tablero tablero;
  private Scanner sc;
  public TableroConsola(Tablero tablero){
    System.out.println("COMANDOS:\nmover izquierda: a\nmover derecha:   d\nmover arriba:    w\nmover abajo:     s");
    this.tablero = tablero;
    sc = new Scanner(System.in);
  }
  private String mostrarTablero(){
    String str = this.tablero.toString();
    StringBuilder strFormated = new StringBuilder("");
    for(int i =0;i<str.length();i++){
      char c = str.charAt(i);
      if(c == '|'){
        strFormated.append(c);
        strFormated.append('\n');
      }else{
        strFormated.append(c);
      }
    }
    return strFormated.toString().trim();
  }
  private boolean tableroLleno(){
    String[] nums = tablero.toString().split("[\s|]");
    for(String num : nums){
      if(num.equals("0")) return false;
    }
    return true;
  }




  public void correr(){
    String comando;
    boolean ganaste = false;
    boolean perdiste = false; //pierde si se llena el tablero
    while(!ganaste && !perdiste){
      System.out.println(mostrarTablero());
      System.out.print("\n\n\nComando: ");
      comando = sc.next();
      if(comando.equals("a")){
        tablero.moverIzquierda();
      }else if(comando.equals("d")){
        tablero.moverDerecha();
      }else if(comando.equals("w")){
        tablero.moverArriba();
      }else if(comando.equals("s")) {
        tablero.moverAbajo();
      }else{
        System.out.println("Comando invalido");
      }

      if(tableroLleno()){
        perdiste = true;
      }
      else if(tablero.alcanceLimite()){
        ganaste = true;
      }
    }
    System.out.println(mostrarTablero());
    if(perdiste){
      System.out.println("PERDISTE");
    }
    else if(ganaste){
      System.out.println("GANASTE");
    }

  }
}
