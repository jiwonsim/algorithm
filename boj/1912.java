import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = nums[0];

        int MAX = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], Math.max(nums[i - 1] + nums[i], nums[i]));
            MAX = Math.max(dp[i], MAX);
        }

        System.out.printf("%d", MAX);
    }
}