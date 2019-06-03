import java.util.*;

/*
    https://a1010100z.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-1946-%EC%8B%A0%EC%9E%85%EC%82%AC%EC%9B%90-java
    hint
    1.  서류 심사 등수 순으로 정렬
    2.  면접 등수는 서류 심사 등수가 현재 검사하는 지원자보다 높은 지원자들 중 가장 높은 등수랑만 비교하면 됨!
        반복문을 돌면서 MAX 값을 갱신. -> O(1)로 비교 가능하다.
*/

public class Main {
    public static int solve(List<Pair> list) {
        int count = 0;
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.p > o2.p ? 1 : -1;
            }
        });

        int MAX = Integer.MAX_VALUE;
        for (Pair p : list) {
            if (p.i < MAX) {
                count++;
                MAX = Math.min(p.i, MAX);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<Pair> list;
        while (T-- != 0) {
            int N = sc.nextInt();
            list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(new Pair(sc.nextInt(), sc.nextInt()));
            }

            System.out.printf("%d\n", solve(list)); // 잉? 줄바꿈 안했더니 틀림; 퐝당
        }
    }
}

class Pair {
    int p, i;
    Pair(int p, int i) {
        this.p = p;
        this.i = i;
    }
}