//L.1214 Two Sum BSTs
//Recursion (Solution from Leetcode)
//O(n1 + n2) time O(2n1 + n2) space n1 and n2 are the number of nodes in the trees
class Solution {
  public Set<Integer> inHashset(TreeNode r, int target, Set<Integer> s) {
    if (r == null) return s;
    inHashset(r.left, target, s);
    s.add(target - r.val);
    inHashset(r.right, target, s);
    return s;
  }

  public boolean inCheck(TreeNode r, Set<Integer> s) {
    if (r == null) return false;
    return inCheck(r.left, s) || s.contains(r.val) || inCheck(r.right, s);
  }

  public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
    Set<Integer> s = inHashset(root1, target, new HashSet());
    return inCheck(root2, s);
  }
}

//Iteration (Solution from Leetcode)
//L(n1 + n2) time O(n1 + max(n1, n2)) space
class Solution {
  public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
    ArrayDeque<TreeNode> stack = new ArrayDeque();
    Set<Integer> s = new HashSet();
    // traverse the first tree 
    // and store node complements (target - val) in hashset
    while (!stack.isEmpty() || root1 != null) {
      while (root1 != null) {
        stack.push(root1);
        root1 = root1.left;
      }
      root1 = stack.pop();
      s.add(target - root1.val);
      root1 = root1.right;
    }

    // traverse the second tree 
    // and check if one of the values exists in hashset
    while (!stack.isEmpty() || root2 != null) {
      while (root2 != null) {
        stack.push(root2);
        root2 = root2.left;
      }
      root2 = stack.pop();
      if (s.contains(root2.val)) {
        return true;
      }
      root2 = root2.right;
    }
    
    return false;
  }
}