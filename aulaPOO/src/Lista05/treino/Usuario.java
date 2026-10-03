package Lista05.treino;

public class Usuario {
    String nome;
    double pesoKg;
    double alturaM;
    int idadeAnos;
    String sexo;

    public Usuario(String nome, double pesoKg, double alturaM, int idadeAnos, String sexo) {
        this.nome = nome;
        this.pesoKg = pesoKg;
        this.alturaM = alturaM;
        this.idadeAnos = idadeAnos;
        this.sexo = sexo;
    }

    public int getIdadeAnos() {
        return idadeAnos;
    }

    public String getSexo() {
        return sexo;
    }

    public double calcularIMC() {
        return pesoKg / (alturaM * alturaM);
    }

    public String resumo() {
        return nome + " | " + idadeAnos + " anos | " + (int)pesoKg + "kg";
    }
}
