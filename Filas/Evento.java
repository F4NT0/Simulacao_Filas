
/**
 * Classe Objeto do Evento com o tipo e o tempo
 */
public class Evento {
    public static enum TipoEvento {
        CHEGADA,
        SAIDA,
        PASSAGEM
    }

    private TipoEvento tipoEvento;
    private double tempo;
    private Fila from;
    private Fila to;

    /**
     * Construtor do objeto Evento
     * @param tipoEvento
     * @param tempo
     */
    public Evento(TipoEvento tipoEvento, double tempo, Fila from, Fila to) {
        this.tipoEvento = tipoEvento;
        this.tempo = tempo;
        this.from = from;
        this.to = to;
    }

    public Fila getOrigem(){
        return from;
    }

    public Fila getDestino(){
        return to;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public double getTempo() {
        return tempo;
    }
}
