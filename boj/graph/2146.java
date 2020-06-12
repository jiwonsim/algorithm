import java.io.*;
import java.util.*;

class Position {
    int x, y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[] toRow = {1, -1, 0, 0}, toCol = {0, 0, 1, -1};
    static int N;
    static int[][] map, cost;
    static Queue<Position> que;
    static boolean[][] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 초기화
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        cost = new int[N][N];
        que = new LinkedList<>();
        visited = new boolean[N][N];
        result = N * N + 1;


        // 입력
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] != 0) que.add(new Position(i, j));
            }
        }

        // 섬의 값을 할당하기
        int value = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) continue;
                if (visited[i][j]) continue;
                changeValueOfLand(i, j, value);
                value++;
            }
        }

        // 다리 놓는 거리 찾기
        find();

        bw.write(result);
        bw.flush();
    }

    // 섬의 값을 할당하는 함수
    static void changeValueOfLand(int x, int y, int value) {
        Queue<Position> que = new LinkedList<>();

        que.add(new Position(x, y));
        visited[x][y] = true;

        while (!que.isEmpty()) {
            Position cur = que.poll();

            map[cur.x][cur.y] = value;

            for (int i = 0; i < 4; i++) {
                int nextRow = toRow[i] + cur.x;
                int nextCol = toCol[i] + cur.y;


                if (!isInRange(nextRow, nextCol)) continue;
                if (visited[nextRow][nextCol]) continue;
                if (map[nextRow][nextCol] != 0) {
                    que.add(new Position(nextRow, nextCol));
                    visited[nextRow][nextCol] = true;
                }
            }
        }

    }

    // 다리를 찾는 함수
    static void find() {

        boolean[][] visited = new boolean[N][N];

        while (!que.isEmpty()) {
            Position cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = toRow[i] + cur.x;
                int nextCol = toCol[i] + cur.y;

                if (!isInRange(nextRow, nextCol)) continue;
                if (visited[nextRow][nextCol]) {
                    // 이미 방문한 적이 있음
                    if (map[cur.x][cur.y] != map[nextRow][nextCol]) {
                        // 현재 섬과 다음 섬이 다르고, 다음 섬의 가중치가 있는 경우==>다리를 놓을 수 있다.
                        result = Math.min(cost[nextRow][nextCol] + cost[cur.x][cur.y], result);
                    }
                }
                else {
                    if (map[nextRow][nextCol] == 0) {
                        // 섬도 없고 다리도 없으면, 다리를 놓는다.
                        map[nextRow][nextCol] = map[cur.x][cur.y]; // 섬을 확장시킨다.
                        cost[nextRow][nextCol] = cost[cur.x][cur.y] + 1; // 다리의 길이
                        visited[nextRow][nextCol] = true; // 방문체크
                        que.add(new Position(nextRow, nextCol));
                    }
                }
            }
        }
    }


    static boolean isInRange(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) return false;
        return true;
    }
}