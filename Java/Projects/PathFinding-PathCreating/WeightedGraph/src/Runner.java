import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(System.in);
        Graph test = new Graph("Graph");
        test.setDes("G");
        test.setStart("A");
        //String path = test.solveGraph();
        test.drawGraph();
        String path = test.solveGraphDist();
        test.drawBestPath(path);
        while(true){
            System.out.println("Enter a command :: ");
            String res = yeet.next().toUpperCase();
            if(!test.getDes().equals(res.charAt(1)+"") && !test.getStart().equals(res.charAt(1)+"")) {
                if (res.charAt(0) == 'U') {
                    test.unblockNodeDist(res.charAt(1) + "");
                } else if(res.charAt(0)=='B'){
                    test.blockNodeDist(res.charAt(1) + "");
                }
            }
            if(res.charAt(0)=='S'){
                test.setStart(res.charAt(1)+"");
            }
            else if(res.charAt(0)=='E'){
                test.setDes(res.charAt(1)+"");
            }
            test.drawConnections();
            String p = test.solveGraphDist();
            //String p = test.solveGraph();
            test.drawBestPath(p);
        }
    }
}