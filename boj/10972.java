import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Gert Taberner - Fallen

public class Main {
    public static boolean brute_force(int arr[]) {
        boolean flag = false;
        int i = 0, j = 0;
        for (i = arr.length - 1; i > 0; i--) {
            for (j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        if (flag) {
            for (int k = j + 1; k < arr.length-1; k++) {
                if (arr[k] < arr[k+1]) continue;
                else {
                    int temp = arr[k];
                    arr[k] = arr[k+1];
                    arr[k+1] = temp;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (brute_force(arr)) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        else {
            System.out.println("-1");
        }
    }
}
