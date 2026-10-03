package Lista07.q2;

import java.util.List;

public class MainQ2 {

    public static void main(String[] args) {

        Armazenamento nuvemOrigem = new ArmazenamentoNuvem(); //cria origem na nuvem
        nuvemOrigem.gravar("arquivo.txt", "ola mundo".getBytes()); //salva um arquivo

        Armazenamento nuvemDestino = new ArmazenamentoNuvem();

        //adiciona cache sem quebrar nada
        Armazenamento origemComCache = new ArmazenamentoComCache(nuvemOrigem);
        Armazenamento destinoComCache = new ArmazenamentoComCache(nuvemDestino);

        BackupService.realizarBackup(
                origemComCache,
                destinoComCache,
                List.of("arquivo.txt") //executa o backup
        );

        System.out.println(new String(nuvemDestino.ler("arquivo.txt")));
    }
}