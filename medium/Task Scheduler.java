class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] tasksCount = new int[26];
        int[] lastExec = new int[26];
        Queue<Integer> pqueue = new PriorityQueue<Integer>(26, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return tasksCount[b] - tasksCount[a];
            }
        });
        
        for(char c : tasks)
            tasksCount[c - 'A']++;
        for(int i = 0; i < 26; i++) {
            if(tasksCount[i] > 0)
                pqueue.add(i);
        }
        
        int count = 1;
        while(!pqueue.isEmpty()) {
            List<Integer> dequeued = new ArrayList<Integer>();
            
            int earliest = pqueue.peek();
            boolean idle = true;
            while(!pqueue.isEmpty()) {
                int temp = pqueue.poll();
                
                if(lastExec[temp] == 0 || count - lastExec[temp] > n) {
                    lastExec[temp] = count++;
                    tasksCount[temp]--;
                    idle = false;
                    dequeued.add(temp);
                    break;
                }
                else {
                    if(lastExec[temp] < lastExec[earliest])
                        earliest = temp;
                }
                
                dequeued.add(temp);
            }
            
            if(idle) {
                lastExec[earliest] += (n + 1);
                count = lastExec[earliest] + 1;
                tasksCount[earliest]--;
            }
            
            for(int i : dequeued) {
                if(tasksCount[i] > 0)
                    pqueue.add(i);
            }
        }
        
        return count - 1;
    }
}
