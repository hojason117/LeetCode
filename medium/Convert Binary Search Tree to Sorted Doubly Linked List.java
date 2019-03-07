/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null)
            return null;
        
        Stack<Node> stack = new Stack<Node>();
        reverseInorder(stack, root);
        
        Node head = stack.pop();
        
        Node temp = head;
        while(!stack.empty()) {
            temp.right = stack.peek();
            stack.peek().left = temp;
            temp = stack.pop();
        }
        
        head.left = temp;
        temp.right = head;
        
        return head;
    }
    
    private void reverseInorder(Stack<Node> stack, Node node) {
        if(node == null)
            return;
        
        reverseInorder(stack, node.right);
        stack.push(node);
        reverseInorder(stack, node.left);
    }
}
