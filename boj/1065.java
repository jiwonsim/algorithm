import java.util.Scanner;

// 한수란..? 자리수가 등차수열임
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int sum = 0;
        String input_str;
        for (int i = 1; i <= input; i++) {
            if (i < 100) {
                sum ++;
                continue;
            }

            input_str = String.valueOf(i);
            int dif = input_str.charAt(0) - input_str.charAt(1);
            for (int j = 1; j < input_str.length() - 1; j++) {
                int comp = input_str.charAt(j) - input_str.charAt(j + 1);
                if (dif != comp) {
//                    System.out.println(input_str);
                    break;
                }
                sum++;
            }
        }

        System.out.println(sum);
    }
}