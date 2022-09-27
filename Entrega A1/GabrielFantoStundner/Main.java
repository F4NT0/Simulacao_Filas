import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException{
        Random random = new Random(10, 1200, 100);
        PrintWriter pw = new PrintWriter(new FileWriter("Valores.txt"));

        for (int i = 0; i < 9000; i++) {
            double aleatorio = random.entreZeroUm();
            double pseudoAleatorio = random.pseudoAleatorio(aleatorio, 0, 1);
            System.out.printf("\n%.3f",pseudoAleatorio);
            String value = String.format("\n%.3f", pseudoAleatorio);
            pw.write(value); 
        }
    }
}
