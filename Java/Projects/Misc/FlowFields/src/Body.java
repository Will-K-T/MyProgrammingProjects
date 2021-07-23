import org.omg.PortableInterceptor.DISCARDING;

public class Body {
    Vector pos;
    Vector vel;
    Vector acc;
    double size;
    double maxVel;

    public Body(double x, double y, double size, double maxVel){
        pos = new Vector(x, y);
        vel = new Vector(0, 0);
        acc = new Vector(0, 0);
        this.size = size;
        this.maxVel = maxVel;
    }

    public void updatePos(){
        updateVel();
        this.pos.add(this.vel);
        this.pos.setX((this.pos.getX() + 1.0) % 1.0);
        this.pos.setY((this.pos.getY() + 1.0) % 1.0);
        this.setAcc(new Vector(0, 0));
    }

    // TODO: 4/12/2021
    // Fix the velocity being way too fast
    public void updateVel(){
        if(Math.abs(this.vel.getMagnitude() - maxVel) <= maxVel) {
            this.vel.add(this.acc);
        }
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Vector getPos() {
        return pos;
    }

    public void setPos(Vector pos) {
        this.pos = pos;
    }

    public Vector getVel() {
        return vel;
    }

    public void setVel(Vector vel) {
        this.vel = vel;
    }

    public Vector getAcc() {
        return acc;
    }

    public void setAcc(Vector acc) {
        this.acc = acc;
    }

    public double getMaxVel() {
        return maxVel;
    }

    public void setMaxVel(double maxVel) {
        this.maxVel = maxVel;
    }
}
