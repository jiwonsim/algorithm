import java.util.*;

class Pair implements Comparable<Pair> {
    int r, c, type;
    Pair(int r, int c, int type) {
        this.r = r;
        this.c = c;
        this.type = type;
    }

    @Override
    public int compareTo(Pair target) {
        if (this.c == target.c) {
            if (this.r == target.r) {
                return this.type - target.type;
            }
            else return this.r - target.r;
        }
        return this.c - target.c;
    }
}

class Solution {
    static int PIL = 0; // 기둥
    static int CLT = 1; // 보자기 
    static boolean EMP = false; // 비어있음
    static int[][] directions = {{0, 1}, {0, -1},
            {1, 0}, {-1, 0}, {1, -1}};

    boolean[][][] map;

    boolean isInRange(int r, int c) {
        return !(r < 0 || c < 0 || r > map.length || c > map.length);
    }

    boolean install(int r, int c, int type) {
        if (type == -1) return true; // 비어있으면 트루
        else if (type == PIL) { return installPillar(r, c); }
        else return installCloth(r, c);
    }

    boolean installPillar(int r, int c) {
        // 기둥을 세울 수 있으려면, 
        // 바닥위에 있거나, 바로 아래에 기둥이 있거나, 좌우에 보가 하나라도 있어야 함
        // 설치를 하고 결과를 반환함 

        if (r != 0 &&
                (isInRange(r-1, c) && map[r-1][c][PIL] == EMP) &&
                (isInRange(r, c-1) && map[r][c-1][CLT] == EMP) &&
                (isInRange(r, c+1) && map[r][c+1][CLT] == EMP)) { // 이 중에 하나만 충족하면 가능
            return false;
        }
        map[r][c][PIL] = !EMP;
        return true;
    }

    boolean installCloth(int r, int c) {
        // 보자기를 설치하기 위해서는 
        // 바로 아래에 기둥이 있거나, 양 옆에 보가 있어야 함. 또는 오른쪽 아래에 기둥이 있어야 함

        if ((isInRange(r-1, c) && map[r-1][c][PIL] == EMP) &&
                (isInRange(r-1, c+1) && map[r-1][c+1][PIL] == EMP) &&
                (isInRange(r, c-1) && map[r][c-1][CLT] == EMP
                        || isInRange(r, c+1) && map[r][c+1][CLT] == EMP)) {
            return false;
        }
        map[r][c][CLT] = !EMP;
        return true;
    }

    boolean remove(int r, int c, int type) {
        // 구조물을 없앨 수 있는 조건은,
        // 삭제를 해보고 사면에 있는 보와 기둥이 설치할 수 있는 조건이라면 삭제를 하고 true를 반환한다.
        // 조건이 충족시키지 못하면 삭제를 취소하고 false를 반환한다.
        map[r][c][type] = EMP; // 삭제
        for (int i = 0; i < directions.length; i++) {
            int nr = r+directions[i][0];
            int nc = c+directions[i][1];

            if (!isInRange(nr, nc)) continue;

            if (map[nr][nc][PIL] && !installPillar(nr, nc)) {
                map[r][c][type] = !EMP;
                return false;
            }
            if (map[nr][nc][CLT] && !installCloth(nr, nc)) {
                map[r][c][type] = !EMP;
                return false;
            }
        }
        return true;
    }

    public int[][] solution(int n, int[][] buildFrame) {
        map = new boolean[n+1][n+1][2];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                map[i][j][PIL] = EMP;
                map[i][j][CLT] = EMP;
            }
        }

        for (int[] frame : buildFrame) {
            int r = frame[1], c = frame[0];
            int type = frame[2];
            int cmd = frame[3];

            if (cmd == 0) {
                // 삭제 연산
                remove(r, c, type);
            }
            else { install(r, c, type); }
        }

        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k < 2; k++) {
                    if (map[i][j][k] == EMP) { continue; }
                    list.add(new Pair(i, j, k));
                }
            }
        }

        Collections.sort(list);

        int[][] result = new int[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).c;
            result[i][1] = list.get(i).r;
            result[i][2] = list.get(i).type;
        }

        return result;
    }
}