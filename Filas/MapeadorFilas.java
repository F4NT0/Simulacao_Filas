import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapeadorFilas {
        private final Map<String, List<Fila>> mapping;
        private HashMap<String, Double> probability = new HashMap<>();


        public MapeadorFilas() {
            this.mapping = new HashMap<String, List<Fila>>();
        }

        // TODO
        // adicionar a
        public void addNext(Fila source, Fila target, double prob){
            if(!this.mapping.containsKey(source.getName()))
                this.mapping.put(source.getName(), new ArrayList<>());
            probability.put(target.getName(), prob);
            this.mapping.get(source.getName()).add(target);
        }

        public Fila getNext(Fila f){
            return this.mapping.get(f.getName()).get(0);
        }

        public HashMap<String, Double> getProbability() {
            return probability;
        }
        
}
