import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Triangles {
    public static void main(String[] args) throws IOException {
        Scanner yeet = new Scanner(new File("Triangles.txt"));
        int numberOfSets = yeet.nextInt();
        yeet.nextLine();
        for(int i=0; i<numberOfSets; i++){
            int size = yeet.nextInt();
            char let = yeet.next().charAt(0);
            for(int j=0; j<size; j++){
                for(int l=0; l<j; l++){
                    System.out.print(" ");
                }
                for(int k=j; k<size; k++){
                    if(let+(size-j-1)<=90) {
                        System.out.print((char)(let + (size - j - 1)));
                    }
                    else{
                        System.out.print((char)(65 + (size-j-2)));
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
