import java.util.*;

class Pair implements Comparable<Pair> {
    int r, c, type;
    boolean set;
    Pair(int r, int c, int type, boolean set) {
        this.r = r;
        this.c = c;
        this.type = type;
        this.set = set;
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

    ArrayList<Pair> list; // 구조물 리스트

    boolean search(int r, int c, int type) {
        for (Pair p : list) {
            if (p.r == r && p.c == c && p.type == type) {
                if (!p.set) return false;
                return true;
            }
        }
        return false;
    }

    void remove(int r, int c, int type) {
        for (Pair p : list) {
            if (p.r == r && p.c == c && p.type == type && p.set) {
                p.set = false;
                return;
            }
        }
    }

    void set(int r, int c, int type) {
        for (Pair p : list) {
            if (p.r == r && p.c == c && p.type == type) {
                p.set = true;
                return;
            }
        }
        list.add(new Pair(r, c, type, true));
    }

    boolean possible(ArrayList<Pair> list) {
        for (Pair pair : list) {
            int r = pair.r, c = pair.c, type = pair.type;

            if (type == PIL) { // 기둥인 경우
                // 바닥에 있거나, 바로 아래에 기둥이 있거나, 좌우에 보가 하나라도 있으면 설치 OK
                if (r == 0 || search(r - 1, c, PIL) ||
                        search(r, c - 1, CLT) || search(r, c + 1, CLT))
                    continue;
                return false;
            }
            if (type == CLT) { // 보자기인 경우
                // 바로 아래에 기둥이 있거나, 오른쪽 아래에 기둥이 있거나, 양 옆에 보가 있어야 함
                if (search(r - 1, c, PIL) || search(r - 1, c + 1, PIL) ||
                        (search(r, c - 1, CLT) && search(r, c + 1, CLT)))
                    continue;
                return false;
            }
        }
        return true;

    }

    public int[][] solution(int n, int[][] buildFrame) {
        int[][] result;

        list = new ArrayList<>();

        for (int[] frame : buildFrame) {
            int r = frame[1], c = frame[0];
            int type = frame[2];
            int operate = frame[3];

            if (operate == 0) { // 삭제 연산
                remove(r, c, type);
                if (!possible(list)) {
                    set(r, c, type);
                }
            }
            if (operate == 1) { // 삽입 연산
                set(r, c, type);
                if (!possible(list)) {
                    remove(r, c, type);
                }
            }
        }

        Collections.sort(list);

        ArrayList<Pair> possibleList = new ArrayList<>();
        for (Pair p : list) {
            if (!p.set) continue;
            possibleList.add(p);
        }

        result = new int[possibleList.size()][3];
        for (int i = 0; i < possibleList.size(); i++) {
            result[i][0] = possibleList.get(i).c;
            result[i][1] = possibleList.get(i).r;
            result[i][2] = possibleList.get(i).type;
        }

        return result;
    }
}
