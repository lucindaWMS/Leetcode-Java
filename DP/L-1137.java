//L.1137 N-th Tribonacci Number
//O(n) time, O(n) space (the space complexity can be optimized to O(1))
class Solution {
    public int tribonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int[] fibs = new int[n+1];
        fibs[0] = 0;
        fibs[1] = 1;
        fibs[2] = 1;
        for (int i = 3; i <= n; i++) {
            fibs[i] = fibs[i-1] + fibs[i-2] + fibs[i-3];
        }
        return fibs[n];
    }
}