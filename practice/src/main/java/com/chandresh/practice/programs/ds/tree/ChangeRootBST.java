package com.chandresh.practice.programs.ds.tree;

import java.util.EmptyStackException;
import java.util.Stack;

public class ChangeRootBST {

	class Node
    {
        int key;
        Node left, right;
 
        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }
 
    // Root of BST
    Node root;
	
	public static void main(String[] args){
		ChangeRootBST bst = new ChangeRootBST();
		Node n = bst.new Node(8);
		bst.root = n;
		n = bst.new Node(3);
		bst.root.left = n;
		n = bst.new Node(1);
		bst.root.left.left = n;
		n = bst.new Node(6);
		Node n1 = n;
		bst.root.left.right = n;
		n = bst.new Node(4);
		bst.root.left.right.left = n;
		n = bst.new Node(7);
		bst.root.left.right.right = n;
		n = bst.new Node(10);
		bst.root.right = n;
		n = bst.new Node(14);
		bst.root.right.right = n;
		n = bst.new Node(13);
		bst.root.right.right.left = n;
		
		//bst.inorder(bst.root);
		System.out.println(bst.root.key);
		bst.root = bst.changeRoot(bst.root, n1);
		System.out.println(bst.root.key);
		//bst.inorder(bst.root);
	}
	
	public Node changeRoot(Node root, Node target){
		if(root==null || target==null || root.key==target.key)
			return root;
		
		Stack<Node> stack = new Stack<Node>();
		Node temp = root;
		
		while (temp != null) {
			stack.push(temp);
			if (temp.key == target.key) {
				break;
			}
			if (temp.key > target.key)
				temp = temp.left;
			else
				temp = temp.right;
			
		}
		if(temp==null)
			return null;
		Node result = null;
		while(!stack.isEmpty()){
			Node child = stack.pop();
			Node parent = null;
			try{
				parent = stack.pop();
			}catch(EmptyStackException ese){
				parent = null;
			}
			
			if(parent==null){
				result = child;
				break;
			}
			
			if(child==parent.left)
				result = rotateRight(parent);
			else
				result = rotateLeft(parent);
			
			if(!stack.isEmpty()){
				if(stack.peek().key>result.key)
					stack.peek().left = result;
				else
					stack.peek().right=result;
			}
			stack.push(result);
		}
		return result;
	}

	private Node rotateLeft(Node node) {
		if(node==null)
			return null;
		
		Node temp = node;
		node = node.right;
		temp.right = node.left;
		node.left = temp;
		return node;
	}

	private Node rotateRight(Node node) {
		if(node==null)
			return null;
		
		Node temp = node;
		node = node.left;
		temp.left = node.right;
		node.right = temp;
		return node;
	}
	
	 void inorder(Node root)
	    {
	        if (root != null)
	        {
	            inorder(root.left);
	            System.out.print(root.key + " ");
	            inorder(root.right);
	        }
	    }
}
