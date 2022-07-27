package Modulos;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** David Joan Mosquera Perea 201910131 - Wilson Estiven Rueda Bastidas 201910057.
 *
 */

public class Estados {
    private int[][] tablero;
    private Point posicionBlanco; //ubicacion (xy)
    private Point posicionNegro; //ubicacion (xy)
    private Double puntosBlanco;
    private Double puntosNegro;
    private Double utilidad;
    private int turno;
    private int profundidad;



    public Estados(int turno, int[][] tablero, Point posicionBlanco, Point posicionNegro, Double puntosBlanco, Double puntosNegro) {
        this.turno = turno;
        this.tablero = tablero;
        this.posicionBlanco = posicionBlanco;
        this.posicionNegro = posicionNegro;
        this.puntosBlanco = puntosBlanco;
        this.puntosNegro = puntosNegro;
    }

    public Estados() {
        this.puntosNegro = 0.0;
        this.puntosBlanco = 0.0;
    }

    public int[][] getTablero() {

        return tablero;
    }

    public void setTablero(int[][] tablero) {

        this.tablero = tablero;
    }
    public Point getPosicionBlanco() {

        return posicionBlanco;
    }

    public void setPosicionBlanco(Point posicionBlanco) {

        this.posicionBlanco = posicionBlanco;
    }

    public Point getPosicionNegro() {

        return posicionNegro;
    }

    public void setPosicionNegro(Point posicionNegro) {

        this.posicionNegro = posicionNegro;
    }
    public Double getPuntosBlanco() {

        return puntosBlanco;
    }

    public void setPuntosBlanco(Double puntosBlanco) {

        this.puntosBlanco += puntosBlanco;
    }

    public Double getPuntosNegro() {

        return puntosNegro;
    }

    public void setPuntosNegro(Double puntosNegro) {

        this.puntosNegro += puntosNegro;
    }

    public double getUtilidad (){

        return utilidad;
    }

    public void setUtilidad(Double utilidad) {

        this.utilidad = utilidad;
    }

    public int getTurno() {

        return turno;
    }

    public void setTurno(int turno) {

        this.turno = turno;
    }

    public int getProfundidad() {

        return profundidad;
    }

    public void setProfundidad(int profundidad) {

        this.profundidad = profundidad;
    }


