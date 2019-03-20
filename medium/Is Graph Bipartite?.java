class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] status = new int[graph.length];
        Queue<Integer> nodeQueue = new LinkedList<Integer>();
        Queue<Boolean> statusQueue = new LinkedList<Boolean>();
        
        for(int i = 0; i < graph.length; i++) {
            if(status[i] != 0)
                continue;
            
            nodeQueue.add(i);
            statusQueue.add(true);
            while(!nodeQueue.isEmpty()) {
                int node = nodeQueue.poll();
                boolean selector = statusQueue.poll();
                if(status[node] == (selector ? -1 : 1))
                    return false;
                if(status[node] == 0) {
                    status[node] = (selector ? 1 : -1);
                    for(int j : graph[node]) {
                        nodeQueue.add(j);
                        statusQueue.add(!selector);
                    }
                }
            }
        }
        
        return true;
    }
}
