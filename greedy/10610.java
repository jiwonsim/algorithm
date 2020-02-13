import java.util.*;
import java.io.*;

public class Main {

    static boolean isDividedByThirty(int[] nums) {
        if (nums[0] == 0) return false;

        int sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += nums[i] * i;
        }

        if (sum % 3 != 0) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int[] nums = new int[10];
        for (int i = 0; i < input.length(); i++) {
            nums[input.charAt(i) - '0']++;
        }

        StringBuffer result = new StringBuffer();
        if (isDividedByThirty(nums)) {
            for (int i = 9; i >= 0; i--) {
                while (nums[i]-- != 0) {
                    result.append(i);
                }
            }
        }
        else {
            result = new StringBuffer("-1");
        }

        bw.write(result.toString());

        bw.flush();
        bw.close();
    }
}