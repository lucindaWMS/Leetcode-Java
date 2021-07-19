//L.452 Minimum Number of Arrows to Burst Ballons
//O(nlogn) time O(n) space
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        Arrays.sort(points, (x, y) -> Integer.compare(x[1], y[1]));
        int prevEnd = points[0][1];
        int res = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= prevEnd) {
                if (points[i][0] == prevEnd) {
                    continue;
                } else {
                    prevEnd = Math.min(prevEnd, points[i][1]);
                }
            } else {
                prevEnd = points[i][1];
                res += 1;
            }
        }
        return res;
    }
}