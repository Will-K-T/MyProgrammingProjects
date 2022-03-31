public class Hour {
    private int hour;
    private int totalSuagar;
    private int numOfSugar;
    private int[] fifteenMinutes;
    private int[] numOf15;

    public Hour(int h){
        hour = h;
        totalSuagar = 0;
        numOfSugar = 0;
        fifteenMinutes = new int[4];
        numOf15 = new int[4];
    }

    public void addSugar15(int time, int sugar){
        int index = time/15;
        fifteenMinutes[index] += sugar;
        numOf15[index]++;
    }

    public double[] getAvgSugar15(){
        double[] avg = new double[4];
        for (int i = 0; i < fifteenMinutes.length; i++) {
            avg[i] = (double)fifteenMinutes[i]/numOf15[i];
        }
        return avg;
    }

    public void addSugar(int sugar){
        totalSuagar+=sugar;
        numOfSugar++;
    }

    public double getAvgSugar(){
        return (double)totalSuagar/numOfSugar;
    }

    public String toString(){
        return hour+" "+getAvgSugar();
    }
}
