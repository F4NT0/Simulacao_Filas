import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Escalonador trata os Eventos da fila
 */
public class Escalonador {

    PriorityQueue<Double> queue;
    ArrayList<Evento> eventos;
    
    /**
     * Construtor do Escalonador, ele inicia uma priority queue de Eventos
     */
    public Escalonador(){
        queue = new PriorityQueue<Double>();
        eventos = new ArrayList<Evento>();
    }
    
    /**
     * Adiciona um Evento na lista de eventos e o tempo na queue
     * @param num
     */
    public void add(Evento evento){
        eventos.add(evento);
        queue.add(evento.getTempo());
    }

    /**
     * Pega o primeiro tempo, procura o evento e o retorna
     * @return Evento
     */
    public Evento next() {
        double tempo = queue.poll();
        for (Evento evento : eventos) {
            if (evento.getTempo() == tempo) {
                return evento;
            }
        }
        return null;
    }

    /**
     * Verifica o primeiro evento da fila
     * @return
     */
    public Evento verify() {
        double tempo = queue.peek();
        for (Evento evento : eventos) {
            if (evento.getTempo() == tempo) {
                return evento;
            }
        }
        return null;
    }
}