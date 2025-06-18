package Recursion.Basics;

// leetcode.ques.172. Factorial Trailing Zeroes = https://leetcode.com/problems/factorial-trailing-zeroes/description/

public class FactorialTrailingZeroes {
    // iterative approach t.c - o(log-n)
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            n = n / 5;
            count = count + n;
        }
        return count;
    }

    // recursive approach
    private static int helper(int n, int count){
        if(n < 5) return count;
        n = n / 5;
        count = count + n;
        return helper(n, count);
    }
    public static int trailingZeroes02(int n){
        return helper(n, 0);
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes02(6));
    }
}