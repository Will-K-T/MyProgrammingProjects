import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Runner {
    public static void main(String[] args) {
        Solution test = new Solution();
        //System.out.println(test.reachNumber(-1000000000));
        System.out.println(test.reachNumber(250));
    }
}


class Solution {
    public int reachNumber(int target) {
//        Queue<int[]> nums = new LinkedList<>();
//        nums.add(new int[] {0, 1});
//        while(!nums.isEmpty()){
//            int[] curr = nums.poll();
//            System.out.println(curr[0]);
//            if(curr[0] == target){
//                return curr[1]-1;
//            }
//            nums.add(new int[] {curr[0]+curr[1], curr[1]+1});
//            nums.add(new int[] {curr[0]-curr[1], curr[1]+1});
//        }
//        return 0;

        Queue<Pair> nums = new PriorityQueue<>();
        nums.add(new Pair(0, 1));
        while(!nums.isEmpty()){
            Pair curr = nums.poll();
            // System.out.println(curr.getSum());
            System.out.println(curr.toString());
            if(curr.getSum() == target){
                return curr.getSteps()-1;
            }
            nums.add(new Pair(curr.getSum()+curr.getSteps(), curr.getSteps()+1));
            nums.add(new Pair(curr.getSum()-curr.getSteps(), curr.getSteps()+1));
        }
        return 0;
    }
}

class Pair implements Comparable<Pair>{
    int sum;
    int steps;
    int target;

    public Pair(int s, int st){
        sum = s;
        steps = st;
    }

    public Pair(int s, int st, int t){
        sum = s;
        steps = st;
        target = t;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    @Override
    public int compareTo(Pair o) {
//        if(this.getSteps() < o.getSteps()){
//            return -1;
//        }
//        if(this.getSteps() > o.getSteps()){
//            return 1;
//        }

        if(this.getSteps() == o.getSteps()){
            if(Math.abs(this.target-this.sum) < Math.abs(o.getTarget()-this.getSum())){
                return -1;
            }
            if(Math.abs(this.target-this.sum) > Math.abs(o.getTarget()-this.getSum())){
                return 1;
            }
        }
        if(this.getSteps() < o.getSteps()){
            return -1;
        }
        if(this.getSteps() > o.getSteps()){
            return 1;
        }
        return 0;
    }

    public String toString(){
        return this.getSteps()+" : "+this.getSum();
    }
}