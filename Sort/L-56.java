//L.56 Merge Intervals
//O(nlogn) time O(n) space
class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> sorted = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            List<Integer> toAdd = temp;
            sorted.add(toAdd);
            temp = new ArrayList<>();
        }
        Collections.sort(sorted, (l1, l2) -> (l1.get(0) - l2.get(0)));
        List<List<Integer>> merged = new ArrayList<>();
        int start = sorted.get(0).get(0);
        int end = sorted.get(0).get(1);
        for (int i = 1; i < sorted.size(); i++) {
            if (sorted.get(i).get(0) <= end) {
                end = Math.max(end, sorted.get(i).get(1));
            } else {
                temp.add(start);
                temp.add(end);
                List<Integer> newInterval = temp;
                merged.add(newInterval);
                temp = new ArrayList<>();
                start = sorted.get(i).get(0);
                end = sorted.get(i).get(1);
            }
        }
        temp.add(start);
        temp.add(end);
        merged.add(temp);
        int[][] res = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            res[i][0] = merged.get(i).get(0);
            res[i][1] = merged.get(i).get(1);
        }
        return res;
    }
}