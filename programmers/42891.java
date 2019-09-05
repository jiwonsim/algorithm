import java.util.*;

class Pair{
    int index, value;

    Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

class Solution {

    Comparator<Pair> compVal = new Comparator<Pair>() {
        public int compare(Pair o1, Pair o2) {
            return o1.value - o2.value;
        }
    };

    Comparator<Pair> compIdx = new Comparator<Pair>() {
        public int compare(Pair o1, Pair o2) {
            return o1.index - o2.index;
        }
    };

    public int solution(int[] food_times, long k) {
        int answer = 0;

        List<Pair> list = new LinkedList<Pair>();
        for (int i = 0; i < food_times.length; i++) {
            list.add(new Pair(i + 1, food_times[i]));
        }

        Collections.sort(list, compVal);

        int prev = 0, i = 0, col = food_times.length;
        for (Pair p : list) {
            long row = p.value - prev;

            if (row != 0) {
                long sum = row * col;

                if (sum <= k) {
                    k = k - sum;
                    prev = p.value;
                }
                else {
                    k = k % col;
                    list.subList(i, food_times.length).sort(compIdx);
                    return list.get(i + (int)k).index;
                }
            }
            i++;
            col--;
        }

        return -1;
    }
}