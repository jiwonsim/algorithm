import java.util.*;

class Solution {

    boolean isUnlocked(int[][] expLock, int N, int M) {
        for (int i = M - 1; i < N + M - 1; i++) {
            for (int j = M - 1; j < N + M - 1; j++) {
                if (expLock[i][j] > 1) return false;
                if (expLock[i][j] == 0) return false;
            }
        }

        return true;
    }

    int[][] rotateArray(int[][] arr, int d) {
        int size = arr.length;
        int[][] rotated = new int[size][size];

        if (d % 4 == 1) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    rotated[j][size - 1 - i] = arr[i][j];
                }
            }
        }
        else if (d % 4 == 2) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    rotated[size - 1 - i][size - 1 - j] = arr[i][j];
                }
            }
        }
        else if (d % 4 == 3) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    rotated[size - 1 - j][i] = arr[i][j];
                }
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    rotated[i][j] = arr[i][j];
                }
            }
        }


        return rotated;
    }

    int[][] match(int startX, int startY, int M, int[][] expLock, int[][] key) {
        int lockLen = expLock.length;
        int[][] tmpExpLock = new int[lockLen][lockLen];

        for (int i = 0; i < lockLen; i++) {
            for (int j = 0; j < lockLen; j++) {
                tmpExpLock[i][j] = expLock[i][j];
            }
        }

        for (int i = startX; i < startX + M; i++) {
            for (int j = startY; j < startY + M; j++) {
                tmpExpLock[i][j] += key[i - startX][j - startY];
            }
        }

        return tmpExpLock;
    }

    boolean search(int startX, int startY, int N, int M, int[][] expLock, int[][] key) {

        int[][] matchedExpLock = match(startX, startY, M, expLock, key);
        if (isUnlocked(matchedExpLock, N, M)) return true;

        for (int i = 1; i < 4; i++) {
            int[][] rotatedKey = rotateArray(key, i);
            matchedExpLock = match(startX, startY, M, expLock, rotatedKey);

            if (isUnlocked(matchedExpLock, N, M)) return true;
        }

        return false;
    }

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;

        int M = key.length;
        int N = lock.length;
        int[][] expLock = new int[N + (M - 1) * 2][N + (M - 1) * 2];
        for (int i = 0; i < expLock.length; i++) {
            for (int j = 0; j < expLock.length; j++) {
                expLock[i][j] = -1;
            }
        }

        for (int i = M - 1; i < N + M - 1; i++) {
            for (int j = M - 1; j < N + M - 1; j++) {
                expLock[i][j] = lock[i - (M - 1)][j - (M - 1)];
            }
        }

        for (int i = 0; i < N + M - 1; i++) {
            for (int j = 0; j < N + M - 1; j++) {
                if (search(i, j, N, M, expLock, key)) return true;
            }
        }

        return false;
    }
}