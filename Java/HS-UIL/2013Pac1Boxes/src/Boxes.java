import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Boxes {
    public static void main(String[] args) throws IOException {
        Scanner yeet = new Scanner(new File("Boxes.txt"));
        while(yeet.hasNext()){
            int boxSize = yeet.nextInt();
            for(int i=0; i<boxSize; i++){
                System.out.print("@");
            }
            System.out.println();
            for(int j=0; j<boxSize-2; j++){
                System.out.print("@");
                for(int i=0; i<boxSize-2; i++){
                    System.out.print(" ");
                }
                System.out.println("@");
            }
            for(int i=0; i<boxSize; i++){
                System.out.print("@");
            }
            System.out.println();
            System.out.println();
        }
    }
}
