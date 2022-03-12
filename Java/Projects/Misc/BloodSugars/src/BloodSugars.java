import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BloodSugars {

    public BloodSugars(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        String[][] csvData = new String[3722][14];
        int count = 0;
        while(sc.hasNext()){
            String line = sc.nextLine();
            String reg;
            reg = "^(\\d{2,},\\d{2}).*";
            if(line.matches(reg)){
                csvData[count] = line.split(",", -1);
                count++;
            }
        }//Creates the 2D array of data in Strings

        //drawHourGraph(createHours(csvData));
        draw15Graph(createFifteenMinutes(csvData));
    }

    public Hour[] createFifteenMinutes(String[][] data){
        Hour[] hours = new Hour[24];
        for (int i = 0; i < data.length; i++) {
            int h = Integer.parseInt(data[i][1].substring(11, 13));
            int m = Integer.parseInt(data[i][1].substring(14, 16));
            int s = Integer.parseInt(data[i][7]);
            if(hours[h]==null){
                hours[h] = new Hour(h);
                hours[h].addSugar15(m, s);
            }
            else{
                hours[h].addSugar15(m, s);
            }
        }
        return hours;
    }

    public Hour[] createHours(String[][] data){
        Hour[] hours = new Hour[24];
        for (int i = 0; i < data.length; i++) {
            int h = Integer.parseInt(data[i][1].substring(11, 13));
            int s = Integer.parseInt(data[i][7]);
            if(hours[h]==null){
                hours[h] = new Hour(h);
                hours[h].addSugar(s);
            }
            else{
                hours[h].addSugar(s);
            }
        }
        return hours;
    }

    public void drawHourGraph(Hour[] hours){
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 24);
        StdDraw.setYscale(0, 400);
        double prevX = 0., prevY = 0.;
        boolean first = true;
        for (int i = 0; i < hours.length; i++) {
            if(first){
                StdDraw.point(i, hours[i].getAvgSugar());
                prevX = i;
                prevY = hours[i].getAvgSugar();
                first = false;
            }
            else{
                StdDraw.point(i, hours[i].getAvgSugar());
                StdDraw.line(prevX, prevY, i, hours[i].getAvgSugar());
                prevX = i;
                prevY = hours[i].getAvgSugar();
            }
        }
        StdDraw.show();
    }

    public void draw15Graph(Hour[] hours){
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 96);
        StdDraw.setYscale(50, 1000);
        double[] fifteenMins;
        int count = 0;
        double prevX = 0., prevY = 0.;
        boolean first = true;
        for (int i = 0; i < hours.length; i++) {
            fifteenMins = hours[i].getAvgSugar15();
            if(first){
                StdDraw.point(count, fifteenMins[0]);
                prevX = count;
                prevY = fifteenMins[0];
                for (int j = 1; j < fifteenMins.length; j++) {
                    StdDraw.point(count, fifteenMins[j]);
                    StdDraw.line(prevX, prevY, count, fifteenMins[j]);
                    prevX = count;
                    prevY = fifteenMins[j];
                    count++;
                }
                count = 3;
                first = false;
            }
            else {
                for (int j = 0; j < fifteenMins.length; j++) {
                    StdDraw.point(count, fifteenMins[j]);
                    StdDraw.line(prevX, prevY, count, fifteenMins[j]);
                    prevX = count;
                    prevY = fifteenMins[j];
                    count++;
                }
            }
        }

        System.out.println(Arrays.toString(hours[16].getAvgSugar15()));
        StdDraw.setPenColor(Color.red);
        StdDraw.line(0, 80, 96, 80);

        StdDraw.setPenColor(Color.orange);
        StdDraw.line(0, 300, 96, 300);

        StdDraw.setPenColor(Color.green);
        StdDraw.line(0, 120, 96, 120);
        StdDraw.show();
    }

    public void drawnGraph(String[][] data){
        StdDraw.enableDoubleBuffering();
        int x = 0;
        StdDraw.setXscale(0.0, 3732);
        StdDraw.setYscale(0, 400);
        int total = 0;
        double avg = 0.;
        for (int i = 0; i < data.length; i++) {
            total += Integer.parseInt("0"+data[i][7]);
            StdDraw.point(x, Double.parseDouble("0"+data[i][7]));
            x+=1;
        }
        avg = total/3732.;
        StdDraw.setPenColor(Color.red);
        StdDraw.line(0, 80, 3732, 80);

        StdDraw.setPenColor(Color.orange);
        StdDraw.line(0, 300, 3732, 300);

        StdDraw.setPenColor(Color.green);
        StdDraw.line(0, 120, 3732, 120);

        StdDraw.setPenColor(Color.pink);
        StdDraw.line(0, avg, 3732, avg);

        StdDraw.show();
    }
}
