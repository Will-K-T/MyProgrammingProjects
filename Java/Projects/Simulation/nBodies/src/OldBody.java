/*
This file is no longer used
This file was used before the 3D version
was created
I have not deleted it for future use
 */

public class OldBody {
    //region InstanceVars
    private static final double G = 6.673e-11;
    private double mass;
    private double radius;
    private Vector pos;
    private Vector vel;
    private Vector acc;
    private Vector force;
    //endregion

    public OldBody(double m, double r, double x, double y, double z){
        this.mass = m;
        this.radius = r;
        this.pos = new Vector(x, y, z);
        this.vel = new Vector(0,0,0);
        this.acc = new Vector(0,0,0);
    }

    public OldBody(double m, double r, double x, double y, double z, double vx, double vy, double vz){
        this.mass = m;
        this.radius = r;
        this.pos = new Vector(x, y, z);
        this.vel = new Vector(vx/1000000,vy/1000000,vz/1000000);
        this.acc = new Vector(0,0,0);
        force = new Vector(0,0,0);
    }

    public void update(double dt){
        vel = vel.add(new Vector(force.getX()/mass, force.getY()/mass, force.getZ()/mass), dt);
        pos = pos.add(vel, dt);
    }

    public void resetForce(){
        this.force = new Vector(0,0,0);
    }

    public void addForce(OldBody b){
        OldBody a = this;
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

    public void setVel(Vector vel) {
        this.vel = vel;
    }

    public void setAcc(Vector acc) {
        this.acc = acc;
    }
    //endregion
}

/* has everything to size
Sun 1.989e30 696.34e5 0 0 0 5.89e9 0 0
Mercury 0.330e24 2.439e6 5.79e10 0 0 0 0 4.74e4
Venus 4.87e24 6.052e6 1.0816e11 0 0 0 0 3.5e4
Earth 5.97e24 6.378e6 1.496e11 0 0 0 0 2.98e4
Mars 0.642e24 3.397e6 2.2793664e11 0 0 0 0 2.41e4
Jupiter 1898e24 7.1492e7 7.78369e11 0 0 0 0 1.31e4
Saturn 568e24 6.0268e7 1.427034e12 0 0 0 0 9.7e3
Uranus 86.8e24 2.5559e7 2.870658186e12 0 0 0 0 6.8e3
Neptune 102e24 2.4766e7 4.496976e12 0 0 0 0 5.4e3
 */