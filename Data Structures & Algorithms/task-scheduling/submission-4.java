class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return b[1] - a[1];
            }
        });

            int[] count = new int[26];
            for(int i = 0; i < tasks.length; i++){
                count[tasks[i] - 'A']++;
            }

            for(int i = 0; i < 26; i++){
                if(count[i] > 0){
                    pq.add(new int[]{i, count[i]});
                }
            }

            Queue<int[]> q = new LinkedList<>();
            int time = 0;

            // 3
            while(!pq.isEmpty() || !q.isEmpty()){
                time++;

                if(pq.isEmpty() && time != q.peek()[2]){
                    time = q.peek()[2];
                }else{
                    if(!pq.isEmpty()){
                        int[] temp = pq.poll();
                        temp[1]--;
                        if(temp[1] > 0)
                            q.add(new int[]{temp[0], temp[1], time+n});
                    }
                }

                //  A,2,4
                if(!q.isEmpty() && time == q.peek()[2]){
                    int[] temp = q.poll();
                    pq.add(new int[]{temp[0], temp[1]});
                }
            }
        return time;
    }
}
