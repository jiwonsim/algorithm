import java.util.*;

class Node {
    int x, y, index;
    Node left, right;

    Node(int index, int x, int y) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}

class Solution {

    int len;
    List<Integer> pre = new ArrayList<>();
    List<Integer> post = new ArrayList<>();


    List<Node> tree = new ArrayList<>();

    Comparator<Node> comp = new Comparator<Node>() {
        public int compare(Node n1, Node n2) {
            if (n1.y > n2.y) return -1; // y에 대해 내림차순
            else if (n1.y < n2.y) return 1;
            else { // x에 대해 오름차순
                if (n1.x > n2.x) return 1;
                return -1;
            }
        }
    };

    void addNode(Node par, Node chi) {
        if (par.x > chi.x) { //이미 정렬 돼있으니까 바로 x를 기준으로 비교
            if (par.left == null) par.left = chi;
            else addNode(par.left, chi);
        }
        else {
            if (par.right == null) par.right = chi;
            else addNode(par.right, chi);
        }
    }
    void preorder(Node root) {
        if (root == null) return;

        pre.add(root.index);
        preorder(root.left);
        preorder(root.right);
    }

    void postorder(Node root) {
        if  (root == null) return;

        postorder(root.left);
        postorder(root.right);
        post.add(root.index);
    }

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer;
        len = nodeinfo.length;
        for (int i = 0; i < nodeinfo.length; i++) {
            tree.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        tree.sort(comp);

        Node root = tree.get(0);

        for (int i = 1; i < nodeinfo.length; i++) {
            addNode(root, tree.get(i));
        }

        preorder(root);
        postorder(root);

        answer = new int[2][nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }

        return answer;
    }
}