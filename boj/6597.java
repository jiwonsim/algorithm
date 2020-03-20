import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        char data;
        Node left, right;

        Node(char data) {
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

    static int rootId = 0;

    static Node setTree(char[] preorder, char[] inorder, int start, int end) {
        if (start > end) return null;

        Node child;
        int root = getRoot(inorder, preorder[rootId++], start, end);
        child = new Node(inorder[root]);
        child.setLeft(setTree(preorder, inorder, start, root - 1));
        child.setRight(setTree(preorder, inorder, root + 1, end));

        return child;
    }

    static int getRoot(char[] inorder, char root, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == root) return i;
        }

        return -1;
    }

    static StringBuffer answer;
    static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        answer.append(node.data);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            // initialize
            String[] input = sc.nextLine().split(" ");
            int length = input[0].length();

            char[] preorder = new char[length];
            char[] inorder = new char[length];

            for (int i = 0; i < length; i++) {
                preorder[i] = input[0].charAt(i);
                inorder[i] = input[1].charAt(i);
            }
            answer = new StringBuffer();
            rootId = 0;

            Node node = setTree(preorder, inorder, 0, length - 1);
            postorder(node);
            System.out.println(answer);
        }
    }
}