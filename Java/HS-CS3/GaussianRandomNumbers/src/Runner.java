//This is the random number generator
public class Runner {
    public static void main(String[] args) {
        double v = Math.random();
        double u = Math.random();
        double r = (Math.sin(2*Math.PI*v)*(Math.pow(-2*Math.log(u), (1/2))));
        System.out.println(r);
    }
}
