import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        char[] input = br.readLine().toCharArray();

        int count = 0, answer = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(') {
                count++;
            }
            else { // input[i] == ')'
                if (input[i - 1] == '(') { // laser
                    answer += --count;
                }
                else { // not laser
                    count--;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}