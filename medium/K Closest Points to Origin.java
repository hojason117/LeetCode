// heap
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][];
        Queue<int[]> maxHeap = new PriorityQueue<int[]>(K + 1, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (int)(Math.pow(b[0], 2) + Math.pow(b[1], 2)) - (int)(Math.pow(a[0], 2) + Math.pow(a[1], 2));
            }
        });
        
        for(int[] p : points) {
            maxHeap.add(p);
            if(maxHeap.size() > K)
                maxHeap.poll();
        }
        
        for(int i = 0; i < K; i++)
            result[i] = maxHeap.poll();
        
        return result;
    }
}

// divide and conquer
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if(K == 0)
            return new int[0][];
        if(K == points.length)
            return points;
        
        int pivot = -1, left = 0, right = points.length - 1;
        
        while(pivot != K) {
            if(pivot < K)
                left = pivot + 1;
            else
                right = pivot - 1;
            
            pivot = partition(points, left, right);
        }
        
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private int partition(int[][] points, int left, int right) {
        int firstGreater = left, middle = distance(points[right]);
        
        for(int i = left; i < right; i++) {
            if(distance(points[i]) <= middle)
                swap(points, i, firstGreater++);
        }
        
        swap(points, right, firstGreater);
        
        return firstGreater;
    }
    
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    
    private void swap(int[][] points, int a, int b) {
        int[] temp = points[a];
        points[a] = points[b];
        points[b] = temp;
    }
}
