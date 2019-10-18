import java.util.*;

public class TRAVERSAL {

    static void printPostorder(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.size() == 0) return;

        int size = preorder.size();
        int root = preorder.get(0);
        int left = inorder.indexOf(root);
        int right = preorder.size() - left - 1;

        printPostorder(preorder.subList(1, left + 1), inorder.subList(0, left));
        printPostorder(preorder.subList(left + 1, size), inorder.subList(left + 1, size));
        System.out.printf("%d ", root);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt(); // 테스트케이스
        List<Integer> preorder, inorder;
        while (C-- > 0) {
            int N = sc.nextInt();
            preorder = new LinkedList<>();
            inorder = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                preorder.add(sc.nextInt());
            }
            for (int j = 0; j < N; j++) {
                inorder.add(sc.nextInt());
            }

            printPostorder(preorder, inorder);
        }
    }
}

/*
1
7
27 16 9 12 54 36 72
9 12 16 27 36 54 72
 */