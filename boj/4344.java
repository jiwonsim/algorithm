import java.util.*;
import java.io.*;

public class Main {

    static double calcAvg(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        return sum / nums.length;
    }

    static double countOverAvg(int[] nums, double avg) {
        Arrays.sort(nums);
        double cnt = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= avg) break;
            cnt++;
        }

        return cnt / (double)nums.length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.valueOf(br.readLine());

        while (C-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.valueOf(input[0]);
            int[] nums = new int[N];
            for (int i = 1; i <= N; i++) {
                nums[i - 1] = Integer.valueOf(input[i]);
            }

            double result = Math.round(countOverAvg(nums, calcAvg(nums)) * 1000 * 100) / 1000.0;
            bw.write( String.format("%.3f", result)+ "%\n");
            bw.flush();

        }
        bw.close();
    }
}