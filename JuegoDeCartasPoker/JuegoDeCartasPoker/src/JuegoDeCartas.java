import java.util.Scanner;

public class JuegoDeCartas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el número de jugadores
        System.out.print("Ingrese el número de jugadores: ");
        int numeroJugadores = scanner.nextInt();

        // Solicitar el número de rondas
        System.out.print("Ingrese el número de rondas: ");
        int numeroRondas = scanner.nextInt();

        // Crear una instancia del juego de póker con los valores proporcionados
        JuegoPoker juego = new JuegoPoker(numeroJugadores, numeroRondas);

        // Iniciar el juego
        juego.jugar();

        scanner.close();
    }
}
