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
    static int PILLA = 0; // 기둥
    static int CLOTH = 1; // 보자기
    static boolean EMPTY = false;

    boolean[][][] map; // 지도

    private boolean inRange(int r, int c) {
        return !(r < 0 || c < 0 || r >= map.length || c >= map.length);
    }

    private boolean possible(int r, int c, int type) {
        if (!inRange(r, c)) return true; // 범위 안 맞으면 컨티뉴

        if (type == PILLA) { // 기둥일 때
            if (r == 0) return true; // 바닥에 설치하거나
            if (inRange(r-1, c) && map[r-1][c][PILLA]) return true; // 바로 아래에 기둥이 있거나
            if (inRange(r, c-1) && map[r][c-1][CLOTH]) return true; // 왼쪽에 보가 있거나
            if (inRange(r, c) && map[r][c][CLOTH]) return true; // 오른쪽에 보가 있거나
            return false; // 모두 충족하지 못할 때 기둥을 세울 수 없다.
        }
        if (type == CLOTH) { // 보자기일 때
            if (inRange(r-1, c) && map[r-1][c][PILLA]) return true;
            if (inRange(r-1, c+1) && map[r-1][c+1][PILLA]) return true;
            if (inRange(r, c-1) && inRange(r, c+1)
                    && map[r][c-1][CLOTH] && map[r][c+1][CLOTH])
                return true;
            return false;
        }
        return true; // 비어있는 공간은 무조건 true
    }

    boolean possible(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (map[i][j][PILLA] && !possible(i, j, PILLA)) {
                    return false;
                }
                if (map[i][j][CLOTH] && !possible(i, j, CLOTH)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] solution(int n, int[][] buildFrame) {
        int[][] result = {};

        // 맵의 초기화
        map = new boolean[n + 1][n + 1][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k < 2; k++) {
                    map[i][j][k] = EMPTY;
                }
            }
        }

        // 연산 시작!
        for (int[] frame : buildFrame) {
            int r = frame[1], c = frame[0];
            int type = frame[2];
            int operate = frame[3];

            if (operate == 0) { // 삭제 연산
                map[r][c][type] = EMPTY; // 선 삭제 후 체크
                if (!possible(n)) map[r][c][type] = !EMPTY;
            }
            if (operate == 1) { // 삽입 연산
                map[r][c][type] = !EMPTY;
                if (!possible(n)) map[r][c][type] = EMPTY;
            }
        }

        // 결과 반환을 위한 리스트 생성
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k < 2; k++) {
                    if (!map[i][j][k]) {
                        continue;
                    }
                    list.add(new Pair(i, j, k));
                }
            }
        }

        Collections.sort(list);

        result = new int[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).c;
            result[i][1] = list.get(i).r;
            result[i][2] = list.get(i).type;
        }

        return result;
    }
}

