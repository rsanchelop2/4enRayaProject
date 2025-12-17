import java.util.Scanner;

public class Tablero {


    private char[][] tablero = new char[6][7];
    private Jugador jugador1 = new Jugador(1,'X');
    private Jugador jugador2 = new Jugador(2,'O');
    private int numTurno = 0;
    private boolean hasGanado = false;

    public void poblarMatriz(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = ' ';
            }
            System.out.println();
        }
    }

    public void pintarTablero(){
        for (int i = 1; i <= tablero.length+1; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("-".repeat(13));
        System.out.println();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-".repeat(13));
    }

    private Jugador tocaTurno(){
      // int random = (Math.random()/2*100)
        if (numTurno%2 == 0){
            numTurno++;
            return jugador1;
        } else {
            numTurno++;
            return jugador2;
        }

    }

    public void jugarTurno() {
        pintarTablero();
        tocaTurno();
        if (tocaTurno() == jugador1){
            colocarFicha(imputJugador(),jugador1);
        } else {
            colocarFicha(imputJugador(),jugador2);
        }
    }


    private void colocarFicha(int i, Jugador jugador) {
        for (int j = 0; j < tablero[0].length; j++) {
            if (tablero[tablero[0].length-j][i] == ' '){
                tablero[j][i] = jugador.getFicha();
                break;
            }
        }
    }

    private int imputJugador() {
        Scanner scanner = new Scanner(System.in);
        String opcion = scanner.nextLine();
        int pos = Integer.parseInt(opcion);
        if (pos > 0 && pos <= tablero.length){
            return pos;
        } else {
            System.out.println("Elija una columna");
            imputJugador();
        }
        return 0;
    }


    //TODO 01: Comprobar hacia que direccion estan las fichas
    private int comprobarDireccion(Jugador jugador){
        int posX = 1;
        int posY = 1;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == posX && j == posY){
                    continue;
                }
                if (i == jugador.getFicha()){

                }
            }
        }

        return 0;
    }



    //TODO 02: Hacer comprobracion de las fichas 2 posiciones hacia la direccion
    private void comprobarRaya(int direccion, int posX, int posY, Jugador jugador){
        int contador = 2;
        switch(direccion) {
            case 1:
                for (int i = 0; i < 2 ; i++) {
                    posX = posX - 1;
                    posY = posY - 1;
                    if(posX < 0  || posX > tablero.length || posY > tablero.length || posY < 0);

                }
                break;
            case 2:

                for (int i = 0; i < 2; i++) {
                    posX = posX - 1;
                }
                if(posX < 0  || posX > tablero.length || posY > tablero.length || posY < 0);
                break;
            case 3:

                for (int i = 0; i < 2; i++) {


                    posX = posX - 1;
                    posY = posY + 1;
                }

                if(posX < 0  || posX > tablero.length || posY > tablero.length || posY < 0);
                break;
            case 4:
                posY = posY -1;
                if(posX < 0  || posX > tablero.length || posY > tablero.length || posY < 0);
                break;
            case 5:
                posY = posY +1;
                if(posX < 0  || posX > tablero.length || posY > tablero.length || posY < 0);
                break;
            case 6:
                posX = posX +1;
                posY = posY -1;
                if(posX < 0  || posX > tablero.length || posY > tablero.length || posY < 0);
                break;
            case 7:
                posX = posX +1;
                if(posX < 0  || posX > tablero.length || posY > tablero.length || posY < 0);
                break;
            case 8:
                posX = posX +1;
                posY = posY +1;
                if(posX < 0  || posX > tablero.length || posY > tablero.length || posY < 0);
        }

    }


    public static void main(String[] args) {
        Tablero tablero1 = new Tablero();
        tablero1.poblarMatriz();
        while (!tablero1.hasGanado){
            tablero1.jugarTurno();
        }
    }
}
