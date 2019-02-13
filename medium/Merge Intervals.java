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
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        for(int i = 0; i < intervals.size(); i++) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            int pointer = i + 1;
            while(pointer < intervals.size() && intervals.get(pointer).start <= end) {
                end = Math.max(end, intervals.get(pointer).end);
                i++;
                pointer++;
            }
            
            result.add(new Interval(start, end));
        }
        
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

