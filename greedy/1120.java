import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        String A = inputs[0];
        String B = inputs[1];

        int result = -1, count;
        for (int i = 0; i <= B.length() - A.length(); i++) {
            count = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) == B.charAt(i + j)) count++;
            }
            if (result < count) {
                result = count;
            }
        }

        bw.write(String.valueOf(A.length() - result));
        bw.flush();
        bw.close();
    }
}