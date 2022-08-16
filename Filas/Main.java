public class Main {
    
    /**
     * Gerador de valores pseudo-aleatórios
     * @param aleatorio
     * @param atendMinimo
     * @param atendMaximo
     * @return double
     */
    private static double pseudoAleatorio(double aleatorio, int atendMinimo, int atendMaximo) {
        double a = Double.valueOf(atendMinimo);
        double b = Double.valueOf(atendMaximo);
        return (b - a) * aleatorio + a;
    }
    
    public static void main (String args[]) {

        // valores iniciais
        int atendMinimo = 2;
        int atendMaximo = 3;
        int capacidade = 3;
        int nroAtendentes = 1;
        int chegadaMinima = 1;
        int chegadaMaxima = 3;
        
        double tempoInicial = 2.0;


        double valoresAleatorios[] = {0.2,0.7,0.5};
    
        for (double valor : valoresAleatorios) {
            System.out.println(pseudoAleatorio(valor,atendMinimo,atendMaximo));
        }
    }
}
