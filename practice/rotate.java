import java.util.Scanner;

public class Main {
    static int N = 5;

    public static int[][] rotate90(int[][] arr, int rotateCount) {
        while (rotateCount-- != 0) {
            for (int i = 0; i < N / 2; i++) {
                for (int j = i; j < N - i - 1; j++) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[N - j - 1][i];
                    arr[N - j - 1][i] = arr[N - i - 1][N - j - 1];
                    arr[N - 1 - i][N - j - 1] = arr[j][N - i - 1];
                    arr[j][N - i - 1] = temp;

                }
            }
        }
        System.out.println();
        return arr;
    }

    public static boolean visited[][] = new boolean[N][N];

    public static boolean checkRangeX(int x) {
        if (x >= 0 && x < N) return true;
        else return false;
    }

    public static boolean checkRangeY(int y) {
        if (y >= 0 && y < N) return true;
        else return false;
    }

    public static boolean passRange(int x, int y, int start, int end) {
        if ((x != start && x != end) && (y != start && y != end)) {
            return false;
        }
        return true;
    }

    public static int[][] rotateOneBlock(int [][] arr, int x, int y, int next_val) {

        int nextY = y + 1;
        int nextX = x + 1;
        if (checkRangeY(nextY) && !visited[x][nextY] && passRange(x, nextY, 0, N - 1)) {

            int temp = arr[x][nextY];
            arr[x][nextY] = next_val;
            visited[x][nextY] = true;
            rotateOneBlock(arr, x, nextY, temp);
        }
        else if (checkRangeX(nextX) && !visited[nextX][y] && passRange(nextX, y, 0, N - 1)) {

            int temp = arr[nextX][y];
            arr[nextX][y] = next_val;
            visited[nextX][y] = true;
            rotateOneBlock(arr, nextX, y, temp);
        }
        else {
            nextX = x - 1;
            nextY = y - 1;
            if (checkRangeY(nextY) && !visited[x][nextY] && passRange(x, nextY,0, N - 1)) {

                int temp = arr[x][nextY];
                arr[x][nextY] = next_val;
                visited[x][nextY] = true;
                rotateOneBlock(arr, x, nextY, temp);
            }
            else if (checkRangeX(nextX) && !visited[nextX][y] && passRange(nextX, y, 0, N - 1)) {

                int temp = arr[nextX][y];
                arr[nextX][y] = next_val;
                visited[nextX][y] = true;
                rotateOneBlock(arr, nextX, y, temp);
            }
        }

        return arr;
    }

    public static int[][] rotateOneBlock2(int arr[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
//                if (i == 0)
            }
        }
        return arr;
    }

    public static void printArray(int arr[][], String title) {
        System.out.println("*** " + title + " ***");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%2d ", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("==============");
    }

    public static void printBooleanArray(boolean arr[][], String title) {
        System.out.println("*** " + title + " ***");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j]) System.out.print("T ");
                else
                    System.out.print("F ");
//                System.out.printf(arr[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("==============");
    }



    public static void main(String[] args) {
        int[][] arr = new int[N][N];
        int[][] res = new int[N][N];
        int val = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = val;
                val += 1;
            }
        }
        printArray(arr, "Input array");

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                res[j][4 - i] = arr[i][j];
//            }
//        }
//        printArray(res, "90도 회전 배열");

//        int[][] res2 = rotate90(arr, 1);
//        printArray(res2, "rotate 90");
//        printArray(arr, "뭐지?!");

        System.out.print("얼마나 돌릴까요? ");
        Scanner sc = new Scanner(System.in);
        int rotation = sc.nextInt();
        int[][] res3 = arr;
        while (rotation-- != 0) {
            visited = new boolean[N][N];
            res3 = rotateOneBlock(arr, 0, 0, arr[0][0]);
        }
        printArray(res3, "rotate per a block");

    }
}