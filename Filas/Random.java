import java.util.ArrayList;

/**
 * Classe de geração de números aleatórios
 */
public class Random {

    private ArrayList<Double> entreZeroUm = new ArrayList<>(); //lista de valores aleatórios entre zero e um
    
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
    public double pseudoAleatorio(double aleatorio, int atendMinimo, int atendMaximo) {
        double a = Double.valueOf(atendMinimo);
        double b = Double.valueOf(atendMaximo);
        return (b - a) * aleatorio + a;
    }

    public double pegaPrimeiroAleatorio() {
        return entreZeroUm.remove(0);
    }

    public int tamanhoRandom() {
        return entreZeroUm.size();
    }


}
