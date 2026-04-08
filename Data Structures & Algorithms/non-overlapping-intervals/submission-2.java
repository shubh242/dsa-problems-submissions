class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 1)
            return 0;

        Arrays.sort(intervals, (a,b)->(a[1]-a[0])-(b[1]-b[0]) + (a[0]-b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        int remove = 0;

        for(int i = 1; i < intervals.length; i++){
            if(start < intervals[i][0] && end <= intervals[i][0]){
                start = intervals[i][0];
                end = intervals[i][1];
            }else{
                remove++;
            }
        }
        return remove;
    }
}
