import java.util.ArrayList;

public class Main {

    public static void main (String args[]) {

        // =====================================================
        // AREA DE COLOCAR OS DADOS NECESSARIOS PARA A SIMULACAO
        // =====================================================
        int c = 1; // número de atendentes (C)
        int k = 3; // capacidade de pessoas na fila (K)
        int chMin = 1; // tempo de chegada mínima de um cliente
        int chMax = 2; // tempo de chegada máximo de um cliente
        int atendMin = 3; // tempo de atendimento mínimo do cliente
        int atendMax = 6; // tempo de atendimento máximo do cliente
        double tempoGlobalInicial = 2.0; //tempo global do primeiro cliente

        // Valores Aleatórios entre 0 e 1 colocados manualmente
        ArrayList<Double> valoresAleatorios = new ArrayList<>();
        valoresAleatorios.add(0.3276);
        valoresAleatorios.add(0.8851);
        valoresAleatorios.add(0.1643);
        valoresAleatorios.add(0.5542);
        valoresAleatorios.add(0.6813);
        valoresAleatorios.add(0.7221);
        valoresAleatorios.add(0.9881);

        // ====================================================
        // SIMULADOR INICIADO E APRESENTAÇÃO DOS DADOS INICIAIS
        // ====================================================
        System.out.println("===========================================");
        System.out.println("============ SIMULADOR DE FILAS ===========");
        System.out.println("===========================================");
        System.out.println("| Nota\u00E7\u00E3o: G/G/" + c + "/" + k);
        System.out.println("| Chegada Minima: " + chMin + " - Chegada Maxima: " + chMax);
        System.out.println("| Atendimento Minimo: " + atendMin + " - Atendimento Maximo: " + atendMax);
        System.out.println("| Tempo Global do primeiro cliente: " + tempoGlobalInicial);
        System.out.print("| Valores Aleat\u00F3rios definidos: ");
        for (Double valor : valoresAleatorios) {
            System.out.print(valor + " | ");
        }
        System.out.println("\n=======================================\n");

        // =================================================
        // ALGORITMO DE INICIAÇÃO E TRARAMENTO DA SIMULAÇÃO
        // =================================================
        Algoritmo algoritmo = new Algoritmo(c, k, chMin, chMax, atendMin, atendMax, valoresAleatorios);
        algoritmo.primeiroEvento("ch", tempoGlobalInicial);
         
        while(algoritmo.getRandom().tamanhoRandom() > 0) {
            Evento evento = algoritmo.getEscalonador().next();
            if (evento.getTipoEvento().equals("ch")) {
                algoritmo.chegada(evento);
            } else {
                if (evento.getTipoEvento().equals("sa")) {
                        algoritmo.saida(evento);
                } else {
                        System.out.println("Erro!");
                }
            }
        }
        
        // ====================
        // RETORNO DA SIMULAÇÃO
        // ====================
        algoritmo.filaEstadosResultadoFinal();
    }
}
