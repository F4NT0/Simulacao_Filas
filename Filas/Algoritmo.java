import java.lang.reflect.Array;
import java.util.ArrayList;

import Apresentacao.Colors;
import Apresentacao.Visual;

/**
 * Classe com o Algoritmo da simulação da Fila
 */
public class Algoritmo {

    private int chMin, chMax;
    private int[] c, k, atendMin, atendMax;
    private Random random;
    private ArrayList<Fila> filas = new ArrayList<Fila>();
    private Escalonador escalonador;
    private Colors colors = new Colors();
    private double tempoGlobal;

    /**
     * Construtor do Objeto do algoritmo de chegadas e saídas
    */
    public Algoritmo(int[] c, int[] k, int chMin, int chMax, int[] atendMin, int[] atendMax, int quantValores) {
        this.c = c;
        this.k = k;
        this.chMin = chMin;
        this.chMax = chMax;
        this.atendMin = atendMin;
        this.atendMax = atendMax;
        this.random = new Random(chMin, chMax, quantValores);
        for (int i : k) {
            this.filas.add(new Fila(i));
        }
        this.escalonador = new Escalonador();
        this.tempoGlobal = 0.0;
    }

    /**
     * Método do algoritmo tratando chegadas
     * @param evento
    */
    public void chegada(Evento evento) {
        /* count tempo
        * se fila < fila1.k
        *  fila ++
        *  se fila1 <= fila1.c(?)
        *     agenda passagem fila 1 pra fila 2 (t.g. + random(taxa de atendimento da fila 1))
        * senao perda1 ++
        * agenda chegada (t.g. + random(taxa de chegada))
        */
        // System.out.println(filas);
        // System.out.println(filas.get(evento.getNumFila()+1));// testando o output do  filas.get(evento.getNumFila()) sozinho, assim como com +1 e -1            
        // System.out.println(filas.get(evento.getNumFila()));

        this.contabilizaTempo(evento.getTempo());
        if (filas.get(evento.getNumFila()).getClientesFila() < k[evento.getNumFila()]) {
            filas.get(evento.getNumFila()).updateClientesFila();
            
            if (filas.get(evento.getNumFila()).getClientesFila() <= c[evento.getNumFila()]) {
                double aleatorio = random.entreZeroUm();
                double pseudoAleatorio = random.pseudoAleatorio(aleatorio, atendMin[evento.getNumFila()], atendMax[evento.getNumFila()]);
                Evento eventoPassagem = new Evento("pa",(this.getTempoGlobal() + pseudoAleatorio), evento.getNumFila());
                escalonador.add(eventoPassagem);
            }
        }
        else {
            filas.get(evento.getNumFila()).setPerdaClientes(filas.get(evento.getNumFila()).getPerdaClientes()+1);
        }
                
        // nova chegada
        double aleatorio = random.entreZeroUm();
        double pseudoAleatorio = random.pseudoAleatorio(aleatorio, chMin, chMax);
        Evento novoEvento = new Evento("ch", (this.getTempoGlobal() + pseudoAleatorio), evento.getNumFila());
        escalonador.add(novoEvento);
    
    } 

    /**
     * Método do algoritmo tratando saídas
     * @param evento
    */
    public void saida(Evento evento) {
        /* 
         * count tempo
         * fila2 --
         * se fila2 >= fila2.c(?)
         * agenda saida2 (t.g. + random(taxa de atendimento da fila dois))
         */
        double aleatorio = random.entreZeroUm();
        double pseudoAleatorio = random.pseudoAleatorio(aleatorio, atendMin[evento.getNumFila()], atendMax[evento.getNumFila()]);
        if (evento.getNumFila() < filas.size()-1) {// menor ou igual?
            passagem(new Evento("pa",(evento.getTempo()), evento.getNumFila()));
        }
        else {
            this.contabilizaTempo(evento.getTempo());
            filas.get(evento.getNumFila()).downgradeClientesFila();
            if (filas.get(evento.getNumFila()).getClientesFila() >= c[evento.getNumFila()]) {
                Evento eventoSaida = new Evento("sa",(this.getTempoGlobal() + pseudoAleatorio),evento.getNumFila());
                escalonador.add(eventoSaida);
                
            }
        }
    }

    public void passagem(Evento evento) {
        /*
         * count tempo
         * fila --
         * se fila >= 1
         *     agenda passagem(t.g. + random(taxa de atendimento da fila 1))
         * se fila < fila2.k
         *    fila2 ++
         *    se fila <= fila2.c(?)
         *       agenda saida da fila 2 (t.g. + random(taxa de atendimento da fila 2))
         * senao perda2 ++;
         *
         */
        this.contabilizaTempo(evento.getTempo());
        filas.get(evento.getNumFila()).downgradeClientesFila();
        if (filas.get(evento.getNumFila()).getClientesFila() >= c[evento.getNumFila()]) {
            double aleatorio = random.entreZeroUm();
            double pseudoAleatorio = random.pseudoAleatorio(aleatorio, atendMin[evento.getNumFila()], atendMax[evento.getNumFila()]);
            Evento eventoPassagem = new Evento("pa", (this.getTempoGlobal() + pseudoAleatorio), evento.getNumFila());
            escalonador.add(eventoPassagem);
        }
        if (filas.get(evento.getNumFila()+1).getClientesFila() < k[evento.getNumFila() + 1]) {
            filas.get(evento.getNumFila()+1).updateClientesFila();
            if (filas.get(evento.getNumFila()+1).getClientesFila() <= c[evento.getNumFila()+1]) {
                double aleatorio = random.entreZeroUm();
                double pseudoAleatorio = random.pseudoAleatorio(aleatorio, atendMin[evento.getNumFila()+1], atendMax[evento.getNumFila()+1]);
                Evento eventoSaida = new Evento("sa", (this.getTempoGlobal() + pseudoAleatorio), evento.getNumFila()+1);
                escalonador.add(eventoSaida);
            }
        }
        else {
            filas.get(evento.getNumFila()+1).setPerdaClientes(filas.get(evento.getNumFila()+1).getPerdaClientes()+1);
        }
    }

    /**
     * Apresentação do resultado final do programa e resultados
     */
    public void filaEstadosResultadoFinal() {
        for (Fila fila : filas) {
            
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
        String apresentacaoValor = Double.toString(percentagem);
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
        Evento evento = new Evento(tipo, tempoInicial, 0);
        escalonador.add(evento);
    }

     /**
     * Método que contabiliza o tempo quando é feito uma chegada ou saida
     * @param tempo
     * @param clientesFila
     */
    public void contabilizaTempo(double tempo) {
        double valorTempo = tempo - tempoGlobal;

        for (Fila fila : filas) {
            
            if (fila.getClientesFila() < fila.getEstadosFila().length) {
                fila.setEstadosFila( fila.getClientesFila(), (fila.getEstadosFila()[fila.getClientesFila()] + valorTempo)
                );
                setTempoGlobal(tempoGlobal + valorTempo);
            }
        }
    }

    // =================
    // GETTERS E SETTERS
    // =================
    public int getC(int i) {
        return c[i];
    }

    public int getK(int i) {
        return k[i];
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

    public int getAtendMin(int i) {
        return atendMin[i];
    }

    public int getAtendMax(int i) {
        return atendMax[i];
    }

    public Random getRandom() {
        return random;
    }

    public Fila getFila(int i) {
        return filas.get(i);
    }

    public Escalonador getEscalonador() {
        return escalonador;
    }
}
