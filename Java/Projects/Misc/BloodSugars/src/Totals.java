import java.util.ArrayList;

public class Totals {
    private String date;
    private int hour0, hour1, hour2, hour3, hour4, hour5, hour6, hour7, hour8, hour9, hour10, hour11, hour12, hour13, hour14, hour15, hour16, hour17, hour18, hour19, hour20, hour21, hour22, hour23;
    private int hourCnt0, hourCnt1, hourCnt2, hourCnt3, hourCnt4, hourCnt5, hourCnt6, hourCnt7, hourCnt8, hourCnt9, hourCnt10, hourCnt11, hourCnt12, hourCnt13, hourCnt14, hourCnt15, hourCnt16, hourCnt17, hourCnt18, hourCnt19, hourCnt20, hourCnt21, hourCnt22, hourCnt23;

    public Totals(String date){
        this.date = date;
        hour0=0; hour1=0; hour2=0; hour3=0; hour4=0; hour5=0; hour6=0; hour7=0; hour8=0; hour9=0; hour10=0; hour11=0; hour12=0; hour13=0; hour14=0; hour15=0; hour16=0; hour17=0; hour18=0; hour19=0; hour20=0; hour21=0; hour22=0; hour23=0;
        hourCnt0=0; hourCnt1=0; hourCnt2=0; hourCnt3=0; hourCnt4=0; hourCnt5=0; hourCnt6=0; hourCnt7=0; hourCnt8=0; hourCnt9=0; hourCnt10=0; hourCnt11=0; hourCnt12=0; hourCnt13=0; hourCnt14=0; hourCnt15=0; hourCnt16=0; hourCnt17=0; hourCnt18=0; hourCnt19=0; hourCnt20=0; hourCnt21=0; hourCnt22=0; hourCnt23=0;

    }

    public double avgHour(int hour){
        switch (hour){
            case 0:
                return (double)hour0/hourCnt0;
            case 1:
                return (double)hour1/hourCnt1;
            case 2:
                return (double)hour2/hourCnt2;
            case 3:
                return (double)hour3/hourCnt3;
            case 4:
                return (double)hour4/hourCnt4;
            case 5:
                return (double)hour5/hourCnt5;
            case 6:
                return (double)hour6/hourCnt6;
            case 7:
                return (double)hour7/hourCnt7;
            case 8:
                return (double)hour8/hourCnt8;
            case 9:
                return (double)hour9/hourCnt9;
            case 10:
                return (double)hour10/hourCnt10;
            case 11:
                return (double)hour11/hourCnt11;
            case 12:
                return (double)hour12/hourCnt12;
            case 13:
                return (double)hour13/hourCnt13;
            case 14:
                return (double)hour14/hourCnt14;
            case 15:
                return (double)hour15/hourCnt15;
            case 16:
                return (double)hour16/hourCnt16;
            case 17:
                return (double)hour17/hourCnt17;
            case 18:
                return (double)hour18/hourCnt18;
            case 19:
                return (double)hour19/hourCnt19;
            case 20:
                return (double)hour20/hourCnt20;
            case 21:
                return (double)hour21/hourCnt21;
            case 22:
                return (double)hour22/hourCnt22;
            case 23:
                return (double)hour23/hourCnt23;
        }
        return 0;
    }

    public void addData(String time, int bloodSugar){
        int hour = Integer.parseInt(time.substring(11, 13));
        switch (hour){
            case 0:
                hour0+=bloodSugar;
                hourCnt0++;
                break;
            case 1:
                hour1+=bloodSugar;
                hourCnt1++;
                break;
            case 2:
                hour2+=bloodSugar;
                hourCnt2++;
                break;
            case 3:
                hour3+=bloodSugar;
                hourCnt3++;
                break;
            case 4:
                hour4+=bloodSugar;
                hourCnt4++;
                break;
            case 5:
                hour5+=bloodSugar;
                hourCnt5++;
                break;
            case 6:
                hour6+=bloodSugar;
                hourCnt6++;
                break;
            case 7:
                hour7+=bloodSugar;
                hourCnt7++;
                break;
            case 8:
                hour8+=bloodSugar;
                hourCnt8++;
                break;
            case 9:
                hour9+=bloodSugar;
                hourCnt9++;
                break;
            case 10:
                hour10+=bloodSugar;
                hourCnt10++;
                break;
            case 11:
                hour11+=bloodSugar;
                hourCnt11++;
                break;
            case 12:
                hour12+=bloodSugar;
                hourCnt12++;
                break;
            case 13:
                hour13+=bloodSugar;
                hourCnt13++;
                break;
            case 14:
                hour14+=bloodSugar;
                hourCnt14++;
                break;
            case 15:
                hour15+=bloodSugar;
                hourCnt15++;
                break;
            case 16:
                hour16+=bloodSugar;
                hourCnt16++;
                break;
            case 17:
                hour17+=bloodSugar;
                hourCnt17++;
                break;
            case 18:
                hour18+=bloodSugar;
                hourCnt18++;
                break;
            case 19:
                hour19+=bloodSugar;
                hourCnt19++;
                break;
            case 20:
                hour20+=bloodSugar;
                hourCnt20++;
                break;
            case 21:
                hour21+=bloodSugar;
                hourCnt21++;
                break;
            case 22:
                hour22+=bloodSugar;
                hourCnt22++;
                break;
            case 23:
                hour23+=bloodSugar;
                hourCnt23++;
                break;
        }
    }
}
