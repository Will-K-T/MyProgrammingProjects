import java.awt.*;

public class Screen {
    private boolean lost, win, clickedOnce;

    public Screen(int xScale, int yScale){
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, xScale);
        StdDraw.setYscale(0, yScale);
        //StdDraw.setScale(-1,2);
    }

    public void updateScreen(Node[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j].getIsClicked() && !map[i][j].getShift()){
                    if(map[i][j].getIsMine()){
                        StdDraw.setPenColor(Color.red);
                        StdDraw.filledSquare((i*10)+5, (j*10)+5, 5);
                        StdDraw.setPenColor(Color.black);
                        StdDraw.square((i*10)+5, (j*10)+5, 5);
                        lost=true;
                    }
                    else {
                        StdDraw.setPenColor(Color.white);
                        StdDraw.filledSquare((i * 10) + 5, (j * 10) + 5, 5);
                        StdDraw.setPenColor(Color.black);
                        StdDraw.square((i * 10) + 5, (j * 10) + 5, 5);
                        StdDraw.setPenColor(Color.black);
                        StdDraw.text(i*10+5,j*10+5, ""+(map[i][j].getMinesTouched()>0?map[i][j].getMinesTouched():""));
                    }
                }
                else if(map[i][j].getShift()){
                    StdDraw.setPenColor(Color.green);
                    StdDraw.filledSquare((i*10)+5, (j*10)+5, 5);
                    StdDraw.setPenColor(Color.black);
                    StdDraw.square((i*10)+5, (j*10)+5, 5);
                }
                else{
                    StdDraw.setPenColor(Color.gray);
                    StdDraw.filledSquare((i*10)+5, (j*10)+5, 5);
                    StdDraw.setPenColor(Color.black);
                    StdDraw.square((i*10)+5, (j*10)+5, 5);
                }
            }
        }
        int count =0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(!map[i][j].getIsClicked() && !map[i][j].getIsMine()){
                    count++;
                }
            }
        }
        win = count==0;
        if(win){
            StdDraw.text((map[0].length/2)*10+5, (map.length/2)*10+5, "You Win!");
        }
        else if(lost){
            StdDraw.text((map[0].length/2)*10+5, (map.length/2)*10+5, "You Lost LOL");
        }
        StdDraw.show();
    }

    public boolean getLost(){
        return this.lost;
    }

    public boolean getWin(){
        return this.win;
    }

    public void setClickedOnce(){
        this.clickedOnce = false;
    }

    public int[] waitForMove(){
        boolean shift = false;
        while(!StdDraw.isMousePressed()){
            continue;
        }
        if(StdDraw.isKeyPressed(16)){
            shift = true;
        }
        double mouseX = StdDraw.mouseX();
        double mouseY = StdDraw.mouseY();
        return new int[]{(int)mouseX, (int)mouseY, shift?1:0};
    }
}
