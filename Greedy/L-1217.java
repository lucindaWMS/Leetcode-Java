//L.1217 Minimum Cost to Move Chips to the Same Position
//O(n) time O(1) space
class Solution {
    public int minCostToMoveChips(int[] position) {
        int odds = 0;
        int evens = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                evens += 1;
            } else {
                odds += 1;
            }
        }
        return Math.min(odds, evens);
    }
}