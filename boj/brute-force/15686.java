import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<Pair> chickenList, homeList;
    static int[] remained;
    static int answer = Integer.MAX_VALUE;

    static int findMinimumDistance() {
        int sum = 0;
        for (int i = 0; i < homeList.size(); i++) {
            int minimumDistance = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
                int dis = Math.abs(homeList.get(i).r - chickenList.get(remained[j]).r)
                        + Math.abs(homeList.get(i).c - chickenList.get(remained[j]).c);
                minimumDistance = Math.min(dis, minimumDistance);
            }
            sum += minimumDistance;
        }
        return sum;
    }

    static void go(int depth, int index) {
        if (depth >= M) {
            answer = Math.min(findMinimumDistance(), answer);
            return;
        }

        for (int i=index; i<chickenList.size(); i++) {
            remained[depth] = i;
            go(depth+1, i+1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = reader.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        map = new int[N][N];
        remained = new int[M];
        chickenList = new ArrayList<>();
        homeList = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            String[] input = reader.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 1) homeList.add(new Pair(i, j));
                if (map[i][j] == 2) chickenList.add(new Pair(i, j));
            }
        }

        go(0, 0);
        writer.write(answer + "\n");
        writer.flush();
    }

    private static class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
