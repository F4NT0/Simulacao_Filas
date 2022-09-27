import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args)  throws IOException{
        Random random = new Random(15, 1300, 100);
        try (PrintWriter pw = new PrintWriter(new FileWriter("Valores.txt"))) {
            for (int i = 0; i < 2000; i++) {
                double aleatorio = random.entreZeroUm();
                double pseudoAleatorio = random.pseudoAleatorio(aleatorio, 0, 1);
                String value = String.format("\n%.3f", pseudoAleatorio);
                System.out.printf(value);
                pw.write(value);  
                    
            }
        }
    }
}
