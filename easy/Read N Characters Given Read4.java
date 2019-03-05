/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int pointer = 0, count = 4;
        
        while(pointer < n && count == 4) {
            count = read4(temp);
            for(int i = 0; i < count && n - pointer > 0; i++)
                buf[pointer++] = temp[i];
        }
        
        return pointer;
    }
}
