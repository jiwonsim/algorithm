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

    static StringBuffer answer = new StringBuffer();
    static int rootId;

    static int getRoot(int[] inorder, int root, int s, int e) {
        for (int i = e; i >= s; i--) {
            if (inorder[i] == root) return i;
        }

        return -1;
    }

    static Node setTree(int[] inorder, int[] postorder, int s, int e) {
        if (s > e) return null;

        Node tree;
        int root = getRoot(inorder, postorder[rootId--], s, e);

        tree = new Node(inorder[root]);
        tree.setRight(setTree(inorder, postorder, root + 1, e));
        tree.setLeft(setTree(inorder, postorder, s, root - 1));

        return tree;
    }

    static void preorder(Node node) {
        if (node == null) return;
        answer.append(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        int n = Integer.parseInt(br.readLine());

        int[] inorder = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) inorder[i] = Integer.parseInt(input[i]);

        int[] postorder = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) postorder[i] = Integer.parseInt(input[i]);

        rootId = n - 1;
        Node tree = setTree(inorder, postorder, 0, n - 1);
        preorder(tree);

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }
}