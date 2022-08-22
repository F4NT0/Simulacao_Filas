
/**
 * Classe Objeto do Evento com o tipo e o tempo
 */
public class Evento {
    private String tipoEvento;
    private double tempo;

    public Evento(String tipoEvento, double tempo) {
        this.tipoEvento = tipoEvento;
        this.tempo = tempo;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }
}
