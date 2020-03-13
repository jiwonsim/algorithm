import java.util.*;

class Solution {
    int gcd(int num1, int num2) { // Greatest common divisor
        // always num2 is bigger than num1
        if (num2 % num1 == 0) return num1;
        return gcd(num2 % num1, num1);
    }

    int lcm(int num1, int num2) { // Lowest common multiple
        // always num2 is bigger than num1
        // LCM can be operated by using GCD
        return num2 * num1 / gcd(num1, num2);
    }

    public int solution(int[] arr) {
        int answer = 0;

        Arrays.sort(arr);

        int lcmVal = -1;
        int comp1, comp2;

        comp1 = arr[0];
        for (int i = 1; i < arr.length; i++) {
            comp2 = arr[i];
            lcmVal = lcm(comp1, comp2);

            comp1 = lcmVal;
        }

        return lcmVal;
    }
}