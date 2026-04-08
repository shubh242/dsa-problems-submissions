class Twitter {
    Map<Integer, Set<Integer>> followerMap;
    Map<Integer, Set<int[]>> tweetMap;
    PriorityQueue<int[]> pq;
    int time;


    public Twitter() {
        this.followerMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
        this.pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return b[1] - a[1];
            }
        });
        this.time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!this.tweetMap.containsKey(userId)){
            this.tweetMap.put(userId, new HashSet<>());
        }
        int[] temp = new int[]{tweetId, this.time};
        this.tweetMap.get(userId).add(temp);
        this.time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(this.tweetMap.containsKey(userId) && this.tweetMap.get(userId).size() > 0) 
            this.pq.addAll(this.tweetMap.get(userId));
        if(followerMap.containsKey(userId) && followerMap.get(userId).size() > 0){
                for(Integer followee: followerMap.get(userId)){
                    if(this.tweetMap.containsKey(followee) && this.tweetMap.get(followee).size() > 0)
                        this.pq.addAll(this.tweetMap.get(followee));
                }
        }
        int i = 0;
        List<Integer> feed = new ArrayList<>();
        while(!this.pq.isEmpty() && i < 10){
            feed.add(this.pq.poll()[0]);
            i++;
        }
        this.pq.clear();
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId != followeeId){
            if(!this.followerMap.containsKey(followerId))
                this.followerMap.put(followerId, new HashSet<>());
            this.followerMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(this.followerMap.containsKey(followerId) && this.followerMap.get(followerId).contains(followeeId))
            this.followerMap.get(followerId).remove(followeeId);
    }
}
