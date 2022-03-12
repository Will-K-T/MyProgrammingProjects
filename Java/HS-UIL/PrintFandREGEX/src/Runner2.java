public class Runner2 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        System.out.println(a.getTnum()+" "+b.getTnum());
    }
}

class A {
    public static int snum = 1;
    public int tnum = 11;
    public int mnom(){
        return 21;
    }
    public int getSnum(){
        return snum;
    }
    public int getTnum(){
        return tnum;
    }
}

class B extends A {
    public static int snum = 2;
    public int tnum = 12;
    public int mnom(){
        return 22;
    }

}
