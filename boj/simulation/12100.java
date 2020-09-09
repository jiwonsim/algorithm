import java.io.*;
import java.util.*;


public class Main {

    static int N;
    static int[][] map;

    static void move(int direction, int depth) {

        // 뒤로도 뺄 수 있고, 앞으로도 뺄 수 있어야 해서 덱으로 만들어주었다.
        Deque<Integer> que = new LinkedList<>();

        switch (direction) {
            // 오른쪽이라면, 행을 기준으로 N-1부터 0까지 쌓아
            case 0: // 오른쪽
                for (int i = 0; i < N; i++) { // 행
                    boolean combined = true;
                    for (int j = N - 1; j >= 0; j--) { // 열
                        if (map[i][j] == 0) continue;
                        if (que.isEmpty()) { que.add(map[i][j]); }
                        else {
                            if (combined && map[i][j] == que.peekLast()) {
                                // 앞의 값이 같으면 합치고 넣어준다.
                                que.add(que.pollLast() + map[i][j]);
                                combined = false; // 합쳤다고 표시
                            }
                            else {
                                // 같지도 않고 이미 합쳤었다면 그냥 삽입
                                que.add(map[i][j]);
                                combined = true;
                            }
                        }
                    }
                    // 만들어준 값들을 배열에 삽입한다.
                    for (int j = N-1; j >= 0; j--) {
                        if (que.isEmpty()) { map[i][j] = 0; }
                        else {
                            map[i][j] = que.pollFirst();
                        }
                    }

                }

                break;

            // 왼쪽이라면, 행을 기준으로 0부터 N-1까지 쌓아
            case 1: // 왼쪽
                for (int i = 0; i < N; i++) { // 행
                    boolean combined = true;
                    for (int j = 0; j < N; j++) { // 열
                        if (map[i][j] == 0) continue;
                        if (que.isEmpty()) { que.add(map[i][j]); }
                        else {
                            if (combined && map[i][j] == que.peekLast()) {
                                que.add(que.pollLast() + map[i][j]);
                                combined = false;
                            }
                            else {
                                que.add(map[i][j]);
                                combined = true;
                            }
                        }
                    }
                    for (int j = 0; j < N; j++) {
                        if (que.isEmpty()) { map[i][j] = 0; }
                        else { map[i][j] = que.pollFirst(); }
                    }
                }
                break;

            // 위쪽이라면, 열을 기준으로 0부터 N-1까지 쌓아
            case 2:
                for (int j = 0; j < N; j++) { // 열
                    boolean combined = true; // 열마다 한 번만 더할 수 있다.
                    for (int i = 0; i < N; i++) { // 행
                        if (map[i][j] == 0) continue;
                        if (que.isEmpty()) {
                            que.add(map[i][j]);
                        } else {
                            if (combined && map[i][j] == que.peekLast()) {
                                que.add(que.pollLast() + map[i][j]);
                                combined = false;
                            } else {
                                que.add(map[i][j]);
                                combined = true;
                            }
                        }
                    }

                    for (int i = 0; i < N; i++) {
                        if (que.isEmpty()) { map[i][j] = 0; }
                        else { map[i][j] = que.pollFirst(); }
                    }
                }

                break;

            // 아래쪽이라면, 열을 기준으로 N-1부터 0까지 쌓아
            case 3:
                for (int j = N-1; j >= 0; j--) { // 열
                    boolean combined = true;
                    for (int i = N-1; i >= 0; i--) { // 행
                        if (map[i][j] == 0) continue;
                        if (que.isEmpty()) {
                            que.add(map[i][j]);
                        } else {
                            if (combined && map[i][j] == que.peekLast()) {
                                que.add(que.pollLast() + map[i][j]);
                                combined = false;
                            } else {
                                que.add(map[i][j]);
                                combined = true;
                            }
                        }
                    }

                    for (int i = N-1; i >= 0; i--) {
                        if (que.isEmpty()) { map[i][j] = 0; }
                        else { map[i][j] = que.pollFirst(); }
                    }
                }
                break;
        }
    }

    static int go(int depth) {
        if (depth == 5) {
            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, map[i][j]);
                }
            }
            return max;
        }

        // 배열을 복사해놓는다.
        int[][] copied = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copied[i][j] = map[i][j];
            }
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            move(i, depth);
            result = Math.max(go(depth+1), result);

            // 다시 원래 상태로 만들기
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    map[r][c] = copied[r][c];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = reader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int result = go(0);
        writer.write(result + "\n");
    }
}
