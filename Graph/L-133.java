//L.133 Clone Graph
//DFS 
//O(n + m) time, O(n) space, n is the number of vertices, m is the number of edges
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node newStartNode = new Node(node.val);
        if (node.neighbors.isEmpty()) {
            return newStartNode;
        }
        map.put(node, newStartNode);
        for (Node n : node.neighbors) {
            if (map.containsKey(n)) {
                newStartNode.neighbors.add(map.get(n));
            } else {
                Node newCopiedNeighbor = cloneGraph(n);
                newStartNode.neighbors.add(newCopiedNeighbor);
                map.put(n, newCopiedNeighbor);
            }
        }
        return newStartNode;
    }
}

//DFS(iteration)
//O(n + m) time O(n) space, n is the number of vertices, m is the number of edges
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Node copiedStartNode = new Node(node.val);
        if (node.neighbors.isEmpty()) {
            return copiedStartNode; 
        }
        
        Map<Node, Node> map = new HashMap<>();
        map.put(node, copiedStartNode);
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node currHead = stack.pop();
            for (Node n : currHead.neighbors) {
                if (!map.containsKey(n)) {
                    map.put(n, new Node(n.val));
                    stack.push(n);
                }
                map.get(currHead).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }
}

//BFS
//O(n + m) time O(n) space, n is the number of vertices, m is the number of edges
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Node copiedStartNode = new Node(node.val);
        if (node.neighbors.isEmpty()) {
            return copiedStartNode; 
        }
        
        Map<Node, Node> map = new HashMap<>();
        map.put(node, copiedStartNode);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node currHead = queue.poll();
            for (Node n : currHead.neighbors) {
                if (!map.containsKey(n)) {
                    map.put(n, new Node(n.val));
                    queue.offer(n);
                }
                map.get(currHead).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }
}