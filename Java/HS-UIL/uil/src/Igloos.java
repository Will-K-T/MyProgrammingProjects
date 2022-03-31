import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Igloos {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("igloos.dat"));
        ArrayList<Integer> words = new ArrayList<>();
        ArrayList<String> realwords = new ArrayList<>();
        int n = scan.nextInt();
        scan.nextLine();
        while(scan.hasNextLine()){
            for (int i = 0; i < n; i++) {
                String line = scan.nextLine();
                String[] array = line.split(" ");
                int sum = 0;
                for (String s: array) {
                    sum += Integer.parseInt(s);
                }
                words.add(sum);
            }
        }

        for (int i = 0; i < words.size(); i++) {
            String temp = "";
            for (int j = 0; j < words.get(i).toString().length(); j++) {
                String word = words.get(i).toString();
                temp += word.charAt(j);
            }
            words.set(i, Integer.parseInt(temp));
        }

        for (int i = 0; i < words.size(); i++) {
            String temp2 = "";
            for (int j = 0; j < words.get(i).toString().length(); j++) {
                char letter = words.get(i).toString().charAt(j);
                if (letter == 0) {
                    temp2 += "0";
                }
                if (letter == 1) {
                    temp2 += "I";
                }
                if (letter == 2) {
                    temp2 += "Z";
                }
                if (letter == 3) {
                    temp2 += "E";
                }
                if (letter == 4) {
                    temp2 += "h";
                }
                if (letter == 5) {
                    temp2 += "S";
                }
                if (letter == 6) {
                    temp2 += "g";
                }
                if (letter == 7) {
                    temp2 += "L";
                }
                if (letter == 8) {
                    temp2 += "B";
                }
                if (letter == 9) {
                    temp2 += "G";
                }
                realwords.add(temp2);
            }
        }
        System.out.println(words);
        System.out.println(realwords);
    }
}
