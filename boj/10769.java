import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int happy = 0, sad = 0;
        int face = 0;
        for (int i = 0; i < str.length(); i++) {
            int cur = str.charAt(i);
            if (cur == ':' || (cur == '-' && face == 1)) {
                face++;
                continue;
            }
            if (face == 2) {
                if (cur == ')') happy++;
                if (cur == '(') sad++;
            }
            face = 0;
        }

        if (happy > sad) System.out.printf("happy");
        else if (sad > happy) System.out.printf("sad");
        else {
            if (happy != 0) System.out.printf("unsure");
            else System.out.printf("none");

        }
    }
}