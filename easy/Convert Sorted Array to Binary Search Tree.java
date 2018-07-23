public class Solution {
	public TreeNode sortedArrayToBST(int[] nums) {
        return findRoot(nums, 0, nums.length - 1);
    }
	
	public static TreeNode findRoot(int[] nums, int start, int end) {
		if(start > end)
			return null;
		
		TreeNode root = new TreeNode(nums[(end + start) / 2]);
		
        root.left = findRoot(nums, start, (end + start) / 2 - 1);
        root.right = findRoot(nums, (end + start) / 2 + 1, end);
		
		return root;
	}
}