import java.util.Scanner;

/*
참고 사이트 : https://limkydev.tistory.com/121
조건 3. 마지막 도착 계단은 반드시 밟아야 한다. 라는 조건에 맞춰서
N번째 계단이 1번 연속인 경우, 2번 연속인 경우 두 가지 경우를 나눠서 생각해볼 수 있다.

N번째 계단이 1번 연속인 경우는 N - 2번째 계단의 총점을 합쳐야 한다.
DP[N] = DP[N - 2] + A[N];
N번째 계단이 2번 연속인 경우는 N - 1번째 계단은 밟아야 하고, N - 2번째 계단은 무조건 밟으면 안 되고, N - 3번째 계단은 밟아야 한다.
DP[N] = A[N] + A[N - 1] + DP[N - 3];
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        dp[1] = arr[1];
        if (N >= 2) dp[2] = dp[1] + arr[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], arr[i] + arr[i - 1] + dp[i - 3]);
        }

        System.out.printf("%d", dp[N]);


    }
}