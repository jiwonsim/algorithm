import java.util.*;

class Tree {
    int ele;
    Tree left;
    Tree right;

    Tree(int ele, Tree left, Tree right) {
        this.ele = ele;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    static StringBuffer result = new StringBuffer();

    static Tree insertTree(Tree rootNode, int inputEle) {
        Tree curNode = null;

        if (rootNode == null) return new Tree(inputEle, null, null);

        if (rootNode.ele > inputEle) {
            curNode = insertTree(rootNode.left, inputEle);
            rootNode.left = curNode;
        }
        else if (rootNode.ele < inputEle) {
            curNode = insertTree(rootNode.right, inputEle);
            rootNode.right = curNode;
        }

        return rootNode;
    }

    static void search(Tree t) {
        if (t == null) return;

        search(t.left);
        search(t.right);
        result.append(t.ele + "\n");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rootEle = sc.nextInt();
        Tree t = new Tree(rootEle, null, null);

        while (sc.hasNextInt()) {
            int input = sc.nextInt();
            insertTree(t, input);
        }

        search(t);
        System.out.printf("%s", result);
    }
}