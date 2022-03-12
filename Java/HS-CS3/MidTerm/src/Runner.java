import java.util.Random;
import java.util.Scanner;

public class Runner {
    static int xScale = 120;
    static int yScale = 120;
    static Turtle turt = new Turtle(xScale,yScale);

    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        Scanner yeet = new Scanner(System.in);
        int numberOfSnowFlakes = 8;
        /*
        System.out.println("Enter the n :: ");
        int n = yeet.nextInt();
        System.out.println("Enter the length :: ");
        */
        double len = 5;
        int y = 120;
        int y2;
        int x;

        while(true) {
            for (int i = 0; i < numberOfSnowFlakes; i++) {
                x = rand.nextInt(120);

                turt.gotTo(x, y); turt.setHeading((double)rand.nextInt(360));
                doTheWhat(rand.nextInt(2) + 2, len);

                y2 = rand.nextInt(120)+y;
                turt.gotTo(x, y2); turt.setHeading((double)rand.nextInt(360));
                doTheWhat(rand.nextInt(2) + 2, len);

                turt.gotTo(x, rand.nextInt(y));
                doTheWhat(rand.nextInt(2) + 2, len);

                y-=rand.nextInt(2);
                if(y<=0){
                    y=120;
                }
            }
            Thread.sleep(100);
            turt.show();
            turt.clear();
        }
    }
    public static void doTheWhat(int n, double len) throws InterruptedException {
        drawTheFlake(n,len);
        turt.setHeading(turt.getHeading()-120);
        drawTheFlake(n,len);
        turt.setHeading(turt.getHeading()-120);
        drawTheFlake(n,len);
        //turt.show();
    }
    public static void drawTheFlake(int n, double len) throws InterruptedException {
        if(n==0){
            turt.forward(len);
            return;
        }
        drawTheFlake(n-1, len/3);
        turt.setHeading(turt.getHeading()+60);
        drawTheFlake(n-1, len/3);
        turt.setHeading(turt.getHeading()-120);
        drawTheFlake(n-1, len/3);
        turt.setHeading(turt.getHeading()+60);
        drawTheFlake(n-1, len/3);
    }
}