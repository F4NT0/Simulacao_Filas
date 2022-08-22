import java.util.ArrayList;

/**
 * Classe de geração de números aleatórios
 */
public class Random {

    private ArrayList<Double> entreZeroUm = new ArrayList<>(); //lista de valores aleatórios entre zero e um
    
    /**
     * Construtor do objeto Random, necessita uma lista de valores aleatórios entre 0 e 1
     * @param valoresEntreZeroUm
     */
    public Random(ArrayList<Double> valoresEntreZeroUm){
        entreZeroUm = valoresEntreZeroUm;
    }
    
    /**
     * Gerador de valores pseudo-aleatórios
     * @param aleatorio
     * @param atendMinimo
     * @param atendMaximo
     * @return double
     */
    public double pseudoAleatorio(double aleatorio, int min, int max) {
        double a = Double.valueOf(min);
        double b = Double.valueOf(max);
        return (b - a) * aleatorio + a;
    }

    /**
     * Pega o primeiro aleatório entre 0 e 1 da lista
     * @return double
     */
    public double pegaPrimeiroAleatorio() {
        return entreZeroUm.remove(0);
    }

    /**
     * Retorna o tamanho da lista de valores aleatórios entre 0 e 1
     * @return int
     */
    public int tamanhoRandom() {
        return entreZeroUm.size();
    }


}
