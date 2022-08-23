import java.util.ArrayList;

/**
 * Classe principal para testar
 */
public class Main {

    public static void main (String args[]) {

        int c = 1; // número de atendentes (C)
        int k = 3; // capacidade de pessoas na fila (K)
        int chMin = 1; // tempo de chegada mínima de um cliente
        int chMax = 2; // tempo de chegada máximo de um cliente
        int atendMin = 3; // tempo de atendimento mínimo do cliente
        int atendMax = 6; // tempo de atendimento máximo do cliente

        // Valores Aleatórios entre 0 e 1
        ArrayList<Double> valoresAleatorios = new ArrayList<>();
        valoresAleatorios.add(0.3276);
        valoresAleatorios.add(0.8851);
        valoresAleatorios.add(0.1643);
        valoresAleatorios.add(0.5542);
        valoresAleatorios.add(0.6813);
        valoresAleatorios.add(0.7221);
        valoresAleatorios.add(0.9881);

        // Iniciando o algoritmo e adicionando primeira chegada
        Algoritmo algoritmo = new Algoritmo(c, k, chMin, chMax, atendMin, atendMax, valoresAleatorios);
        algoritmo.primeiroEvento("ch", 2.0);
         
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
        algoritmo.filaEstadosResultadoFinal();
    }
}
