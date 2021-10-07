package packagea;
import packageb.Tablero;
import java.util.Scanner;

public class TableroConsola {
  private Tablero tablero;
  private Scanner sc;
  public TableroConsola(Tablero tablero){
    System.out.println("\n\nCOMANDOS:\nmover izquierda: a\nmover derecha:   d\nmover arriba:    w\nmover abajo:     s");
    this.tablero = tablero;
    sc = new Scanner(System.in);
  }
  private String formatearTablero(){
    String[] nums = this.tablero.toString().split("[\s|]");
    StringBuilder strFormated = new StringBuilder("");
    int newLine = 1;
    for(int i =0;i<nums.length;i++){
      String numFormated = formatearNumero(Integer.parseInt(nums[i]));
      strFormated.append(numFormated);
      if(newLine % 4 == 0){
        strFormated.append('\n');
      }
      newLine++;
    }
    return strFormated.toString();
  }
  private String formatearNumero(int n ){
    if(n >= 1000){
      return ""+n;
    }
    else if(n >= 100){
      return " "+n;
    }
    else if(n >= 10){
      return "  "+n;
    }
    else{
      return "   "+n;
    }
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
      System.out.println(formatearTablero());
      System.out.print("\nComando: ");
      comando = sc.next();

      boolean sePudoMover = false;
      if(comando.equals("a")){
        sePudoMover = tablero.moverIzquierda();
      }else if(comando.equals("d")){
        sePudoMover = tablero.moverDerecha();
      }else if(comando.equals("w")){
        sePudoMover = tablero.moverArriba();
      }else if(comando.equals("s")) {
        sePudoMover = tablero.moverAbajo();
      }else{
        System.out.println("Comando invalido");
      }

      if(!sePudoMover){
        perdiste = true;
      }
      else if(tablero.alcanceLimite()){
        ganaste = true;
      }
    }
    System.out.println(formatearTablero());
    if(perdiste){
      System.out.println("PERDISTE");
    }
    else if(ganaste){
      System.out.println("GANASTE");
    }

  }
}
