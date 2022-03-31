public class Recurse {
    static boolean up, down;
    static boolean forward = true;
    static double stay, rand, rand2, rand3;
    static double rateOfChange = .005;
    static int recursiveRate = 10;
    static int color = (255<<16)+(255<<8)+255;
    static int blue, green, red;
    static int recursiveBranches = 1;
    static Picture recurse = new Picture(1000, 1000);
    public static void main(String[] args) throws InterruptedException {
        road(recurse.width()/2, 0);
        System.out.println(recursiveBranches);
    }
    public static String road(int row, int col) throws InterruptedException {
        int oldColor = color;
        stay=1.0;
        while(col<recurse.width() && (row>=0 && row<recurse.height())){
            if(recurse.getRGB(col, row)!=-16777216){
                break;
            }
            if(forward){
                rand = Math.random();
                if(rand<stay){
                    recurse.setRGB(col++, row, color);
                    stay-=rateOfChange;
                }
                else{
                    rand2 = Math.random()*100;
                    if(rand2<recursiveRate){
                        recursiveBranches+=1;
                        rand3 = Math.random()*2;
                        switch ((int)rand3){
                            case(0):
                                red = (int)(Math.random()*255);
                                green = (int)(Math.random()*255);
                                blue = (int)(Math.random()*255);
                                color = (red<<16)+(green<<8)+blue;
                                forward=false; up=true; down=false;
                                road(row-1, col);
                                down=true;
                                up=false;
                                color = oldColor;
                                break;
                            case(1):
                                red = (int)(Math.random()*255);
                                green = (int)(Math.random()*255);
                                blue = (int)(Math.random()*255);
                                color = (red<<16)+(green<<8)+blue;
                                forward=false; up=false; down=true;
                                road(row+2, col);
                                down=true;
                                forward=false;
                                color = oldColor;
                                break;
                        }
                    }
                    else if(rand2<((double)(100-recursiveRate)/2)+recursiveRate){
                        forward=false; up=true; down=false;
                        stay=1;
                    }
                    else{
                        forward=false; up=false; down=true;
                        stay=1;
                    }
                }
            }
            if(up && (col<recurse.width() && (row>=0 && row<recurse.height()))){
                rand = Math.random();
                if(rand<stay){
                    recurse.setRGB(col, row--, color);
                    stay-=rateOfChange;
                }
                else{
                    forward=true; up=false; down=false;
                    stay=1;
                }
            }
            if(down && (col<recurse.width() && (row>=0 && row<recurse.height()))){
                rand = Math.random();
                if(rand<stay){
                    recurse.setRGB(col, row++, color);
                    stay-=rateOfChange;
                }
                else{
                    forward=true; up=false; down=false;
                    stay=1;
                }
            }
            recurse.show();
            Thread.sleep(1);
        }
        return "";
    }
}