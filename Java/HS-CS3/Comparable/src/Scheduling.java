import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Scheduling {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("schedule.dat"));
        ArrayList<Event> times = new ArrayList<>();
        int numOfSets = yeet.nextInt();
        while (numOfSets-- > 0){
            int numOfTimes = yeet.nextInt();
            for(int i=0; i<numOfTimes; i++){
                times.add(new Event(yeet.nextInt(), yeet.nextInt()));
            }
            Collections.sort(times);
            for(int i=0; i<times.size()-1; i++){
                if(times.get(i).endTime > times.get(i+1).startTime){
                    times.remove(i+1);
                    i--;
                }
            }
            times.clear();
        }
    }
}

class Event implements Comparable{
    int startTime;
    int endTime;

    public Event(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Object o) {
        return this.endTime - ((Event) o).endTime;
    }

    public String toString(){
        return startTime+" "+endTime;
    }
}
