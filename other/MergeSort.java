import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) {
    int[] input = new int[]{5, 4, 70, 2, 6, 99, 23, 10, 11, 11, 4, 1, -5, 5, 0};
    
    int[] sorted = mergesort(input, 0, input.length - 1);
    
    for(int i : sorted)
      System.out.print("" + i + ' ');
  }
  
  private static int[] mergesort(int[] input, int left, int right) {
    if(left == right)
      return new int[]{input[left]};
    
    int middle = (left + right) / 2;
    
    int[] leftHalf = mergesort(input, left, middle);
    int[] rightHalf = mergesort(input, middle + 1, right);
    
    
    int[] sorted = new int[leftHalf.length + rightHalf.length];
    int p1 = 0, p2 = 0, ps = 0;
    while(p1 < leftHalf.length || p2 < rightHalf.length) {
      if(p2 == rightHalf.length || (p1 < leftHalf.length && leftHalf[p1] <= rightHalf[p2]))
        sorted[ps++] = leftHalf[p1++];
      else
        sorted[ps++] = rightHalf[p2++];
    }
    
    return sorted;
  }
}
