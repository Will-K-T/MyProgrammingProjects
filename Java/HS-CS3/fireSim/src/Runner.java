import java.awt.*;

public class Runner {
    static Picture image = new Picture(1000,500);
    static int[] palet = new int[256];
    static int[][] buffer = new int[image.height()][image.width()];
    public static void main(String[] args) {
        //fireColumn();
        //fireFullScreen();
        fireColums();
    }

    public static void fireFullScreen(){
        for (int i = 0; i < 256; i++) {
            palet[i] = Color.HSBtoRGB( ((float)i/4)/255, 1.0f, i/255f);
        }
        while(true){
            for(int i=0; i<image.width(); i++){
                buffer[image.height() - 1][i] = (int) (Math.random() * 256);
            }
            for (int i = 0; i < image.height()-1; i++) {
                for (int j = 0; j < image.width(); j++) {
                    buffer[i][j] = (
                            ((buffer[(i + 1) % image.height()][(j - 1 + image.width()) % image.width()]
                                    + buffer[(i + 1) % image.height()][(j) % image.width()]
                                    + buffer[(i + 1) % image.height()][(j + 1) % image.width()]
                                    + buffer[(i + 2) % image.height()][(j) % image.width()]))*32)/129;
                }
            }
            for (int i = 0; i < image.height(); i++) {
                for (int j = 0; j < image.width(); j++) {
                    image.setRGB(j, i, palet[buffer[i][j]]);
                }
            }
            image.show();
        }
    }

    public static void fireColumn(){
        int count1 = 0, distance = -500;
        boolean countDown = false;
        int columnSize = image.width()/4;
        for (int i = 0; i < 256; i++) {
            palet[i] = Color.HSBtoRGB( ((float)i/4)/255, 1.0f, i/255f);
        }
        while (true) {
            if(!countDown && (image.width()/distance)+count1>=image.width()){
                countDown = true;
            }
            if(countDown && count1==1){
                countDown = false;
            }
            if(!countDown){
                count1++;
            }
            if(countDown){
                count1--;
            }
            for(int i=count1; i<columnSize+count1-1; i++){
                buffer[image.height() - 1][i] = (int) (Math.random() * 256);
            }
            if(!countDown){
                buffer[image.height()-1][count1-1] = 0;
            }
            if(countDown){
                buffer[image.height()-1][columnSize+count1] = 0;
            }
            for (int i = 0; i < image.height()-1; i++) {
                for (int j = 0; j < image.width(); j++) {
                    buffer[i][j] = (
                            ((buffer[(i + 1) % image.height()][(j - 1 + image.width()) % image.width()]
                                    + buffer[(i + 1) % image.height()][(j) % image.width()]
                                    + buffer[(i + 1) % image.height()][(j + 1) % image.width()]
                                    + buffer[(i + 2) % image.height()][(j) % image.width()]))*32)/129;
                }
            }
            for (int i = 0; i < image.height(); i++) {
                for (int j = 0; j < image.width(); j++) {
                    image.setRGB(j, i, palet[buffer[i][j]]);
                }
            }
            image.show();
        }
    }

    public static void fireColums(){
        int count1=1, count2=0, count3=0, count4=0;
        for (int i = 0; i < 256; i++) {
            palet[i] = Color.HSBtoRGB( ((float)i/4)/255, 1.0f, i/255f);
        }
        while (true) {
            if(count1==200) {
                for (int i = 0; i < image.width()/4; i++) {
                    buffer[image.height() - 1][i] = (int) (Math.random() * 256);
                }
                count1=0;
            }
            if(count2==25){
                for (int i = image.width()/4; i < image.width()/2; i++) {
                    buffer[image.height() - 1][i] = (int) (Math.random() * 256);
                }
                count2=0;
            }
            if(count3==5){
                for (int i = image.width()/2; i < (image.width()*3)/4; i++) {
                    buffer[image.height() - 1][i] = (int) (Math.random() * 256);
                }
                count3=0;
            }
            if(count4==1){
                for (int i = (image.width()*3)/4; i < image.width(); i++) {
                    buffer[image.height() - 1][i] = (int) (Math.random() * 256);
                }
                count4=0;
            }
            for (int i = 0; i < image.height()-1; i++) {
                for (int j = 0; j < image.width(); j++) {
                    buffer[i][j] = (
                            ((buffer[(i + 1) % image.height()][(j - 1 + image.width()) % image.width()]
                                    + buffer[(i + 1) % image.height()][(j) % image.width()]
                                    + buffer[(i + 1) % image.height()][(j + 1) % image.width()]
                                    + buffer[(i + 2) % image.height()][(j) % image.width()]))*32)/129;
                }
            }
            for (int i = 0; i < image.height(); i++) {
                for (int j = 0; j < image.width(); j++) {
                    image.setRGB(j, i, palet[buffer[i][j]]);
                }
            }
            count1++;count2++;count3++;count4++;
            image.show();
        }
    }
}