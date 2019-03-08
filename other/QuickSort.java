import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] arg) {
        int[] input = new int[]{5, 4, 70, 2, 6, 99, 23, 10, 11, 11, 4, 1, -5, 5, 0};
        
        quicksort(input, 0, input.length - 1);

        for(int i : input)
          System.out.print("" + i + ' ');
    }
    
    private static void quicksort(int[] input, int left, int right) {
        if(left >= right)
            return;
        
        int pivot = right, large = left;
        for(int i = left; i < pivot; i++) {
            if(input[i] < input[pivot])
                swap(input, i, large++);
        }
        
        swap(input, pivot, large);
        
        quicksort(input, left, large - 1);
        quicksort(input, large + 1, right);
    }

    private static void swap(int[] input, int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
