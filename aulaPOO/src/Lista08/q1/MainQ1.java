package Lista08.q1;

public class MainQ1 {

        public static void main(String[] args) {

            ProcessadorDeAlunos processador = new ProcessadorDeAlunos();

            try {

                processador.processar("alunos.csv");

            } catch (RegistroInvalidoException e) {

                System.out.println("Erro no registro — " + e.getMessage());

                System.out.println("Número da linha: " + e.getNumeroLinha());

                if (e.getCause() != null) {
                    System.out.println("  Causa: " + e.getCause());
                }

            } finally {

                System.out.println("Processamento encerrado.");
            }
        }
    }

