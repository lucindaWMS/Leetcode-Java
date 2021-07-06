//L.257 Binary Tree Paths
//Recursion
//O(n) time O(n) space in the worst case
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root.left == null && root.right == null) {
            res.add("" + root.val);
            return res;
        }
        StringBuilder sb = new StringBuilder();
        res = backtracking(root, sb, res);
        return res;
    }
    
    public List<String> backtracking(TreeNode root, StringBuilder sb, List<String> res) {
        if (root == null) {
            return res;
        }
        String curr = String.valueOf(root.val);
        sb.append(curr);
        
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
            return res;
        }
        sb.append("->");
        int length = sb.length();
        res = backtracking(root.left, sb, res);
        sb.setLength(length);
        res = backtracking(root.right, sb, res);
        return res;
    }
}

//Iteration
//Solution from Leetcode
//O(n) time O(n) space in the worst case
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root.left == null && root.right == null) {
            res.add("" + root.val);
            return res;
        }
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<String> paths = new Stack<>();
        paths.push(Integer.toString(root.val));
        
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            String currPath = paths.pop();
            if (currNode.left == null && currNode.right == null) {
                res.add(currPath);
            }
            if (currNode.left != null) {
                stack.push(currNode.left);
                paths.push(currPath + "->" + Integer.toString(currNode.left.val));
            }
            if (currNode.right != null) {
                stack.push(currNode.right);
                paths.push(currPath + "->" + Integer.toString(currNode.right.val));
            }
        }
        return res;
    }
}