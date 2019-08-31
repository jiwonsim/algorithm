import java.util.*;

class Pair {
    int idx;
    double val;
    Pair(int idx, double val) {
        this.idx = idx;
        this.val = val;
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        List<Pair> list = new ArrayList<>();

        int[] val = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            val[stages[i]]++;
        }
        int sumUser = stages.length;
        double[] res = new double[N + 2];
        for (int i = 1; i < val.length; i++) {
            int failUser = 0;
            for (int j = 1; j < i; j++) {
                failUser += val[j];
            }
            res[i] = val[i] / (double)(sumUser - failUser);
        }

        for (int i = 1; i < N + 1; i++) {
            list.add(new Pair(i, res[i]));
        }

        Comparator<Pair> comp = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.val > o2.val) return -1;
                else if (o1.val < o2.val) return 1;
                else {
                    if (o1.idx > o2.idx) return 1;
                    else if (o1.idx < o2.idx) return -1;
                }
                return 0;
            }
        };

        Collections.sort(list, comp);
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).idx;
        }


        return answer;
    }
}