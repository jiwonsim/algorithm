import java.io.*;
import java.util.*;

class Node {
    int left, right, parent;

    Node(int left, int right, int parent) {
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

public class Main {

    static Node[] tree;
    static int order = 0, maxDepth = 0;
    static int[] minWidth, maxWidth;

    static void inorder(int node, int depth) {
        if (node == -1) return;

        if (maxDepth < depth) maxDepth = depth;
        inorder(tree[node].left, depth + 1);

        minWidth[depth] = Math.min(minWidth[depth], order);
        maxWidth[depth] = order;
        order++;

        inorder(tree[node].right, depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 초기화
        minWidth = new int[N + 1];
        maxWidth = new int[N + 1];

        tree = new Node[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new Node(-1, -1, -1);
            minWidth[i] = N;
            maxWidth[i] = 0;
        }

        // 입력
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            int node = Integer.parseInt(input[0]);
            int left = Integer.parseInt(input[1]);
            int right = Integer.parseInt(input[2]);

            tree[node].left = left;
            tree[node].right = right;

            if (left != -1) tree[left].parent = node;
            if (right != -1) tree[right].parent = node;
        }

        // 루트 찾기
        int root = 0;
        for (int i = 1; i <= N; i++) {
            if (tree[i].parent == -1) {
                root = i;
                break;
            }
        }

        inorder(root, 1);

        int resOfDepth = 1, resOfOrder = maxWidth[1] - minWidth[1] + 1;
        for (int i = 2; i <= maxDepth; i++) {
            int width = maxWidth[i] - minWidth[i] + 1;

            if (width > resOfOrder) {
                resOfOrder = width;
                resOfDepth = i;
            }
        }

        bw.write(resOfDepth + " " + resOfOrder);
        bw.flush();
    }
}