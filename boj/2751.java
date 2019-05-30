import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 1. Scanner로 받고 Arrays.sort()를 사용하면 시간초과남 (1% 겨우 지남)
 * 2. Scanner로 받고 Collections.sort()를 사용하면 시간초과남 (2% 겨우 지남)
 * 3. BuffredReader로 받고 Collections.sort()를 사용하면 되긴 되는데.......... 진짜 너무너무 느림! 메모리 259516KB	시간 4284 ms 개 오 바
 * 4. 우선순위 큐를 이용하면 진짜 개느림. 그리고 그냥 pq.poll을 출력하면 안 되고, String도 안 되고 StringBuilder에 append()해줘야됨!! ㅋㅋ
 *      그리고 우선순위 큐 메모리 개오짐. 	309616 KB	1800 ms
 * 5. 머지소트로 해보자. O(NlogN)
*/

public class Main {
    public static int[] sorted;

    public static void mergeSort(int [] arr, int l, int r) {
        int mid;
        if (l < r) {
            mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void merge(int [] arr, int left, int mid, int right) {
        int l = left;
        int m = mid + 1;
        int k = left;

        while (l <= mid || m <= right) {
            if (l <= mid && m <= right) {
                if (arr[l] <= arr[m])
                    sorted[k] = arr[l++];
                else
                    sorted[k] = arr[m++];
            } else if (l <= mid && m > right)
                sorted[k] = arr[l++];
            else
                sorted[k] = arr[m++];
            k++;
        }

        for (int i = left; i < right + 1; i++) {
            arr[i] = sorted[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        sorted = new int[N];
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, 0, N - 1);

        StringBuilder result = new StringBuilder();
        for (int i : sorted) {
            result.append(sorted[i] + " \n");
        }

        System.out.println(result);

    }
}