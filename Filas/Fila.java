
public class Fila {
 
    private int clientesFila;
    
    private double[] estadosFila;
    private int perdaClientes;


    /**
     * Construtor do Objeto de filas, necessita o valor da 
     * capacidade de clientes na fila como atributo
     * @param k
     */
    public Fila(int k) {
        this.estadosFila = new double[k+1];
        this.clientesFila = 0;
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

    public void setEstadosFila(int i, double value) {
        estadosFila[i] = value;
    }

    public int getClientesFila() {
        return clientesFila;
    }

    public void setClientesFila(int clientesFila) {
        this.clientesFila = clientesFila;
    }

    public int getPerdaClientes() {
        return perdaClientes;
    }

    public void setPerdaClientes(int perdaClientes) {
        this.perdaClientes = perdaClientes;
    }
}
