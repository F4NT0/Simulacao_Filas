import java.util.PriorityQueue;

public class Fila {

    public int attendant; 
    public int size;
    public int chTimeMin;
    public int chTimeMax;
    public int consumeTimeMin;
    public int consumeTimeMax;


    public Fila(int attendant ,int size,
                 int chTimeMin, int chTimeMax,
                 int consumeTimeMin,int consumeTimeMax){

        this.attendant = attendant;
        this.size = size;
        
        this.chTimeMin = chTimeMin;
        this.chTimeMax = chTimeMax;
        
        this.consumeTimeMin = consumeTimeMin;
        this.consumeTimeMax = consumeTimeMax;
    }

    public void chegada() {
        
    }

    
   
    
}
