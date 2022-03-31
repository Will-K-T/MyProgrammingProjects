import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class card_sort {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("card_sort.dat"));
        ArrayList<Card> cards = new ArrayList<>();
        while(yeet.hasNextLine()){
            String[] items = yeet.nextLine().split("/");
            cards.add(new Card(items[0], Double.parseDouble(items[1]), Double.parseDouble(items[2])));
        }
        Collections.sort(cards);
        for (int i = 0; i < cards.size(); i++) {
            Card curr = cards.get(i);
            System.out.printf("%.2f (%s/%.2f/%.2f)%n", curr.getPwr(), curr.getName(), curr.getAttk(), curr.getCost());
        }
    }
}

class Card implements Comparable<Card>{

    String name;
    double attk;
    double cost;
    double pwr;

    public Card(String name, double attk, double cost) {
        this.name = name;
        this.attk = attk;
        this.cost = cost;
        pwr = attk/cost;
    }

    public String getName() {
        return name;
    }

    public double getAttk() {
        return attk;
    }

    public double getCost() {
        return cost;
    }

    public double getPwr() {
        return pwr;
    }

    @Override
    public int compareTo(Card o) {
        if(this.getPwr()==o.getPwr()){
            if(this.getAttk()==o.getAttk()){
                return this.getName().compareTo(o.getName());
            }
            double d = o.getAttk()-this.getAttk();
            if(d>0){
                return 1;
            }
            else if(d<0){
                return -1;
            }
            else{
                return 0;
            }
        }
        double g = o.getPwr()-this.getPwr();
        if(g>0){
            return 1;
        }
        else if(g<0){
            return -1;
        }
        return 0;
    }
}
