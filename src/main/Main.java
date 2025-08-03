package main;

import java.util.Scanner;

import buscaminasExamenPracticoTC.ControladorJuego;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Solicitar y obtener el nombre del jugador
        System.out.print("Ingrese su nombre: ");
        String nombreJugador = scanner.nextLine();

        // 2. Crear una instancia de ControladorJuego
        // Ajusta los parámetros según tus necesidades (filas, columnas, minas)
        int filas = 10;
        int columnas = 10;
        int minas = 10;
        ControladorJuego juego = new ControladorJuego(filas, columnas, minas, nombreJugador);

        // 3. Iniciar el juego
        juego.iniciar();

        // 4. Cerrar el Scanner (buena práctica)
        scanner.close();
    }
}
