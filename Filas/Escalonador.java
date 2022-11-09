import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Escalonador trata os Eventos da fila
 */
public class Escalonador {
    public class QueueTimes {
        public Fila queue;
        public double[] times;

        public QueueTimes(Fila f) {
            this.queue = f;
            this.times = new double[f.getCapacity() + 1];
        }
    }

    private double globalTime;
    private List<QueueTimes> queuesTimes;
    private PriorityQueue<Evento> eventos;
    
    /**
     * Construtor do Escalonador, ele inicia uma priority queue de Eventos
     */
    public Escalonador(List<Fila> filas){
        this.globalTime = 0.0;
        this.eventos = new PriorityQueue<Evento>((e1, e2) -> {
            if (e1.getTempo() > e2.getTempo()) return 1;
            else if (e1.getTempo() < e2.getTempo()) return -1;
            return 0;
        });

        this.queuesTimes = new ArrayList<>();
        for(Fila f: filas) 
            queuesTimes.add(new QueueTimes(f));
    }
    
    /**
     * Adiciona um Evento na lista de eventos e o tempo na queue
     * @param num
     */
    public void add(Evento evento){
        eventos.add(evento);
    }

    /**
     * Pega o primeiro tempo, procura o evento e o remove e depois retorna
     * @return Evento
     */
    public Evento next() {
        return eventos.poll();
    }

    public void contabilizaTempo(Evento evento){
        double delta = evento.getTempo() - this.globalTime;
        for(QueueTimes queueTimes: queuesTimes)
            queueTimes.times[queueTimes.queue.getClients()] += delta;
        this.globalTime = evento.getTempo();
    }

    public List<QueueTimes> getQueuesTimes(){
            return queuesTimes;
    }

    public double getGlobalTime(){
        return globalTime;
    }
}