package buscaminasExamenPracticoTC;

import java.util.Scanner;

public class ControladorJuego {
    private TableroBM tablero; // Asegúrate de que el nombre de la clase sea TableroBM
    private Jugador jugador;
    private VistaConsola vista;
    private Scanner scanner;

    public ControladorJuego(int filas, int columnas, int minas, String nombreJugador) {
        this.tablero = new TableroBM(filas, columnas, minas); // Cambiado a TableroBM
        this.setJugador(new Jugador(nombreJugador));
        this.vista = new VistaConsola();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            vista.imprimirTablero(tablero);
            System.out.println("Ingrese coordenadas (ejemplo: A5) o 'marcar A5' para marcar una mina:");
            String input = scanner.nextLine().toUpperCase();
            if (input.startsWith("MARCAR ")) {
                marcarCasilla(input.substring(7));
                continue;
            }
            int[] coordenadas = obtenerCoordenadas(input);
            if (coordenadas == null) {
                System.out.println("Coordenadas inválidas. Intente de nuevo.");
                continue;
            }
            int fila = coordenadas[0];
            int columna = coordenadas[1];

            try {
                if (tablero.getCasilla(fila, columna).tieneMina()) {
                    System.out.println("¡Perdiste! Has encontrado una mina.");
                    vista.imprimirTableroCompleto(tablero);
                    break;
                } else {
                    revelarCasilla(fila, columna);
                    if (tablero.juegoGanado()) {
                        System.out.println("¡Ganaste! Has descubierto todas las casillas seguras.");
                        vista.imprimirTableroCompleto(tablero);
                        break;
                    }
                }
            } catch (CasillaYaDescubiertaException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }

    public void marcarCasilla(String input) {
        int[] coordenadas = obtenerCoordenadas(input);
        if (coordenadas == null) {
            System.out.println("Coordenadas inválidas para marcar. Intente de nuevo.");
            return;
        }
        int fila = coordenadas[0];
        int columna = coordenadas[1];
        tablero.getCasilla(fila, columna).setMarcada(!tablero.getCasilla(fila, columna).isMarcada()); // Cambiado para alternar el estado de marcado
        System.out.println(tablero.getCasilla(fila, columna).isMarcada() ? "Casilla marcada." : "Casilla desmarcada.");
    }

    private int[] obtenerCoordenadas(String input) {
        if (input.length() < 2) return null;
        int fila = input.charAt(0) - 'A';
        int columna;
        try {
            columna = Integer.parseInt(input.substring(1)) - 1;
        } catch (NumberFormatException e) {
            return null;  // Manejo de entrada no válida.
        }
        if (fila < 0 || fila >= tablero.getFilas() || columna < 0 || columna >= tablero.getColumnas()) {
            throw new ArrayIndexOutOfBoundsException("Coordenadas fuera de los límites del tablero.");
        }
        return new int[]{fila, columna};
    }

    private void revelarCasilla(int fila, int columna) throws CasillaYaDescubiertaException {
        if (tablero.getCasilla(fila, columna).isRevelada()) {
            throw new CasillaYaDescubiertaException("La casilla ya ha sido descubierta.");
        }
        tablero.getCasilla(fila, columna).setDescubierta(true); // Cambiado para marcar la casilla como descubierta
        if (tablero.getCasilla(fila, columna).getMinasAlrededor() == 0) {
            for (int k = -1; k <= 1; k++) {
                for (int l = -1; l <= 1; l++) {
                    if (fila + k >= 0 && fila + k < tablero.getFilas() &&
                        columna + l >= 0 && columna + l < tablero.getColumnas()) {
                        revelarCasilla(fila + k, columna + l);
                    }
                }
            }
        }
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
