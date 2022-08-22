
public class Fila {
 
    private int clientesFila;
    private double tempoGlobal;
    private double[] estadosFila;


    public Fila(int k) {
        this.estadosFila = new double[k+1];
        this.tempoGlobal = 0.0;
        this.clientesFila = 0;
    }

    public void contabilizaTempo(double tempo, int clientesFila) {
        double valorTempo = tempo - estadosFila[clientesFila];
        if (clientesFila <= estadosFila.length) {
            estadosFila[clientesFila] = valorTempo;
            setTempoGlobal(getTempoGlobal() + valorTempo);
        }
    }

    // INICIALIZADORES E UPDATES

    public void updateClientesFila(){
        clientesFila++;
    }

    public void initEstadosFila() {
        int verificador = 0;
        while (estadosFila.length > verificador) {
            estadosFila[verificador] = 0.0;
            verificador++;
        }
    }


    // GETTERS E SETTERS

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
