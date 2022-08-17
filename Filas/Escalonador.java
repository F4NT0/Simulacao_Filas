import java.util.PriorityQueue;

/**
 * Escalonador
 */
public class Escalonador {

    PriorityQueue<Integer> queue;
    public Escalonador(){
        queue = new PriorityQueue<Integer>();

    }
    public void ch(int num){
        queue.add(num);
    }

    public int next(){
        /*Remove and return */
        return queue.poll();
    }
}