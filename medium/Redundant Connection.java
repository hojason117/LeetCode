class Solution {
    Set<Integer> seen = new HashSet();
    
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList sols = new ArrayList<int[]>();
        int sol[] = {};
        
        for(int i = edges.length - 1; i >= 0; i--) {
            seen.clear();
            ArrayList<int[]> graph = new ArrayList<int[]>(Arrays.asList(edges));
            graph.remove(edges[i]);
            if(dfs(graph, edges[i][0], edges[i][1])) {
                sol = edges[i];
                break;
            }
        }
        return sol;
    }
    
    public boolean dfs(ArrayList<int[]> edges, int start, int end) {
        if(seen.contains(start))
            return false;
        if (start == end)
            return true;
        
        seen.add(start);
        
        for(int i = 0; i < edges.size(); i++) {
            int edge[] = (int[])edges.get(i);
            if(edge[0] == start) {
                ArrayList<int[]> newEdges = (ArrayList<int[]>)edges.clone();
                newEdges.remove(i);
                if(dfs(newEdges, edge[1], end))
                    return true;
            }
            else if(edge[1] == start) {
                ArrayList<int[]> newEdges = (ArrayList<int[]>)edges.clone();
                newEdges.remove(i);
                if(dfs(newEdges, edge[0], end))
                    return true;
            }
        }
        return false;
    }
}
