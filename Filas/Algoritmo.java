
/**
 * Classe com o Algoritmo da simulação da Fila
 */
public class Algoritmo {

    private int c, k, chMin, chMax, atendMin, atendMax;
    private Random random;
    private Fila fila;
    private Escalonador escalonador;
    private Colors colors = new Colors();

    /**
     * Construtor do Objeto do algoritmo de chegadas e saídas
    */
    public Algoritmo(int c, int k, int chMin, int chMax, int atendMin, int atendMax, int quantValores) {
        this.c = c;
        this.k = k;
        this.chMin = chMin;
        this.chMax = chMax;
        this.atendMin = atendMin;
        this.atendMax = atendMax;
        this.random = new Random(chMin, chMax, quantValores);
        this.fila = new Fila(k);
        this.escalonador = new Escalonador();
    }

    /**
     * Método do algoritmo tratando chegadas
     * @param evento
    */
    public void chegada(Evento evento) {
        
        fila.contabilizaTempo(evento.getTempo(), fila.getClientesFila());
        if (fila.getClientesFila() < k) {
            fila.updateClientesFila();
        
            if (fila.getClientesFila() <= c) {
                double aleatorio = random.entreZeroUm();
                double pseudoAleatorio = random.pseudoAleatorio(aleatorio, atendMin, atendMax);
                Evento eventoSaida = new Evento("sa",(fila.getTempoGlobal() + pseudoAleatorio));
                escalonador.add(eventoSaida);
            }
        }
        else {
            fila.setPerdaClientes(fila.getPerdaClientes()+1);
        }

        // nova chegada
        double aleatorio = random.entreZeroUm();
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
        if (fila.getClientesFila() >= c) {
            double aleatorio = random.entreZeroUm();
            double pseudoAleatorio = random.pseudoAleatorio(aleatorio, atendMin, atendMax);
            Evento eventoSaida = new Evento("sa",(fila.getTempoGlobal() + pseudoAleatorio));
            escalonador.add(eventoSaida);
        }
    }

    /**
     * Apresentação do resultado final do programa e resultados
     */
    public void filaEstadosResultadoFinal() {
        double filaSalva[] = fila.getEstadosFila();
        double totalTempo = 0.0;

        System.out.println("SIMULA\u00C7\u00C3O CONCLUIDA\n");
        //DecimalFormat tempo = new DecimalFormat("#.00000");
        //DecimalFormat percentagem = new DecimalFormat("#.00");
        for (int i = 0 ; i < filaSalva.length ; i++) {
            System.out.println("Estado da fila " + i + " = " + colors.BLUE_BRIGHT + filaSalva[i]  + colors.RESET + " | probabilidade = " + colors.GREEN_BRIGHT + calculoProbabilidade(filaSalva[i], fila.getTempoGlobal()) + "%" + colors.RESET);
            totalTempo += filaSalva[i];
        }
        System.out.println("\nTotal dos valores no vetor : " + totalTempo + "\nTotal do tempo global:  " + fila.getTempoGlobal() + "\nPerda: " + fila.getPerdaClientes() + "\n");
    }

    /**
     * Método do calculo da probabilidade para o retorno
     * @param valorPosicao
     * @param valorFinal
     * @return double
     */
    public double calculoProbabilidade(double valorPosicao, double valorFinal) {
        double divisaoPercentagem = valorPosicao/valorFinal;
        return divisaoPercentagem*100;
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

    // =================
    // GETTERS E SETTERS
    // =================
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
}
