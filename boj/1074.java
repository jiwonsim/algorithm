import java.util.*;

public class Main {
    static int size, r, c, res;

    public static void recursion(int sx, int sy, int tsize) {
        if (sx == r && sy == c) return;
        if (tsize < 1) return;

        if (r < sx + tsize / 2 && r >= sx) {
            if (c < sy + tsize / 2 && c >= sy) { // 1분면
                recursion(sx, sy, tsize / 2);
            }
            else { // 2분면
                res += (int)Math.pow(tsize / 2, 2) * 1;
                recursion(sx, sy + tsize / 2, tsize / 2);
            }
        }
        else {
            if (c < sy + tsize / 2 && c >= sy) { // 3분면
                res += (int)Math.pow(tsize / 2, 2) * 2;
                recursion(sx + tsize / 2, sy, tsize / 2);
            }
            else { // 4분면
                res += (int)Math.pow(tsize / 2, 2) * 3;
                recursion(sx + tsize / 2, sy + tsize / 2, tsize / 2);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        size = (int)Math.pow(2, N);

        recursion(0, 0, size);

        System.out.printf("%d", res);
    }
}