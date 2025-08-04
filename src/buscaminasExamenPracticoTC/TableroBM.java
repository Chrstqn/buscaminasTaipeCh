package buscaminasExamenPracticoTC;

import java.io.Serializable;
import java.util.Random;

public class TableroBM implements Serializable {
    private static final long serialVersionUID = 1L;
    private int filas;
    private int columnas;
    private int minas;
    private Casilla[][] casillas;

    public TableroBM(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        this.casillas = new Casilla[filas][columnas];
        inicializarCasillas();
        colocarMinas();
        calcularMinasAlrededor();
    }
    
    private void inicializarCasillas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla();
            }
        }
    }

    private void colocarMinas() {
        Random random = new Random();
        int minasColocadas = 0;
        while (minasColocadas < minas) {
            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);
            if (!casillas[fila][columna].tieneMina()) {
                casillas[fila][columna].colocarMina();
                minasColocadas++;
            }
        }
    }

    void calcularMinasAlrededor() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (casillas[i][j].tieneMina()) {
                    continue;
                }
                int contador = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        if (i + k >= 0 && i + k < filas && j + l >= 0 && j + l < columnas && casillas[i + k][j + l].tieneMina()) {
                            contador++;
                        }
                    }
                }
                casillas[i][j].setMinasAlrededor(contador);
            }
        }
    }

    public Casilla getCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public boolean juegoGanado() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!casillas[i][j].tieneMina() && !casillas[i][j].isRevelada()) {
                    return false;
                }
            }
        }
        return true;
    }
}
