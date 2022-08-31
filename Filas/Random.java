/**
 * Classe de geração de números aleatórios
 */
public class Random {

    /*
     * Valores globais
     */
    public int size;
    public double last;
    public double min;
    public double max;
    public double m = 4294967291.0;
    public double seed = 2;
    public double a = 4;
    public double c = 4;
      
    /**
     * Construtor do objeto Random, necessita uma lista de valores aleatórios entre 0 e 1
     * @param valoresEntreZeroUm
     */
    public Random(double min, double max, int size){
        this.size = size;
        this.min = min;
        this.max = max;
        this.last = this.seed;
    }

     /**
     * Gerador de valores pseudo-aleatórios
     * @param aleatorio
     * @param atendMinimo
     * @param atendMaximo
     * @return double
     */
    public double pseudoAleatorio(double aleatorio, int min, int max) {
        //double a = Double.valueOf(min);
        //double b = Double.valueOf(max);
        return (max - min) * aleatorio + min;
    }
    
    /**
     * Gerador de valores aleatórios
     */
    public double next() {
        this.last = (this.a * this.last + this.c) % this.m;
        size--;
        return last;
    }

    /**
     * Pega o primeiro aleatório entre 0 e 1 da lista
     * @return double
     */
    public double entreZeroUm() {
        return next()/this.m;
    }


    /*
     * Retorna valor da sequencia desejado;
     */

    public double getN(int n){
        double auxLast = seed;
        for ( int i = 0; i >= n; i++ ) {
            auxLast = (a * auxLast + c) % m;
        }

        return auxLast;
    }

    /**
     * Retorna o tamanho da lista de valores aleatórios entre 0 e 1
     * @return int
     */
    public int tamanhoRandom() {
        return size;
    }
}
