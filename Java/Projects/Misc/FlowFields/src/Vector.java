public class Vector {
    double x, y, z;
    double theta;
    double magnitude;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.theta = this.getTheta();
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
        this.z = 0;
        this.theta = this.getTheta();
    }

    public void add(Vector o){
        this.setX(this.getX() + o.getX());
        this.setY(this.getY() + o.getY());
        this.setZ(this.getZ() + o.getZ());
    }

    public void multScalar(double scalar){
        this.setX(this.getX() * scalar);
        this.setY(this.getY() * scalar);
        this.setZ(this.getZ() * scalar);
    }

    public void normalize(){
        if(this.getMagnitude() > 0) {
            this.x /= this.getMagnitude();
            this.y /= this.getMagnitude();
            this.z /= this.getMagnitude();
        }
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public double getTheta() {
        return Math.atan(this.getY()/this.getX());
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String toString(){
        return "X: "+this.getX()+" Y: "+this.getY();
    }
}
