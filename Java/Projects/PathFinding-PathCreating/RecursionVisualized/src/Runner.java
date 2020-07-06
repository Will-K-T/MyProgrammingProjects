import java.awt.*;

import static java.awt.event.KeyEvent.*;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Picture naenae = new Picture(1000, 1000);
        StdDraw.enableDoubleBuffering();
        float color=0.0f, trig=0.0f;
        boolean up = true;
        double side=0.0, upDown=0.0;
        double[] xCords = {0.4, .5, .6};
        double[] yCords = {0.5, (.2*Math.sqrt(3))/2+.5, 0.5};
        double[] negativeYCords = {0.5, -(.2*Math.sqrt(3))/2+.5, 0.5};
        char letterPressed = 0;
        int counter=0;
        int length=1;

        while(true){
            if(StdDraw.hasNextKeyTyped()){
                letterPressed = StdDraw.nextKeyTyped();
            }
            if(letterPressed=='w'){
                StdDraw.filledCircle(side, upDown+=.01, .01);
            }
            if(letterPressed=='a'){
                StdDraw.filledCircle(side-=.01, upDown, .01);
            }
            if(letterPressed=='d'){
                StdDraw.filledCircle(side+=.01, upDown, .01);
            }
            if(letterPressed=='s'){
                StdDraw.filledCircle(side, upDown-=.01, .01);            }
            //StdDraw.clear();
            StdDraw.show();
            Thread.sleep(70);
            counter++;
            if(counter==length){
                StdDraw.clear();
                counter=0;
            }
        }
        /*
        while(true){
            StdDraw.setPenColor(Color.getHSBColor(color,1f, 1f));
            StdDraw.filledCircle(Math.cos(trig-.5)/3 + .5, Math.sin(trig-.5)/3 + .5, .01);
            StdDraw.filledPolygon(xCords, yCords);
            StdDraw.filledPolygon(xCords, negativeYCords);
            StdDraw.filledSquare(.5, .1, .1);
            StdDraw.filledSquare(.1, .5, .1);
            StdDraw.filledSquare(.9, .5, .1);
            StdDraw.filledSquare(.5, .9, .1);
            StdDraw.line(0,0,1,1);
            StdDraw.line(0,1,1,0);
            //Thread.sleep(1);
            StdDraw.show();
            if(trig<(Math.PI*2)){
                trig+=.01;
            }
            else{
                trig=0.0f;
            }
            if(up){
                if(color<.99){
                    color+=.01;
                }
                else{
                    up = false;
                }
            }
            if(!up){
                if(color>0.01){
                    color-=.01;
                }
                else{
                    up=true;
                }
            }
        }*/
        /*
        int red = 0;
        int green = 0;
        int blue = 255;
        int loop = 0;
        int color = (red<<16) + (green<<8) + (blue);
        int counter = 0;
        int howMany = (naenae.width()/255)+1;
        while(counter<naenae.width()) {
            for (int row = 0; row < naenae.height(); row++) {
                for (int col = counter; col < counter+howMany; col++) {
                    naenae.setRGB(col, row, red);
                }
                //Thread.sleep(1);
                naenae.show();
            }
            red++;
            counter+=howMany;
        }*/
    }
}
