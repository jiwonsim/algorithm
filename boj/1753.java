import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int index;
    int dist;

    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node node) {
        return this.dist - node.dist;
    }
}

public class Main {

    static int V, E, start;
    static int[] weight;
    static ArrayList<ArrayList<Node>> list;

    static void search(int start) {
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        weight[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (visited[curNode.index]) continue;
            visited[curNode.index] = true;

            for (Node nextNode : list.get(curNode.index)) {
                if (weight[nextNode.index] > weight[curNode.index] + nextNode.dist) {
                    weight[nextNode.index] = weight[curNode.index] + nextNode.dist;
                    pq.add(new Node(nextNode.index, weight[nextNode.index]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        start = Integer.parseInt(br.readLine());
        weight = new int[V + 1];
        list = new ArrayList<ArrayList<Node>>();

        Arrays.fill(weight, Integer.MAX_VALUE);
        for (int i = 0; i <= V; i++)
            list.add(new ArrayList<Node>());


        for (int i = 1; i <= E; i++) {
            String[] vertexInfo = br.readLine().split(" ");
            int u = Integer.parseInt(vertexInfo[0]);
            int v = Integer.parseInt(vertexInfo[1]);
            int w = Integer.parseInt(vertexInfo[2]);

            list.get(u).add(new Node(v, w));
        }

        search(start);

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= V; i++) {
            if (weight[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(weight[i] + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}