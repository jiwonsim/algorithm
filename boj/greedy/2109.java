import java.util.*;
import java.io.*;

public class Main {

    private static class Pair implements Comparable<Pair> {
        int cost, day;
        Pair(int cost, int day) {
            this.cost = cost;
            this.day = day;
        }

        @Override
        public int compareTo(Pair target) {
            if (this.day == target.day) { return target.cost - this.cost; }
            return target.day - this.day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Pair[] map = new Pair[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            int cost = Integer.parseInt(input[0]);
            int day = Integer.parseInt(input[1]);

            map[i] = new Pair(cost, day);
        }

        Arrays.sort(map);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int result = 0, index = 0;
        for (int i = 10000; i >= 1; i--) {
            while (index < n && map[index].day == i) {
                pq.add(map[index].cost);
                index += 1;
            }


            if (!pq.isEmpty()) {
                result+=pq.poll();
            }
        }
        
        bw.write(result+"\n");
        bw.flush();
    }
}