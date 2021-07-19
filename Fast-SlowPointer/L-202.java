//L.202 Happy Number
//Fast-slow pointer (solution from Leetcode)
//O(logn)time O(1) space
class Solution {

     public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}

//HashSet
//O(logn) time O(logn) space
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> res = new HashSet<>();
        while (n >= 1) {
            int sum = sumOfSquaredDigits(n);
            if (sum == 1) {
                return true;
            }
            if (res.contains(sum)) {
                return false;
            }
            res.add(sum);
            n = sum;
        }
        return false;
    }
    
    public int sumOfSquaredDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }
}