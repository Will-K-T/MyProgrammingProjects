public class Twenty {
    public static void main(String[] args) {
        for (int i = 1; i <= 2020; i++) {
            if(i < 10) System.out.println("000" + i);
            else if(i < 100) System.out.println("00" + i);
            else if(i < 1000) System.out.println("0" + i);
            else if(i >= 1000) System.out.println(i);

        }
    }
}
