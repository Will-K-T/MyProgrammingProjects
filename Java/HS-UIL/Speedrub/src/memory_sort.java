import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class memory_sort {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("memory_sort.dat"));
        ArrayList<Memory> sticks = new ArrayList<>();
        while (yeet.hasNextLine()){
            String[] nums = yeet.nextLine().split(",");
            sticks.add(new Memory(nums[0], nums[1], nums[2]));
        }
        Collections.sort(sticks);
        for (int i = 0; i < sticks.size(); i++) {
            System.out.println(sticks.get(i).getName()+" - "+"("+sticks.get(i).getSize()+"/"+sticks.get(i).getSpeed()+")");
        }
    }
}

class Memory implements Comparable<Memory>{

    private String name;
    private String size;
    private String speed;

    public Memory(String s1, String s2, String s3){
        name = s1;
        size = s2;
        speed = s3;
    }

    public String toString(){
        return this.name+" - "+"("+this.size+"/"+this.speed+")";
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getSpeed() {
        return speed;
    }

    @Override
    public int compareTo(Memory o) {
        if(this.name.equals(o.name)){
            if(this.size.equals(o.size)){
                return Integer.parseInt(o.speed.substring(0, o.speed.length()-3))-Integer.parseInt(this.speed.substring(0, this.speed.length()-3));
            }
            if(this.size.substring(this.size.length()-2).equals(o.size.substring(this.size.length()-2))){
                return Integer.parseInt(o.size.substring(0, o.size.length()-2))-Integer.parseInt(this.size.substring(0, this.size.length()-2));
            }
            else{
                if(this.size.substring(this.size.length()-2).equals("GB")){
                    return -1;
                }
                return 1;
            }
        }
        return this.name.compareTo(o.name);
    }
}
