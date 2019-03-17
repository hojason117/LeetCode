class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(n == 0)
            return new int[0];
        
        Stack<String[]> stack = new Stack<String[]>();
        int[] times = new int[n];
        
        int previous = Integer.valueOf(logs.get(0).split(":")[2]);
        for(int i = 0; i < logs.size(); i++) {
            String[] current = logs.get(i).split(":");
            if(current[1].equals("start")) {
                if(stack.size() > 0) {
                    times[Integer.valueOf(stack.peek()[0])] += (Integer.valueOf(current[2]) - previous);
                    previous = Integer.valueOf(current[2]);
                }
                stack.push(current);
            }
            else {
                stack.pop();
                times[Integer.valueOf(current[0])] += (Integer.valueOf(current[2]) - previous + 1);
                previous = Integer.valueOf(current[2]) + 1;
            }
        }
        
        return times;
    }
}
