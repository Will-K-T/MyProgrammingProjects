import java.util.LinkedList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner yeet = new Scanner(System.in);
        System.out.printf("Input the following values with the following format %stunnelWidth tunnelHeight diamondGoal fortunelvl%s: ", "'", "'");
        int tunnelX = yeet.nextInt();
        int tunnelY = yeet.nextInt();
        int goal = yeet.nextInt();
        int fortunelvl = yeet.nextInt();
        MinecraftMiner letsGetSomeDiamonds = new MinecraftMiner(tunnelX, tunnelY, goal, fortunelvl);
        int totalBlocks = 0;
        for(int i=0; i<10000; i++){
            totalBlocks += letsGetSomeDiamonds.findDiamonds();
        }
        System.out.printf("At level 12 with a fortune %d pickaxe, you would have to mine approximately %d layers or %d blocks (%d stacks) of a %d by %d tunnel to get %d diamonds.", letsGetSomeDiamonds.getFortune(),totalBlocks/10000, (totalBlocks/10000)*(tunnelX*tunnelY), (totalBlocks/10000)*(tunnelX*tunnelY)/64,letsGetSomeDiamonds.getTunnelX(), letsGetSomeDiamonds.getTunnelY(), letsGetSomeDiamonds.getGoal());
    }
}
