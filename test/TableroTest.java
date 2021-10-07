import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import packageb.Tablero;
import org.junit.jupiter.api.Test;

class TableroTest {

  @Test
  public void testToStringTableroLLeno(){
    Tablero tablero = new Tablero();
    for(int i =0;i<16;i++){
//      tablero.insertarNumero2();
    }
    String resultado = "2 2 2 2|2 2 2 2|2 2 2 2|2 2 2 2";
    String tableroStr = tablero.toString();
    assertEquals(tableroStr,resultado);
  }
  @Test
  public void testInsertar1Vez(){
    Tablero tablero = new Tablero();
//    assert(tablero.insertarNumero2());
  }
  @Test
  public void testLLenoDespuesDeInsertar16Veces(){
    Tablero tablero = new Tablero();
    for(int i =0;i<16;i++){
//      tablero.insertarNumero2();
    }
    String tableroStr = tablero.toString();
    int twos = 0;
    for(int i =0;i<tableroStr.length();i++){
      if(tableroStr.charAt(i)=='2'){
        twos ++;
      }
    }
    assertEquals(16,twos);
  }
  @Test //similar al anterior test, solo por probar insertar2()->false
  public void testInsertar17Veces(){
    Tablero tablero = new Tablero();
    for(int i =0;i<16;i++){
//      tablero.insertarNumero2();
    }
//    assertFalse(tablero.insertarNumero2());
  }

  @Test
  public void testMoverIzquierdaTableroLLeno(){
    Tablero tablero = new Tablero();
    for(int i =0;i<16;i++){
//      tablero.insertarNumero2();
    }
    tablero.moverIzquierda();
    String[] numeros = tablero.toString().split("[\s|]");
    boolean correcto = true;
    //verificamos los 4s
    for(int i =0 ;i<numeros.length;i+=4){
        correcto &= (numeros[i].equals("4") && numeros[i+1].equals("4"));
    }
    //verificamos el 2 anhadido
    int twos = 0;
    for(int i = 2;i< numeros.length;i+=4){
      if(numeros[i].equals("2")) twos++;
      else if(numeros[i+1].equals("2")) twos++;
    }
    correcto &= (twos==1);
    assert(correcto);
  }
  @Test
  public void testMoverDerechaTableroLleno(){
    Tablero tablero = new Tablero();
    for(int i =0;i<16;i++){
//      tablero.insertarNumero2();
    }
    tablero.moverDerecha();
    String[] numeros = tablero.toString().split("[\s|]");
    boolean correcto = true;
    //verificamos los 4s
    for(int i = 2;i<numeros.length;i+=4){
      correcto &= (numeros[i].equals("4") && numeros[i+1].equals("4"));
    }
    //verificamos el 2 anhadido
    int twos = 0;
    for(int i =0;i< numeros.length;i+=4){
      if(numeros[i].equals("2")) twos++;
      else if(numeros[i+1].equals("2")) twos++;
    }
    correcto &= (twos==1);
    assert(correcto);
  }
  @Test
  public void testMoverArribaTableroLLeno(){
    Tablero tablero = new Tablero();
    for(int i =0;i<16;i++){
//      tablero.insertarNumero2();
    }
    tablero.moverArriba();
    String[] numeros = tablero.toString().split("[\s|]");
    boolean correcto = true;
    //verificamos los 4s
    for(int i =0;i<8;i++){
      correcto &= (numeros[i].equals("4"));
    }
    //verificamos el 2 anhadido
    int twos = 0;
    for(int i =8;i<numeros.length;i++){
      if(numeros[i].equals("2")) twos++;
    }
    correcto &= (twos==1);
    assert(correcto);
  }
  @Test
  public void testMoverAbajoTableroLLeno(){
    Tablero tablero = new Tablero();
    for(int i =0;i<16;i++){
//      tablero.insertarNumero2();
    }
    tablero.moverAbajo();
    String[] numeros = tablero.toString().split("[\s|]");
    boolean correcto = true;
    //verificamos los 4s
    for(int i = 8;i< numeros.length;i++){
      correcto &= (numeros[i].equals("4"));
    }
    //verificamos el 2 anhadido
    int twos = 0;
    for(int i =0;i<8;i++){
      if(numeros[i].equals("2")) twos++;
    }
    correcto &= (twos==1);
    assert(correcto);
  }
  @Test
  public void testMoverDerechaTableroVacio(){
    Tablero tablero = new Tablero();
    tablero.moverDerecha();
    int twos = 0;
    String tableroStr = tablero.toString();
    for(int i =0;i<tableroStr.length();i++){
      if(tableroStr.charAt(i)=='2'){
        twos ++;
      }
    }
    assertEquals(1,twos);
  }
  @Test
  public void testMoverIzquierdaTableroVacio(){
    Tablero tablero = new Tablero();
    tablero.moverIzquierda();
    int twos = 0;
    String tableroStr = tablero.toString();
    for(int i =0;i<tableroStr.length();i++){
      if(tableroStr.charAt(i)=='2'){
        twos ++;
      }
    }
    assertEquals(1,twos);
  }
  @Test
  public void testMoverArribaTableroVacio(){
    Tablero tablero = new Tablero();
    tablero.moverArriba();
    int twos = 0;
    String tableroStr = tablero.toString();
    for(int i =0;i<tableroStr.length();i++){
      if(tableroStr.charAt(i)=='2'){
        twos ++;
      }
    }
    assertEquals(1,twos);
  }
  @Test
  public void testMoverAbajoTableroVacio(){
    Tablero tablero = new Tablero();
    tablero.moverAbajo();
    int twos = 0;
    String tableroStr = tablero.toString();
    for(int i =0;i<tableroStr.length();i++){
      if(tableroStr.charAt(i)=='2'){
        twos ++;
      }
    }
    assertEquals(1,twos);
  }
  @Test
//test desactivado, para activar cambiar LIMITE en Tablero.java a 32
//  @Disabled
  public void testAlcanceLimite16Con4Movimientos(){
    //POR TESTEO SE MODIFICA EL LIMITE A 32
    Tablero tablero = new Tablero();
    for(int i =0;i<16;i++){
//      tablero.insertarNumero2();
    }
    tablero.moverIzquierda();
    tablero.moverIzquierda();
    tablero.moverAbajo();
    tablero.moverAbajo();
    assert(tablero.alcanceLimite());
  }
}