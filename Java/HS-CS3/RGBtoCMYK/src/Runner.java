import java.util.*;
//This is the RGB to CMYK
public class Runner {
    public static void main(String[] args){
        double red = Double.parseDouble(args[0]);
        double green = Double.parseDouble(args[1]);
        double blue = Double.parseDouble(args[2]);
        double w, c, m, y, k;
        if((red>=0 && red<=255) && (green>=0 && green<=255) && (blue>=0 && blue<=255)){
            w = Math.max(Math.max(red/255, green/255), blue/255);
            c = (w-(red/255))/w;
            m = (w-(green/255))/w;
            y = (w-(blue/255))/w;
            k = 1-w;
            System.out.printf("C=%.2f ", c);
            System.out.printf("M=%.2f ", m);
            System.out.printf("Y=%.2f ", y);
            System.out.printf("K=%.2f", k);
        }
        else{
            System.out.print("Please enter 3 valid RGB values!");
        }
    }
}
