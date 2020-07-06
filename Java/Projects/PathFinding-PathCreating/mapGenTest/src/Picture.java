import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Picture {
    BufferedImage emptyMap;
    Pixel[][] map;
    Random ranDom = new Random();
    public Picture(){
        emptyMap = new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB);
    }

    public void createMap(){
        //Creates a new blank image
        //Creates the objs needed to display the image
        JFrame mapFrame = new JFrame();
        ImageIcon icon = new ImageIcon(emptyMap);
        JLabel label = new JLabel(icon);
        //Display info
        mapFrame.add(label);
        mapFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mapFrame.pack();
        ranDom.setSeed(5);
        //change the image
        map = makePixelMap();
        System.out.println(makeRoad(2, 300, true, false, false, true, false));
        //display the final image
        mapFrame.setVisible(true);
    }

    public Pixel[][] makePixelMap(){
        int height = emptyMap.getHeight();
        int width = emptyMap.getWidth();
        Pixel[][] pixs = new Pixel[height][width];
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                try{
                    pixs[i][j] = new Pixel(emptyMap, i, j);}
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println(i + " "+ j);
                }
            }
        }
        return pixs;
    }

    public void makeRoad(int r, int c, boolean B, int R, int G, int b){
        map[r][c].setColor(B, R, G, b);
        map[r+1][c].setColor(B, R, G, b);
        map[r][c+1].setColor(B, R, G, b);
        map[r+1][c+1].setColor(B, R, G, b);
    }

    public int makeRoad(int R, int C, boolean f, boolean u, boolean d, boolean rec, boolean B){
        boolean forward = f;
        boolean up = u;
        boolean down = d;
        boolean recur = rec;
        boolean blue = B;
        boolean first = true;
        int randRed = (int)(Math.random()*250);
        int randGreen = (int)(Math.random()*250);
        int randBlue = (int)(Math.random()*250);
        int r = R;
        int c = C;
        double rand = 0;
        int count = 1;
        double sameDir = 100.0;
        double changeDir1 = 102.0;
        double changeDir2 = 104.0;
        //start of every path is white
        makeRoad(r,c,false,255,255,255);
        while((c<698 && r<698) && (c>=0 && r>=0)) {
            if (forward) {
                rand = ranDom.nextInt(100);
                if(map[r+2][c].isRoad()){
                    makeRoad(r,c,false,255,0,0);
                    break;
                }
                if(first){
                    first = false;
                    r += 2;
                    makeRoad(r, c, blue, randRed, randGreen, randBlue);
                }
                else if (rand < sameDir) {
                    r += 2;
                    makeRoad(r, c, blue, randRed, randGreen, randBlue);
                    sameDir -= .2;
                    changeDir1 -= .2;
                    changeDir2 -= .2;
                }
                else if (rand < changeDir1) {
                    forward = false;
                    up = true;
                    down = false;
                    sameDir = 100.0;
                    changeDir1 = sameDir + 2;
                    changeDir2 = sameDir + 4;
                }
                else if(rand < changeDir2) {
                    forward = false;
                    down = true;
                    up = false;
                    sameDir = 100.0;
                    changeDir1 = sameDir + 2;
                    changeDir2 = sameDir + 4;
                }
                else if(recur){
                    int rand3 = ranDom.nextInt(10);
                    if(rand3 < 5){
                        makeRoad(r,c,false,false,true, true, true);
                        blue = false;
                    }
                    else{
                        makeRoad(r,c,false,true,false,true, true);
                        blue = false;
                    }
                }
            }
            else if(up){
                rand = ranDom.nextInt(100);

                if(map[r][c-2].isRoad()){
                    //next two lines print the next pixel color and creates a red pixel to indicate the end of a path
                    makeRoad(r,c,false,255,0,0);
                    break;
                }
                if((rand < sameDir && c-2>1)){
                    c-=2;
                    makeRoad(r, c, blue, randRed, randGreen, randBlue);
                    sameDir -= .2;
                    changeDir1 -= .2;
                    changeDir2 -= .2;
                }
                else {
                    forward = true;
                    first = true;
                    up = false;
                    down = false;
                    sameDir = 100.0;
                    changeDir1 = sameDir + 2;
                    changeDir2 = sameDir + 4;
                }
            }
            else if(down){
                rand = ranDom.nextInt(100);

                if(map[r][c+2].isRoad()){
                    //next two lines print the next pixel color and creates a red pixel to indicate the end of a path
                    makeRoad(r,c,false,255,0,0);
                    break;
                }
                if (rand < sameDir) {
                    c += 2;
                    makeRoad(r, c, blue, randRed, randGreen, randBlue);
                    sameDir -= .2;
                    changeDir1 -= .2;
                    changeDir2 -= .2;
                }
                else {
                    forward = true;
                    first = true;
                    up = false;
                    down = false;
                    sameDir = 100.0;
                    changeDir1 = sameDir + 2;
                    changeDir2 = sameDir + 4;
                }
            }
        }
        return count;
    }

}
