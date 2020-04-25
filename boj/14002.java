import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int MAX_ID = -1, MAX_VAL = -1;
    static int[] len;
    static int[] link;

    static int[] numbers;

    static void printing(int index) {
        if (index == -1) return;
        printing(link[index]);
        System.out.printf("%d ", numbers[index]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        // init
        len = new int[N];
        link = new int[N];
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
            link[i] = i;
        }

        // calculate
        for (int i = 0; i < N; i++) {
            len[i] = 1;
            link[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[i] <= numbers[j]) continue;
                if (len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                    link[i] = j;
                }
            }
        }

        int count = len[0];
        int biggest = 0;
        for (int i = 0; i < N; i++) {
            if (count < len[i]) {
                count = len[i];
                biggest = i;
            }
        }

        System.out.printf("%d\n", count);
        printing(biggest);
    }
}
