
/**
 * Classe Objeto do Evento com o tipo e o tempo
 */
public class Evento {
    private String tipoEvento;
    private double tempo;
    private int numFila;

    /**
     * Construtor do objeto Evento
     * @param tipoEvento
     * @param tempo
     */
    public Evento(String tipoEvento, double tempo, int numFila) {
        this.tipoEvento = tipoEvento;
        this.tempo = tempo;
        this.numFila = numFila;
    }

    // =================
    // GETTERS E SETTERS
    // =================
    public int getNumFila() {
        return numFila;
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
