package Lista07.q2;

import java.util.List;

public class BackupService {

    public static void realizarBackup(Armazenamento origem, Armazenamento destino, List<String> caminhos) {

        for (String c : caminhos) { //loop em cada caminho
            byte[] dados = origem.ler(c); //lê da origem
            if (dados != null) {
                destino.gravar(c, dados);
            }
        }
    }
}
