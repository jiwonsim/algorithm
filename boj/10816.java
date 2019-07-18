import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] sg = new int[N];
        for (int i = 0; i < N; i++)
            sg[i] = sc.nextInt();

        Arrays.sort(sg);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (hm.containsKey(sg[i])) hm.put(sg[i], hm.get(sg[i]) + 1);
            else hm.put(sg[i], 1);
        }

        int M = sc.nextInt();
        int[] num = new int[M];
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < M; i++) {
            num[i] = sc.nextInt();
            if (hm.containsKey(num[i])) res.append(hm.get(num[i]) + " ");
            else res.append("0 ");
        }


        System.out.printf("%s", res.toString());
    }
}