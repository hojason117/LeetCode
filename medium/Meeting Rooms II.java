/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        
        for(Interval i : intervals) {
            queue.add(i.end);
            while(queue.peek() <= i.start)
                queue.poll();
            
            if(queue.size() > count)
                count = queue.size();
        }
        
        return count;
    }
}
