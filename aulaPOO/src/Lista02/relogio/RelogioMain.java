package Lista02.relogio;

public class RelogioMain {
    public static void main(String[] args) {
        Relogio meuRelogio = new Relogio(23, 59, 57);
        System.out.println("Hora inicial" + meuRelogio.exibirHorario());
        meuRelogio.adicionarSegundos(5);
        Relogio relogio1 = new Relogio(0,0,5); // 00:00:05
        Relogio relogio2 = new Relogio(15, 30,0); // 15:30:00
    System.out.println(relogio2.isMaiorQue(relogio1));
    }
}
