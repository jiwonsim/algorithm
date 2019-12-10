import java.util.*;
import java.io.*;

public class Main {

    static int calcPeriod(int M) {
        int first = 1, second = 1;
        int period = 0;

        do {
            int temp = first;
            first = second;
            second = (temp + second) % M;
            period++;
        } while (!(first == 1 && second == 1));

        return period;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int P = Integer.parseInt(br.readLine());
        for (int i = 1; i <= P; i++) {
            String[] input = br.readLine().split(" ");

            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            int answer = calcPeriod(M);

            bw.write(N + " " + answer + "\n");
            bw.flush();
        }

        bw.close();
    }

}