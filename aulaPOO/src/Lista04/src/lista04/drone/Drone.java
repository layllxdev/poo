package Lista04.src.lista04.drone;

public class Drone {

    private String identificador;
    private int bateria;
    private int altitude;
    private boolean emVoo;

    public Drone(String identificador) {
        if (identificador == null || identificador.trim().equals("")) {
            throw new IllegalArgumentException("Identificador inválido");
        }

        this.identificador = identificador;
        this.bateria = 0;
        this.altitude = 0;
        this.emVoo = false;
    }

    public String getIdentificador() {
        return identificador;
    }

    public int getBateria() {
        return bateria;
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isEmVoo() {
        return emVoo;
    }

    public void setBateria(int valor) {
        if (valor < 0 || valor > 100) {
            throw new IllegalArgumentException("Valor de bateria inválida: " + valor + "(esperando 0-100)");
        }
        this.bateria = valor;

    }

    public void setAltitude(int metros) {
        if (!emVoo) {
            return;
        }

        if (metros < 0 || metros > 120) {
            throw new IllegalArgumentException("Altitude inválida");
        }

        this.altitude = metros;
    }

    public void decolar() {
        if (bateria > 20) {
            emVoo = true;
        }
    }

    public void pousar() {
        emVoo = false;
        altitude = 0;
    }
}
