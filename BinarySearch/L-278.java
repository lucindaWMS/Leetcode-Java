//L.278 First Bad Version
//O(log n) time O(1) space
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 1) {
            return 1;
        }
        int low = 1; 
        int high = n;
        int res = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid-1;
                res = mid;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}