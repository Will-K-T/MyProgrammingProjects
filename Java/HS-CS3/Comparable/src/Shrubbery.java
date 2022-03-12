import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Shrubbery {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("shrubbery.dat"));
        int numOfSets = yeet.nextInt();
        while(numOfSets-- > 0){
            ArrayList<Shrub> shrubs = new ArrayList<>();
            int numOfShrubs = yeet.nextInt();
            for(int i=0; i<numOfShrubs; i++){
                //yeet.next();
                shrubs.add(new Shrub(yeet.next(), yeet.nextInt(), yeet.nextDouble(), yeet.nextDouble()));
            }
            String sort = yeet.next();
            for (int i = 0; i < shrubs.size(); i++) {
                shrubs.get(i).setSort(sort);
            }
            Collections.sort(shrubs);
            for (int i = 0; i < shrubs.size(); i++) {
                System.out.println(shrubs.get(i).getName());
            }
            System.out.println();
            //System.out.println(shrubs);
        }
    }
}

class Shrub implements Comparable{
    int nice;
    double price;
    public double size;
    String sort;
    String name;

    public Shrub(String n, int nice, double price, double size){
        this.nice = nice;
        this.price = price;
        this.size = size;
        name = n;
    }

    public void setSort(String sort){
        this.sort = sort;
    }

    public String getName(){return this.name;}

    @Override
    public int compareTo(Object o) {
        switch (sort){
            case "SIZE":
                //return (this.price > ((Shrub) o).price) ? -1 : 1;
                return (int)((((Shrub) o).size - this.size)*10000000);
            case "PRICE":
                return (int)((((Shrub) o).price - this.price)*1000000);
            case "NICE":
                return (((Shrub) o).nice - this.nice);
        }
        return 0;
    }

    public String toString(){
        return this.nice+" "+this.price+" "+this.size;
    }
}
