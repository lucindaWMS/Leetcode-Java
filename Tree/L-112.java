//L.112 Path Sum
//O(n) time, O(n) space in the worst case, O(log n) space on average
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

//Recursion
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return traverse(root, targetSum, 0);
    }
    
    public boolean traverse(TreeNode root, int targetSum, int currSum) {
        if (root == null) {
            return false;
        }
        currSum += root.val;
        if (root.left == null && root.right == null && currSum == targetSum) {
            return true;
        }
        boolean res = false;
        res = traverse(root.left, targetSum, currSum);
        if (res) {
            return res;
        }
        res = traverse(root.right, targetSum, currSum);
        if (res) {
            return res;
        }
        currSum -= root.val;
        return res;
    }
}

//Iteration
Class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        nodeStack.push(root);
        sumStack.push(target - root.val);
        while (!nodeStack.isEmpty()) {
            TreeNode currNode = nodeStack.pop();
            int currSum = sumStack.pop();
            if (currSum == 0 && currNode.left == null && currNode.right == null) {
                return true;
            }
            if (currNode.right != null) {
                nodeStack.push(currNode.right);
                sumStack.push(currSum - currNode.right.val);
            }
            if (currNode.left != null) {
                nodeStack.push(currNode.left);
                sumStack.push(currSum - currNode.left.val);
            }
        }
        return false;
    }
}