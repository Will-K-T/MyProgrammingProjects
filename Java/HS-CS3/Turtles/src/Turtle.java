import java.awt.*;

public class Turtle {
    double heading, x, y;
    Color penColor;
    public Turtle(){
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        penColor = Color.BLACK;
        heading = 0.0;
        x = 50;
        y = 50;
    }
    public void forward(double distance) throws InterruptedException {
        StdDraw.setPenColor(penColor);
        double deltaX = Math.cos(Math.toRadians(heading))*distance;
        double deltaY = Math.sin(Math.toRadians(heading))*distance;
        StdDraw.line(x, y, x+deltaX, y+deltaY);
        x = x+deltaX;
        y = y+deltaY;
        Thread.sleep(100);
        StdDraw.show();
    }
    public void turnLeft(){
        heading += 90;
    }
    public void turnRight(){
        heading -= 90;
    }
    public void turnLeft(double degrees){
        heading += degrees;
    }
    public void turnRight(double degrees){
        heading -= degrees;
    }
    public void setHeading(double heading){
        this.heading = heading;
    }
    public void gotTo(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void setPenColor(Color newColor){
        penColor = newColor;
    }
}
