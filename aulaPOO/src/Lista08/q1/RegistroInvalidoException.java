package Lista08.q1;

public class RegistroInvalidoException extends Throwable {

        private int numeroLinha;

        public RegistroInvalidoException(String mensagem, int numeroLinha) {
            super(mensagem);
            this.numeroLinha = numeroLinha;
        }

        public RegistroInvalidoException(String mensagem, int numeroLinha, Throwable causa) {
            super(mensagem, causa);
            this.numeroLinha = numeroLinha;
        }

        public int getNumeroLinha() {
            return numeroLinha;
        }
    }

