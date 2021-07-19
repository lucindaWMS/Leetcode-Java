//L.435 Non-overlapping intervals
//Greedy
//O(nlogn) time O(n) space
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        int prevEndTime = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEndTime) {
                res += 1;
            } else {
                prevEndTime = intervals[i][1];
            }
        }
        return res;
    }
}

//DP (Solution from Leetcode)
//O(n^2) time O(n) space
class Solution {
  class myComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
      return a[1] - b[1];
    }
  }
  public boolean isOverlapping(int[] i, int[] j) {
    return i[1] > j[0];
  }
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0) {
      return 0;
    }
    Arrays.sort(intervals, new myComparator());
    int dp[] = new int[intervals.length];
    dp[0] = 1;
    int ans = 1;
    for (int i = 1; i < dp.length; i++) {
      int max = 0;
      for (int j = i - 1; j >= 0; j--) {
        //Since we sorted the original array in the ascending order of the right bound of intervals, the right bound of intervals before interval[i] are all smaller than the right bound of interval[i]
        //When one interval before interval[i] is not overlapping with interval[i], this means the right bound of that interval is smaller than the left bound of interval[i]
        //if we continue trying to loop the intervals on the left hand side of the non-overlapping interval, we can only find non-overlapping intervals
        //therefore, we can just break our loop
        if (!isOverlapping(intervals[j], intervals[i])) {
          max = Math.max(dp[j], max);
          break;
        }
      }
      dp[i] = Math.max(max + 1, dp[i - 1]);
      ans = Math.max(ans, dp[i]);
    }
    return intervals.length - ans;
  }
}