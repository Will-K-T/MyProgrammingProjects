//which is more likely: getting a 1 atleast once when rolling a fair die 6 times or getting 1 at least twice when rolling it 12 times
public class DieChances {
    public static void main(String[] args) {
        int numberOfOne6 = 0;
        int numberOfOne12 = 0;
        int numberOfOne18 = 0;
        for(int i=0; i<10000; i++){
            if(numberOfOneWith12()==1){
                numberOfOne12++;
            }
            if(numberOfOneWith6()==1){
                numberOfOne6++;
            }
            if(numberOfOneWith18()==1){
                numberOfOne18++;
            }
        }
        System.out.printf("Chance of rolling a 1 at least once with 6 rolls is %.2f%%\n", ((double)numberOfOne6/10000)*100);
        System.out.printf("Chance of rolling a 1 at least twice with 12 rolls is %.2f%%\n", ((double)numberOfOne12/10000)*100);
        System.out.printf("Chance of rolling a 1 at least three times with 12 rolls is %.2f%%", ((double)numberOfOne18/10000)*100);
    }

    public static int rollDie(){
        return (int)(Math.random()*6)+1;
    }

    public static int numberOfOneWith6(){
        int numberOfWins = 0;
        for(int i=0; i<6; i++){
            if(rollDie()==1){
                numberOfWins++;
            }
        }
        if(numberOfWins>=1){
            return 1;
        }
        return 0;
    }

    public static int numberOfOneWith12(){
        int numberOfWins = 0;
        for(int i=0; i<12; i++){
            if(rollDie()==1){
                numberOfWins++;
            }
        }
        if(numberOfWins>=2){
            return 1;
        }
        return 0;
    }

    public static int numberOfOneWith18(){
        int numberOfWins = 0;
        for(int i=0; i<18; i++){
            if(rollDie()==1){
                numberOfWins++;
            }
        }
        if(numberOfWins>=3){
            return 1;
        }
        return 0;
    }
}
