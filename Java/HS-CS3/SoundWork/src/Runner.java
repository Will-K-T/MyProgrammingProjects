public class Runner {
    public static void main(String[] args) {
        int[] song = {-17,-15,-14, -10, -12, -14, -19};
        double[] length = {1, 1, 1,1,1,1,1};
        double bassHz = 0;
        for(int i=0; i<song.length; i++){
            bassHz = 440 * Math.pow(2, song[i]/12.0);
            StdAudio.play(note(bassHz, length[i]*88/60.0, 5.0));
        }
    }


    public static double[] note(double hz, double duration, double amp){
        int n = (int)(StdAudio.SAMPLE_RATE * duration);
        double[] sine = new double[n+1];
        for(int i=0; i<=n; i++){
            sine[i] = amp * Math.sin(2* Math.PI*i*hz/StdAudio.SAMPLE_RATE);
        }
        return sine;
    }
}
