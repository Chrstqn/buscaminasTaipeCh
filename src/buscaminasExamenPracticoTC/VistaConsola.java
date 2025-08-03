package buscaminasExamenPracticoTC;

public class VistaConsola {
    public void imprimirTablero(TableroBM tablero) {
        System.out.print(" ");
        for (int i = 0; i < tablero.getColumnas(); i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < tablero.getFilas(); i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < tablero.getColumnas(); j++) {
                Casilla casilla = tablero.getCasilla(i, j);
                if (casilla.isRevelada()) {
                    if (casilla.tieneMina()) {
                        System.out.print("X ");
                    } else {
                        System.out.print(casilla.getMinasAlrededor() + " ");
                    }
                } else {
                    System.out.print(casilla.isMarcada() ? "M " : ". ");
                }
            }
            System.out.println();
        }
    }

    public void imprimirTableroCompleto(TableroBM tablero) {
        System.out.print(" ");
        for (int i = 0; i < tablero.getColumnas(); i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < tablero.getFilas(); i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < tablero.getColumnas(); j++) {
                Casilla casilla = tablero.getCasilla(i, j);
                if (casilla.tieneMina()) {
                    System.out.print("X ");
                } else {
                    System.out.print(casilla.getMinasAlrededor() + " ");
                }
            }
            System.out.println();
        }
    }
}
