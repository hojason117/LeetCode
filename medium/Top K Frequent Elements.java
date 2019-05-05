// two pass
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        Queue<Integer> pqueue = new PriorityQueue<Integer>(10, (Integer a, Integer b) -> count.get(a) - count.get(b));
        
        for(int num : nums)
            count.put(num, count.getOrDefault(num, 0) + 1);
        
        for(int num : count.keySet()) {
            pqueue.offer(num);
            if(pqueue.size() > k)
                pqueue.poll();
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < k; i++)
            result.add(pqueue.poll());
        
        Collections.reverse(result);
        
        return result;
    }
}

// dynamic solution - good for streaming data
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        Queue<Integer> pqueue = new PriorityQueue<Integer>(10, (Integer a, Integer b) -> count.get(b) - count.get(a));
        
        for(int num : nums) {
            if(count.containsKey(num))
                pqueue.remove(num);
            count.put(num, count.getOrDefault(num, 0) + 1);
            pqueue.offer(num);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < k; i++)
            result.add(pqueue.poll());
        
        return result;
    }
}
