import Apresentacao.Colors;
import Apresentacao.Visual;

/**
 * Classe com o Algoritmo da simulação da Fila
 */
public class Algoritmo {

    private int c, k, chMin, chMax, atendMin, atendMax;
    private Random random;
    private Fila fila;
    private Escalonador escalonador;
    private Colors colors = new Colors();
    private double tempoGlobal;

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
        this.tempoGlobal = 0.0;
    }

    /**
     * Método do algoritmo tratando chegadas
     * @param evento
    */
    public void chegada(Evento evento) {
        
        this.contabilizaTempo(evento.getTempo(), fila);
        if (fila.getClientesFila() < k) {
            fila.updateClientesFila();
        
            if (fila.getClientesFila() <= c) {
                double aleatorio = random.entreZeroUm();
                double pseudoAleatorio = random.pseudoAleatorio(aleatorio, atendMin, atendMax);
                Evento eventoSaida = new Evento("sa",(this.getTempoGlobal() + pseudoAleatorio));
                escalonador.add(eventoSaida);
            }
        }
        else {
            fila.setPerdaClientes(fila.getPerdaClientes()+1);
        }

        // nova chegada
        double aleatorio = random.entreZeroUm();
        double pseudoAleatorio = random.pseudoAleatorio(aleatorio, chMin, chMax);
        Evento novoEvento = new Evento("ch", (this.getTempoGlobal() + pseudoAleatorio));
        escalonador.add(novoEvento);
    } 

    /**
     * Método do algoritmo tratando saídas
     * @param evento
    */
    public void saida(Evento evento) {
        this.contabilizaTempo(evento.getTempo(), fila);
        fila.downgradeClientesFila();
        if (fila.getClientesFila() >= c) {
            double aleatorio = random.entreZeroUm();
            double pseudoAleatorio = random.pseudoAleatorio(aleatorio, atendMin, atendMax);
            Evento eventoSaida = new Evento("sa",(this.getTempoGlobal() + pseudoAleatorio));
            escalonador.add(eventoSaida);
        }
    }

    /**
     * Apresentação do resultado final do programa e resultados
     */
    public void filaEstadosResultadoFinal() {
        Visual visual = new Visual();

        double filaSalva[] = fila.getEstadosFila();
        double totalTempo = 0.0;

       visual.quadroFinalizacaoSimulacao();

        for (int i = 0 ; i < filaSalva.length ; i++) {
            System.out.println(visual.meio() + " Estado da fila " + i + " = " + colors.BLUE_BRIGHT + filaSalva[i]  + colors.RESET + " | probabilidade = " + colors.GREEN_BRIGHT + calculoProbabilidade(filaSalva[i], this.getTempoGlobal()) + "%" + colors.RESET);
            totalTempo += filaSalva[i];
        }
        System.out.println("\nTotal dos valores no vetor : " + totalTempo + "\nTotal do tempo global:  " + this.getTempoGlobal() + "\nPerda: " + fila.getPerdaClientes() + "\n");
    }

    /**
     * Método do calculo da probabilidade para o retorno
     * @param valorPosicao
     * @param valorFinal
     * @return String
     */
    public String calculoProbabilidade(double valorPosicao, double valorFinal) {
        double divisaoPercentagem = valorPosicao/valorFinal;
        double percentagem = divisaoPercentagem*100;
        String apresentacaoValor = Double.toString(percentagem).substring(0, 5);
        return apresentacaoValor;
    }

    /**
     * Método para ajuste do número de casas decimais dos valores do estado das posições na fila
     * @param valorPosicao
     * @return String
     */
    public String ajusteValorEstadoFila(double valorPosicao) {
        String apresentacaoValor = Double.toString(valorPosicao).substring(0,11);
        return apresentacaoValor;
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

     /**
     * Método que contabiliza o tempo quando é feito uma chegada ou saida
     * @param tempo
     * @param clientesFila
     */
    public void contabilizaTempo(double tempo, Fila fila) {
        double filaSalva[] = fila.getEstadosFila();
        double valorTempo = tempo - tempoGlobal;
        if (fila.getClientesFila() <= fila.getEstadosFila().length) {
            fila.setEstadosFila( fila.getClientesFila(), (filaSalva[fila.getClientesFila()] + valorTempo)
            );
            setTempoGlobal(tempoGlobal + valorTempo);
        }
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

    public double getTempoGlobal() {
        return tempoGlobal;
    }

    public void setTempoGlobal(double tempoGlobal) {
        this.tempoGlobal = tempoGlobal;
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
