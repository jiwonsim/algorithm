import java.util.*;

class SegmentTree {
    long tree[];
    int treeSize;

    SegmentTree(int size) {
        int h = (int)Math.ceil(Math.log(size) / Math.log(2));
        this.treeSize = (int) Math.pow(2, h + 1);
        tree = new long[treeSize];
    }

    long init(long[] tree, int[] nums, int node, int start, int end) {
        if (start == end) return tree[node] = nums[start];

        int mid = (start + end) / 2;
        return tree[node] = init(tree, nums, node * 2, start, mid)
                + init(tree, nums, node * 2 + 1, mid + 1, end);
    }

    void update(long[] tree, int node, int start, int end, int index, long diff) {
        if (start > index || index > end) return;

        tree[node] += diff;
        if (start != end) {
            int mid = (start + end) / 2;
            update(tree, node * 2, start, mid, index, diff);
            update(tree, node * 2 + 1, mid + 1, end, index, diff);
        }
    }

    long sum(long[] tree, int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return sum(tree, node * 2, start, mid, left, right)
                + sum(tree, node * 2 + 1, mid + 1, end, left, right);
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[1000001];
        for (int i = 1; i <= N; i++) arr[i] = sc.nextInt();

        SegmentTree st = new SegmentTree(N);
        st.init(st.tree, arr, 1, 1, N);

        int op, in1, in2;

        for (int i = 0; i < M + K; i++) {
            op = sc.nextInt();
            in1 = sc.nextInt();
            in2 = sc.nextInt();

            if (op == 1) {
                long thisnum = arr[in1];
                long diff = in2 - thisnum;
                arr[in1] = in2;

                st.update(st.tree, 1, 1, N, in1, diff);
            }
            else if (op == 2) {
                System.out.printf("%d\n", st.sum(st.tree, 1, 1, N, in1, in2));
            }
        }
    }
}