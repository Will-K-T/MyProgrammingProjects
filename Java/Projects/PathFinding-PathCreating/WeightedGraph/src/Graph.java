import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {

    //region Instance Vars
    private HashMap<String, ArrayList<Node>> map;
    private HashMap<String, ArrayList<Node>> mapDist;
    private HashMap<String, Double> weightSum;
    private HashMap<String, String> pred;
    private HashMap<String, VisualNode> nodes;
    private HashMap<String, Double> oldWeight;
    private String des;
    private String start;
    private boolean mapD = false;
    //endregion

    /**
     * Default Constructor
     * @param file
     * @throws FileNotFoundException
     */
    public Graph(String file) throws FileNotFoundException {
        map = new HashMap<>();
        weightSum = new HashMap<>();
        pred = new HashMap<>();
        oldWeight = new HashMap<>();
        mapDist = new HashMap<>();
        des = "";
        Scanner yeet = new Scanner(new File(file));
        while(yeet.hasNext()){
            String p = yeet.next();
            String c = yeet.next();
            double w = yeet.nextDouble();
            if(!map.containsKey(p)){
                map.put(p, new ArrayList<>());
                map.get(p).add(new Node(c, w));
                weightSum.put(p, Double.MAX_VALUE);
            }
            else{
                map.get(p).add(new Node(c, w));
            }
            if(!map.containsKey(c)){
                map.put(c, new ArrayList<>());
                weightSum.put(c, Double.MAX_VALUE);
            }

            if(!mapDist.containsKey(p)){
                mapDist.put(p, new ArrayList<>());
                //mapDist.get(p).add(new Node(c, w));
                //weightSum.put(p, Double.MAX_VALUE);
            }
            else{
                //map.get(p).add(new Node(c, w));
            }
            if(!mapDist.containsKey(c)){
                mapDist.put(c, new ArrayList<>());
                //weightSum.put(c, Double.MAX_VALUE);
            }
        }
    }

    /**
     * Blocks a node in the path
     * @param n
     */
    public void blockNode(String n){
        for(Map.Entry mapElement : map.entrySet()){
            String key = (String)mapElement.getKey();
            ArrayList<Node> children = map.get(key);
            map.put(key, new ArrayList<>());
            for(Node i : children){
                if(i.getName().equals(n)){
                    oldWeight.put(key+n, i.getWeight());
                    map.get(key).add(new Node(i.getName(), Double.MAX_VALUE));
                }
                else{
                    map.get(key).add(i);
                }
            }
            weightSum.put(key, Double.MAX_VALUE);
        }
    }

    /**
     * Blocks node n in mapDist
     * @param n
     */
    public void blockNodeDist(String n){
        for(Map.Entry mapElement : mapDist.entrySet()){
            String key = (String)mapElement.getKey();
            ArrayList<Node> children = mapDist.get(key);
            mapDist.put(key, new ArrayList<>());
            for(Node i : children){
                if(i.getName().equals(n)){
                    //System.out.println(key+" "+i.getName());
                    oldWeight.put(key+n, i.getWeight());
                    //System.out.println(oldWeight);
                    mapDist.get(key).add(new Node(i.getName(), Double.MAX_VALUE));
                }
                else{
                    mapDist.get(key).add(i);
                }
            }
            weightSum.put(key, Double.MAX_VALUE);
        }
    }

    /**
     * Unblocks a node in the path
     * @param n
     */
    public void unblockNode(String n){
        for(Map.Entry mapElement : map.entrySet()){
            String key = (String)mapElement.getKey();
            ArrayList<Node> children = map.get(key);
            map.put(key, new ArrayList<>());
            for(Node i : children){
                if(i.getName().equals(n)){
                    map.get(key).add(new Node(i.getName(), oldWeight.get(key+n)));
                }
                else{
                    map.get(key).add(i);
                }
            }
            weightSum.put(key, Double.MAX_VALUE);
        }
    }

    /**
     * Unblocks node n in mapDist
     * @param n
     */
    public void unblockNodeDist(String n){
        for(Map.Entry mapElement : mapDist.entrySet()){
            String key = (String)mapElement.getKey();
            ArrayList<Node> children = mapDist.get(key);
            mapDist.put(key, new ArrayList<>());
            for(Node i : children){
                if(i.getName().equals(n)){
                    mapDist.get(key).add(new Node(i.getName(), oldWeight.get(key+n)));
                }
                else{
                    mapDist.get(key).add(i);
                }
            }
            weightSum.put(key, Double.MAX_VALUE);
        }
    }

    /**
     * Recursively finds the path from the end node to the start node
     * @param i
     * @param s
     * @return A string that represents the path of nodes from the start to the end
     */
    public String findPath(String i, String s){
        if(i.equals(s)){
            return s;
        }
        return findPath(pred.get(i), s)+i;
    }

    /**
     * Uses a greedy algorithm to find the shortest path from the start node to the des node (calls findPath())
     * @param start
     * @return A string that represents the path of nodes from the start to the end
     */
    public String solveGraph(String start){
        this.start = start;
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        nodes.add(new Node(start, 0.0));
        while (!nodes.isEmpty()){
            Node curr = nodes.poll();
            ArrayList<Node> children = map.get(curr.getName());
            for (Node n : children) {
                if(curr.getWeight() + n.getWeight() < weightSum.get(n.getName())){
                    pred.put(n.getName(), curr.getName());
                    weightSum.put(n.getName(), curr.getWeight() + n.getWeight());
                    nodes.add(new Node(n.getName(), curr.getWeight() + n.getWeight()));
                }
            }
        }
        return findPath(des, start);
    }

    public String solveGraphDist(){
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        nodes.add(new Node(start, 0.0));
        while (!nodes.isEmpty()){
            Node curr = nodes.poll();
            ArrayList<Node> children = mapDist.get(curr.getName());
            for (Node n : children) {
                if(curr.getWeight() + n.getWeight() < weightSum.get(n.getName())){
                    pred.put(n.getName(), curr.getName());
                    weightSum.put(n.getName(), curr.getWeight() + n.getWeight());
                    nodes.add(new Node(n.getName(), curr.getWeight() + n.getWeight()));
                }
            }
        }
        return findPath(des, start);
    }

    /**
     * Uses a greedy algorithm to find the shortest path from the start node to the des node (calls findPath())
     * @return A string that represents the path of nodes from the start to the end
     */
    public String solveGraph(){
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        nodes.add(new Node(start, 0.0));
        while (!nodes.isEmpty()){
            Node curr = nodes.poll();
            ArrayList<Node> children = map.get(curr.getName());
            for (Node n : children) {
                if(curr.getWeight() + n.getWeight() < weightSum.get(n.getName())){
                    pred.put(n.getName(), curr.getName());
                    weightSum.put(n.getName(), curr.getWeight() + n.getWeight());
                    nodes.add(new Node(n.getName(), curr.getWeight() + n.getWeight()));
                }
            }
        }
        return findPath(des, start);
    }

    /**
     * Creates a visual representation of the graph
     */
    public void drawGraph(){
        nodes = new HashMap<>();
        StdDraw.show();
        double x = 0;
        double y = 0;
        for(Map.Entry mapElement : map.entrySet()){
            String key = (String)mapElement.getKey();
            while (!StdDraw.isMousePressed()){}
            while(StdDraw.isMousePressed()){
                x = StdDraw.mouseX();
                y = StdDraw.mouseY();
            }
            StdDraw.filledCircle(x, y, .05);
            if(key.equals(start)){
                StdDraw.setPenColor(Color.GREEN);
            }
            else if(key.equals(des)){
                StdDraw.setPenColor(Color.RED);
            }
            else{
                StdDraw.setPenColor(Color.PINK);
            }
            StdDraw.text(x, y, key);
            StdDraw.setPenColor(Color.BLACK);
            nodes.put(key, new VisualNode(x, y));
        }
        StdDraw.setPenColor(Color.BLACK);
        drawConnections();
    }

    /**
     * Draws the connections between the nodes
     */
    public void drawConnections(){
        for(Map.Entry mapElement : map.entrySet()){
            StdDraw.setPenColor(Color.CYAN);
            String key = (String)mapElement.getKey();
            ArrayList<Node> children = map.get(key);

            //region Changes the color of the start, des, and normal nodes
            if(key.equals(start)){
                StdDraw.setPenColor(Color.GREEN);
                StdDraw.text(nodes.get(key).getX(), nodes.get(key).getY(), key);
            }
            else if(key.equals(des)){
                StdDraw.setPenColor(Color.RED);
                StdDraw.text(nodes.get(key).getX(), nodes.get(key).getY(), key);
            }
            else{
                StdDraw.setPenColor(Color.PINK);
                StdDraw.text(nodes.get(key).getX(), nodes.get(key).getY(), key);
            }
            StdDraw.setPenColor(Color.CYAN);
            //endregion
            for(Node n : children){
                double dist = Math.sqrt(Math.pow(nodes.get(n.getName()).getX() - nodes.get(key).getX(), 2) + Math.pow(nodes.get(n.getName()).getY() - nodes.get(key).getY(), 2));
                if(!mapD) {
                    mapDist.get(key).add(new Node(n.getName(), dist));
                }
                StdDraw.setPenRadius(dist/200);
                StdDraw.line(nodes.get(key).getX(), nodes.get(key).getY(), nodes.get(n.getName()).getX(), nodes.get(n.getName()).getY());
                StdDraw.setPenRadius(.002);
                //region Changes the color of the start, des, and normal nodes
                if(n.getName().equals(start)){
                    StdDraw.setPenColor(Color.GREEN);
                    StdDraw.text(nodes.get(n.getName()).getX(), nodes.get(n.getName()).getY(), n.getName());
                }
                else if(n.getName().equals(des)){
                    StdDraw.setPenColor(Color.RED);
                    StdDraw.text(nodes.get(n.getName()).getX(), nodes.get(n.getName()).getY(), n.getName());
                }
                else{
                    StdDraw.setPenColor(Color.PINK);
                    StdDraw.text(nodes.get(n.getName()).getX(), nodes.get(n.getName()).getY(), n.getName());
                }
                StdDraw.setPenColor(Color.CYAN);
                //endregion
            }
        }
        mapD = true;
        StdDraw.setPenColor(Color.BLACK);
    }

    /**
     * Draws the best path from the start node to the des node
     * @param path
     */
    public void drawBestPath(String path){
        StdDraw.setPenColor(Color.ORANGE);
        String[] nodePath = path.split("");
        double prevX = nodes.get(nodePath[0]).getX();
        double prevY = nodes.get(nodePath[0]).getY();
        for(String s : nodePath){
            double dist = Math.sqrt(Math.pow(prevX - nodes.get(s).getX(), 2) + Math.pow(prevY - nodes.get(s).getY(), 2));
            StdDraw.setPenRadius(dist/200);
            StdDraw.line(prevX, prevY, nodes.get(s).getX(), nodes.get(s).getY());
            StdDraw.setPenRadius(.002);
            prevX = nodes.get(s).getX();
            prevY = nodes.get(s).getY();
        }
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledRectangle(0, .0, 1, .06);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(.5, .03, "Total cost: "+weightSum.get(des)+"");
    }

    /**
     * Sets the des node to d
     * @param d
     */
    public void setDes(String d){
        des = d;
    }

    /**
     * Sets the start node to s
     * @param s
     */
    public void setStart(String s){ start = s; }

    /**
     * Gets the des node
     * @return des
     */
    public String getDes(){
        return des;
    }

    /**
     * Gets mapDist
     * @return mapDist
     */
    public HashMap<String, ArrayList<Node>> getMapDist(){
        return mapDist;
    }

    /**
     * Gets map
     * @return map
     */
    public HashMap<String, ArrayList<Node>> getMap(){ return map; }

    /**
     * Gets the start node
     * @return start
     */
    public String getStart(){ return start; }
}