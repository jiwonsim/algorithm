import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int x, y;
    int distance;
    Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node n) {
        if (this.distance < n.distance) {
            return -1;
        }
        else return 1;
    }
}

public class Main {
    static int N, M;
    static int to_x[] = {1, -1, 0, 0};
    static int to_y[] = {0, 0, 1, -1};
    static int arr[][], temp[][];
    static boolean visited[][];
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static boolean check_range(int x, int y) {
        if (x >= 0 && x < M && y >= 0 && y < N) {
            return true;
        }
        return false;
    }

    public static int solve(int start_x, int start_y) {
        pq.add(new Node(start_x, start_y, arr[start_x][start_y]));
        temp[start_x][start_y] = 0;
        //The peek() method only retrieved the element at the head
        //but the poll() also removes the element along with the retrieval.
        //it turns NULL if the queue is empty.
        while (!pq.isEmpty()) {
            Node n = pq.poll();

            if (n.x == M - 1 && n.y == N - 1) {
                return n.distance;
            }

            if (n.distance > temp[n.x][n.y]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int go_x = n.x + to_x[i];
                int go_y = n.y + to_y[i];

                if (check_range(go_x, go_y)) {
                    if (temp[go_x][go_y] > temp[n.x][n.y] + arr[n.x][n.y]) {
                        temp[go_x][go_y] = temp[n.x][n.y] + arr[n.x][n.y];
                        pq.add(new Node(go_x, go_y, temp[go_x][go_y]));
                    }
                }

            }
        }
        return -1;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        temp = new int[M][N];
        visited = new boolean[M][N];

        String str[] = new String[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            str[i] = st.nextToken();
            for (int j = 0; j < str[i].length(); j++) {
                arr[i][j] = str[i].charAt(j) - '0';
            }
        }


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(solve(0, 0));

    }
}