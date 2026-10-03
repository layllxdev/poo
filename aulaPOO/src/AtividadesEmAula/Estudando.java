package AtividadesEmAula;// Crie um programa que lê os dados de um estudante (Nome e CPF)
// O seu programa deve sempre pedir ao usuário para digitar
// novamente o CPF caso o valor digitado seja inválido (se setCpf()
// lança exceção.
//
// Digite seu nome: antonio
// Digite seu CPF: 123
// CPF deve ter 11 dígitos.
// Digite seu CPF: 1234
// CPF deve ter 11 dígitos.
// Digite seu CPF: 12312312312
// Cadastro concluido para:
// Nome: antonio
// CPF: 12312312312

import java.util.Scanner;
public class Estudando {

    public class CadastroSimples{
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite seu nome: ");
            String nome;
            nome = scanner.nextLine();

            String cpf;
            while (true) {
                System.out.println("Digite seu cpf: ");
                cpf = scanner.nextLine();

                if (cpf.length() == 11 && cpf.matches("\\d+")) {
                    break;
                } else {
                    System.out.println("CPF deve ter 11 dígitos.");
                }

            }

            System.out.println("Cadastro concluído");
            System.out.println("Nome: " + nome);
            System.out.println("CPF: " + cpf);
        }
    }
}
