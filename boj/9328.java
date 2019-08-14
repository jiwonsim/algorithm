import java.util.*;

class Pair {
    int x, y;
    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int h, w;
    static char[][] arr;
    static boolean[] keys;

    static int[] toX = {0, 0, 1, -1}, toY = {1, -1, 0, 0};

    public static boolean isInRange(int x, int y) {
        if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length) return true;
        return false;
    }

    public static void solve() {

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[h + 2][w + 2];

        HashMap<Integer, ArrayList<Pair>> doors = new HashMap<>();

        q.offer(new Pair(0, 0));
        visited[0][0] = true;

        int count = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {

                int goX = toX[i] + p.x;
                int goY = toY[i] + p.y;

                if (!isInRange(goX, goY)) continue;
                if (visited[goX][goY]) continue;
                if (arr[goX][goY] == '*') continue;

                visited[goX][goY] = true;

                // 딸 수 없는 문을 만나면 저장해뒀다가 키를 만나면 푸는 방식으로 바꿈.


                if (arr[goX][goY] == '$') {
                    count++;
                    q.add(new Pair(goX, goY));
                    continue;
                }
                if (arr[goX][goY] >= 'A' && arr[goX][goY] <= 'Z') { // 대문자
                    int nextPos = arr[goX][goY] - 'A';

                    if (keys[nextPos]) { // 키가 있음
                        q.add(new Pair(goX, goY));
                    }
                    else { // 키가 없음
                        // 문을 저장해둠!
                        ArrayList<Pair> curDoor = doors.get(nextPos);
                        if (curDoor == null) {
                            curDoor = new ArrayList<>();
                        }

                        curDoor.add(new Pair(goX, goY));
                        doors.put(nextPos, curDoor);
                    }
                    continue;
                }
                if (arr[goX][goY] >= 'a' && arr[goX][goY] <= 'z') { // 소문자
                    int nextPos = arr[goX][goY] - 'a';
                    keys[nextPos] = true;
                    q.add(new Pair(goX, goY));
                    if (doors.containsKey(nextPos)) { // 딸 수 있게 된 문이 있으면 큐에 넣기
                        ArrayList<Pair> curDoor = doors.get(nextPos);
                        for (int k = 0; k < curDoor.size(); k++) {
                            q.add(curDoor.get(k));
                        }
                    }
                    continue;
                }

                q.add(new Pair(goX, goY));

            }
        }

        System.out.printf("%d\n", count);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            h = sc.nextInt();
            w = sc.nextInt();

            arr = new char[h + 2][w + 2];

            keys = new boolean[26];

            String in;
            for (int i = 1; i < h + 1; i++) {
                in = sc.next();
                for (int j = 1; j < w + 1; j++) {
                    arr[i][j] = in.charAt(j - 1);
                }
            }


            in = sc.next();

            if (!in.equals("0")) {
                for (int i = 0; i < in.length(); i++) {
                    keys[in.charAt(i) - 'a'] = true;
                }
            }

            solve();

        }

    }
}