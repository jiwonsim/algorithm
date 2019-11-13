import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int num = 0;
        while (N > 0) {
            num++;
            String str = Integer.toString(num);

            if (str.contains("666")) N--;
        }

        System.out.printf("%d", num);

    }
}