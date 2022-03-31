import java.awt.*;

public class Image {
    private Picture map;
    private int[][] heightMap;

    public Image(int[][] heightMap){
        this.heightMap = heightMap;
        this.map = new Picture(heightMap[0].length, heightMap.length);
        makeImage();
        this.map.show();
    }

    public Picture getMap(){
        return this.map;
    }

    public void makeImage(){
        for (int row = 0; row < heightMap.length; row++) {
            for (int col = 0; col < heightMap[row].length; col++) {
                if(heightMap[row][col]==4334){
                    map.setRGB(col, row, Color.HSBtoRGB(.1f, 1f, 1f));
                }
                else {
                    map.setRGB(col, row, Color.HSBtoRGB(.5f, 1f, heightMap[row][col] / 4334f));
                }
            }
        }
    }
}
