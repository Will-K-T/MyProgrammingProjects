import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameBoard {
    private double x;
    private double y;
    private double boxWidth;
    private double boxHeight;
    private Sector[][] sectors;
    private String[][] ideas;
    private Scanner yeet;
    private ArrayList<String> topics;
    private Scanner stuff;
    private int points;

    public GameBoard(double x, double y, int boxesPerRow, int boxesPerCol) throws FileNotFoundException, InterruptedException {
        this.x = x;
        this.y = y;
        boxWidth = x/boxesPerCol;
        boxHeight = y/boxesPerRow;
        topics = new ArrayList<>();
        ideas = new String[boxesPerRow][boxesPerCol];
        sectors = new Sector[boxesPerRow][boxesPerCol];
        yeet = new Scanner(new File("src\\Topics.txt"));
        stuff = new Scanner(new File("src\\ideas.txt"));
        points = 0;
        StdDraw.setCanvasSize(2560, 1350);
        StdDraw.setXscale(0, x);
        StdDraw.setYscale(0, y+20);
        StdDraw.enableDoubleBuffering();
        for (int i = 0; i < sectors.length; i++) {
            for (int j = 0; j < sectors[0].length; j++) {
                sectors[i][j] = new Sector(0,0);
            }
        }
        while(yeet.hasNext()){
            topics.add(yeet.nextLine());
        }
        for (int i = 0; i < ideas.length; i++) {
            for (int j = 0; j < ideas[0].length; j++) {
                ideas[i][j] = stuff.next();
            }
        }
        while(true) {
            StdDraw.setFont(new Font("Ariel", 0, 2*(int)boxWidth));
            drawBoard();
            StdDraw.setFont(new Font("Ariel", 0, 40));
            drawPoints();
            StdDraw.show();
            while (!StdDraw.isMousePressed()){ }
            double mouseX = StdDraw.mouseX();
            double mouseY = StdDraw.mouseY();
            Thread.sleep(100);
            findClickedSquare(mouseX, y-boxHeight-mouseY);
            StdDraw.clear();
        }
    }

    public void drawBoard() throws InterruptedException {
        double xCord;
        double yCord = 0;
        for (int i = 0; i < sectors.length; i++) {
            xCord = 0;
            for (int j = 0; j < sectors[0].length; j++) {
                StdDraw.filledRectangle(xCord, yCord, boxWidth, boxHeight);
                sectors[i][j].setX(xCord);
                sectors[i][j].setY(yCord);
                xCord+=boxWidth;
            }
            yCord+=boxHeight;
        }
        drawLines();
    }

    public void drawLines(){
        double xLine = boxWidth;
        double yLine = boxHeight;
        StdDraw.setPenColor(Color.red);
        for (int i = 0; i < sectors[0].length-1; i++) {
            StdDraw.line(xLine, 0, xLine, y);
            xLine+=boxWidth;
        }
        for (int i = 0; i < sectors.length-1; i++) {
            StdDraw.line(0, yLine, x, yLine);
            yLine+=boxHeight;
        }
        drawText();
    }

    public void drawText(){
        double xLine = 0;
        double yLine = y-boxHeight/2;
        int topic = 0;
        int pointValue = 100;
        for (int i = 0; i < sectors[0].length; i++) {
            StdDraw.setPenColor(Color.pink);
            StdDraw.text(xLine+boxWidth/2, yLine, topics.get(topic));
            topic++;
            xLine+=boxWidth;
        }
        for (int i = 0; i < sectors.length; i++) {
            yLine-=boxHeight;
            xLine = 0;
            for (int j = 0; j < sectors[0].length; j++) {
                StdDraw.setPenColor(Color.yellow);
                if(!sectors[i][j].isClicked()) {
                    StdDraw.text(xLine + boxWidth / 2, yLine, pointValue + "");
                    sectors[i][j].setPointValue(pointValue);
                }
                else{
                    StdDraw.text(xLine + boxWidth / 2, yLine, ideas[i][j]);
                    //sectors[i][j].setPointValue(-1);
                }
                xLine+=boxWidth;
            }
            pointValue+=100;
        }
        StdDraw.setPenColor(Color.black);
    }

    public void findClickedSquare(double x, double y){
        one:for (int i = 0; i < sectors.length-1; i++) {
            for (int j = 0; j < sectors[0].length; j++) {
                Sector s = sectors[i][j];
                double xMax = s.getX()+boxWidth;
                double yMax = s.getY()+boxHeight;
                //System.out.println("mouseX: "+x+" MouseY: "+y+" SectorX: "+s.getX()+" SectorXMax: "+xMax+" SectorY: "+s.getY()+" SectorYMax: "+yMax);
                if((x > s.getX() && x < xMax) && (y > s.getY() && y < yMax)){
                    if(!s.isClicked()){
                        points+=s.getPointValue();
                    }
                    sectors[i][j].setClicked(true);
                    break one;
                }
            }
        }
    }

    public void drawPoints(){
        StdDraw.setPenColor(Color.black);
        StdDraw.filledRectangle(0, y+10, x, 10);
        StdDraw.setPenColor(Color.green);
        StdDraw.text(x/2, y+10, "Fun Points Earned :: "+points);
        StdDraw.setPenColor(Color.black);
    }
}