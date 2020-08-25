public class Vector {
    private double x;
    private double y;
    private double z;

    //region Constructors
    public Vector(double x, double y){
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    //endregion

    //region Vector Methods

    /**
     * adds two vectors together
     * @param v the vector to be added
     * @param dt scalar
     * @return the resultant vector
     */
    public Vector add(Vector v, double dt){
        return new Vector(this.getX()+v.getX()*dt, this.getY()+v.getY()*dt, this.getZ()+v.getZ()*dt);
    }

    /**
     * adds two vectors together
     * @param v the vector to be added
     * @return the resultant vector
     */
    public Vector add(Vector v){
        return new Vector(this.getX()+v.getX(), this.getY()+v.getY(), this.getZ()+v.getZ());
    }

    /**
     * subtracts two vectors
     * @param v the vector to be subtracted
     * @return the resultant vector
     */
    public Vector diff(Vector v){
        return new Vector(this.getX()-v.getX(), this.getY()-v.getY(), this.getZ()-v.getZ());
    }

    /**
     * divides the vector by a scalar
     * @param d scalar
     * @return the resultant vector
     */
    public Vector div(double d){
        return new Vector(this.getX()/d, this.getY()/d, this.getZ()/d);
    }
    //endregion

    //region Gets and Sets
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
    //endregion

    public String toString(){
        return this.getX()+" "+this.getY()+" "+this.getZ();
    }
}