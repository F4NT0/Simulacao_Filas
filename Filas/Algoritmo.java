import java.util.ArrayList;

/**
 * Algoritmo da simulação da Fila
 */
public class Algoritmo {

    private int c, k, chMin, chMax, atendMin, atendMax;
    private Random random;
    private Fila fila;

    public Algoritmo(int c, int k, int chMin, int chMax, int atendMin, int atendMax, ArrayList<Double> valoresAleatorios) {
        this.c = c;
        this.k = k;
        this.chMin = chMin;
        this.chMax = chMax;
        this.atendMin = atendMin;
        this.atendMax = atendMax;
        this.random = new Random(valoresAleatorios);
        this.fila = new Fila(k);
    }

    public void chegada() {
        // contabiliza tempo
        // if fila < 3 {
        //  fila++
        // }
        // if fila <= 1 {
        //   evento = saida(tempoGlobal + random(2...3))
        //   escalonador.add(evento)
        // } else {
        //       perda++
        // }
        // evento = chegada(tempoGlobal + random(1...3))
        // escalonador.add(evento)
    } 

    public void saida() {
        // contabiliza tempo
        // fila--
        // if fila >= 1 {
        //     evento = saida(tempoGlobal + random(2...3))
        //     escalonador.add(evento)
        // }
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
}
