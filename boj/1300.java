import java.util.*;

/*
참고 : https://huiung.tistory.com/90
    N이 3일 때
    1   2   3
    2   4   6
    3   6   9

    left = 1, right = 7, mid = 4 로 시작한다.
    1번째 과정에서 총 개수는 3 + 2 + 1로 6개. k = 7이므로 left를 mid + 1인 5로 바꿔준다.
    2번째 과정에서 mid = 6, 6을 대상으로 계산하면 3 + 3 + 2 = 8개가 나온다.
    (N = 3, k = 7일 때  7보다 작은 수의 개수를 찾고 싶다면
     3 * 3 배열 안에 있는 숫자들(i * j(1 <= i, j <= N))은 k / i(1 <= i <= N)를 해야 구할 수 있다.)
    이제 8은 k보다 크므로 res에 mid 값을 넣고 right를 mid - 1를 넣어준다. (5)
    left와 right가 동일하게 5가 나오며, 총 개수는 3 + 2 + 1 = 6개.
    left와 right가 동일하므로 마지막 과정으로 5보다 작은 수는 6개, 6보다 작은 수는 8개이므로 7번째 수는 6이다.

 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();

        long left = 1, right = k;
        int res = 0;
        while (left <= right) {
//            System.out.printf("%d %d\n", left, right);
            int mid = (int)(left + right) / 2;
            long cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            if (cnt >= k) {
                res = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }

        System.out.printf("%d", res);
    }
}