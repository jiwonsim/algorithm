import java.util.*;
import java.io.*;

public class Main {
    static int maxSize = 100;

    static int boxCount = 1;
    static int[] boxHeights = new int[maxSize+1];
    static int n, w, b;
    static char[][][] box;
    static ArrayList<Character[][]> list; // 장식판의 리스트
    static boolean[] checked; // 장식판을 이미 놨는지 체크 배열

    static void go() {

        int height = maxSize+1-list.get(0).length; // 깊이 인덱스
        int beforeHeight = list.get(0).length; // 탐색마다 차지하는 장식판 높이

        // 0번째부터 n번째 까지 장식판을 설치
        for (int i = 0; i < list.size(); i++) {
            Character[][] current = list.get(i);
            // 이전의 장식판과의 위치를 고려하면서 설치한다.

            while(height > 0) {
                boolean possible = true;
                for (int r = height; r < height+current.length; r++) {
                    for (int c = 0; c < w; c++) {
                        if (current[r - height][c] == 'X' && box[boxCount][r][c] == 'X') {
                            // 겹치는 상황이면 안됨!!
                            height -= 1; // 겹치게 되면 height이 가리키는 곳이 더 위로 가야됨
                            possible = false; // 불가능하다고ㅗ 표시
                            break;
                        }
                    }
                    if (!possible) break; // 불가능하면 포문 탈출 후, 계속 와일문을 돌고
                }
                if (possible) break; // 가능하면 와일문 탈출
            }

            // 장식장을 박스에 쌓는다.
            for (int r = height; r < height+current.length; r++) {
                for (int c = 0; c < w; c++) {
                    if(box[boxCount][r][c] == 'X') continue;
                    box[boxCount][r][c] = current[r-height][c];
                }
            }

            if (maxSize+1-height > b) {
                // 박스의 높이보다 장식장이 더 큰 경우
                boxHeights[boxCount] = beforeHeight;
                boxCount+=1;

                // 새로운 박스에 장식장을 설치한다.
                Character[][] next = list.get(i);
                for (int k = next.length-1; k >= 0; k--) {
                    for (int j = 0; j < w; j++) {
                        box[boxCount][maxSize+k-next.length+1][j] = next[k][j];
                    }
                }

                height = maxSize;
                beforeHeight = next.length;
            }
            else { // 지금 박스에서 계속 탐색!
                beforeHeight = maxSize+1-height;
            }
        }

        if (beforeHeight <= b) {
            boxHeights[boxCount] = beforeHeight;
        }

        for (int i = 1; i <= boxCount; i++) {
            System.out.printf("%d ", boxHeights[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");

        n = Integer.parseInt(input[0]); // 장식 판의 종류
        w = Integer.parseInt(input[1]); // 박스의 너비
        b = Integer.parseInt(input[2]); // 박스의 높이

        box = new char[maxSize+1][maxSize+1][w]; // 넣을 박스! [박스개수][높이][너비]
        for (int k = 0; k <= maxSize; k++) {
            for (int i = 0; i <= maxSize; i++) {
                for (int j = 0; j < w; j++) {
                    box[k][i][j] = '.';
                }
            }
        }
        list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(reader.readLine());
            Character[][] map = new Character[h][w];
            for (int r = 0; r < h; r++) {
                String row = reader.readLine();
                for (int c = 0; c < w; c++) {
                    map[r][c] = row.charAt(c);
                }
            }
            list.add(map);
        }

        if (list.get(0).length > b) { // b가 작을 때
            System.out.printf("0\n");
            return;
        }
        go();

    }
}