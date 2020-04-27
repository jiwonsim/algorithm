import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        // init
        int[] end = new int[N];
        int[] start = new int[N];
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        // ending series
        end[0] = array[0];
        for (int i = 1; i < N; i++) {
            end[i] = array[i];
            end[i] = Math.max(end[i], end[i - 1] + array[i]);

        }

        // starting series
        start[N - 1] = array[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            start[i] = array[i];
            start[i] = Math.max(start[i], start[i + 1] + array[i]);
        }

        // init result
        int result = Math.max(end[0], start[0]);
        for (int i = 1; i < N; i++) {
            result = Math.max(result, Math.max(end[i], start[i]));
        }

        // find max value
        for (int i = 0; i < N; i++) {
            if (N == 1) break;

            if (i == 0) result = Math.max(result, start[i + 1]);
            else if (i == N - 1) result = Math.max(result, end[i - 1]);
            else result = Math.max(result, end[i - 1] + start[i + 1]);
        }

        // output
        bw.write(result + "\n");
        bw.flush();
    }
}