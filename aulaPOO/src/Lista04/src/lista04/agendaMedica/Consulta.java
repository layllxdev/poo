package Lista04.src.lista04.agendaMedica;

public class Consulta {

    private int id;
    private String nomePaciente;
    private String nomeMedico;
    private String dataHora;
    private String status;
    private String observacoes;

    public Consulta(int id, String nomePaciente, String nomeMedico, String dataHora, String status) {

        if (id <= 0)
            throw new IllegalArgumentException();

        if (nomePaciente == null || nomePaciente.trim().equals(""))
            throw new IllegalArgumentException();

        if (nomeMedico == null || nomeMedico.trim().equals(""))
            throw new IllegalArgumentException();

        if (dataHora == null || dataHora.trim().equals(""))
            throw new IllegalArgumentException();

        this.id = id;
        this.nomePaciente = nomePaciente;
        this.nomeMedico = nomeMedico;
        this.dataHora = dataHora;
        this.status = "AGENDADA";
        this.observacoes = "";
    }

    public int getId() { return id; }
    public String getNomePaciente() { return nomePaciente; }
    public String getNomeMedico() { return nomeMedico; }
    public String getDataHora() { return dataHora; }
    public String getStatus() { return status; }
    public String getObservacoes() { return observacoes; }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void confirmar() {
        if (status.equals("AGENDADA")) {
            status = "CONFIRMADA";
        }
    }

    public void cancelar() {
        if (status.equals("AGENDADA") || status.equals("CONFIRMADA")) {
            status = "CANCELADA";
        }
    }

    public void realizar() {
        if (status.equals("CONFIRMADA")) {
        status = "REALIZADA";
        }
    }
}
