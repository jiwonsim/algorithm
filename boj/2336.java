import java.util.*;

class SegmentTree {
    long tree[];
    int treeSize;

    SegmentTree(int size) {
        int h = (int)Math.ceil(Math.log(size) / Math.log(2));
        this.treeSize = (int) Math.pow(2, h + 1);
        tree = new long[treeSize];
    }

    long init(long[] tree, int pos, int val, int node, int start, int end) {
        if (end < pos || pos < start) return tree[node];
        if (start == end) return tree[node] = val;

        int mid = (start + end) / 2;
        return tree[node] = Math.min(init(tree, pos, val, node * 2, start, mid),
                init(tree, pos, val, node * 2 + 1, mid + 1, end));
    }

    long update(long[] tree, int low, int high, int start, int end, int index) {
        if (end < low || high < start) return Integer.MAX_VALUE;
        if (low <= start && end <= high) return tree[index];
        int mid = (start + end) / 2;
        return Math.min(update(tree, low, high, start, mid, index * 2), update(tree, low, high, mid + 1, end, index * 2 + 1));
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] x = new int[5000001], y = new int[5000001], z = new int[5000001];

        for (int i = 1; i <= N; i++) {
            x[i] = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            y[i] = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            z[i] = sc.nextInt();
        }



        SegmentTree st = new SegmentTree(N + 1);

        int res = 0;
        for (int i = 1; i <= N; i++) st.init(st.tree, i, Integer.MAX_VALUE, 1, 1, N);
        for (int i = 1; i <= N; i++) {
            long tmp = st.update(st.tree, 1, y[i], 1, N, 1);
//            System.out.printf("%d %d\n", tmp, z[i]);
            if (tmp > z[i]) res++;
            st.init(st.tree, y[i], z[i], 1, 1, N);
        }

        System.out.printf("\n%d\n", res);
    }
}