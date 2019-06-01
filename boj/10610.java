import java.util.*;

/*
    참고 : https://pangsblog.tistory.com/87
    N는 최대 10^5개의 숫자로 구성 = 10^5 자리 => String으로 받기!
    '3의 배수는 모든 자리 수의 합이 3의 배수'임을 이용한다.

    마지막에 result를 String으로 받지말고 StringBuffer / StringBuilder로 받아야함.
    String으로 +를 하면 개 느림!!!
*/


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();

        int num[] = new int[10];
        long sum = 0;
        for (int i = 0; i < N.length(); i++) {
            int temp = N.charAt(i) - '0';
            num[temp]++;
            sum += temp;
        }

//        System.out.printf("%d \n", sum);

        if (num[0] == 0 || sum % 3 != 0) {
            System.out.printf("-1");
            return;
        }
        StringBuffer result = new StringBuffer();
        for (int i = num.length - 1; i >= 0; i--) {
            for (int j = 0; j < num[i]; j++) {
                result.append(i);
            }
        }
        System.out.printf("%s", result);
    }
}