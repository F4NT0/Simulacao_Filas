import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapeadorFilas {
        private final Map<String, List<Fila>> mapping;


        public MapeadorFilas() {
            this.mapping = new HashMap<String, List<Fila>>();
        }

        public void addNext(Fila source, Fila target){
            if(!this.mapping.containsKey(source.getName()))
                this.mapping.put(source.getName(), new ArrayList<>());
            this.mapping.get(source.getName()).add(target);
        }

        public Fila getNext(Fila f){
            return this.mapping.get(f.getName()).get(0);
        }
        
}
