package Lista02.estudante;

public class Estudante {
    String nome;
    int matricula;
    double[] notas;
    public Estudante(String nome, int matricula,  double... notas){
        this.nome = nome;
        this.matricula = matricula;
        this.notas = notas;
    }
    public void setNotas(double... novasNotas) { this.notas = novasNotas; }

    public double getMedia(){
        if (this.notas.length == 0){
            System.out.println("Sem nota cadastrada");
            return 0;
        }
        double soma;
        soma = 0;
        for (int x = 0;x<notas.length;x++){
            soma +=notas[x];
        }
        double media = soma / this.notas.length;
        System.out.printf("Media: %.2f \n", media);
        return media;
    }
    public double getNota(int indice){
        if (this.notas.length == 0 || indice < 0 || indice >= this.notas.length){
            System.out.println("Sem nota cadastrada");
            return -1;
        }
        double notaEncontrada = this.notas[indice];
        System.out.println("Nota" + indice + "é" + notaEncontrada);
        return notaEncontrada;
    }
    public void getSituacao(){
        double mediaFinal = getMedia();
        if(mediaFinal >= 7){
            System.out.println("Aprovado");
        } else if (mediaFinal >= 4 && mediaFinal < 7){
            System.out.println("Final");
        } else {
            System.out.println("Reprovado");
        }
    }
}
