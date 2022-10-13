public class Fila {
    private int clients;
    private int servers;
    private int capacity;
    private int lost_clients;
    private int min_arrival_time;
    private int max_arrival_time;
    private int min_service_time;
    private int max_service_time;

    /**
     * Construtor do Objeto de fila
     */
    public Fila(int c, int k, int min_arrival_time, int max_arrival_time, int min_time_of_service, int max_time_of_service) {
        this.clients = 0;
        this.servers = c;
        this.capacity = k;
        this.lost_clients = 0;
        this.min_arrival_time = min_arrival_time;
        this.max_arrival_time = max_arrival_time;
        this.min_service_time = min_time_of_service;
        this.max_service_time = max_time_of_service;
    }

    public void addClients() {
        if(this.clients < this.capacity) {
            this.clients++;
        }
        else {
            this.lost_clients++;
        }
    }

    public void removeClients() {
        if(this.clients > 0) 
            this.clients--;
    }

    public int getClients() {
        return clients;
    }

    public void setClients(int clientesFila) {
        this.clients = clientesFila;
    }

    public int getLostClients() {
        return lost_clients;
    }

    public void setLostClients(int lost_clients) {
        this.lost_clients = lost_clients;
    }


    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other != this) return false;
        return true;
    }

    @Override
    public String toString() {
        return "(" + this.clients + ", " + this.servers + ", " + this.lost_clients + ")";
    }
}
















public class Fila {
 
    private int clientesFila;
    
    private double[] estadosFila;
    private int lost_clients;


    /**
     * Construtor do Objeto de fila
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

    public int getlost_clients() {
        return lost_clients;
    }

    public void setlost_clients(int lost_clients) {
        this.lost_clients = lost_clients;
    }
}
