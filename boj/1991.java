import java.util.*;

public class Main {

    static void preorder(int[][] arr, int root) {
        if (root == -1) return;

        System.out.printf("%c", root + 'A');
        preorder(arr, arr[root][0]);
        preorder(arr, arr[root][1]);
    }

    static void inorder(int[][] arr, int root) {
        if (root == -1) return;

        inorder(arr, arr[root][0]);
        System.out.printf("%c", root + 'A');
        inorder(arr, arr[root][1]);
    }

    static void postorder(int[][] arr, int root) {
        if (root == -1) return;

        postorder(arr, arr[root][0]);
        postorder(arr, arr[root][1]);
        System.out.printf("%c", root + 'A');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[26][2];

        int N = sc.nextInt();

        sc.nextLine();
        for (int i = 0; i < N; i++) {

            String in = sc.nextLine();

            int root = in.charAt(0) - 'A';

            if (in.charAt(2) == '.') arr[root][0] = -1;
            else arr[root][0] = in.charAt(2) - 'A';

            if (in.charAt(4) == '.') arr[root][1] = -1;
            else arr[root][1] = in.charAt(4) - 'A';
        }

        preorder(arr, 0);
        System.out.printf("\n");
        inorder(arr, 0);
        System.out.printf("\n");
        postorder(arr, 0);
    }
}