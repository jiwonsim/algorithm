import java.util.*;

public class Main {
    static int MOD = 10007;
    static int[][] values = new int[1001][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        initValues(num);
        System.out.println(values[num][9] % MOD);

    }

    static void initValues(int num) {

        for (int row = 0; row <= num; row++) {
            values[row][0] = 1;
            for (int col = 1; col < 10; col++) {
                if (row == 0) values[row][col] = 1;
                else {
                    values[row][col] = (values[row - 1][col] % MOD  + values[row][col - 1] % MOD) % MOD;
                }
            }
        }
    }
}