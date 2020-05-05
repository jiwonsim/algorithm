import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(input[i]);
        }

        if (N == 1 || switching(searchDesc()) == -1) {
            bw.write("-1");
        }
        else {
            for (int i = 0; i < N; i++) {
                bw.write(arr[i] + " ");
            }
        }
        bw.flush();
    }

    static int switching(int index) {

        if (index == N - 1) {
            long temp = arr[index];
            arr[index] = arr[index - 1];
            arr[index - 1] = temp;
            return 1;
        }

        long maxVal = Long.MAX_VALUE;
        int maxId = -1;
        for (int i = index + 1; i < N; i++) {
            if (arr[index] < arr[i]) {
                if (maxVal > arr[i]) {
                    maxVal = arr[i];
                    maxId = i;
                }
            }
        }

        if (maxId == -1) {
            return -1;
        }

        long temp = arr[index];
        arr[index] = arr[maxId];
        arr[maxId] = temp;

        sorting(index);
        return 1;
    }

    static void sorting(int index) {
        Arrays.sort(arr, index + 1, N);
    }

    static int searchDesc() {

        long before = -1;
        for (int i = N - 1; i >= 0; i--) {
            if (before < arr[i]) {
                before = arr[i];
                continue;
            }
            return i;
        }
        return 0;
    }
}