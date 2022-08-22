import java.util.PriorityQueue;

/**
 * Escalonador trata os Eventos da fila
 */
public class Escalonador {

    PriorityQueue<Evento> queue;
    
    public Escalonador(){
        queue = new PriorityQueue<Evento>();
    }
    
    /**
     * Adiciona um Evento no escalonador
     * @param num
     */
    public void add(Evento evento){
        queue.add(evento);
    }

    /**
     * Pega o primeiro da fila e o remove da fila
     * @return 
     */
    public Evento next() {
        /*Remove and return */
        return queue.poll();
    }

    /**
     * Verifica o primeiro evento da fila
     * @return
     */
    public Evento verify() {
        return queue.peek();
    }
}