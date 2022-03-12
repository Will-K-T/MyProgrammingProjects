import javafx.scene.shape.Sphere;
import javafx.scene.paint.Color;

public class Body {
    //region InstanceVars
    private static final double G = 6.673e-11;
    private double mass;
    private double radius;
    private Vector pos;
    private Vector vel;
    private Vector acc;
    private Vector force;
    private Sphere sphere;
    private Color color;
    private String name;
    //endregion

    /**
     * constructor to set up a new body object
     * @param name name of the body
     * @param m mass of the body
     * @param r radius of the body
     * @param x x pos of the body
     * @param y y pos of the body
     * @param z z pos of the body
     * @param vx initial vel in the x direction
     * @param vy initial vel in the y direction
     * @param vz initial vel in the z direction
     * @param s sphere that is used for graphics
     */
    public Body(String name, double m, double r, double x, double y, double z, double vx, double vy, double vz, Sphere s){
        this.name = name;
        this.mass = m;
        this.radius = r;
        this.pos = new Vector(x, y, z);
        this.vel = new Vector(vx/1000000,vy/1000000,vz/1000000);
        this.acc = new Vector(0,0,0);
        force = new Vector(0,0,0);
        this.sphere = s;
        sphere.setRadius(radius);
        setSphereInitPos();
    }

    /**
     * Sets the graphical sphere to the pos of the body object
     */
    public void setSphereInitPos(){
        sphere.translateXProperty().set(pos.getX());
        sphere.translateYProperty().set(pos.getY());
        sphere.translateZProperty().set(pos.getZ());
    }

    /**
     * updates the vel, and pos of the object scaled by the timeStep
     * @param dt timeStep
     */
    public void update(double dt){
        vel = vel.add(new Vector(force.getX()/mass, force.getY()/mass, force.getZ()/mass), dt);
        pos = pos.add(vel, dt);
        sphere.translateXProperty().set(pos.getX());
        sphere.translateYProperty().set(pos.getY());
        sphere.translateZProperty().set(pos.getZ());
    }

    /**
     * resets the force acting on the object
     */
    public void resetForce(){
        this.force = new Vector(0,0,0);
    }

    /**
     * Adds the force between this body and body b to the total force acting on the body
     * @param b a body that is acting upon this body
     */
    public void addForce(Body b){
        Body a = this;
        double EPS = 3E4;
        double dx = b.getPos().getX() - a.getPos().getX();
        double dy = b.getPos().getY() - a.getPos().getY();
        double dz = b.getPos().getZ() - a.getPos().getZ();
        double dist = Math.sqrt(dx*dx + dy*dy + dz*dz);
        //double dist = Math.sqrt(dx*dx + dy*dy);
        double F = (G * a.getMass() * b.getMass()) / (dist*dist + EPS*EPS);
        a.force = a.force.add(new Vector(F*dx/dist, F*dy/dist, F*dz/dist));
    }

    //region Gets and Sets
    public double getX(){
        return pos.getX();
    }

    public String getName(){ return this.name; }

    public double getY(){
        return pos.getY();
    }

    public double getZ(){
        return pos.getZ();
    }

    public double getRadius(){
        return this.radius;
    }

    public Vector getPos() {
        return pos;
    }

    public Vector getVel() {
        return vel;
    }

    public Vector getAcc() {
        return acc;
    }

    public double getMass() {
        return mass;
    }

    public Color getColor(){
        return color;
    }

    public Sphere getSphere(){
        return this.sphere;
    }

    public void setVel(Vector vel) {
        this.vel = vel;
    }

    public void setAcc(Vector acc) {
        this.acc = acc;
    }

    public void setColor(Color c){
        this.color = c;
    }
    //endregion

}