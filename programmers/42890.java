import java.util.*;

class Solution {
    Comparator<Integer> comp = new Comparator<Integer>() {
        int countBits(int n) {
            int ret = 0;
            while (n != 0) {
                if ((n & 1) != 0) ++ret;
                n = n >> 1;
            }
            return ret;
        }

        public int compare(Integer o1, Integer o2) {
            int x = countBits(o1); // 각각의 공집합을 나타내는 인트 값을 센다.
            int y = countBits(o2);

            if (x > y) return 1;
            else if (x < y) return -1;
            else return 0;
        }
    };

    boolean check(int subset, String[][] relation, int row, int col) {

        for (int i = 0; i < row - 1; i++) {
            for (int j = i + 1; j < row; j++) {
                boolean isSame = true;
                for (int k = 0; k < col; k++) {
                    if ((subset & 1 << k) == 0) continue;
                    if (relation[i][k].equals(relation[j][k]) == false) {
                        isSame = false;
                        break;
                    }
                }

                if (isSame) return false;
            }
        }

        return true;
    }


    public int solution(String[][] relation) {
        int answer = 0;

        int row = relation.length;
        int col = relation[0].length;

        // 유일성 검사
        List<Integer> cand = new LinkedList<Integer>();

        for (int i = 1; i < 1 << col; i++) {
            if (check(i, relation, row, col) == true) cand.add(i);
        }

        Collections.sort(cand, comp);

        while (cand.size() != 0) {
            int n = cand.remove(0);
            ++answer;

            for (Iterator<Integer> it = cand.iterator(); it.hasNext(); ) {
                int c = it.next();
                if ((n & c) == n) {// c가 n이 가진 속성을 가지고 있다면
                    it.remove(); // 삭제
                }
            }
        }

        return answer;
    }
}