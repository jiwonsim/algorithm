import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int[] ropes = new int[N];
        for (int i = 0; i < N; i++) ropes[i] = Integer.valueOf(br.readLine());

        Arrays.sort(ropes);
        int MAX = -1;
        for (int i = 0; i < N; i++) {
            int weight = ropes[i] * (N - i);
            if (MAX < weight) MAX = weight;
        }

        bw.write(String.valueOf(MAX));
        bw.close();
    }
}