import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        int SIZE = 26;

        int first_count[] = new int[SIZE];
        int second_count[] = new int[SIZE];

        for (int i =0; i < first.length(); i++) {
            first_count[first.charAt(i) - 'a']++;
        }
        for (int i = 0; i < second.length(); i++) {
            second_count[second.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            count += Math.abs(first_count[i] - second_count[i]);
        }

        System.out.println(count);
    }
}

// a b
// c