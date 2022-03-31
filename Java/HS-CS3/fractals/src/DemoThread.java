public class DemoThread extends Thread {
    Picture mandle = new Picture(500, 500);
    double x;
    double y;
    double startZoom = 1*2.0;
    double endZoom;


    public DemoThread(double x, double y, double zoom){
        this.x = x;
        this.y = y;
        endZoom = zoom;
    }
    @Override
    public void run(){
        Mandlebrot test;
        for(; startZoom>endZoom; startZoom=startZoom/1.2) {
            try {
                test = new Mandlebrot(mandle, y - startZoom, y + startZoom, x - startZoom, x + startZoom, 0,0);
            }catch (Exception e){
                continue;
            }
            test.clear();
        }
    }
}
