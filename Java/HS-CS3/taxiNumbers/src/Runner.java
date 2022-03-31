import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);
        int maxNumber = (int)Math.cbrt(number)+1;
        int aCube, bCube, cCube, dCube;

        ArrayList<Integer> taxi = new ArrayList<>();
        for (int a = 0; a < maxNumber; a++) {
            aCube = a*a*a;
            for (int b = a+1; b < maxNumber; b++) {
                bCube = b*b*b;
                for (int c = a+1; c < maxNumber; c++) {
                    cCube = c*c*c;
                    for (int d = c+1; d < maxNumber; d++) {
                        dCube = d*d*d;
                        if(b != c) {
                            if (((aCube+bCube) == (cCube+dCube))) {
                                taxi.add(aCube+bCube);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(taxi);
    }
}
