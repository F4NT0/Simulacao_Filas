import java.util.List;

public class Report {
    public void print(List<Escalonador.QueueTimes> queuesTimes, double globalTime){
        System.out.println("==================================================");
        System.out.println("===================== REPORT =====================");
        System.out.println("==================================================");
        for(Escalonador.QueueTimes queueTimes: queuesTimes){
            System.out.println("Queue: " + queueTimes.queue.getName() + " (G/G/" + queueTimes.queue.getServers() + "/" + queueTimes.queue.getCapacity() + ")");
            System.out.println("Arrival: " + queueTimes.queue.getArrivalTime().min + ", " + queueTimes.queue.getArrivalTime().max);
            System.out.println("Service: " + queueTimes.queue.getServiceTime().min + ", " + queueTimes.queue.getServiceTime().max);
            System.out.println("************************************************************");
            System.out.println("State        Time        Probability");
            for(int i = 0; i < queueTimes.times.length; i++){
                System.out.println(i + "        " + queueTimes.times[i] + "   " + String.format("%.2f", (queueTimes.times[i] / globalTime) * 100) + "%");
            }
            System.out.println("Number of losses: " + queueTimes.queue.getLostClients());
            System.out.println("************************************************************");
        }
        
        System.out.println("Simulation time: " + globalTime);
    }
}
