package Lista02.temperatura;

public class Temperatura {
    double valor;
    String escala;
    public Temperatura(double valor, String escala) {
        this.escala = escala.toUpperCase();
        if (!this.escala.equals("C")&& !this.escala.equals("F") && !this.escala.equals("K")) {
            System.out.println("Escala invalida");
            this.escala="C";
        }
        if (!this.escala.equals("K") && valor < 0) {
            System.out.println("A temperatura em Kelvin nunca pode ser negstiva");
            this.valor = 0;
        } else {
            this.valor = valor;
        }
    }
    public Temperatura toCelsius() {
        if (this.escala.equals("C")){
            return new Temperatura(this.valor, "C");
        }
        double celsius = 0;
        if (this.escala.equals("F")) {
            celsius = (this.valor - 32) * 5 / 9;
        } else if (this.escala.equals("K")) {
            celsius = this.valor - 273.15;
        }
        return new Temperatura(celsius, "C");
    }
    public Temperatura toFahrenheit() {
        if (this.escala.equals("F")){
            return new Temperatura(this.valor, "F");
        }
        double fahrenheit = 0;
        if (this.escala.equals("C")) {
            fahrenheit = (this.valor * 9 / 5) + 32;
        } else if (this.escala.equals("K")) {
            fahrenheit = (this.valor - 273.15) * 9 / 5 + 32;
        }
        return new Temperatura(fahrenheit, "F");
    }
    public Temperatura toKelvin() {
        if (this.escala.equals("K")){
            return new Temperatura(this.valor, "K");
        }
        double kelvin = 0;
        if (this.escala.equals("C")) {
            kelvin = this.valor + 273.15;
        } else if (this.escala.equals("F")) {
            kelvin = (this.valor - 32) * 5 / 9 + 273.15;
        }
        return new Temperatura(kelvin, "K");
    }
    public void imprimeComEscala() {System.out.printf("%.2f °%s\n", this.valor, this.escala); }
}