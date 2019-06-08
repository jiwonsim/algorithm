
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] minusArr = input.split("-");
        int tmp, result = 0, index = 0;
        for (String minus : minusArr) {
            String[] plusArr = minus.split("\\+");
            tmp = 0;
            for (String plus : plusArr) {
                tmp += Integer.parseInt(plus);
            }

            if (index == 0) tmp = -1 * tmp;
            result -= tmp;
            index++;
        }

        System.out.printf("%d", result);
    }
}