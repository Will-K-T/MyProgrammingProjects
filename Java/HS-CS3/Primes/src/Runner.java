import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        boolean[] primes = new boolean[100000000];
        Arrays.fill(primes, true);
        primes[1] = false;
        primes[0] = false;
        for (int i = 2; i < (int)(Math.sqrt(primes.length)); i++) {
            if(!primes[i]){
                continue;
            }
            for (int j = primes.length-1000; j < primes.length; j++) {
                if(primes[j] && j%i==0){
                    primes[j] = false;
                }
            }
        }
        for (int i = primes.length-1; i >= 0; i--) {
            if(primes[i]){
                System.out.println(i);
                break;
            }
        }
    }
}
