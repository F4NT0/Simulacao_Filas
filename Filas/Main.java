import java.util.Arrays;

public class Main {

    public static void main (String args[]) {
        int iterations = 100000;

        Fila fila1 = new Fila("fila1", 2, 3, new Fila.Time(2, 3), new Fila.Time(2, 5));
        Fila fila2 = new Fila("fila2", 1, 3, new Fila.Time(3, 5));

        Escalonador scheduler = new Escalonador(Arrays.asList(fila1, fila2));
        scheduler.add(new Evento(Evento.TipoEvento.CHEGADA, 2.5, fila1, null));

        MapeadorFilas mapper = new MapeadorFilas();
        mapper.addNext(fila1, fila2);

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

        new Report().print(scheduler.getQueuesTimes(), scheduler.getGlobalTime());
    }
}
