package Lista02.conta;

public class ContaCorrente {
    String titular;
    double saldo;
    int numeroConta;
    public ContaCorrente (String titular, int numeroConta){
        this.titular = titular;
        this.saldo = 0.0;
        this.numeroConta = numeroConta;
    }
    public void depositar(double valor){
        if (valor > 0){
            this.saldo += valor;
        } else {
            System.out.println("Valor invalido para deposito");
        }
    }
    public void sacar(double valor){
        if (valor > 0 && valor <= this.saldo){
            this.saldo -= valor;
        } else {
            System.out.println("Saque invalido");
        }
    }
    public void getSaldo(){
        System.out.printf("Titular: %s Numero da conta: %s Saldo: %.2f \n", this.titular, this.numeroConta, this.saldo);
    }
    public void transferencia(ContaCorrente destino, double valor){
        if (destino != null && valor > 0 && valor <= this.saldo){
            this.saldo -= valor;
            destino.saldo += valor;
        } else {
            System.out.println("Transferencia invalida");
        }
    }
}
