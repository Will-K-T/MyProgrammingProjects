public class Runner {
    public static void main(String[] args) {
        Display canvas = new Display(800, 800);
        VectorField field = new VectorField(10, 10);


        double x = 0;
        double y = 0;
        Bodies bodies = new Bodies();
//        for (int i = 0; i < 10; i++) {
//            bodies.addBody(new Body(Math.random(), Math.random(), .01));
//        }
        //bodies.addBody(new Body(.5, .5, .01, .0001));
        while (true) {
            StdDraw.clear();
            field.randNoise(new OpenSimplexNoise(), .1, x, y);
            //bodies.updateBodies(field);
            //canvas.drawBodies(bodies);
            canvas.drawVectors(field.getField());
            x += .001;
            y += .001;
            StdDraw.show();
        }
    }
}
