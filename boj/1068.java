import java.util.*;


public class Main {
    static int n, removeIdx, res, root;
    static ArrayList<Integer>[] tree;

    static void search(int label) {
        if (label == removeIdx) {
            res++;
            return;
        }

        if (tree[label].size() == 0) {
            res++;
        }

        for (int child : tree[label]) {
            search(child);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 초기화
        n = sc.nextInt();
        int[] arr = new int[n];
        tree = (ArrayList<Integer>[]) new ArrayList[51];
        for (int i = 0; i < tree.length; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        removeIdx = sc.nextInt();

        root = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) {
                root = i;
                continue;
            }
            if (removeIdx == i) continue;

            tree[arr[i]].add(i);
        }

        if (root == removeIdx) res = 0;
        else search(root);

        System.out.printf("%d", res);
    }
}