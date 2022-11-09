

/**
 * Classe com o Algoritmo da simulação da Fila
 */
public class Algoritmo {
    private MapeadorFilas mapper;
    private Escalonador scheduler;

    private final Random random;

    /**
     * Construtor do Objeto do algoritmo de chegadas e saídas
    */
    public Algoritmo(MapeadorFilas mapper, Escalonador scheduler) {
        this.mapper = mapper;
        this.scheduler = scheduler;

        this.random = new Random(2);
    }
    
    public void chegada(Evento evento) {
        /* 
        * count tempo
        * se fila1.getClientes < fila1.getCapacidade
        *   fila1.adicionaCliente
        *   se fila1.getClientes <= fila1getServidores
        *     agenda passagem fila1 -> fila2 (tempo = random(fila1.getServiceTime))
        * senao 
            fila1.addPerda
        * agenda chegada (tempo = random(fila1.getArrivalTime))
        */
        
        this.scheduler.contabilizaTempo(evento);

        Fila fila = evento.getOrigem();
        if (fila.getClients() < fila.getCapacity()) {
            fila.addClient();
            if(fila.getClients() <= fila.getServers()) {
                double serviceTime = this.random.nextInRange(fila.getServiceTime().min, fila.getServiceTime().max);
                scheduler.add(new Evento(Evento.TipoEvento.PASSAGEM, this.scheduler.getGlobalTime() + serviceTime, fila, this.mapper.getNext(fila)));
            }
        } else {
             fila.addPerda();
        }

        double arrivalTime = this.random.nextInRange(fila.getArrivalTime().min, fila.getArrivalTime().max);
        scheduler.add(new Evento(Evento.TipoEvento.CHEGADA, this.scheduler.getGlobalTime() + arrivalTime, fila, null));
    } 

    public void passagem(Evento evento) {
        /*
         * count tempo
         * fila1.removeClient
         * se fila1.getClientes >= fila1.getServidores
         *     agenda passagem fila1 -> fila2 (tempo = random(fila1.getServiceTime))
         * se fila2. < fila2.getCapacidade
         *    fila2.adicionaCliente
         *    se fila2.getClientes <= fila2.getServidores
         *       agenda saida da fila2 (tempo = random(fila2.getServiceTime))
         * senao 
         *    fila2.addPerda;
         */

        this.scheduler.contabilizaTempo(evento);

        Fila fila1 = evento.getOrigem();
        Fila fila2 = evento.getDestino();
        
        fila1.removeClient();
        if(fila1.getClients() >= fila1.getServers()){
            double serviceTime = this.random.nextInRange(fila1.getServiceTime().min, fila1.getServiceTime().max);
            scheduler.add(new Evento(Evento.TipoEvento.PASSAGEM, this.scheduler.getGlobalTime() + serviceTime, fila1, this.mapper.getNext(fila1)));
        }
        if(fila2.getClients() < fila2.getCapacity()) {
            fila2.addClient();
            if(fila2.getClients() <= fila2.getServers()) {
                double serviceTime = this.random.nextInRange(fila2.getServiceTime().min, fila2.getServiceTime().max);
                scheduler.add(new Evento(Evento.TipoEvento.SAIDA, this.scheduler.getGlobalTime() + serviceTime, fila2, null));
            }
        } else {
            fila2.addPerda();
        }
    }

    public void saida(Evento evento) {
        /* 
         * count tempo
         * fila2.removeCliente
         * se fila2.adicionaCliente >= fila2.getServidores
         *   agenda saida2 (tempo = random(fila2.getServiceTime))
         */

        this.scheduler.contabilizaTempo(evento);

        Fila fila = evento.getOrigem();
        fila.removeClient();
        if(fila.getClients() >= fila.getServers()) {
            double serviceTime = this.random.nextInRange(fila.getServiceTime().min, fila.getServiceTime().max);
            scheduler.add(new Evento(Evento.TipoEvento.SAIDA, this.scheduler.getGlobalTime() + serviceTime, fila, null));
        }
    }
}
