import java.util.Scanner;

public class Main {
    public static void solve(int n) {
        long arr[] = new long[n + 1];
        int index = 1;
        long val = 1;
        int ten = 1;
        while (true) {
            if (val / 10 > 987654321) {
                System.out.println("-1" );
                break;
            }
            if (index == arr.length) {
                System.out.println(arr[index - 1]);
                return;
            }

            if (index <= 10) {
                arr[index++] = val++;
                continue;
            }

            if (val > ten) ten *= 10;

            boolean flag = true;
            String str = String.valueOf(val);
            int i;
            for (i = 1; i < str.length(); i++) {
                if (str.charAt(i - 1) <= str.charAt(i)) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                val = val + (int)Math.pow(10, str.length() - 1 - i) - (int)(val % Math.pow(10, str.length() - 1 - i));
                continue;
            }

            arr[index++] = val;
            val++;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        solve(N);
    }
}