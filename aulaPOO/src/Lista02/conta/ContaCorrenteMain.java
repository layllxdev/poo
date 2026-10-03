package Lista02.conta;

public class ContaCorrenteMain {
    public static void main(String[]args){
        ContaCorrente conta1 =  new ContaCorrente("Laila", 1234);
        ContaCorrente conta2 = new ContaCorrente("Ruann", 1223);
        conta1.depositar(50);
        conta2.depositar(20);
        conta1.sacar(10);
        conta2.sacar(10);
        conta2.sacar(20);
        conta1.getSaldo();
        conta1.transferencia(conta2,10);
        conta2.getSaldo();
    }
}
