public class MinecraftMiner {
    private int tunnelX, tunnelY, goal, area, perimeter, fortune, possibleDiamonds;

    public MinecraftMiner(int tunnelX, int tunnelY, int goal, int fortunelvl) {
        this.tunnelX = tunnelX;
        this.tunnelY = tunnelY;
        this.goal = goal;
        fortune = fortunelvl;
        area = tunnelX*tunnelY;
        perimeter = (2*tunnelX)+(2*tunnelY);
        possibleDiamonds = area+perimeter;
    }

    public int findDiamonds(){
        int numberOfDiamonds = 0;
        int distance = 0;
        int foundDiamond;
        while(numberOfDiamonds<goal){
            for(int i=0; i<possibleDiamonds; i++) {
                foundDiamond = (int) (Math.random() * 10000);
                if (foundDiamond < 12) {
                    distance += 16;
                    int randomNum = (int)(Math.random()*100);
                    if(randomNum == 0){
                        if(Math.random()<.5) {
                            if(fortune>0){
                                numberOfDiamonds += fortune(1);
                            }
                            else{
                                numberOfDiamonds++;
                            }
                        }
                        else{
                            if(fortune>0){
                                numberOfDiamonds += fortune(10);
                            }
                            else{
                                numberOfDiamonds += 10;
                            }
                        }
                    }
                    else if(randomNum<=5){
                        if(Math.random()<.5) {
                            if(fortune>0){
                                numberOfDiamonds += fortune(2);
                            }
                            else{
                                numberOfDiamonds += 2;
                            }
                        }
                        else{
                            if(fortune>0){
                                numberOfDiamonds += fortune(9);
                            }
                            else{
                                numberOfDiamonds += 9;
                            }
                        }
                    }
                    else if(randomNum<=20){
                        if(Math.random()<.5) {
                            if(fortune>0){
                                numberOfDiamonds += fortune(3);
                            }
                            else{
                                numberOfDiamonds += 3;
                            }
                        }
                        else{
                            if(fortune>0){
                                numberOfDiamonds += fortune(8);
                            }
                            else{
                                numberOfDiamonds += 8;
                            }
                        }
                    }
                    else if(randomNum<=50){
                        if(Math.random()<.5) {
                            if(fortune>0){
                                numberOfDiamonds += fortune(4);
                            }
                            else{
                                numberOfDiamonds += 4;
                            }
                        }
                        else{
                            if(fortune>0){
                                numberOfDiamonds += fortune(7);
                            }
                            else{
                                numberOfDiamonds += 7;
                            }
                        }
                    }
                    else{
                        if(Math.random()<.5) {
                            if(fortune>0){
                                numberOfDiamonds += fortune(5);
                            }
                            else{
                                numberOfDiamonds += 5;
                            }
                        }
                        else{
                            if(fortune>0){
                                numberOfDiamonds += fortune(6);
                            }
                            else{
                                numberOfDiamonds += 6;
                            }
                        }
                    }
                }
            }
            distance++;
        }
        return distance;
    }

    public int fortune(int vainSize){
        int totalDiamonds = 0;
        int randNum = 0;
        for(int i=0; i<vainSize; i++) {
            if (fortune == 1) {
                randNum = (int)(Math.random()*3);
                if (randNum == 0) {
                    totalDiamonds += 2;
                }
                else{
                    totalDiamonds++;
                }
            }
            else if(fortune == 2){
                randNum = (int)(Math.random()*4);
                if(randNum == 0){
                    totalDiamonds += 2;
                }
                else if(randNum == 1){
                    totalDiamonds += 3;
                }
                else{
                    totalDiamonds++;
                }
            }
            else if(fortune == 3){
                randNum = (int)(Math.random()*5);
                if(randNum == 0){
                    totalDiamonds += 2;
                }
                else if(randNum == 1){
                    totalDiamonds += 3;
                }
                else if(randNum == 2){
                    totalDiamonds += 4;
                }
                else{
                    totalDiamonds++;
                }
            }
        }
        return totalDiamonds;
    }

    public int getGoal(){
        return this.goal;
    }

    public int getTunnelX(){
        return this.tunnelX;
    }

    public int getTunnelY(){
        return this.tunnelY;
    }

    public int getFortune(){
        return fortune;
    }
}