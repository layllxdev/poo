package Lista02.estudante;

public class EstudanteMain {
    public static void main(String[]args){
        Estudante laila = new Estudante("Laila", 35271, 10,8,7,9);
        laila.getSituacao();
        laila.setNotas(8,2,4);
        laila.getSituacao();
    }
}
