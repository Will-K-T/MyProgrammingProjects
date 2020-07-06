import java.awt.*;

public class Runner {
    public static void main(String[] args) throws InterruptedException {

        //region scaling
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(-1, 10);
        StdDraw.setYscale(-1, 10);
        //endregion

        //region Arrays needed to store sin, cos, tan, and line cords
        double[][] pointsSin = new double[600][2], pointsCos = new double[600][2], pointsTan = new double[600][2];
        double[][] linePointsCos = new double[2][2], linePointsSin = new double[2][2];
        //endregion

        boolean alternate = false, yopo = false;
        int count = 0, countTan = 0;
        double x = 0.0;
        double osc = 1.;

        double sin;
        double cos;
        double tan;
        while(true){
            StdDraw.clear();
            StdDraw.setPenColor(Color.red);
            StdDraw.text(8, 0, "Sin(x)");
            StdDraw.setPenColor(Color.green);
            StdDraw.text(8, 4, "Cos(x)");
            StdDraw.setPenColor(Color.blue);
            StdDraw.text(8, 8, "Tan(x)");
            StdDraw.setPenColor(Color.black);
            sin = Math.sin(x*osc);
            cos = Math.cos(x*osc);
            tan = -Math.tan(x*osc);

            if(StdDraw.isKeyPressed(38)){
                osc += .1;
            }

            if(StdDraw.isKeyPressed(40)){
                osc -= .1;
            }

            if(cos>.99 && sin<.09 && sin>=0){
                if(!alternate) {
                    linePointsCos[0] = new double[]{1, cos + 4};
                    linePointsSin[0] = new double[]{1, sin};
                    alternate = true;
                }
                else{
                    linePointsCos[1] = new double[]{1, cos + 4};
                    linePointsSin[1] = new double[]{1, sin};
                    alternate = false;
                }
            }//Finds the cords to make a new vert line

            //region Makeing the circles
            StdDraw.circle(0, 8, 1);
            StdDraw.line(0, 8, (cos), (sin)+8);

            StdDraw.circle(0, 4, 1);
            StdDraw.line(0, 4, (cos), (sin)+4);

            StdDraw.circle(0, 0, 1);
            StdDraw.line(0, 0, (cos), (sin));
            //endregion

            //region Finds the cords for all sin, cos, and tan values
            if (count < pointsCos.length) {
                pointsCos[count] = new double[]{1, cos + 4};
            }
            if (count < pointsSin.length) {
                pointsSin[count] = new double[]{1, sin};
            }
            else{
                count = 0;
            }
            if(countTan<pointsTan.length && ((tan+8)>7 && (tan+8)<9)){
                pointsTan[countTan] = new double[]{1, tan + 8};
            }
            else{
                countTan = 0;
            }
            //endregion

            //region Animating all of the functions
            shiftPoints(pointsSin, 0);
            shiftPoints(pointsCos, 1);
            shiftPoints(pointsTan, 2);
            shiftLines(linePointsCos);
            shiftLines(linePointsSin);
            //endregion

            //region Necessary counters
            countTan++;
            count++;
            x+=.01;
            //endregion

            yopo = StdDraw.isKeyPressed(38);
            StdDraw.show();
        }
    }

    public static void drawLine(double[][] p){
        StdDraw.setPenColor(Color.black);
        for (int i = 0; i < p.length; i++) {
            if(!(p[i]==null)){
                StdDraw.line(p[i][0], p[i][1]-10, p[i][0], p[i][1]+10);
            }
        }
    }

    public static void shiftLines(double[][] p){
        for (int i = 0; i < p.length; i++) {
            if(!(p[i]==null)){
                p[i][0]+=.01;
            }
        }
        drawLine(p);
    }

    public static void shiftPoints(double[][] p, int color){
        for (int i = 0; i < p.length; i++) {
            if(!(p[i]==null)){
                p[i][0]+=.01;
            }
        }
        drawPoints(p, color);
    }

    public static void drawPoints(double[][] p, int color){
        if(color==0){
            StdDraw.setPenColor(Color.red);
        }
        if(color==1){
            StdDraw.setPenColor(Color.green);
        }
        if(color==2){
            StdDraw.setPenColor(Color.blue);
        }
        for (int i = 0; i < p.length; i++) {
            if(!(p[i]==null)){
                StdDraw.point(p[i][0], p[i][1]);
            }
            else{
                break;
            }
        }
        StdDraw.setPenColor(Color.black);
    }
}
