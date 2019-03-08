import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] input = new int[]{5, 4, 70, 2, 6, 99, 23, 10, 11, 11, 4, 1, -5, 5, 0};

        heapsort(input);

        for(int i : input)
            System.out.print("" + i + ' ');
    }

    private static void heapsort(int[] input) {
        buildHeap(input);

        for(int i = input.length - 1; i >= 0; i--) {
            swap(input, 0, i);
            heapify(input, i, 0);
        }
    }

    private static void heapify(int[] input, int heapSize, int index) {
        if(leftChild(index) >= heapSize && rightChild(index) >= heapSize)
            return;

        int maxChildIndex = index;
        if(leftChild(index) < heapSize && input[leftChild(index)] > input[maxChildIndex])
            maxChildIndex = leftChild(index);
        if(rightChild(index) < heapSize && input[rightChild(index)] > input[maxChildIndex])
            maxChildIndex = rightChild(index);

        if(input[index] < input[maxChildIndex]) {
            swap(input, index, maxChildIndex);
            heapify(input, heapSize, maxChildIndex);
        }
    }

    private static void buildHeap(int[] input) {
        for(int i = input.length / 2; i >= 0; i--)
            heapify(input, input.length, i);
    }

    private static int parent(int index) {
        return (index - 1) / 2;
    }

    private static int leftChild(int index) {
        return (index + 1) * 2 - 1;
    }

    private static int rightChild(int index) {
        return (index + 1) * 2;
    }

    private static void swap(int[] input, int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
