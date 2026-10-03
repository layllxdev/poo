package Lista02.relogio;

public class Relogio {
    int horas;
    int minutos;
    int segundos;
    public Relogio(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }
    public void tick() {
        this.segundos++;
        if (this.segundos == 60) {
            this.segundos = 0;
            this.minutos++;

            if (this.minutos == 60) {
                this.minutos = 0;
                this.horas++;

                if (this.horas == 240) {
                    this.horas = 0;
                }
            }
        }
    }
    public void adicionarSegundos(int segundosAdd) {
        for (int i = 0; i < segundosAdd; i++){
            this.tick();
            System.out.println("tick..." + this.exibirHorario());
        }
    }
    public String exibirHorario() {return String.format("%02d:%02d:%02d", this.horas, this.minutos, this.segundos);}
    public boolean isMaiorQue(Relogio outro) {
        int totalSegundosEste = (this.horas * 3600) + (this.minutos * 60) + this.segundos;
        int totalSegundosOutro = (outro.horas * 3600) + (outro.minutos * 60) + outro.segundos;
        return totalSegundosEste > totalSegundosOutro;
    }
}