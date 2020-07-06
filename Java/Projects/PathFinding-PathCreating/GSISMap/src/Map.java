import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Map {
    private Scanner yeet;
    private int[][] map;

    public Map() throws FileNotFoundException {
        map = new int[480][840];
        yeet = new Scanner(new File("Colorado_844x480.dat"));
        makeMap();
    }

    public int[][] getMap(){
        return map;
    }

    public void makeMap(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = yeet.nextInt();
            }
        }
    }

    public String findExtreme(){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 0;
        while(yeet.hasNext()){
            count++;
            int num = yeet.nextInt();
            if(num<min){
                min = num;
            }
            if(num>max){
                max = num;
            }
        }
        return min+" "+max+" "+count;
    }

    public String toString(){
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        return Arrays.deepToString(map);
    }
}
