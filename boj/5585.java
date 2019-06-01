import java.util.*;

public class Main {
    public static void main(String[] args) {
        final int moneys[] = {500, 100, 50, 10, 5, 1};
        Scanner sc = new Scanner(System.in);

        int taro = sc.nextInt();
        taro = 1000 - taro;

        int count = 0;
        for (int money : moneys) {
            if (money > taro) continue;
            while (money <= taro) {
                count += taro / money;
                taro = taro % money;
            }
        }

        System.out.printf("%d", count);


        /*
        380
        500 * 1
        100 * 1
        10 * 2
         */
    }
}