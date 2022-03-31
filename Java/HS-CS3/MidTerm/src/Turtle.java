import java.awt.*;

public class Turtle {
    double heading, x, y;
    Color penColor;
    int yScaleUp, xScaleUp, yScaleDown, xScaleDown;

    public Turtle(int xScale, int yScale){
        StdDraw.enableDoubleBuffering();
        StdDraw.filledSquare(0, 0, 10000);
        StdDraw.setXscale(0, xScale);
        StdDraw.setYscale(0, yScale);
        this.xScaleUp = xScale;
        this.yScaleUp = yScale;
        this.xScaleDown = 0;
        this.yScaleDown = 0;
        penColor = Color.CYAN;
        heading = 0.0;
        x = 0;
        y = 0;
        show();
    }
    public void shiftScreenUp(double newShift){
        //StdDraw.clear();
        yScaleDown+=newShift;
        yScaleUp+=newShift;
        StdDraw.setYscale(yScaleDown, yScaleUp);
        StdDraw.setXscale(xScaleDown, xScaleUp);
        StdDraw.show();
    }
    public void clear(){
        StdDraw.clear();
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledSquare(0, 0, 10000);
        StdDraw.setXscale(0, 120);
        StdDraw.setYscale(0, 120);
        StdDraw.setPenColor(Color.CYAN);
    }
    public void forward(double distance) throws InterruptedException {
        StdDraw.setPenColor(penColor);
        double deltaX = Math.cos(Math.toRadians(heading))*distance;
        double deltaY = Math.sin(Math.toRadians(heading))*distance;
        StdDraw.line(x, y, x+deltaX, y+deltaY);
        x = x+deltaX;
        y = y+deltaY;
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
    public double getHeading(){
        return this.heading;
    }
    public void gotTo(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void show(){
        StdDraw.show();
    }
    public void setPenColor(Color newColor){
        penColor = newColor;
    }
}