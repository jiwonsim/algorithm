import java.io.*;
import java.util.*;

class Position {
    int row, col;

    Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main {

    static final int[] toRow = {0, 0, 1, -1}, toCol = {1, -1, 0, 0};
    static int result = Integer.MAX_VALUE, N, M;
    static char[][] map;

    static boolean outOfRange(Position p) {
        if (p.row >= N || p.row < 0 || p.col >= M || p.col < 0) return true;
        return false;
    }

    static void move(Position first, Position second, int count) {
        if (count > 10) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            Position nextFirst = new Position(first.row + toRow[i], first.col + toCol[i]);
            Position nextSecond = new Position(second.row + toRow[i], second.col + toCol[i]);

            // 둘 다 떨어짐 -> 다른 경우 찾기
            if (outOfRange(nextFirst) && outOfRange(nextSecond)) continue;

            // 둘 중 하나가 떨어짐 -> 탐색 종료
            if ((outOfRange(nextFirst) && !outOfRange(nextSecond)) || (!outOfRange(nextFirst) && outOfRange(nextSecond))) {
                result = result > count ? count : result;
                return;
            }

            // 동전이 겹침 -> 다른 경우 찾기
            if (nextFirst.equals(nextSecond)) continue;

            // 벽에 막힘 -> 가만히 있기
            if (map[nextFirst.row][nextFirst.col] == '#') nextFirst = first;
            if (map[nextSecond.row][nextSecond.col] == '#') nextSecond = second;

            // 둘 다 안 떨어지고 벽도 아니고 동전이 겹치지도 않음 -> 계속 탐색
            move(nextFirst, nextSecond, count + 1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new char[N][M];

        Position[] coins = new Position[2];
        int coinIndex = 0;

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j);

                if (map[i][j] == 'o') {
                    coins[coinIndex++] = new Position(i, j);
                }
            }
        }

        move(coins[0], coins[1], 1);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
}