import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] array;

    static int calcSum() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += array[i];
        }

        return sum;
    }

    static void sortingByHeap() {
        for (int i = 1; i < N; i++) {
            int cur = i;

            do {
                int root = (cur - 1) / 2;

                if (array[root] < array[cur]) {
                    int temp = array[root];
                    array[root] = array[cur];
                    array[cur] = temp;
                }

                cur = root;
            } while (cur != 0);
        }

        for (int i = N - 1; i >= 0; i--) {
            // swapping
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            int root = 0, cur = 0;
            do {
                cur = root * 2 + 1;

                if (cur < i - 1 && array[cur] < array[cur + 1]) {
                    cur++;
                }

                if (cur < i && array[root] < array[cur]) {
                    temp = array[root];
                    array[root] = array[cur];
                    array[cur] = temp;
                }

                root = cur;
            } while (cur < i);
        }
    }

    static int countFrequency() {
        int freq;

        int[] count = new int[8001];
        int MAX = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            count[array[i] + 4000]++;
            if (count[array[i] + 4000] > MAX) {
                MAX = count[array[i] + 4000];
            }
        }

        ArrayList<Integer> duplicated = new ArrayList<>();
        int dupCnt = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == MAX) {
                dupCnt++;
                duplicated.add(i - 4000);
            }
        }

        if (dupCnt > 1) {
            Collections.sort(duplicated);
            freq = duplicated.get(1);
        } else freq = duplicated.get(0);

        return freq;
    }

    public static void main(String[] args) throws IOException{

        // init
        N = Integer.valueOf(br.readLine());
        array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.valueOf(br.readLine());
        }

        int sum = 0, mid = 0, freq = 0, range = 0;

        // sorting
        sortingByHeap();

        // calculate sum of array
        sum = calcSum();

        // find median value of sorted array in ascending order
        mid = array[N / 2];

        // count frequency
        freq = countFrequency();

        // calculate range
        range = array[N - 1] - array[0];

        // calculate average of array
        long avg = Math.round((double)(Math.abs(sum)) / N);

        // print result
        bw.write(String.valueOf(sum < 0 ? -avg : avg) + "\n" +
                String.valueOf(mid) + "\n" +
                String.valueOf(freq) + "\n" +
                String.valueOf(range));

        bw.flush();
        bw.close();
    }
}