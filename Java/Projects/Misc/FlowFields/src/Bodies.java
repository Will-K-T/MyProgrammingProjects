import java.util.ArrayList;

public class Bodies {
    ArrayList<Body> bodies;

    public Bodies(){
        bodies = new ArrayList<>();
    }

    public void updateBodies(VectorField field){
        Vector[][] v = field.getField();
        for(int i=0; i<bodies.size(); i++){
            Body curr = bodies.get(i);
//            int r = (int)(Math.round(curr.getPos().getY() / v.length) + 10) % 10;
//            int c = (int)(Math.round(curr.getPos().getX() / v.length) + 10) % 10;
            int c = ((int)(curr.getPos().getX() * v.length) + 10) % 10;
            int r = ((int)(curr.getPos().getY() * v.length) + 10) % 10;
            Vector vec = v[r][c];
            curr.setAcc(new Vector(vec.getX(), vec.getY()));
            System.out.println(curr.getVel());
            curr.updatePos();



            System.out.println(r + " " + c);
            // System.out.println(curr.getX() + " " + curr.getY());
        }
    }

    public void addBody(Body b){
        this.bodies.add(b);
    }

    public ArrayList<Body> getBodies(){
        return this.bodies;
    }
}
