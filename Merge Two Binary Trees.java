public class Solution {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
        	return null;
        
        TreeNode t3 = new TreeNode(0);
        
		if(t1 != null && t2 != null) {
			t3.val = t1.val + t2.val;
        	t3.left = mergeTrees(t1.left, t2.left);
    		t3.right = mergeTrees(t1.right, t2.right);
		}
		else
			t3 = (t1 == null) ? t2 : t1;
		
		return t3;
    }
}