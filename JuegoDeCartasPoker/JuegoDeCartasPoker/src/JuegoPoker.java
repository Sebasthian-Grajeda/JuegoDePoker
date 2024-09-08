import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JuegoPoker {
    private List<Jugador> jugadores;
    private List<Cartas> baraja;
    private int numeroRondas;

    public JuegoPoker(int numeroJugadores, int numeroRondas) {
        this.jugadores = crearJugadores(numeroJugadores);
        this.numeroRondas = numeroRondas;
        this.baraja = crearBaraja();
    }

    private List<Jugador> crearJugadores(int numeroJugadores) {
        List<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i < numeroJugadores; i++) {
            jugadores.add(new Jugador("Jugador" + (i + 1), 1000)); // Saldo inicial de 1000 fichas
        }
        return jugadores;
    }

    private List<Cartas> crearBaraja() {
        List<Cartas> baraja = new ArrayList<>();
        String[] simbolos = {"Corazón", "Diamante", "Trébol", "Espadas"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "As"};

        for (String simbolo : simbolos) {
            for (String valor : valores) {
                baraja.add(new Cartas(valor, simbolo));
            }
        }
        return baraja;
    }

    private void barajar() {
        Collections.shuffle(baraja);
    }

    private void repartirCartas() {
        for (Jugador jugador : jugadores) {
            jugador.borrarCartas(); // Asegurarse de que el jugador comience sin cartas
            for (int i = 0; i < 2; i++) {
                jugador.agregarCarta(baraja.remove(0));
            }
        }
    }

    private void mostrarCartas() {
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + ": " + jugador.getCartas());
        }
    }

    private void jugarRonda() {
        System.out.println("\nNueva ronda:");
        barajar();
        repartirCartas();
        mostrarCartas();

        // Simular apuestas (esto debería ser más sofisticado en una versión completa del juego)
        for (Jugador jugador : jugadores) {
            jugador.apostar(50); // Todos apuestan 50 por simplicidad
        }

        // Mostrar apuestas
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + " apostó: " + jugador.getApuestaActual());
        }

        // Reiniciar apuestas para la siguiente ronda
        for (Jugador jugador : jugadores) {
            jugador.reiniciarApuesta();
        }
    }

    private Jugador determinarGanador() {
        // Para simplificar, determinamos el "ganador" al azar
        return jugadores.get((int) (Math.random() * jugadores.size()));
    }

    public void jugar() {
        for (int ronda = 1; ronda <= numeroRondas; ronda++) {
            System.out.println("\n--- Ronda " + ronda + " ---");
            jugarRonda();
        }

        Jugador ganador = determinarGanador();
        System.out.println("\nEl ganador es: " + ganador.getNombre());
    }
}
