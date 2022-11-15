import java.util.Arrays;

public class Main {

    public static void main (String args[]) {
        int iterations = 100000;

        Fila fila1 = new Fila("fila1", 1, -1, new Fila.Time(1, 4), new Fila.Time(1, 1.5));
        Fila fila2 = new Fila("fila2", 3, 5, new Fila.Time(5, 10));
        Fila fila3 = new Fila("fila3", 2,8, new Fila.Time(10,20));

        Escalonador scheduler = new Escalonador(Arrays.asList(fila1, fila2, fila3));
        scheduler.add(new Evento(Evento.TipoEvento.CHEGADA, 2.5, fila1, null));

        // Transições
        MapeadorFilas mapper = new MapeadorFilas();
        mapper.addNext(fila1, fila2, 0.8);
        mapper.addNext(fila1, fila3, 0.2);
        mapper.addNext(fila2, fila3, 0.5);
        mapper.addNext(fila2, fila1, 0.3);
        mapper.addNext(fila3, fila2, 0.7);



        Algoritmo alg = new Algoritmo(mapper, scheduler);

        for(int i = 0; i < iterations; i++) {
            Evento evento = scheduler.next();
            switch(evento.getTipoEvento()){
                case CHEGADA:
                    alg.chegada(evento);
                    break;
                case SAIDA:
                    alg.saida(evento);
                    break;
                case PASSAGEM:
                    alg.passagem(evento);
                    break;
            }
        }
        mapper.getProbability();
        new Report().print(scheduler.getQueuesTimes(), scheduler.getGlobalTime());
    }
}
