package Lista05.treino;

    public class Serie {
        private String nomeExercicio;
        private int repeticoes;
        private double cargaKg;

        public Serie(String nomeExercicio, int repeticoes, double cargaKg) {
            this.nomeExercicio = nomeExercicio;
            this.repeticoes = repeticoes;
            this.cargaKg = cargaKg;
        }

        public String getNomeExercicio() {
            return nomeExercicio;
        }

        public int getRepeticoes() {
            return repeticoes;
        }

        public double getCargaKg() {
            return cargaKg;
        }

        public String linha() {
            return nomeExercicio + ": " + repeticoes + "x " + (int)cargaKg + "kg";
        }
    }
