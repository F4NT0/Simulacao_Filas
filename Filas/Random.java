/**
 * Classe de geração de números aleatórios
 */
public class Random {
    public double last;
    public long a = 251;
    public long c = 3767;
    public long m = 42949672910L;
      
    /**
     * Construtor do objeto Random, necessita uma lista de valores aleatórios entre 0 e 1
     * @param valoresEntreZeroUm
     */
    public Random(int seed){
        this();
        this.last = 4;
    }
    
    public Random(){
        this.last = System.currentTimeMillis();
    }
    
    /**
     * Gerador de valores aleatórios
     */
    public double next() {
        return (this.last = (this.last * this.a + this.c) % this.m) / this.m;
    }

    public double nextInRange(int min, int max){
        return (max - min) * this.next() + min;
    }
}