/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        
        Collections.sort(intervals, (a,b)->a.start-b.start);
        Set<Interval> intSet = new HashSet<>(intervals);
        Map<Integer, List<Interval>> intMap = new HashMap<>();
        int days = 0;
        int i = 0, start = 0, end = 0;

        while(!intSet.isEmpty()){
            if(intSet.contains(intervals.get(i))){
                if(!intMap.containsKey(days)){
                    intMap.put(days, new ArrayList<>());
                    intMap.get(days).add(intervals.get(i));
                    start = intervals.get(i).start;
                    end = intervals.get(i).end;
                    intSet.remove(intervals.get(i));
                }else{
                    if(intervals.get(i).start >= end){
                        intMap.get(days).add(intervals.get(i));
                        start = Math.min(start, intervals.get(i).start);
                        end = Math.max(end, intervals.get(i).end);
                        intSet.remove(intervals.get(i));
                    }
                }
            }
            i++;
            if(i == intervals.size()){
                i = 0;
                days++;
            }
        }
        return intMap.size();
    }
}
