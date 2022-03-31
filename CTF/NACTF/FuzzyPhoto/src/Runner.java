import java.awt.*;
import java.io.File;

public class Runner {
    public static void main(String[] args) {
        Picture yeet = new Picture(new File("D:\\NACTF\\The_phuzzy_photo.png"));
        Picture deCipher = new Picture(yeet.width(), yeet.height());
        float[] hsb = new float[3];
        int rgb = 0;
        Color color = null;
        for(int i=0; i<deCipher.height(); i++){
            for(int j=0; j<deCipher.width(); j++){
                /*
                rgb = yeet.getRGB(j, i);
                color = new Color(rgb);
                hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), hsb);
                hsb[2] = .2f;
                rgb = Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);*/
                if(i%6==0){
                    deCipher.setRGB(j, i, yeet.getRGB(j, i));
                }
                if(j%6==0){
                    //deCipher.setRGB(j, i, yeet.getRGB(j, i));
                }
            }
        }
        deCipher.show();
        deCipher.save(new File("D:\\NACTF\\The_coolkid_photo.png"));
    }
}
