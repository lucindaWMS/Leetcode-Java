//L.78 Subsets
//O(n*2^n) time O(n) space
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res = backtracking(nums, 0, res, new ArrayList<>());
        return res;
    }
    
    public List<List<Integer>> backtracking(int[] nums, int startIndex, List<List<Integer>> res, List<Integer> curr) {
        res.add(new ArrayList<>(curr));
        for (int i = startIndex; i < nums.length; i++) {
            curr.add(nums[i]);
            res = backtracking(nums, i + 1, res, curr);
            curr.remove(curr.size() - 1);
        }
        return res;
    }
}