package packageb;

import java.util.Random;
public class Tablero {
  public static final int LIMITE = 64;
  private int[][] matriz;
  private int dimension;
  private Random random = new Random();
  public Tablero(){
    this.dimension = 4;
    this.matriz = new int[dimension][dimension];
    insertarNumero2();
  }
  private boolean lleno() {
    for(int i =0;i<dimension;i++){
      for(int j=0;j<dimension;j++){
        if(matriz[i][j] == 0) return false;
      }
    }
    return true;
  }
  private boolean posicionValida(int x,int y){
    return matriz[x][y] == 0;
  }
  private void recorrerVertical(int ini,int fin){
    int dis = ini <= fin? 1 : -1;
    for(int col = 0; col < dimension; col++){
      int filRec, fil;
      filRec = fil = ini;
      while(filRec != (fin+dis) && fil != (fin+dis)){
        if(matriz[fil][col] != 0){
          int num = matriz[fil][col];
          matriz[fil][col] = 0;
          matriz[filRec][col] = num;
          filRec += dis;
        }
        fil += dis;
      }
    }
  }
  private void recorrerHorizontal(int ini,int fin){
    //dis representa direccion, izq-der es -1, der-izq es +1
    int dis = ini <= fin? 1 : -1;
    for(int fil = 0;fil<dimension;fil++){
      int colRec, col;
      colRec = col = ini;
      while(colRec != (fin+dis) && col != (fin+dis)){
        if(matriz[fil][col] != 0){
          int num = matriz[fil][col];
          matriz[fil][col] = 0;
          matriz[fil][colRec] = num;
          colRec += dis;
        }
       col += dis;
      }
    }
  }
  /*
                   i       e      i       e
                -1 0 1 2 3 4   -1 0 1 2 3 4
      izquierda    2 2 0 0        2 0 2 0
      derecha      0 0 2 2        2 0 2 0
                 e       i      e       i
   */
  private boolean filaOrdenada(int fila,int ini,int end,int inc){
    for(int col=ini;col != end + (-inc);col+=inc){
      if(matriz[fila][col] == 0 && matriz[fila][col+inc] == 2){
        return false;
      }
    }
    return true;
  }
  private boolean insertarNumero2() {
    int nuevaX,nuevaY;
    if(lleno()) return false;
    do{
      nuevaX = random.nextInt(dimension);
      nuevaY = random.nextInt(dimension);
    }while(!posicionValida(nuevaX,nuevaY));
    matriz[nuevaX][nuevaY] = 2;
    return true;
  }

  @Override
  public String toString(){
    String str = "";
    for(int fil =0;fil<dimension;fil++){
      for(int col =0;col<dimension;col++){
        if(col < dimension-1){
          str += (matriz[fil][col]+" ");
        }
        else if(col==(dimension-1) && fil<(dimension-1)){
          str += (matriz[fil][col]+"|");
        }
        else{
          str += matriz[fil][col];
        }
      }
    }
    return str.trim();
  }
  public void moverIzquierda(){
    recorrerHorizontal(0,dimension-1);
    for(int fil=0;fil<dimension;fil++){
      int colTail = 0,colHead = 1;
      while(colHead < dimension){
        if(matriz[fil][colTail]==matriz[fil][colHead]){
          matriz[fil][colTail] = matriz[fil][colTail]+matriz[fil][colHead];
          matriz[fil][colHead] = 0;
        }
        colTail++;
        colHead++;
      }
    }
    recorrerHorizontal(0,dimension-1);
    insertarNumero2();
  }
  public void moverDerecha(){
    recorrerHorizontal(dimension-1, 0);
    for(int fil = 0;fil < dimension; fil++){
      int colTail = dimension-1, colHead = dimension-2;
      while(colHead >=0){
        if(matriz[fil][colTail] == matriz[fil][colHead]){
          matriz[fil][colTail] = matriz[fil][colTail]+matriz[fil][colHead];
          matriz[fil][colHead] = 0;
        }
        colHead--;
        colTail--;
      }
    }
    recorrerHorizontal(dimension-1, 0);
    insertarNumero2();
  }
  public void moverArriba() {
    recorrerVertical(0,dimension-1);
    for(int col = 0; col < dimension; col++){
      int filTail = 0, filHead = 1;
      while(filHead < dimension){
        if(matriz[filTail][col] == matriz[filHead][col]){
          matriz[filTail][col] = matriz[filTail][col]+matriz[filHead][col];
          matriz[filHead][col] = 0;
        }
        filHead++;
        filTail++;
      }
    }
    recorrerVertical(0,dimension-1);
    insertarNumero2();
  }
  public void moverAbajo(){
    recorrerVertical(dimension-1, 0);
    for(int col = 0; col < dimension; col++){
      int filTail = dimension-1, filHead = dimension-2;
      while(filHead >= 0){
        if(matriz[filTail][col] == matriz[filHead][col]){
          matriz[filTail][col] = matriz[filTail][col]+matriz[filHead][col];
          matriz[filHead][col] = 0;
        }
        filHead--;
        filTail--;
      }
    }
    recorrerVertical(dimension-1, 0);
    insertarNumero2();
  }
  public boolean alcanceLimite() {
    for(int fil =0;fil<dimension;fil++){
      for(int col=0;col<dimension;col++){
        if(matriz[fil][col] == LIMITE) return true;
      }
    }
    return false;
  }
}
