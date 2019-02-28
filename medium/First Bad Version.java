/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(isBadVersion(1))
            return 1;
        
        int pointer = n / 2, left = 1, right = n;
        
        while(left <= right) {
            if(isBadVersion(pointer)) {
                if(pointer > 1 && !isBadVersion(pointer - 1))
                    return pointer;
                
                right = pointer;
                pointer -= (pointer - left) / 2;
            }
            else {
                left = pointer;
                pointer += (right - pointer + 1) / 2;
            }
        }
        
        return 0;
    }
}
