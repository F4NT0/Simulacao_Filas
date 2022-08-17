
public class Fila {

    private int c; 
    private int k;
    private int chMin;
    private int chMax;
    private int atendMin;
    private int atendMax;
    private int clientesFila;
    private double tempoGlobal;
    private double[] estadosFila;


    public Fila(int c, int k, int chMin, int chMax, int atendMin, int atendMax) {
        this.c = c;
        this.k = k;
        this.chMin = chMin;
        this.chMax = chMax;
        this.atendMin = atendMin;
        this.atendMax = atendMax;
        this.estadosFila = new double[k+1];
    }

    public void contabilizaTempo(double tempo, int clientesFila) {
        double valorTempo = tempo - estadosFila[clientesFila];
        estadosFila[clientesFila] = valorTempo;
        setTempoGlobal(getTempoGlobal() + valorTempo);
    }

    public double[] getEstadosFila() {
        return estadosFila;
    }

    public void initEstadosFila() {
        int verificador = 0;
        while (estadosFila.length > verificador) {
            estadosFila[verificador] = 0.0;
            verificador++;
        }
    }

    public int getClientesFila() {
        return clientesFila;
    }

    public void setClientesFila(int clientesFila) {
        this.clientesFila = clientesFila;
    }

    public void initClientesFila() {
        this.clientesFila = 0;
    }

    public double getTempoGlobal() {
        return tempoGlobal;
    }

    public void setTempoGlobal(double tempoGlobal) {
        this.tempoGlobal = tempoGlobal;
    }

    public void initTempoGlobal() {
        this.tempoGlobal = 0.0;
    }

    public int getC() {
        return c;
    }

    public int getK() {
        return k;
    }

    public int getChMin() {
        return chMin;
    }

    public int getChMax() {
        return chMax;
    }

    public int getAtendMin() {
        return atendMin;
    }

    public int getAtendMax() {
        return atendMax;
    }
}
