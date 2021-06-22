//L.252 Meeting Room
//The most optimized solution: Arrays.sort(), O(nlogn) time, O(1) space
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return true;
        }
        int minStart = Integer.MAX_VALUE;
        int maxEnd = -1;
        for (int i = 0; i < intervals.length; i++) {
            minStart = Math.min(minStart, intervals[i][0]);
            maxEnd = Math.max(maxEnd, intervals[i][1]);
        }
        int[] time = new int[maxEnd-minStart+1];
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            time[start-minStart] += 1;
            time[end-minStart] -= 1;
        }
        int res = 0;
        for (int i = 0; i < time.length; i++) {
            res += time[i];
            if  (res > 1) {
                return false;
            }
        }
        return res == 0;
    }
}