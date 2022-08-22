import java.util.ArrayList;

/**
 * Algoritmo da simulação da Fila
 */
public class Algoritmo {

    private int c, k, chMin, chMax, atendMin, atendMax;
    private Random random;
    private Fila fila;
    private Escalonador escalonador;
    private int perdaClientes;

    /**
     * Construtor do Objeto do algoritmo de chegadas e saídas
    */
    public Algoritmo(int c, int k, int chMin, int chMax, int atendMin, int atendMax, ArrayList<Double> valoresAleatorios) {
        this.c = c;
        this.k = k;
        this.chMin = chMin;
        this.chMax = chMax;
        this.atendMin = atendMin;
        this.atendMax = atendMax;
        this.random = new Random(valoresAleatorios);
        this.fila = new Fila(k);
        this.escalonador = new Escalonador();
    }

    /**
     * Método do algoritmo tratando chegadas
     * @param evento
    */
    public void chegada(Evento evento) {
        
        fila.contabilizaTempo(evento.getTempo(), fila.getClientesFila());
        if (fila.getClientesFila() < 3) {
            fila.updateClientesFila();
        }
        if (fila.getClientesFila() <= 1) {
            double aleatorio = random.pegaPrimeiroAleatorio();
            double pseudoAleatorio = random.pseudoAleatorio(aleatorio, atendMin, atendMax);
            Evento eventoSaida = new Evento("sa",(fila.getTempoGlobal() + pseudoAleatorio));
            escalonador.add(eventoSaida);
        } else {
            perdaClientes++;
        }

        // nova chegada
        double aleatorio = random.pegaPrimeiroAleatorio();
        double pseudoAleatorio = random.pseudoAleatorio(aleatorio, chMin, chMax);
        Evento novoEvento = new Evento("ch", (fila.getTempoGlobal() + pseudoAleatorio));
        escalonador.add(novoEvento);
    } 

    /**
     * Método do algoritmo tratando saídas
     * @param evento
    */
    public void saida(Evento evento) {
        fila.contabilizaTempo(evento.getTempo(), fila.getClientesFila());
        fila.downgradeClientesFila();
        if (fila.getClientesFila() >= 1) {
            double aleatorio = random.pegaPrimeiroAleatorio();
            double pseudoAleatorio = random.pseudoAleatorio(aleatorio, atendMin, atendMax);
            Evento eventoSaida = new Evento("sa",(fila.getTempoGlobal() + pseudoAleatorio));
            escalonador.add(eventoSaida);
        }
    }

    public void filaEstadosAtualizado() {
        double filaSalva[] = fila.getEstadosFila();
        for (int i = 0 ; i < filaSalva.length ; i++) {
            System.out.println("Array [" + i + "] = " + filaSalva[i]);
        }
    }

    /**
     * Método para criar o primeiro evento
     * @param tipo
     * @param tempoInicial
    */
    public void primeiroEvento(String tipo, double tempoInicial) {
        Evento evento = new Evento(tipo, tempoInicial);
        escalonador.add(evento);
    }

    // GETTERS E SETTERS
    
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

    public Random getRandom() {
        return random;
    }

    public Fila getFila() {
        return fila;
    }

    public Escalonador getEscalonador() {
        return escalonador;
    }

    public int getPerdaClientes() {
        return perdaClientes;
    }
}
