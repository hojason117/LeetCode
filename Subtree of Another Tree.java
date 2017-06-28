public class Solution {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		boolean result = false;
		
		result = subtreeVerify(s, t);
		if(result)
			return true;
		
		if(s != null) {
			result = isSubtree(s.left, t);
			if(result)
				return true;
			
			result = isSubtree(s.right, t);
			if(result)
				return true;
		}
		
		return false;
    }
	
	public static boolean subtreeVerify(TreeNode s, TreeNode t) {
		if(s == null && t == null)
			return true;
		else if(s == null || t == null)
			return false;
		
		if(s.val != t.val)
			return false;
		
		return subtreeVerify(s.left, t.left) & subtreeVerify(s.right, t.right);
	}
}