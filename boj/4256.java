import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    static int n;
    static int[] pre, in, order;
    static Node node;

    static Node create(int start, int end) {
        if (start > end) return null;

        int minOrder = Integer.MAX_VALUE, minVal = 0, minId = 0;
        for (int i = start; i <= end; i++) {
            int val = in[i];

            if (minOrder > order[val]) {
                minOrder = order[val];
                minVal = val;
                minId = i;
            }
        }

        Node root = new Node(minVal);
        root.setLeft(create(start, minId - 1));
        root.setRight(create(minId + 1, end));

        return root;
    }

    static void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.printf("%d ", node.data);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            // input
            n = Integer.parseInt(br.readLine());
            order = new int[n + 1];

            pre = new int[n + 1];
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                pre[i] = Integer.parseInt(input[i]);
                order[pre[i]] = i + 1;
            }

            in = new int[n];
            input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                in[i] = Integer.parseInt(input[i]);
            }

            node = create(0, n - 1);
            postorder(node);
            System.out.println();
        }
    }
}