import java.util.*;

/*
1차 시도 : 재귀로 했다가 역시나 시간초과
2차 시도 : memorization 방식으로 변경! 인데 2차배열을 이용하였다.
 */

public class Main {
    static long[][] mem;
    public static void calcMem() {
        mem[0][1] = mem[1][2] = 1;
        mem[0][3] = mem[1][3] = mem[2][3] = 1;

        for (int i = 4; i < 100001; i++) {
            mem[0][i] = (mem[1][i - 1] + mem[2][i - 1]) % 1000000009;
            mem[1][i] = (mem[2][i - 2] + mem[0][i - 2]) % 1000000009;
            mem[2][i] = (mem[0][i - 3] + mem[1][i - 3]) % 1000000009;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        mem = new long[3][100001];
        calcMem();

        while (T-- != 0) {
            int n = sc.nextInt();
            System.out.printf("%d\n", (mem[0][n] + mem[1][n] + mem[2][n]) % 1000000009);
        }
    }
}