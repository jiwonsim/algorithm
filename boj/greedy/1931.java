import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int time[][] = new int[N][2];
        for (int i = 0; i < N; i++) {
            time[i][0] = sc.nextInt();
            time[i][1] = sc.nextInt();
        }


        // 2차원 배열 정렬
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });



        int before = -1, count = 0;
        for (int i = 0; i < N; i++) {
            if (time[i][0] >= before) {
                before = time[i][1];
                count++;
            }
        }

        System.out.printf("%d", count);

        /*
        11
        1 4 - 3
        3 5 - 2
        0 6 - 6
        5 7 - 2
        3 8 - 5
        5 9 - 4
        6 10 - 4
        8 11 - 3
        8 12 - 4
        2 13 - 11
        12 14 - 2

        1 4
        5 7
        8 11
        12 14
        */

    }
}