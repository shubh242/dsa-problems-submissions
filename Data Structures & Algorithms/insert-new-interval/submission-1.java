class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0)
            return new int[][]{newInterval};
        
        if(newInterval.length == 0)
            return intervals;
            
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][0];
        int i = 0;

        // Skipping irrelevant
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        // Merging till we are able to
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        result.add(newInterval);

        // Adding all others
        while(i < intervals.length){
            result.add(intervals[i]);
            i++;
        }

        int[][] res = new int[result.size()][2];
        res = result.toArray(res);
        return res;
    }
}
