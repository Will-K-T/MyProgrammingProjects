import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class word_score {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner yeet = new Scanner(new File("word_score.dat"));
        while (yeet.hasNextLine())
        {
            String line = yeet.nextLine();
            String[] words = line.split(" ");
            int[] score = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                score[i] += word.length()/2;
                for (int j = 0; j < word.length(); j++) {
                    String let = word.substring(j,j+1).toLowerCase();

                    if (let.equals("a") || let.equals("e") || let.equals("i") || let.equals("o") || let.equals("u"))
                    {
                        score[i] += 1;
                    }
                    else if(let.equals("z"))
                    {
                        score[i] +=2;
                    }
                    else if(let.equals("x") || let.equals("q"))
                    {
                        score[i] += 3;
                    }
                }
            }
            int biggest = 0;
            for (int i = 0; i < score.length; i++) {
                if (score[i] > score[biggest])
                {
                    biggest = i;
                }
            }
            System.out.println(words[biggest] + " - " + score[biggest] );
        }
    }
}
