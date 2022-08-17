public class Random {
    
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

    public Random(){}
}
