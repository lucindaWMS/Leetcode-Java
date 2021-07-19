//L.653 Two Sum IV Input is a BST
//O(n) time O(n) space
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public boolean findTarget(TreeNode root, int k) {
        if (root.left == null && root.right == null) {
            return false;
        }
        List<Integer> valList = new ArrayList<>();
        valList = inOrder(root, valList);
        int left = 0;
        int right = valList.size() - 1;
        while (left < right) {
            int sum = valList.get(left) + valList.get(right);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return false;
    }
    
    public List<Integer> inOrder(TreeNode root, List<Integer> valList) {
        if (root == null) {
            return valList;
        }
        valList = inOrder(root.left, valList);
        valList.add(root.val);
        valList = inOrder(root.right, valList);
        return valList;
    }
}