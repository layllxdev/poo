package Lista08.q2;

import java.util.HashMap;
import java.util.Map;

public class ServicoDeLogin {

    private Map<String, String> usuarios = new HashMap<>();

    public ServicoDeLogin() {

        usuarios.put("Laila", "RuannMeuAmor");
        usuarios.put("Ruann", "LailaMeuAmor");
        usuarios.put("Lis", "xyz9");
    }

    public String autenticar(String login, String senha)
            throws AutenticacaoException {

        if (!usuarios.containsKey(login)) {
            throw new AutenticacaoException("Usuário não encontrado");
        }

        if (!usuarios.get(login).equals(senha)) {
            throw new AutenticacaoException("Senha incorreta");
        }

        return "Bem-vindo, " + login + "!";
    }
}