import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[];

    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean next() {
        int index = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i+1]) index = i;
        }

        if (index == -1) return false;

        int j = arr.length - 1;
        for (; j >= 0; j--) {
            if (arr[j] > arr[index]) break;
        }

        // swap
        swap(index, j);

        for (int i = index + 1; i < (arr.length + index + 1) / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - (i - index)];
            arr[arr.length - (i - index)] = temp;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (next()) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        else {
            System.out.println("-1");
        }
    }
}