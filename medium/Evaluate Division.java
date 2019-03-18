class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> results = new HashMap<String, Map<String, Double>>();
        double[] answers = new double[queries.length];
        
        for(int i = 0; i < equations.length; i++) {
            if(!results.containsKey(equations[i][0])) {
                results.put(equations[i][0], new HashMap<String, Double>());
                results.get(equations[i][0]).put(equations[i][0], 1.0);
            }
            
            if(!results.containsKey(equations[i][1])) {
                results.put(equations[i][1], new HashMap<String, Double>());
                results.get(equations[i][1]).put(equations[i][1], 1.0);
            }
            
            results.get(equations[i][0]).put(equations[i][1], values[i]);
            results.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }
        
        for(int i = 0; i < queries.length; i++)
            answers[i] = calculate(results, queries[i][0], queries[i][1], new HashSet<String>(), 1.0);
        
        return answers;
    }
    
    private double calculate(Map<String, Map<String, Double>> results, String start, String end, Set<String> visited, double current) {
        if(!results.containsKey(start))
            return -1.0;
        
        if(start.equals(end))
            return current;
        
        Map<String, Double> edges = results.get(start);
        Iterator<String> iter = edges.keySet().iterator();
        while(iter.hasNext()) {
            String temp = iter.next();
            if(!visited.contains(temp)) {
                visited.add(temp);
                double answer = calculate(results, temp, end, visited, current * edges.get(temp));
                if(answer != -1.0)
                    return answer;
            }
        }
        
        return -1.0;
    }
}
