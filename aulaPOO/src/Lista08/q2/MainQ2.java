package Lista08.q2;

import java.util.Scanner;

public class MainQ2 {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            ServicoDeLogin servico = new ServicoDeLogin();

            try {

                System.out.print("Login: ");
                String login = scanner.nextLine();

                System.out.print("Senha: ");
                String senha = scanner.nextLine();

                String mensagem = servico.autenticar(login, senha);

                System.out.println(mensagem);

            } catch (AutenticacaoException e) {

                System.out.println("Erro: " + e.getMessage());

            } finally {

                scanner.close();

                System.out.println("Conexão encerrada.");
            }
        }
    }

