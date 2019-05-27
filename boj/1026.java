import java.util.*;

class Solution {
    public int solution(int N, int A[], int B[]) {
        int answer = 0;

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        for (int a : A) {
            listA.add(a);
        }
        for (int b : B) {
            listB.add(b);
        }

        Collections.sort(listA);
        Collections.sort(listB);
        Collections.reverse(listB);

//        for (int a : listA) {
//            System.out.print(a + " ");
//        }
//        System.out.println();
//        for (int b : listB) {
//            System.out.print(b + " ");
//        }

        for (int i = 0; i < N; i++) {
            answer += listA.get(i) * listB.get(i);
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] A = new int[N];
        int [] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        Solution s = new Solution();
        System.out.println(s.solution(N, A, B));
    }
}