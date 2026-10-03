package Lista05.treino;

import java.util.ArrayList;
import java.util.List;

    public class Treino {
        private Usuario usuario;
        private List<Serie> series = new ArrayList<>();

        public Treino(Usuario usuario) {
            this.usuario = usuario;
        }

        public void adicionarSerie(Serie s) {
            series.add(s);
        }

        public void adicionarSerie(String exercicio, int repeticoes, double cargaKg) {
            series.add(new Serie(exercicio, repeticoes, cargaKg));
        }

        public double calcularVolume() {
            double total = 0;
            for (Serie s : series) {
                total += s.getRepeticoes() * s.getCargaKg();
            }
            return total;
        }

        public double calcularVolume(String nomeExercicio) {
            double total = 0;
            for (Serie s : series) {
                if (s.getNomeExercicio().equalsIgnoreCase(nomeExercicio)) {
                    total += s.getRepeticoes() * s.getCargaKg();
                }
            }
            return total;
        }

        public int fcMaxima() {
            if (usuario.getSexo().equalsIgnoreCase("M")) {
                return 220 - usuario.getIdadeAnos();
            } else {
                return 226 - usuario.getIdadeAnos();
            }
        }

        public String avaliar() {
            double volume = calcularVolume();
            double imc = usuario.calcularIMC();

            if (imc < 18.5 || imc > 29.9) {
                return "Consulte um profissional";
            }

            if (volume >= 1000) {
                return "Treino adequado";
            } else {
                return "Aumentar carga";
            }
        }

        public String relatorio() {
            StringBuilder sb = new StringBuilder();

            sb.append(usuario.resumo()).append("\n");

            for (Serie s : series) {
                sb.append(s.linha()).append("\n");
            }

            sb.append("Volume total: ").append(calcularVolume());

            return sb.toString();
        }
    }

