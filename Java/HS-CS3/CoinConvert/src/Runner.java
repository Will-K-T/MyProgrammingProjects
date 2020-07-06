import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner yeet = new Scanner(System.in);
        do{
            System.out.print("Please enter a value :: ");
            double price = yeet.nextDouble();
            calcCoins(price);
        }while (true);
    }

    public static void calcCoins(double price){
        int wholeDollar=0, halfDollar=0, quarter=0, dime=0, nickel=0, penny = 0;
        while(price>.01){
            if(price-1.0 >= 0){
                price-=1.0;
                wholeDollar++;
            }
            else if(price-.5 >= 0){
                price-=.5;
                halfDollar++;
            }
            else if(price-.25 >= 0){
                price-=.25;
                quarter++;
            }
            else if(price-.1 >= 0){
                price-=.1;
                dime++;
            }
            else if(price-.05 >= 0){
                price-=.05;
                nickel++;
            }
            else if(price-.01 >= 0){
                price-=.01;
                penny++;
            }
        }
        System.out.println("WholeDollars: "+wholeDollar+"\nHalfDollar: "+halfDollar+"\nQuarter: "+quarter+"\nDime: "+dime+"\nNickel: "+nickel+"\nPenny: "+penny);
    }
}
