package buscaminasExamenPracticoTC;

import org.junit.Test;
import static org.junit.Assert.*; // Importa todas las aserciones de JUnit

public class BuscaminasTestSuite {
    private ControladorJuego controlador;
    private TableroBM tablero;

    @Test
    public void testMarcarCasilla() {
        // Prueba para marcar una casilla
        controlador.marcarCasilla("A1");
        assertTrue("La casilla A1 debería estar marcada", tablero.getCasilla(0, 0).isMarcada());

        // Desmarcar la casilla
        controlador.marcarCasilla("A1");
        assertFalse("La casilla A1 debería estar desmarcada", tablero.getCasilla(0, 0).isMarcada());
    }

    @Test
    public void testObtenerCoordenadas() {
        // Prueba para obtener coordenadas válidas
        int[] coordenadas = controlador.obtenerCoordenadas("B2");
        assertArrayEquals(new int[]{1, 1}, coordenadas);

        // Prueba para coordenadas inválidas
        int[] coordenadasInvalidas = controlador.obtenerCoordenadas("Z9");
        assertNull(coordenadasInvalidas);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testObtenerCoordenadasFueraDeLimites() {
        // Prueba para coordenadas fuera de los límites
        controlador.obtenerCoordenadas("E6"); // Debería lanzar excepción
    }

    @Test
    public void testRevelarCasilla() throws CasillaYaDescubiertaException {
        // Prueba para revelar una casilla
        tablero.getCasilla(0, 0).setMinasAlrededor(0); // Asegúrate de que no hay minas alrededor
        controlador.revelarCasilla(0, 0);
        assertTrue(tablero.getCasilla(0, 0).isRevelada());
    }

    @Test(expected = CasillaYaDescubiertaException.class)
    public void testRevelarCasillaYaDescubierta() throws CasillaYaDescubiertaException {
        // Prueba para intentar revelar una casilla ya descubierta
        tablero.getCasilla(0, 0).setDescubierta(true);
        controlador.revelarCasilla(0, 0); // Debería lanzar excepción
    }

    // Pruebas para TableroBM
    @Test
    public void testInicializacionCasillas() {
        // Verifica que todas las casillas se inicialicen correctamente
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                assertNotNull(tablero.getCasilla(i, j));
            }
        }
    }

    @Test
    public void testColocarMinas() {
        // Verifica que se coloquen el número correcto de minas
        int minasContadas = 0;
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                if (tablero.getCasilla(i, j).tieneMina()) {
                    minasContadas++;
                }
            }
        }
        assertEquals(3, minasContadas); // Asegúrate de que se coloquen 3 minas
    }

    @Test
    public void testCalcularMinasAlrededor() {
        // Verifica que las minas alrededor se calculen correctamente
        tablero.getCasilla(1, 1).colocarMina(); // Coloca una mina manualmente
        tablero.calcularMinasAlrededor(); // Calcula las minas alrededor

        // Verifica que las casillas alrededor de (1, 1) se actualicen correctamente
        assertEquals(1, tablero.getCasilla(0, 0).getMinasAlrededor());
        assertEquals(1, tablero.getCasilla(0, 1).getMinasAlrededor());
        assertEquals(1, tablero.getCasilla(1, 0).getMinasAlrededor());
        assertEquals(0, tablero.getCasilla(2, 2).getMinasAlrededor()); // Sin minas alrededor
    }

    @Test
    public void testJuegoGanado() {
        // Verifica que el juego se considere ganado correctamente
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                if (!tablero.getCasilla(i, j).tieneMina()) {
                    tablero.getCasilla(i, j).setDescubierta(true); // Marca como descubierta
                }
            }
        }
        assertTrue(tablero.juegoGanado()); // Debería ser verdadero si todas las casillas sin mina están descubiertas
    }
}
