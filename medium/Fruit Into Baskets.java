class Solution {
    public int totalFruit(int[] tree) {
        int max = 0;
        for(int i = 0; i < tree.length; i++) {
            if(max > tree.length - i)
                break;
            
            int temp = collect(tree, i);
            if(temp > max)
                max = temp;
        }
        
        return max;
    }
    
    private int collect(int[] tree, int pos) {
        int count = 0, typeA = tree[pos], typeB = -1;
        
        while(pos < tree.length) {
            if(typeB == -1 && tree[pos] != typeA)
                typeB = tree[pos];
            
            if(tree[pos] != typeA && tree[pos] != typeB)
                break;
            
            count++;
            pos++;
        }
        
        return count;
    }
}
