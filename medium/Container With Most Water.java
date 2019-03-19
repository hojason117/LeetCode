// brute force
class Solution1 {
    public int maxArea(int[] height) {
        int max = 0;
        
        for(int i = 0; i < height.length; i++) {
            for(int j = i + 1; j < height.length; j++)
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
        }
        
        return max;
    }
}

// two pointers
class Solution {
    public int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        
        while(left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        
        return max;
    }
}
