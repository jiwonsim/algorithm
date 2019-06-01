import java.util.*;

// 정말 그리디하게 풀었따.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        int i, j, MIN = Integer.MAX_VALUE;
        for (i = 0; i < str2.length(); i++) {
            int count = 0;
            if (str2.length() - str1.length() < i) break;
            for (j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) != str2.charAt(i + j)) count++;
            }
            MIN = Math.min(count, MIN);
        }

        System.out.printf("%d ", MIN);
    }
}