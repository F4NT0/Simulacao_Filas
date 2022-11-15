public class Fila {

    public static class Time{
        public double min;
        public double max;

        public Time(double min, double max) {
            this.min = min;
            this.max = max;
        }
    }

    private String name;
    private int clients;
    private int servers;
    private int capacity;
    private int lost_clients;
    private Time arrival_time;
    private Time service_time;

    
    public Fila(String name, int c, int k, Time service_time){
        this(name, c, k, new Time(0, 0), service_time);
    }
    
    public Fila(String name, int c, int k, Time arrival_time, Time service_time) {
        this.name = name;
        this.clients = 0;
        this.servers = c;
        this.capacity = k;
        this.lost_clients = 0;
        this.arrival_time = arrival_time;
        this.service_time = service_time;
    }

    public String getName(){
        return this.name;
    }

    public void addClient() {
        this.clients++;
    }

    public void removeClient() {
        this.clients--; 
    }

    public void addPerda(){
        this.lost_clients ++;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getServers(){
        return this.servers;
    }

    public int getClients() {
        return clients;
    }

    public int getLostClients() {
        return lost_clients;
    }


    public Time getArrivalTime() {
        return arrival_time;
    }

    public Time getServiceTime() {
        return service_time;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Fila))
            return false;
        
        Fila otherFila = (Fila) other;
        return this.clients == otherFila.clients && 
                this.capacity == otherFila.capacity && 
                this.lost_clients == otherFila.lost_clients &&
                this.servers == otherFila.servers;
    }

    @Override
    public String toString() {
        return "Fila(" + this.name + ", " + this.clients + ", " + this.servers + ", " + this.lost_clients + ")";
    }
}
