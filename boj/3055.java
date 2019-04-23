

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
    int x, y;
    Position (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int R, C;
    static char arr[][];
    static Queue<Position> dochiQue = new LinkedList<>();
    static Queue<Position> waterQue = new LinkedList<>();
    static int toX[] = {0, 0, 1, -1};
    static int toY[] = {1, -1, 0, 0};

    public static void printArray() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("==========");
    }


    public static boolean checkRange(int x, int y) {
        if (x >= 0 && y >= 0 && x < R && y < C) return true;
        return false;
    }

    public static boolean dochi() {
        int dochiQueSize = dochiQue.size();

        for (int i = 0; i < dochiQueSize; i++) {
            Position now = dochiQue.poll();

            for (int j = 0; j < 4; j++) {
                int nextX = toX[j] + now.x;
                int nextY = toY[j] + now.y;

                if (checkRange(nextX, nextY)) {
                    if (arr[nextX][nextY] == '.') {
                        arr[nextX][nextY] = 'S';
                        dochiQue.offer(new Position(nextX, nextY));
                    }
                    if (arr[nextX][nextY] == 'D') {
                        dochiQue.offer(new Position(nextX, nextY));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void water() {
        int waterQueSize = waterQue.size();

        for (int i = 0; i < waterQueSize; i++) {
            Position now = waterQue.poll();

            for (int j = 0; j < 4; j++) {
                int nextX = toX[j] + now.x;
                int nextY = toY[j] + now.y;

                if (checkRange(nextX, nextY) && arr[nextX][nextY] == '.') {
                    arr[nextX][nextY] = '*';
                    waterQue.offer(new Position(nextX, nextY));
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = input.charAt(j);
                if (input.charAt(j) == 'S') {
                    //도치
                    dochiQue.offer(new Position(i, j));
                }
                if (input.charAt(j) == '*') {
                    //물
                    waterQue.offer(new Position(i, j));
                }
            }
        }

        int count = 0;
        while (true) {
            count++;
            water();
            if (dochi()) {
                System.out.println(count);
                return;
            }
//            printArray();

            if (dochiQue.isEmpty()) {
                System.out.println("KAKTUS");
                return;
            }
        }
    }
}