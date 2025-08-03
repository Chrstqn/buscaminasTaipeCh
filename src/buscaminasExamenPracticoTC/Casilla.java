package buscaminasExamenPracticoTC;

public class Casilla {
    private boolean tieneMina;
    private boolean descubierta;
    private boolean marcada; // Nuevo atributo para indicar si la casilla está marcada
    private int minasAlrededor;

    public Casilla() {
        this.tieneMina = false;
        this.descubierta = false;
        this.marcada = false; // Inicializamos marcada a false
        this.minasAlrededor = 0;
    }

    // Getters y setters para los atributos

    public boolean tieneMina() {
        return tieneMina;
    }

    public void setTieneMina(boolean tieneMina) {
        this.tieneMina = tieneMina;
    }

    public boolean estaDescubierta() {
        return descubierta;
    }

    public void setDescubierta(boolean descubierta) {
        this.descubierta = descubierta;
    }

    public boolean isMarcada() {
        return marcada; // Retorna si la casilla está marcada
    }

    public void setMarcada(boolean marcada) { // Nuevo setter para marcar/desmarcar la casilla
        this.marcada = marcada;
    }

    public int getMinasAlrededor() {
        return minasAlrededor;
    }

    public void setMinasAlrededor(int minasAlrededor) {
        this.minasAlrededor = minasAlrededor;
    }

    public void colocarMina() {
        this.tieneMina = true; // Marca la casilla como que tiene una mina
    }

    public boolean isRevelada() {
        return this.descubierta; // Retorna si la casilla está descubierta
    }
}
