
public class Main {

    public static void main (String args[]) {

        Fila fila1 = new Fila(1, 3, 1, 2, 3, 6);
        
        double tempoInicial = 2.0;
        //double valoresAleatorios[] = {0.2,0.7,0.5};

        fila1.initClientesFila();
        fila1.initTempoGlobal();
        fila1.initEstadosFila();

        System.out.println("Estados da Fila inicial:");
        for(int i = 0 ; i < fila1.getEstadosFila().length ; i++) {
            System.out.println("[" + i + "] = " + fila1.getEstadosFila()[i]);
        }

        System.out.println("Tempo Global: " + fila1.getTempoGlobal());
        System.out.println("Número de Clientes na fila inicial: " + fila1.getClientesFila());

        fila1.contabilizaTempo(tempoInicial, fila1.getClientesFila());

        System.out.println("Estados da fila após contabilizar o tempo:");
        for(int i = 0 ; i < fila1.getEstadosFila().length ; i++) {
            System.out.println("[" + i + "] = " + fila1.getEstadosFila()[i]);
        }

        System.out.println("Tempo global depois de contabilizado: " + fila1.getTempoGlobal());

        

    }
}
