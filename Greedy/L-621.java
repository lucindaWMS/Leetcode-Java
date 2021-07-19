//L.621 Task Scheduler
//Solution from Leetcode
//O(n) time O(1) space
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 1) {
            return 1;
        }
        int[] taskCounts = new int[26];
        for (char c : tasks) {
            taskCounts[c - 'A'] += 1;
        }
        Arrays.sort(taskCounts);
        int maxTaskCounts = taskCounts[25];
        int maxIdleTime = (maxTaskCounts - 1) * n;
        
        for (int i = taskCounts.length - 2; i >= 0; i--) {
            maxIdleTime -= Math.min(maxTaskCounts - 1, taskCounts[i]);
        }
        maxIdleTime = Math.max(0, maxIdleTime);
        return maxIdleTime + tasks.length;
    }
}