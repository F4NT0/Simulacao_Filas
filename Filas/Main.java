import java.util.ArrayList;

public class Main {

    public static void main (String args[]) {
        Colors colors = new Colors();

        // =====================================================
        // AREA DE COLOCAR OS DADOS NECESSARIOS PARA A SIMULACAO
        // =====================================================
        int c = 1; // número de atendentes (C)
        int k = 5; // capacidade de pessoas na fila (K)
        int chMin = 2; // tempo de chegada mínima de um cliente
        int chMax = 4; // tempo de chegada máximo de um cliente
        int atendMin = 3; // tempo de atendimento mínimo do cliente
        int atendMax = 5; // tempo de atendimento máximo do cliente
        double tempoGlobalInicial = 3.0; //tempo global do primeiro cliente

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
        System.out.println(colors.BLUE + "===========================================");
        System.out.println("============ SIMULADOR DE FILAS ===========");
        System.out.println("===========================================" + colors.RESET);
        System.out.println(colors.RED + "| Nota\u00E7\u00E3o: G/G/" + c + "/" + k + colors.RESET);
        System.out.println(colors.GREEN + "| Chegada Minima: " + chMin + " - Chegada Maxima: " + chMax + colors.RESET);
        System.out.println(colors.CYAN + "| Atendimento Minimo: " + atendMin + " - Atendimento Maximo: " + atendMax + colors.RESET);
        System.out.println(colors.PURPLE + "| Tempo Global do primeiro cliente: " + tempoGlobalInicial + colors.RESET);
        System.out.print("| Valores Aleat\u00F3rios definidos: ");
        for (Double valor : valoresAleatorios) {
            System.out.print(colors.YELLOW + valor + " | " + colors.RESET);
        }
        System.out.println(colors.BLUE + "\n=======================================\n" + colors.RESET);

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
