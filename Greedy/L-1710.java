//L.1710 Maximum Units on a Truck
//Sort + Greedy
//O(nlogn) time O(n) space
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;
        Arrays.sort(boxTypes, (a, b) -> (b[1] - a[1]));
        for (int i = 0; i < boxTypes.length; i++) {
            int boxCount = Math.min(boxTypes[i][0], truckSize);
            res += boxCount * boxTypes[i][1];
            truckSize -= boxCount;
            if (truckSize <= 0) {
                break;
            }
        }
        return res;
    }
}

//PriorityQueue + Greedy (Solution from Leetcode)
//O(nlogn) time O(n) space
class Solution {
public
    int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->b[1] - a[1]);
        queue.addAll(Arrays.asList(boxTypes));
        int unitCount = 0;
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int boxCount = Math.min(truckSize, top[0]);
            unitCount += boxCount * top[1];
            truckSize -= boxCount;
            if(truckSize == 0)
                break;
        }
        return unitCount;
    }
}