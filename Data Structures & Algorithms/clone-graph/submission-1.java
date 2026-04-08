/*
Definition for a Node.
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
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;

        Map<Integer, Node> nodeTracker = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        nodeTracker.put(node.val, new Node(node.val)); 
        
        q.add(node);
        while(!q.isEmpty()){
            Node current = q.poll(); 
            visited.add(current.val);
            for(Node n : current.neighbors){
                if(!nodeTracker.containsKey(n.val)){ 
                    nodeTracker.put(n.val, new Node(n.val)); 
                    q.add(n);
                }
                nodeTracker.get(current.val).neighbors.add(nodeTracker.get(n.val)); 

                // if(!visited.contains(n.val)){
                    
                // }
                // System.out.println(visited.toString() + " " + n.val + " " + q.toString());
            }
        }
        return nodeTracker.get(node.val);
    }
}