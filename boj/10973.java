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

    public static boolean before() {
        int index = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i+1]) index = i;
        }

//        System.out.println("index : "+index + " / arr[index] : " + arr[index]);

        if (index == -1) return false;

        int j = arr.length - 1;
        for (; j >= index; j--) {
            if (arr[index] > arr[j]) break;
        }

//        System.out.println("arr[index] : " + arr[index]);
//        System.out.println("arr[j] : " + arr[j]);

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

        if (before()) {
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");
        }
        else {
            System.out.println("-1");
        }
    }
}