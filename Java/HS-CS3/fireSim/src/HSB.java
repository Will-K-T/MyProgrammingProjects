import java.awt.*;

public class HSB {
    public static void main (String args[]){
        Picture boi = new Picture(500, 500);
        int r =0;
        int g = 0;
        int b = 0;
        int [] pallete = new int[256];
        double colors = 0.0;
        int okay = 0;
        int [][] fire = new int[boi.width()][boi.height()];
        for(int x= 0; x<256; x++) {
            pallete[x] = Color.HSBtoRGB((x/4f)/255, 1f, x/255f);
        }
        for(int x = 0; x<boi.width(); x++) {
            for (int y = 0; y < boi.height(); y++) {
                fire[x][y] = 0;
            }
        }
        while(true){
            for(int i = 0; i< boi.width(); i++ ) {
                fire[boi.height() - 1][i] = (int) (Math.random() * 256);
            }
            for (int y = 0; y < boi.height()-1; y++) {
                for (int x = 0; x < boi.width(); x++) {
                    fire[y][x] = ((fire[(y + 1) % boi.height()][(x - 1 + boi.width()) % boi.width()]
                            + fire[(y + 1) % boi.height()][(x) %  boi.width()]
                            + fire[(y + 1) % boi.height()][(x + 1) %  boi.width()]
                            + fire[(y + 2) % boi.height()][(x) %  boi.width()])
                            * 32) / 129;
                }
            }
            for(int x = 0; x < boi.height(); x++) {
                for (int y = 0; y < boi.width(); y++) {
                    boi.setRGB(x, y, pallete[fire[y][x]]);
                }
            }
            boi.show();
        }
    }
}
