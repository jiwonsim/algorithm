public class Main {
    static int N = 5;

    public static int[][] rotate90(int[][] arr, int rotateCount) {

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                System.out.println(arr[i][j] + " -> " + arr[N - j - 1][i] + " -> " + arr[N - i - 1][N - j - 1] + " -> " + arr[j][N - i - 1]);
                int temp = arr[i][j];
                arr[i][j] = arr[N - j - 1][i];
                arr[N - j - 1][i] = arr[N - i - 1][N - j - 1];
                arr[N - 1 - i][N - j - 1] = arr[j][N - i - 1];
                arr[j][N - i - 1] = temp;
            }
        }
        System.out.println();
        return arr;
    }

    public static int[][] rotateCustom(int [][] arr, int rotate) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int temp = arr[i][j];
//                arr[i][j] = arr[]
            }
        }
        return arr;
    }

    public static void printArray(int arr[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%2d ", arr[i][j]);
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
                val += 2;
            }
        }
        printArray(arr);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res[j][4 - i] = arr[i][j];
            }
        }
        printArray(res);

        System.out.println("rotate 90 degree");
        int[][] res2 = rotate90(arr, 2);
        printArray(res2);


    }
}