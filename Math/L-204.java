//L.204 Count Primes
//O(n^0.5 * loglogn) time, O(n) space
class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        isPrime[0] = true;
        isPrime[1] = true;
        int res = 0;
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (!isPrime[i]) {
                isPrime = flipValue(i, isPrime, true);
            }
        }
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                res += 1;
            }
        }
        return res;
    }
    
    public boolean[] flipValue(int n, boolean[] isPrime, boolean val) {
        for (int i = n*2; i < isPrime.length; i+=n) {
            isPrime[i] = val;
        }
        return isPrime;
    }
}