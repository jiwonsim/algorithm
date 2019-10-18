import java.util.*;

class Tree {
    int index;
    List<Tree> chilren;

    Tree(int index, List<Tree> chilren) {
        this.index = index;
        this.chilren = chilren;
    }
}

public class FORTRESS {
    static int N, longest;
    static int[] x, y, r;

    static int sqr(int x) {
        return x * x;
    }

    static int sqrdist(int a, int b) {
        return sqr(y[a] - y[b]) + sqr(x[a] - x[b]);
    }

    static boolean isEnclosed(int a, int b) {
        return r[a] > r[b] &&
                sqrdist(a, b) < sqr(r[a] - r[b]);
    }

    static boolean isChild(int parent, int child) {
        if (!isEnclosed(parent, child)) return false;

        for (int i = 0; i < N; i++) {
            if (i != parent && i != child &&
            isEnclosed(parent, i) && isEnclosed(i, child)) return false;
        }
        return true;
    }

    static Tree makeTree(int root) {
        List<Tree> children = new ArrayList<>();
        Tree ret = new Tree(root, children);

        for (int ch = 0; ch < N; ch++) {
            if (isChild(root, ch)) {
                ret.chilren.add(makeTree(ch));
            }
        }

        return ret;
    }

    static int findLongestHeight(Tree root) {
        List<Integer> height = new ArrayList<>();

        for (int i = 0; i < root.chilren.size(); i++) {
            height.add(findLongestHeight(root.chilren.get(i)));
        }

        if (height.size() == 0) return 0;
        Collections.sort(height);

        if (height.size() >= 2) {
            longest = Math.max(longest,
                    height.get(height.size() - 2) + height.get(height.size() - 1) + 2);
        }

        return height.get(height.size() - 1) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        while (C-- > 0) {
            N = sc.nextInt();
            x = new int[N];
            y = new int[N];
            r = new int[N];

            for (int i = 0; i < N; i++) {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
                r[i] = sc.nextInt();
            }

            Tree t = makeTree(0);

            longest = 0;
            int res = findLongestHeight(t);
            System.out.printf("%d", Math.max(res, longest));
        }
    }
}

/*
2
3
5 5 15
5 5 10
5 5 5
8
21 15 20
15 15 10
13 12 5
12 12 3
19 19 2
30 24 5
32 10 7
32 9 4
 */