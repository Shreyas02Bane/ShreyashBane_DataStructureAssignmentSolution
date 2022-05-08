/**
 * 
 */
package com.greatLearning.gradedProject2;

/**
 * @author Shreyas
 *
 */

class Node{
	int val;
	Node left, right;
	Node(int key){
		this.val = key;
		left = right = null;
	}
}


public class BSTToSkewed {

	/**
	 * @param args
	 */
	
	Node node;
	static Node prevNode = null;
	static Node headNode = null;
	
	static void BSTToSkew(Node root, int order) {
		
		if(root == null) {
			return;
		}
		
		if(order > 0) {
			BSTToSkew(root.right, order);
		}else {
			BSTToSkew(root.left, order);
		}
		
		Node rightNode = root.right;
		Node leftNode = root.left;
		
		if(headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		}else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}
		
		if(order > 0){
            BSTToSkew(leftNode, order);
        }else{
            BSTToSkew(rightNode, order);
        }
	}
	
	static int count = 0;
	
	// Function to traverse the right
    // skewed tree using recursion
    static void traverseRightSkewed(Node root)
    {
        if(root == null)
        {
            return;
        }
        
        for(int i = 0; i < count; i++) {
        	System.out.print(" ");
        }
        
        count++;
        
        System.out.println(root.val);
        
        for(int i = 0; i < count; i++) {
        	System.out.print(" ");
        }
        int j = 0;
        if(j <= count-1) {
        	System.out.println("\\");
        	j++;
        }
        traverseRightSkewed(root.right);       
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BSTToSkewed tree = new BSTToSkewed();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.left.left = new Node(10);
        tree.node.right = new Node(60);
        tree.node.right.left = new Node(55);
       
        // Order of the Skewed tree can
        // be defined as follows -
        // For Increasing order - 0
        // For Decreasing order - 1
        int order = 0;
        BSTToSkew(tree.node, order);
        traverseRightSkewed(headNode);
        
	}

}
