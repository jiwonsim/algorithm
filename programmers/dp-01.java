class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int[][] temp = new int[land.length][land[0].length];
        int before = -1, max_idx = 0, max = 0, max_temp = 0;
        for (int i = 0; i < land[0].length; i++)
            temp[0][i] = land[0][i];

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                for (int k = 0; k < land[i].length; k++) {
                    if (j == k) continue;
                    temp[i][j] = Math.max(land[i][j] + temp[i - 1][k], temp[i][j]);
                }
            }
        }

//        for (int i = 0; i < temp.length; i++) {
//            for (int j = 0; j < temp[i].length; j++) {
//                System.out.print(temp[i][j] + " ");
//            }
//            System.out.println();
//        }
        int LASTLINE = land.length;
        for (int i = 0; i < temp[LASTLINE - 1].length; i++) {
            answer = Math.max(temp[LASTLINE - 1][i], answer);
        }

        return answer;
    }
}