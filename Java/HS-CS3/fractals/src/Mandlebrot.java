import java.awt.*;

public class Mandlebrot {
    double leftBound, rightBound, downBound, upBound;
    Picture mandle;
    float numOfColors = 255f;
    int numOfIterations = 2500;
    int sectors = 1;
    int halfWidth;
    int halfHeight;

    public Mandlebrot(Picture mandle, double downBound, double upBound, double leftBound, double rightBound, int halfHeight, int halfWidth) throws InterruptedException {
        this.mandle = mandle;
        this.halfHeight=halfHeight;this.halfWidth=halfWidth;
        this.leftBound = leftBound;this.rightBound = rightBound;this.downBound = downBound;this.upBound = upBound;
        makeMandlebrot(this.downBound, this.upBound, this.leftBound, this.rightBound);
        mandle.show();
        Thread.sleep(10);
    }

    public void clear(){
        for(int row=0; row<mandle.height(); row++){
            for(int col=0; col<mandle.width(); col++){
                mandle.set(col, row, Color.black);
            }
        }
    }

    public void clear(int r, int c){
        for(int row=r; row<r+mandle.width()/2; row++){
            for(int col=c; col<c+mandle.width()/2; col++){
                mandle.set(col, row, Color.black);
            }
        }
    }

    public void makeMandlebrot(double downStart, double upEnd, double leftStart, double rightEnd){
        for(double j=downStart; j<upEnd; j+=(upEnd-downStart)/525) {
            for (double i=leftStart; i<rightEnd; i+=(rightEnd-leftStart)/525) {
                Complex point = new Complex(i, j);
                isMandlebrot(point);
            }
        }
    }

    public void isMandlebrot(Complex point){
        Complex z = point;
        int i;
        int iterations = 0;
        for(i=0; i<numOfIterations; i++){
            iterations++;
            z = (z.multiply(z)).add(point);
            if(z.getA()>=2.0 || z.getB()>=2.0){
                break;
            }
        }
        if(iterations!=i){
            mandle.set((int)((((point.getA()-leftBound)/(rightBound-leftBound)))*mandle.width()/sectors)+halfWidth, (mandle.height()-1)-(int)((((point.getB()-downBound)/(upBound-downBound)))*(mandle.height()/sectors))-halfHeight, new Color(Color.HSBtoRGB(iterations/numOfColors, 1f, 1f)));
        }
        //(x+1.5)*(500/2)
    }

}
