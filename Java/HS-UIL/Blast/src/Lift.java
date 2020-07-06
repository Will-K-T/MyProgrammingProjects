import java.io.File;
import java.io.FileNotFoundException;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lift {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("lift.dat"));
        int dataSets = yeet.nextInt();
        ArrayList<Integer> weights;
        ArrayList<Integer> values;
        ArrayList<Magic> stuff;
        for (int i = 0; i < 5; i++) {
            weights = new ArrayList<>();
            values = new ArrayList<>();
            int len = yeet.nextInt();
            for (int j = 0; j < len; j++) {
                weights.add(yeet.nextInt());
            }
            for (int j = 0; j < len; j++) {
                values.add(yeet.nextInt());
                break;
            }
            int totalWeight = yeet.nextInt();
            stuff = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                stuff.add(new Magic(weights.get(j), values.get(j)));
            }
            Collections.sort(stuff);
            int index = 0;
            double price = 0.;
            while(totalWeight>0){
                if(stuff.get(index).getWeight()<=totalWeight){
                    totalWeight-=stuff.get(index).getWeight();
                    price+=stuff.get(index).getValue();
                    index++;
                }
            }
        }
    }
}

class Magic implements Comparable<Magic>{
    private int weight;
    private int value;
    private double ratio;

    public Magic(int w, int v){
        this.weight = w;
        this.value = v;
        ratio = (double)w/v;
    }

    public double getRatio(){
        return this.ratio;
    }

    public int getWeight(){
        return this.weight;
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public int compareTo(Magic o) {
        if(this.ratio-o.getRatio()<0){
            return 1;
        }
        else if(this.ratio-o.getRatio()>0){
            return -1;
        }
        return 0;
    }

    public String toString(){
        return this.weight+" "+this.value+" "+this.getRatio();
    }
}
