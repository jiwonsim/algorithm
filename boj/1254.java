import java.util.Scanner;
import java.util.Stack;

class Solution {
    public boolean isPalindrome(String str, int start, int end) {
        if (start == end) return true; // 1자리일 때

        if (start + 1 == end) { // 2자리일 때
            if (str.charAt(start) == str.charAt(end)) return true;
            return false;
        }

        if (str.charAt(start) != str.charAt(end)) return false;
        else return isPalindrome(str, start + 1, end - 1);
    }

    public int solution(String plain) {
        int answer = 0;

        Stack<Character> s = new Stack<>();

        String tmpPlain = plain;
        for (int i = 0; i < plain.length(); i++) {
//            System.out.printf("%s \n", tmpPlain);
            if (isPalindrome(tmpPlain, 0, tmpPlain.length() - 1)) break;

            tmpPlain = plain;
            for (int j = 0; j <= i; j++) {
                s.push(plain.charAt(j));
            }

            while (!s.isEmpty()) {
                tmpPlain += s.pop();
            }
        }

        answer = tmpPlain.length();

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);

        System.out.printf("%d", s.solution(sc.next()));
    }
}