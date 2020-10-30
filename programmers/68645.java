import java.util.*;

class Solution {

    boolean isInRange(int r, int c, int n) {
        if (r < 0 || c < 0 || r >= n || c >= n) return false;
        return true;
    }

    public int[] solution(int n) {
        if (n == 1) return new int[]{1};
        
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = {};

        int row = 0, col = 0;
        int[][] map = new int[n][n];

        int number = 1;
        while (isInRange(row, col, n) && map[row][col] == 0) {

            while (row+1 < n && map[row+1][col] == 0) {
                map[row++][col] = number++;
            }

            while (col+1 < n && map[row][col+1] == 0) {
                map[row][col++] = number++;
            }

            while (map[row-1][col-1] == 0) {
                map[row--][col--] = number++;
            }
            map[row++][col] = number++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) break;
                list.add(map[i][j]);
            }
        }

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) answer[i] = list.get(i); 

        return answer;
    }
}
