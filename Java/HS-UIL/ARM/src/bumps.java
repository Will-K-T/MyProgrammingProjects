import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class bumps {
    static HashMap<String, ArrayList<Node>> map;
    static HashMap<String, Integer> weightSum;
    static HashMap<String, String> pred;
    static String des;
    static String ans = "";
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("bumps.dat"));
        map = new HashMap<>();
        weightSum = new HashMap<>();
        pred = new HashMap<>();
        des = yeet.nextLine();
        while(yeet.hasNextLine()){
            String[] line = yeet.nextLine().split(" ");
            String p = line[0].charAt(0)+"";
            String c = line[0].charAt(2)+"";
            int w = Integer.parseInt(line[line.length-1]);
            if(!map.containsKey(p)){
                map.put(p, new ArrayList<>());
                map.get(p).add(new Node(c, w));
                if(p.equals("A")){
                    weightSum.put(p, 0);
                }
                else{
                    weightSum.put(p, Integer.MAX_VALUE);
                }
            }
            else{
                map.get(p).add(new Node(c, w));
            }
            if(!map.containsKey(c)){
                map.put(c, new ArrayList<>());
                weightSum.put(c, Integer.MAX_VALUE);
            }
        }
        solve();
        findPath(des);
        System.out.println("A"+ans);
    }

    public static void findPath(String i){
        if(i.equals("A")){
            return;
        }
        findPath(pred.get(i));
        ans+=i;
    }

    public static void solve(){
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        nodes.add(new Node("A", weightSum.get("A")));
        while(!nodes.isEmpty()){
            Node curr = nodes.poll();
            ArrayList<Node> children = map.get(curr.getName());
            for (Node n: children) {
                if (curr.getWeight() + n.getWeight() < weightSum.get(n.getName())) {
                    pred.put(n.getName(), curr.getName());
                    weightSum.put(n.getName(), curr.getWeight()+n.getWeight());
                    nodes.add(new Node(n.getName(), curr.getWeight() + n.getWeight()));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    String name;
    int weight;
    public Node(String n, int w){
        name = n;
        weight = w;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.getWeight()-o.getWeight();
    }

    public String toString(){
        return name+" "+weight;
    }
}