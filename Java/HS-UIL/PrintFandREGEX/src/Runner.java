import java.util.*;

public class Runner {
    public static void main(String[] args) {
        String mouse = "bla^every^thing";
        mouse = mouse.replaceAll("..{2}", "HA");
        System.out.println(mouse);
        String reg = "^(.)|(..)";
        String reg2 = "^(.*)@gmail.com";
        String test = "Hello, World!";
        String test2 = "HH";
        String test3 = "someone@gmail.com";
        String gamger = "I am cool not I";
        String rex = "[a-d[d-z]]";
        gamger = gamger.replaceAll(rex, "yeet");
        System.out.println(gamger);
        System.out.println(test.matches(reg));
        System.out.println(test3.matches(reg2) ? "Welcome to google!" : "GO AWAY!");
        //System.out.println(test3.matches(reg2));
        System.out.println(test2.matches(reg));




        Map<String, String> map = new TreeMap<>();
        ArrayList<String> al = new ArrayList<>();
        al.add("ghj");
        al.add("vds");
        al.add("234");
        al.add("abc");
        Set<String> set = new TreeSet<>();
        set.add("234");
        set.add("abc");
        set.add("ghj");
        set.add("vds");
        System.out.println(set);
        Iterator<String> it = set.iterator();
        for(String s: al){
            map.put(s, it.next());
        }
        System.out.println(map);
        Queue<Integer> theQ = new PriorityQueue<>();
        theQ.add(3);
        System.out.println(theQ);
        theQ.add(5);
        System.out.println(theQ);
        theQ.add(1);
        System.out.println(theQ);
        System.out.println(theQ.remove());
        System.out.println(theQ);
        theQ.remove();
        System.out.println(theQ);
        theQ.add(0);
        System.out.println(theQ);
        theQ.remove();
        System.out.println(theQ);
        System.out.println(theQ.remove());

        System.out.println(two(10));

        String sample = "the_thirty_three";
        String[] yeet = sample.split("h");
        System.out.println(Arrays.toString(yeet));

        IntCell naenae = new IntCell(5);
        IntCell other = naenae;
        other.add();
        System.out.println(other);
        naenae.add();
        System.out.println(naenae);
        System.out.println(17/2);
        System.out.println("bouncingxballoons".substring(8+1));
        System.out.println(stuff("bouncing balloons"));
    }

    public static String stuff(String s){
        int n = s.length()/2;
        //System.out.println(s);
        if(n>2){
            System.out.println(s);
            s=stuff(s.substring(0, n-1))+"*"+stuff(s.substring(n+1));
        }
        return s;
    }

    public static int two(int x){
        if(x<=3){
            return 1;
        }
        else{
            return 1 + two(x-2);
        }
    }
}

class IntCell{
    int x;
    public IntCell(int x){
        this.x = x;
    }

    public void add(){
        x++;
    }

    public String toString(){
        return "Val: "+x;
    }
}
