import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Star {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("star.dat"));
        int numOfSets = yeet.nextInt();
        for (int i = 0; i < numOfSets; i++) { //Goes through all of the data sets
            ArrayList<Person> ppl = new ArrayList<>();
            int numOfPeople = yeet.nextInt();
            for (int j = 0; j < numOfPeople; j++){ //Goes through all of the people in each data set
                String name = yeet.next();
                int grade = yeet.nextInt();
                ppl.add(new Person(name, grade));
            }
            Collections.sort(ppl);
            System.out.println(ppl.get(0).getName());
        }
    }
}

class Person implements Comparable<Person>{
    String name;
    int grade;

    public Person(String n, int g){
        name = n;
        grade = g;
    }

    public int getGrade(){
        return grade;
    }

    public String getName(){
        return name;
    }

    @Override
    public int compareTo(Person o) {
        return o.getGrade() - this.getGrade();
    }
}
