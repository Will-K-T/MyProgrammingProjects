import java.util.ArrayList;

public class Display {
    public int width, height;

    public Display(int w, int h){
        this.width = w;
        this.height = h;
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, this.width);
        StdDraw.setYscale(0, this.height);
        StdDraw.setCanvasSize(this.width, this.height);
    }

    public void test(){
        double radius = .01;
        double points = 10;
        double space = 1/points;
        for(int i=0; i<points; i++){
            for(int j=0; j<points; j++){
                StdDraw.filledCircle(space*i+(space/2), space*j+(space/2), radius);
            }
        }
        //StdDraw.circle(this.width/2, this.height/2, 30);
        StdDraw.show();
    }

    public void drawVectors(Vector[][] vectors){
        double space = (double)1/vectors.length;
        for(int i=0; i<vectors.length; i++){
            for(int j=0; j<vectors[0].length; j++){
                Vector v = vectors[i][j];
                double x = v.getMagnitude() * Math.cos(v.getTheta()) / 20;
                double y = v.getMagnitude() * Math.sin(v.getTheta()) / 20;
                StdDraw.line(space*i+(space/2), space*j+(space/2), space*i+(space/2)+x, space*j+(space/2)+y);
            }
        }
    }

    public void drawBodies(Bodies b){
        ArrayList<Body> bodies = b.getBodies();
        for (Body body: bodies) {
            StdDraw.filledCircle(body.getPos().getX(), body.getPos().getY(), body.getSize());
        }
    }
}
