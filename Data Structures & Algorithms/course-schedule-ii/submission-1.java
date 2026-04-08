class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        List<Integer> visited = new ArrayList<>();
        Set<Integer> visiting = new HashSet<>();

        for(int i = 0; i < numCourses; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        System.out.println(adj.toString());
        for(int i = 0; i < numCourses; i++){
            System.out.println(i);
            if(!dfs(adj, visited, visiting, i))
                return new int[0];
        }

        System.out.println(visited.toString());
        int[] res = new int[numCourses];
        int j = 0;
        for(int i : visited){
            res[j] = i;
            j++;
        }
        return res;
    }

    public boolean dfs(Map<Integer, List<Integer>> adj, List<Integer> visited, Set<Integer> visiting, int start){
        if(adj.get(start).isEmpty()){
            if(!visited.contains(start))
                visited.add(start);
            return true;
        }
            
        if(visited.contains(start) || (adj.containsKey(start) && adj.get(start).size() == 0))
            return true;

        if(visiting.contains(start))
            return false;

        visiting.add(start);
        for(int n: adj.getOrDefault(start, new ArrayList<>())){
            if(!dfs(adj, visited, visiting, n))
                return false;
        }
        visiting.remove(start);
        visited.add(start);
        adj.put(start, new ArrayList<>());
        // System.out.println(visited.toString());
        return true;
    }
}
