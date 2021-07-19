//L.103 Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            res.add(temp);
            return res;
        }
        boolean isForward = true;
        LinkedList<TreeNode> myQueue = new LinkedList<>();
        myQueue.addLast(root);
        myQueue.addLast(null);
        LinkedList<Integer> temp = new LinkedList<>();
        
        while (!myQueue.isEmpty() || !myStack.isEmpty()) {
            TreeNode curr = myQueue.pollFirst();
            if (curr != null) {
                if (isForward) {
                    temp.addLast(curr.val);
                } else {
                    temp.addFirst(curr.val);
                }
                
                if (curr.left != null) {
                    myQueue.addLast(curr.left);
                }
                if (curr.right != null) {
                    myQueue.addLast(curr.right);
                }
            } else {
                res.add(temp);
                temp = new LinkedList<>();
                if (myQueue.size() > 0) {
                    myQueue.addLast(null);
                }
                isForward = !isForward;
            }
        }
        return res;
    }
}

//DFS (Solution from Leetcode)
//O(n) time O(h) space
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  protected void DFS(TreeNode node, int level, List<List<Integer>> results) {
    if (level >= results.size()) {
      LinkedList<Integer> newLevel = new LinkedList<Integer>();
      newLevel.add(node.val);
      results.add(newLevel);
    } else {
      if (level % 2 == 0)
        results.get(level).add(node.val);
      else
        results.get(level).add(0, node.val);
    }

    if (node.left != null) DFS(node.left, level + 1, results);
    if (node.right != null) DFS(node.right, level + 1, results);
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<List<Integer>>();
    }
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    DFS(root, 0, results);
    return results;
  }
}