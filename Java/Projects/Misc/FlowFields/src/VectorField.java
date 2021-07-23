public class VectorField {
    Vector[][] field;

    public VectorField(int r, int c){
        field = new Vector[r][c];
    }

    public void randomize(int xRange, int yRange, int zRange){
        for(int i=0; i<field.length; i++){
            for(int j=0; j<field[0].length; j++){
                double x, y = 0;
                if(Math.random() < .5){
                    x = Math.random() * xRange;
                }else{
                    x = -1 * Math.random() * xRange;
                }
                if(Math.random() < .5){
                    y = Math.random() * yRange;
                }else{
                    y = -1 * Math.random() * yRange;
                }
                field[i][j] = new Vector(x, y, Math.random() * zRange);
                field[i][j].normalize();
            }
        }
    }

    //Todo fix the magnitude
    public void randNoise(OpenSimplexNoise n, double featreSize, double xp, double yp){
        double weight = 10.0;
        for(int i=0; i<field.length; i++){
            for(int j=0; j<field[0].length; j++){
//                double x = n.eval(xp+i*featreSize, 0);
//                double y = n.eval(0, yp+j*featreSize);
                double ang = n.eval(xp+i*featreSize, yp+j*featreSize) * 2 * Math.PI;
                field[i][j] = new Vector(0, 0);
                field[i][j].setMagnitude(weight);
                //field[i][j] = new Vector(x, y);
                //field[i][j].normalize();
            }
        }
    }

    public Vector[][] getField(){
        return this.field;
    }
}
