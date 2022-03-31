import java.util.Stack;
import java.util.concurrent.Callable;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Picture mandle = new Picture(500, 500);
        double x = -0.04524074130409;
        double y = 0.9868162207157852;
        double zoom = 1*2.0;
        //region Test Threads
        /*
        myThread tOne = new myThread("One", mandle, y, y+zoom, x - zoom, x, 250, 0, x, y, zoom);
        myThread tTwo = new myThread("Two", mandle, y, y+zoom, x, x+zoom, 250, 250, x, y, zoom);
        myThread tThree = new myThread("Three", mandle, y - zoom, y, x - zoom, x, 0, 0, x, y, zoom);
        myThread tFour = new myThread("Four", mandle, y - zoom, y, x, x+zoom, 0, 250, x, y, zoom);
        //*/
        //endregion
        //region Mandle Threads
        DemoThread mandleOne = new DemoThread(-0.235125, 0.827215, 4.0E-5);
        DemoThread mandleTwo = new DemoThread(-1.15412664822215, 0.30877492767139, 6.2E-11);
        DemoThread mandleThree = new DemoThread(-0.745428, 0.113009, 3.0E-5);
        mandleOne.start();
        mandleTwo.start();
        mandleThree.start();
        //6.7e-14
        while(true) {
            Mandlebrot test;
            x = -0.04524074130409;
            y = 0.9868162207157852;
            zoom = 1*2.0;
            for(; zoom>6.7e-14; zoom=zoom/1.2) {
                try {
                    test = new Mandlebrot(mandle, y - zoom, y + zoom, x - zoom, x + zoom, 0,0);
                }catch (Exception e){
                    continue;
                }
                test.clear();
            }

            x = -1.15412664822215;
            y = 0.30877492767139;
            zoom = 1*2.0;
            for(; zoom>6.2E-11; zoom=zoom/1.2) {
                try {
                    test = new Mandlebrot(mandle, y - zoom, y + zoom, x - zoom, x + zoom, 0,0);
                }catch (Exception e){
                    continue;
                }
                test.clear();
            }

            x = -0.235125;
            y = 0.827215;
            zoom = 1*2.0;
            for(; zoom>4.0E-5; zoom=zoom/1.2) {
                try {
                    test = new Mandlebrot(mandle, y - zoom, y + zoom, x - zoom, x + zoom, 0,0);
                }catch (Exception e){
                    continue;
                }
                test.clear();
            }

            x = -0.745428;
            y = 0.113009;
            zoom = 1*2.0;
            for(; zoom>3.0E-5; zoom=zoom/1.2) {
                try {
                    test = new Mandlebrot(mandle, y - zoom, y + zoom, x - zoom, x + zoom, 0,0);
                }catch (Exception e){
                    continue;
                }
                test.clear();
            }
        }
        //endregion

        //region Starting Threads
        //mandleOne.start();
        //mandleTwo.start();
        ///mandleThree.start();
        //mandleFour.start();
        //Mandlebrot test;
        //Mandlebrot test = new Mandlebrot(mandle, y - zoom, y + zoom, x - zoom, x + zoom, 0,0);
        //endregion

        //Zooms into the madle at (x,y)
        /*
        for(; zoom>6.7e-14; zoom=zoom/1.2) {
            try {
                test = new Mandlebrot(mandle, y - zoom, y + zoom, x - zoom, x + zoom, 0,0);
            }catch (Exception e){
                continue;
            }
            test.clear();
        }//*/
    }
}
