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
        for (int i = 0; i < tablero.length; i++) {
            System.out.println("-".repeat(14));
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + "|");

            }
            System.out.println();
        }
        System.out.println("-".repeat(14));
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
        System.out.print("Elije una columna: ");
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


    public static void main(String[] args) {
        Tablero tablero1 = new Tablero();
        tablero1.poblarMatriz();
        while (!tablero1.hasGanado){
            tablero1.jugarTurno();
        }
    }
}

