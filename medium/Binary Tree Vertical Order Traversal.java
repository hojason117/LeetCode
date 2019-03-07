/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<List<Integer>>();
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> columns = new HashMap<Integer, List<Integer>>();
        
        int min = 0, max = 0;
        
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> indexQueue = new LinkedList<Integer>();
        nodeQueue.add(root);
        indexQueue.add(0);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int index = indexQueue.poll();
            
            min = Math.min(index, min);
            max = Math.max(index, max);
            
            if(!columns.containsKey(index))
                columns.put(index, new ArrayList<Integer>());
            columns.get(index).add(node.val);
            
            if(node.left != null) {
                nodeQueue.add(node.left);
                indexQueue.add(index - 1);
            }
            if(node.right != null) {
                nodeQueue.add(node.right);
                indexQueue.add(index + 1);
            }
        }
        
        for(int i = min; i <= max; i++)
            result.add(columns.get(i));
        
        return result;
    }
}
