import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static ArrayList solve(long n, int index, ArrayList list) {
        if (index > 10) return list;

        list.add(n);

        for (int i = 0; i < 10; i++) {
            if (n % 10 > i) {
                solve(n * 10 + i, index + 1, list);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N >= 1023) {
            System.out.println("-1");
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++)
            solve(i, 1, list);

        Collections.sort(list);

        System.out.println(list.get(N));
    }
}