
import Apresentacao.Colors;
import Apresentacao.Visual;

public class Main {

    public static void main (String args[]) {
        Colors colors = new Colors();
        Visual visual = new Visual();

        // =====================================================
        // AREA DE COLOCAR OS DADOS NECESSARIOS PARA A SIMULACAO
        // =====================================================

        int c = 1; // número de atendentes (C)
        int k = 5; // capacidade de pessoas na fila (K)
        int chMin = 2; // tempo de chegada mínima de um cliente
        int chMax = 4; // tempo de chegada máximo de um cliente
        int atendMin = 3; // tempo de atendimento mínimo do cliente
        int atendMax = 5; // tempo de atendimento máximo do cliente
        double tempoGlobalInicial = 2.0; //tempo global do primeiro cliente
        int valoresAleatorios = 100000;

        // ====================================================
        // SIMULADOR INICIADO E APRESENTAÇÃO DOS DADOS INICIAIS
        // ====================================================
        visual.quadroApresentacaoSimulador();
        System.out.println(colors.RED + "\u2551 Nota\u00E7\u00E3o: G/G/" + c + "/" + k + colors.RESET);
        System.out.println(colors.GREEN + "\u2551 Chegada Minima: " + chMin + " - Chegada Maxima: " + chMax + colors.RESET);
        System.out.println(colors.CYAN + "\u2551 Atendimento Minimo: " + atendMin + " - Atendimento Maximo: " + atendMax + colors.RESET);
        System.out.println(colors.PURPLE + "\u2551 Tempo Global do primeiro cliente: " + tempoGlobalInicial + colors.RESET);

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
