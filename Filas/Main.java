
public class Main {
    
    public int GlobalTime = 0;

    public static void main (String args[]) {

        Random random = new Random();

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
            System.out.println(random.pseudoAleatorio(valor,atendMinimo,atendMaximo));
        }
    }
}
