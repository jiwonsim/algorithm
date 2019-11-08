import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int minji = sc.nextInt();
        int hansu = sc.nextInt();

        int round = 0;
        while (minji != hansu) {
            minji = minji / 2 + minji % 2;
            hansu = hansu / 2 + hansu % 2;
            round++;
        }

        System.out.printf("%d", round);
    }
}