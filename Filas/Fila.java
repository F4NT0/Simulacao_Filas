
public class Fila {
 
    private int clientesFila;
    private double tempoGlobal;
    private double[] estadosFila;


    /**
     * Construtor do Objeto de filas, necessita o valor da 
     * capacidade de clientes na fila como atributo
     * @param k
     */
    public Fila(int k) {
        this.estadosFila = new double[k+1];
        this.tempoGlobal = 0.0;
        this.clientesFila = 0;
    }

    /**
     * Método que contabiliza o tempo quando é feito uma chegada ou saida
     * @param tempo
     * @param clientesFila
     */
    public void contabilizaTempo(double tempo, int clientesFila) {
        double valorTempo = tempo - tempoGlobal;
        if (clientesFila <= estadosFila.length) {
            estadosFila[clientesFila] = estadosFila[clientesFila] + valorTempo;
            setTempoGlobal(tempoGlobal + valorTempo);
        }
    }

    // ==========================
    // INICIALIZADORES E UPDATES
    // ==========================

    /**
     * Incrementa o números de clientes na fila
     */
    public void updateClientesFila(){
        clientesFila++;
    }

    /**
     * Decrementa o número de clientes na fila
     */
    public void downgradeClientesFila() {
        clientesFila--;
    }

    /**
     * Inicia o vetor de estados da fila com zeros
     */
    public void initEstadosFila() {
        int verificador = 0;
        while (estadosFila.length > verificador) {
            estadosFila[verificador] = 0.0;
            verificador++;
        }
    }

    // =================
    // GETTERS E SETTERS
    // =================
    public double[] getEstadosFila() {
        return estadosFila;
    }

    public int getClientesFila() {
        return clientesFila;
    }

    public void setClientesFila(int clientesFila) {
        this.clientesFila = clientesFila;
    }

    public double getTempoGlobal() {
        return tempoGlobal;
    }

    public void setTempoGlobal(double tempoGlobal) {
        this.tempoGlobal = tempoGlobal;
    }
}
