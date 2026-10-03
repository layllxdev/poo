package Lista02.temperatura;

public class TemperaturaMain {
    public static void main(String[]args){
        Temperatura tempInicial = new Temperatura(25, "C");
        Temperatura tempFahrenheit = tempInicial.toFahrenheit();
        tempFahrenheit.imprimeComEscala();
        Temperatura tempKelvin = tempInicial.toKelvin();
        tempKelvin.imprimeComEscala();
        Temperatura tempCelsius = tempInicial.toCelsius();
        tempCelsius.imprimeComEscala();
    }
}