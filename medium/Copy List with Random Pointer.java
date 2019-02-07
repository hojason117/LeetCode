/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, Integer> nodeToIndex = new HashMap<RandomListNode, Integer>();
        Map<Integer, RandomListNode> indexToNode = new HashMap<Integer, RandomListNode>();
        RandomListNode result = new RandomListNode(0);
        
        int i = 0;
        RandomListNode originalPointer = head;
        RandomListNode copyPointer = result;
        while(originalPointer != null) {
            nodeToIndex.put(originalPointer, i);
            RandomListNode newNode = new RandomListNode(originalPointer.label);
            indexToNode.put(i, newNode);
            copyPointer.next = newNode;
            
            originalPointer = originalPointer.next;
            copyPointer = copyPointer.next;
            i++;
        }
        
        originalPointer = head;
        copyPointer = result.next;
        while(originalPointer != null) {
            if(originalPointer.random == null)
                copyPointer.random = null;
            else
                copyPointer.random = indexToNode.get(nodeToIndex.get(originalPointer.random));
            
            originalPointer = originalPointer.next;
            copyPointer = copyPointer.next;
        }
        
        return result.next;
    }
}
