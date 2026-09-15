class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int coursesTaken = 0;
        List<Integer> result = new ArrayList<>();
        int[] res = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            ArrayList<Integer> tmp = adj.get(prerequisites[i][0]);
            tmp.add(prerequisites[i][1]);
            adj.put(prerequisites[i][0], tmp);
            indegree[prerequisites[i][1]]++;
        }

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()) {
            int course = q.poll();
            result.add(course);
            coursesTaken++;
            res[numCourses - coursesTaken] = course;
            if(adj.get(course).size() > 0) {
                for(Integer nei: adj.get(course)) {
                    indegree[nei]--;
                    if(indegree[nei] == 0) {
                        q.add(nei);
                    }
                }
            } else {
                adj.remove(course);
            }
        }
        if(numCourses != coursesTaken)
            return new int[0];

        // for(int i = result.size()-1; i >= 0; i--) {
        //     res[numCourses - i - 1] = result.get(i);
        // }
        return res;
    }
}
