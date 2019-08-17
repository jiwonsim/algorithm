import java.util.*;



public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.next();
        int cnt = 0;


        if (Integer.parseInt(N) < 10) {
            N = '0' + N;
        }


        int n1 = N.charAt(0) - '0';
        int n2 = N.charAt(1) - '0';

        while (true) {
            int sum = n1 + n2;

            String res = String.valueOf(n1) + String.valueOf(n2);
            if (res.equals(N) && cnt != 0) {
                System.out.printf("%d\n", cnt);
                break;
            }

            if (sum >= 10) {
                sum = String.valueOf(sum).charAt(1) - '0';
            }

            cnt++;
            n1 = n2;
            n2 = Integer.parseInt(String.valueOf(sum));

        }

    }
}