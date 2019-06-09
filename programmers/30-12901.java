import java.util.Scanner;

class Solution {
    public String solution(int a, int b) {
        String answer = "";

        int[] numsOfDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 4;

        int result = 0;
        for (int i = 1; i < a; i++) {
            result += numsOfDays[i];
        }
        result = (result + b + days) % 7 - 1;

        System.out.printf("%d \n", result);
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        s.solution(sc.nextInt(), sc.nextInt());
    }
}