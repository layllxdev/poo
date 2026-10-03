package Lista02.circulo;

public class Circulo {
    double raio;

    public Circulo(int raio) {
    }

    public double calcularArea(){
        double area = Math.PI * raio * raio;
        return area;
    }
    public double calcularCircunferencia(){
        double circunferencia = 2 * Math.PI * raio;
        return circunferencia;
    }
    public boolean contemOutro(Circulo outro) {
        if (this.raio > outro.raio) {
            return true;
        } else {
            return false;
        }
    }
    public Circulo maior(Circulo outro) {
        if (this.raio > outro.raio) {
            return this;
        } else {
            return outro;
        }
    }
    public void exibirDados() {
        String texto = String.format("Raio: %.2f Circunferencia: %.2f", this.raio, this.calcularArea(), this.calcularCircunferencia());
        System.out.println(texto);
    }
}
