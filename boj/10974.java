
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int arr[];

    public static void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return;
    }

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

        swap(index, j);

        for (int i = index + 1; i < (arr.length + index + 1) / 2; i++) {
            int temp = arr[arr.length - (i - index)];
            arr[arr.length - (i - index)] = arr[i];
            arr[i] = temp;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        do {
            print();
        } while (next());
    }
}