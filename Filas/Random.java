import java.util.ArrayList;

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
    public double m;
    public double seed = 2;
    public double a = 2;
    public double c = 1;
      
    /**
     * Construtor do objeto Random, necessita uma lista de valores aleatórios entre 0 e 1
     * @param valoresEntreZeroUm
     */
    public Random(double min, double max, int size){
        this.size = size;
        this.min = min;
        this.m = max;
        this. seed = this.last = seed;
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
        size--;
        last = (a * last + c) % m;
        return last;
    }

    /**
     * Pega o primeiro aleatório entre 0 e 1 da lista
     * @return double
     */
    public double entreZeroUm() {
        return next()/m;
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
