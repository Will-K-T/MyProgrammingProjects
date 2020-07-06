import java.awt.*;
import java.awt.image.BufferedImage;

public class Pixel {

    BufferedImage image;
    Color pixColor;
    int x;
    int y;
    int Red;
    int Green;
    int Blue;

    public Pixel(BufferedImage map, int x, int y){
        pixColor = new Color(map.getRGB(x, y));
        image = map;
        this.x = x;
        this.y = y;
    }

    public void setColor(boolean B, int r, int g, int b){
        boolean blue = B;
        Red= r;
        Green= g;
        Blue = b;
        pixColor = new Color(Red, Green, Blue, 255);
        image.setRGB(x,y, new Color(Red, Green, Blue, 255).getRGB());
    }

    public boolean isRoad(){
        if(Red==0 && Green==0 && Blue==0){
            return false;
        }
        return true;
    }
}
