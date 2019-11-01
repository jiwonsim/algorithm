import java.util.*;

class Solution {
    public int solution(int N) {
        int sack = 0;
        int accuracy = N;

        while (accuracy > 0) {
            if (accuracy % 5 == 0) {
                sack += accuracy / 5;
                accuracy %= 5;
            } else {
                sack++;
                accuracy -= 3;
            }
        }

        if (accuracy < 0) {
            return -1;
        }

        return sack;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Solution s = new Solution();
        int ans = s.solution(N);
        System.out.printf("%d", ans);
    }
}