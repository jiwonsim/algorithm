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

    static int findRootId(int[] inorder, int root, int s, int e) {
        for (int i = s; i <= e; i++) {
            if (root == inorder[i]) return i;
        }

        return -1;
    }
    static int rootId = 0;

    static Node setTree(int[] preorder, int[] inorder, int s, int e) {
        if (s > e) return null;
        Node child;

        int root = findRootId(inorder, preorder[rootId++], s, e);

        child = new Node(inorder[root]);
        child.setLeft(setTree(preorder, inorder, s, root - 1));
        child.setRight(setTree(preorder, inorder, root + 1, e));

        return child;
    }

    static void postorder(Node node, StringBuffer answer) {
        if (node == null) return;
        postorder(node.left, answer);
        postorder(node.right, answer);
        answer.append(node.data + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringBuffer answer = new StringBuffer();
            rootId = 0;

            String[] buf = br.readLine().split(" ");
            int[] preorder = new int[n];
            for (int i = 0; i < n; i++) preorder[i] = Integer.parseInt(buf[i]);

            buf = br.readLine().split(" ");
            int[] inorder = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = Integer.parseInt(buf[i]);

            Node tree = setTree(preorder, inorder, 0, n - 1);
            postorder(tree, answer);

            bw.write(answer + "\n");
            bw.flush();
        }
        bw.close();
    }
}