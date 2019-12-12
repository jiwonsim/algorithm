
import java.util.*;
import java.io.*;

public class Main {

    static int[] searchLIS(int[] nums, int N) {
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && result[i] < result[j] + 1)
                    result[i]++;
            }
        }

        return result;
    }

    static int[] searchLISReverse(int[] nums, int N) {
        int[] result = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            result[i] = 1;
            for (int j = N - 1; j >= i; j--) {
                if (nums[j] < nums[i] && result[i] < result[j] + 1)
                    result[i]++;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");

        int[] nums = new int[N];
        for (int i = 0; i < in.length; i++) {
            nums[i] = Integer.parseInt(in[i]);
        }

        int[] lis = searchLIS(nums, N);
        int[] lisRev = searchLISReverse(nums, N);

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(lis[i] + lisRev[i], result);
        }

        result--;

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}