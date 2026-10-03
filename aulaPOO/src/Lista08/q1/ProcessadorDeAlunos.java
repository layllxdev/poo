package Lista08.q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcessadorDeAlunos {


        public void processar(String caminhoArquivo)
                throws RegistroInvalidoException {

            try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {

                String linha;
                int numeroLinha = 0;

                while ((linha = br.readLine()) != null) {

                    numeroLinha++;

                    String[] campos = linha.split(";");

                    String nome = campos[0];
                    String idadeTexto = campos[1];
                    String notaTexto = campos[2];

                    if (nome.trim().isEmpty()) {
                        throw new Throwable(
                        );
                    }

                    int idade;

                    try {
                        idade = Integer.parseInt(idadeTexto);

                    } catch (NumberFormatException e) {

                        throw new Throwable(
                        );
                    }

                    double nota = Double.parseDouble(notaTexto);

                    if (nota < 0 || nota > 10) {
                        throw new Throwable(
                        );
                    }

                    System.out.println(
                            "Aluno registrado: " +
                                    nome +
                                    ", idade " +
                                    idade +
                                    ", nota " +
                                    nota
                    );
                }

            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

