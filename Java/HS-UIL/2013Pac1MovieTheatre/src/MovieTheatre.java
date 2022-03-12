import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MovieTheatre {
    public static void main(String[] args) throws IOException {
        Scanner yeet = new Scanner(new File("MovieTheatre.txt"));
        int numberOfSets = yeet.nextInt();
        yeet.nextLine();
        for(int i=0; i<numberOfSets; i++){
            int numOfSeats = yeet.nextInt();
            int people = yeet.nextInt();
            if(numberOfSets<=people){
                System.out.println(0);
            }
            else{
                int pairs = 0;
                for(int j=(2*(people-2)); j<numOfSeats; j++){
                    for(int k=j+1; k<numOfSeats; k++){
                        if(k>j+1){
                            pairs++;
                        }
                    }
                }
                System.out.println(pairs+(people-2));
            }
        }
    }
}
