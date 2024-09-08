import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private float saldo;
    private List<Cartas> mano; // Cartas en mano (2 cartas)
    private int apuestaActual; // Cantidad apostada por el jugador en la ronda actual

    public Jugador(String nombre, float saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.mano = new ArrayList<>();
        this.apuestaActual = 0;
    }

    // Obtiene el nombre del jugador
    public String getNombre() {
        return nombre;
    }

    // Obtiene el saldo (fichas) del jugador
    public float getSaldo() {
        return saldo;
    }

    // Ajusta el saldo después de realizar una apuesta
    public void apostar(int cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            apuestaActual += cantidad;
        } else {
            System.out.println(nombre + " no tiene suficientes fichas para apostar " + cantidad);
        }
    }

    // Obtiene la cantidad de fichas apostadas en la ronda actual
    public int getApuestaActual() {
        return apuestaActual;
    }

    // Agrega una carta a la mano del jugador (máximo 2 cartas)
    public void agregarCarta(Cartas carta) {
        if (mano.size() < 2) {
            mano.add(carta);
        } else {
            System.out.println("No se pueden agregar más cartas a la mano.");
        }
    }

    // Obtiene las cartas en la mano del jugador
    public List<Cartas> getMano() {
        return mano;
    }

    // Borra las cartas de la mano al final de una ronda
    public void borrarCartas() {
        mano.clear();
    }

    // Reinicia la apuesta del jugador al comienzo de una nueva ronda
    public void reiniciarApuesta() {
        apuestaActual = 0;
    }

    // Mostrar las cartas de la mano del jugador
    @Override
    public String toString() {
        return nombre + " tiene " + mano;
    }

    // Método para obtener las cartas de la mano del jugador en forma de cadena
    public String getCartas() {
        StringBuilder sb = new StringBuilder();
        for (Cartas carta : mano) {
            sb.append(carta.toString()).append(", ");
        }
        // Eliminar la última coma y espacio extra
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}
