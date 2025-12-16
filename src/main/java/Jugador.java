public class Jugador {

    private int numJugador;
    private char ficha;

    public Jugador(int numJugador, char ficha) {
        this.numJugador = numJugador;
        this.ficha = ficha;
    }

    public int getNumJugador() {
        return numJugador;
    }

    public char getFicha() {
        return ficha;
    }
}