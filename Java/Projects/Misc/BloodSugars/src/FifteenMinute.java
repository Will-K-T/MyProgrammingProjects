public class FifteenMinute {
    private int fiveMinute;
    private int totalSuagar;
    private int numOfSugar;

    public FifteenMinute(int m){
        fiveMinute = m;
        totalSuagar = 0;
        numOfSugar = 0;
    }

    public void addSugar(int sugar){
        totalSuagar+=sugar;
        numOfSugar++;
    }

    public double getAvgSugar(){
        return (double)totalSuagar/numOfSugar;
    }

    public String toString(){
        return fiveMinute+" "+getAvgSugar();
    }
}
