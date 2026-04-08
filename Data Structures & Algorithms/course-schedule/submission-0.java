class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();

        for(int i = 0; i < numCourses; i++){
            adj.put(i, new HashSet<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(adj, new HashSet<>(), i))
                return false;
        }

        return true;
    }

    public boolean dfs(Map<Integer, Set<Integer>> adj, Set<Integer> visited, int start){
        if(adj.containsKey(start) && adj.get(start).size() == 0)
            return true;

        if(visited.contains(start))
            return false;
        
        visited.add(start);

    
        for(int n: adj.get(start)){
            if(!dfs(adj, visited, n)){
                return false;
            }
        }

        visited.remove(start);
        adj.put(start, new HashSet<>());

        return true;
    }
}
