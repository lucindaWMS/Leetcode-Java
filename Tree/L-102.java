//L.102 Binary Tree Level Order Traversal
//BFS 
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> myQueue = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        myQueue.addLast(root);
        myQueue.add(null);
        
        while (myQueue.size() > 0) {
            TreeNode curr = myQueue.pollFirst();
            if (curr != null) {
                temp.add(curr.val);
                if (curr.left != null) {
                    myQueue.addLast(curr.left);
                }
                if (curr.right != null) {
                    myQueue.addLast(curr.right);
                }
            } else {
                res.add(temp);
                if (myQueue.size() > 0) {
                    temp = new ArrayList<>();
                    myQueue.add(null);
                }
            }
        }
        return res;
    }
}

//DFS
//O(n) time O(h) space
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        res = backtracking(root, 0, res);
        return res;
    }
    
    public List<List<Integer>> backtracking(TreeNode root, int level, List<List<Integer>> res) {
    if (level >= res.size()) {
        List<Integer> newLevel = new ArrayList<>();
        res.add(newLevel);
    }
    res.get(level).add(root.val);
    if (root.left != null) {
        res = backtracking(root.left, level + 1, res);
    }
    if (root.right != null) {
        res = backtracking(root.right, level + 1, res);
    }
    return res;
}
}