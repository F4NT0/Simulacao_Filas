package RafaelDosSantosCardoso;
public class Main {
    public static void main(String[] args) {
        Random random = new Random(20, 1250, 100);

        for (int i = 0; i < 9000; i++) {
            double aleatorio = random.entreZeroUm();
            double pseudoAleatorio = random.pseudoAleatorio(aleatorio, 0, 1);
            System.out.printf("\n%.3f",pseudoAleatorio
                ); 
                
        }
    }
}
