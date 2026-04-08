class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return b[1] - a[1];
            }
        });

        int[] c = new int[26];

        for(int i = 0; i < tasks.length; i++){
            c[tasks[i] - 'A']++;
        }

        for(int i = 0; i < 26; i++){
            if(c[i] > 0)
                pq.add(new int[]{i, c[i]});
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;

            if(pq.isEmpty() && time != q.peek()[2]){
                time = q.peek()[2];
            }else{
                if(!pq.isEmpty()){
                    int[] temp = pq.poll();
                    temp[1] -= 1;
                    if(temp[1] > 0)
                        q.add(new int[]{temp[0], temp[1], time+n});
                }
            }

            if((!q.isEmpty()) && (time == q.peek()[2])){
                int[] temp1 = q.poll();
                pq.add(new int[]{temp1[0], temp1[1]});
            }
            // System.out.println(time + " " + pq.toString() + " " + q.toString());
        }
        return time;
    }
}
