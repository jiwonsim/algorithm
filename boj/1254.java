import java.util.*;

public class Main {

    public static boolean isPalindrome(String str, int start, int end) {
        if (start == end) return true; // 한 자리는 언제나 팰린드롬
        if (start + 1 == end) {
            if (str.charAt(start) == str.charAt(end)) return true;
            return false;
        }

        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindrome(str, start + 1, end - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Character> st = new Stack<>();
        String res = str;
        for (int i = 0; i < str.length(); i++) {
            if (isPalindrome(res, 0, res.length() - 1)) break;

            res = str;

            for (int j = 0; j <= i; j++) {
                st.push(str.charAt(j));
            }

            while (!st.isEmpty()) {
                res += st.pop();
            }
        }

//        System.out.printf("%s\n", res);
        System.out.printf("%d\n", res.length());
    }
}