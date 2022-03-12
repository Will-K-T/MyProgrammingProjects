import java.util.Arrays;

public class CoinFlip {
    public static int bets = 0;
    public static void main(String[] args) {
        int wins = 0;
        int loses = 0;
        int totalGames = 0;
        for(int i=0; i<=1000; i++){
            totalGames++;
            if(headsOrTails(1000) == 0){
                loses++;
            }
            else{
                wins++;
            }
        }
        System.out.printf("The chance of winning is %.2f%% %n", ((double)wins/totalGames)*100);
        System.out.printf("The average number of bets before winning or losing is %.2f", ((double)bets/totalGames));
    }

    public static int headsOrTails(int loopNumber){
        double randomNum;
        int heads = 0;
        int tails = 0;
        int stake = 10;
        int goal = 20;
        while(stake>0 && stake<goal){
            randomNum = Math.random();
            bets++;
            if(randomNum < .5){
                heads += 1;
                stake--;
            }
            else{
                tails += 1;
                stake++;
            }
        }
        //System.out.printf("Tails %.2f percent%n", ((double)heads/(double)(heads+tails))*100);
        //System.out.printf("Heads %.2f percent", ((double)heads/(double)(heads+tails))*100);
        return stake;
    }
}
