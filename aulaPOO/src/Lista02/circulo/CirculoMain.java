package Lista02.circulo;

public class CirculoMain {
    public static void main(String[] args) {
        Circulo circulo1 = new Circulo(5);
        Circulo circulo2 = new Circulo(3);
        circulo1.raio = circulo1.raio * 2;
        circulo1.exibirDados();
        circulo2.exibirDados();
        circulo1.contemOutro(circulo2);
    }
}