    public Estados resultado(Point accion) {

        Estados proximo = new Estados();
        int tamano = this.tablero.length;
        Double puntos = 0.0;

        int[][] tablero = new int[tamano][tamano];
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                tablero[i][j] = this.tablero[i][j];
            }
        }

        if (tablero[accion.x][accion.y] == 3) {
            puntos = 1.0;
        }

        if (tablero[accion.x][accion.y] == 4) {
            puntos = 3.0;
        }

        if (this.turno == 1) {
            tablero[posicionBlanco.x][posicionBlanco.y] = 0;
            tablero[accion.x][accion.y] = 1;
            proximo.setPosicionNegro(this.posicionNegro);
            proximo.setPosicionBlanco(accion);
            proximo.setPuntosNegro(this.puntosNegro);
            proximo.setPuntosBlanco(puntos);
            proximo.setTurno(2);
        }

        if (this.turno == 2) {
            tablero[posicionNegro.x][posicionNegro.y] = 0;
            tablero[accion.x][accion.y] = 2;
            proximo.setPosicionBlanco(this.posicionBlanco);
            proximo.setPosicionNegro(accion);
            proximo.setPuntosBlanco(this.puntosBlanco);
            proximo.setPuntosNegro(puntos);
            proximo.setTurno(1);
        }

        proximo.setProfundidad(this.profundidad + 1);
        proximo.setTablero(tablero);
        return proximo;
    }

    public List movimientosValidos() {

        List movidas = new ArrayList<>();
        Point posicion = new Point();
        Point posicionOponente = new Point();

        if (this.turno == 1) {
            //blanco
            posicion.setLocation(this.posicionBlanco.x, this.posicionBlanco.y);
            posicionOponente.setLocation(this.posicionNegro.x, this.posicionNegro.y);
        }
        if (this.turno == 2) {
            //negro
            posicion.setLocation(this.posicionNegro.x, this.posicionNegro.y);
            posicionOponente.setLocation(this.posicionBlanco.x, this.posicionBlanco.y);
        }
        int x = posicion.x - 2;
        int y = posicion.y -1;

        Point movida = verificarMovimiento(x,y,posicionOponente);

        if(movida!=null){

            movidas.add(movida);}

        y = posicion.y+1;
        movida = null;
        movida = verificarMovimiento(x,y,posicionOponente);

        if(movida!=null){

            movidas.add(movida);}

        x = posicion.x+2;
        y = posicion.y-1;
        movida = null;
        movida = verificarMovimiento(x,y,posicionOponente);

        if(movida!=null){

            movidas.add(movida);}

        y = posicion.y+1;
        movida = null;
        movida = verificarMovimiento(x,y,posicionOponente);

        if(movida!=null){

            movidas.add(movida);}

        x = posicion.x-1;
        y = posicion.y-2;
        movida = null;
        movida = verificarMovimiento(x,y,posicionOponente);

        if(movida!=null){

            movidas.add(movida);}

        x = posicion.x+1;
        movida = null;
        movida = verificarMovimiento(x,y,posicionOponente);

        if(movida!=null){

            movidas.add(movida);}

        x = posicion.x-1;
        y = posicion.y+2;
        movida = null;
        movida = verificarMovimiento(x,y,posicionOponente);

        if(movida!=null){

            movidas.add(movida);}

        x = posicion.x+1;
        movida = null;
        movida = verificarMovimiento(x,y,posicionOponente);

        if(movida!=null){

            movidas.add(movida);}

        return movidas;
    }

    private Point verificarMovimiento(int x, int y, Point posicionOponente){
        Point movimiento = null;

        if((x >= 0) && (x<=7) && (y>=0) && (y<=7)){
            boolean ocupada = ((posicionOponente.distance(new Point(x, y))) == 0);
            if (!ocupada) {
                movimiento = new Point(x, y);
            }
        }
        return movimiento;
    }


    public static Estados crearEstadoInicial(int tamano){

        List casillas = new ArrayList<Point>();
        Point posicionNegro = new Point();//caballo negro
        Point posicionBlanco = new Point();//caballo blanco
        Double puntosNegro = 0.0;
        Double puntosBlanco = 0.0;
        Double utilidad = Double.NEGATIVE_INFINITY;
        
        int turno = 1;
        int profundidad = 0;
        int [][] tablero = new int[tamano][tamano];

        for(int fila=0; fila<tamano; fila++){
            for(int cola=0;cola<tamano;cola++){
                casillas.add(new Point(fila,cola));
                tablero[fila][cola]=0;
            }
        }

        for(int i=0;i<27;i++){
            int max = casillas.size();
            Random rand = new Random(System.currentTimeMillis());
            int idx = rand.nextInt(max);
            Point figura = (Point)casillas.get(idx);

            if(i<20){
                //cesped
                tablero[figura.x][figura.y]=3;
            }
            if(i>=20 && i<25){
                //flores
                tablero[figura.x][figura.y]=4;
            }
            if(i==25){
                tablero[figura.x][figura.y]=1;//caballo blanco
                posicionBlanco.setLocation(figura.x, figura.y);
            }
            if(i==26){
                tablero[figura.x][figura.y]=2;//caballo negro
                posicionNegro.setLocation(figura.x, figura.y);
            }
            casillas.remove(idx);
        }

        Estados inicial = new Estados(turno, tablero, posicionBlanco,posicionNegro, puntosBlanco, puntosNegro);
        inicial.setProfundidad(profundidad);
        inicial.setUtilidad(utilidad);
        return inicial;
    }

    static public void imprimirTablero(Estados estado){

        int [][] tablero = estado.getTablero();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println();
        }
        HungryHorses.Main.jugadas.append("posicionBlanco: "+estado.getPosicionBlanco());
        HungryHorses.Main.jugadas.append("posicionNegro: "+estado.getPosicionNegro());
        HungryHorses.Main.jugadas.append("puntosBlanco: "+estado.getPuntosBlanco());
        HungryHorses.Main.jugadas.append("puntosNegro: "+estado.getPuntosNegro());
        HungryHorses.Main.jugadas.append("utilidad: "+estado.calcularUtilidad());
        HungryHorses.Main.jugadas.append("profundidad: "+estado.getProfundidad());
        HungryHorses.Main.jugadas.append("turno (1) blanco (2) negro: "+estado.getTurno());
    }


    public Double calcularUtilidad() {
        Double utilidad = (Double) this.puntosBlanco - this.puntosNegro;//blanco - negro
        this.utilidad = utilidad;
        return utilidad;
    }

    public boolean terminal(int limite) {

        boolean FinPartida= false;

        if ((profundidad >= limite)) {

            FinPartida = true;
            return FinPartida;
        }else{
            if((35 - puntosNegro - puntosBlanco) == 0){
                FinPartida = true;
                return FinPartida;
            }else{
                return FinPartida;
            }
        }
    }
}
