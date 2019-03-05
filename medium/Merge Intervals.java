// Java
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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        
        if(intervals.size() == 0)
            return result;
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for(Interval i : intervals) {
            if(i.start > end) {
                result.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
            else
                end = Math.max(i.end, end);
        }
        
        result.add(new Interval(start, end));
        
        return result;
    }
}

// Javascript
/**
 * Definition for an interval.
 * function Interval(start, end) {
 *     this.start = start;
 *     this.end = end;
 * }
 */
/**
 * @param {Interval[]} intervals
 * @return {Interval[]}
 */
var merge = function(intervals) {
    var result = [];
    
    intervals.sort((a, b) => a.start - b.start);
    
    for(let i = 0; i < intervals.length; i++) {
        let start = intervals[i].start;
        let end = intervals[i].end;
        let pointer = i + 1;
        while(pointer < intervals.length && intervals[pointer].start <= end) {
            end = (intervals[pointer].end > end) ? intervals[pointer].end : end;
            i++;
            pointer++;
        }
        
        result.push(new Interval(start, end));
    }
    
    return result;
};

