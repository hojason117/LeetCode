class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pqueue = new PriorityQueue<Integer>();
        
        for(int i : nums){
            pqueue.add(i);
            if(pqueue.size() > k)
                pqueue.poll();
        }
        
        return pqueue.poll();
    }
}
