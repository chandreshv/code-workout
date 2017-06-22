package com.chandresh.practice.programs.ds.tree;



public class FindDistance {

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
		FindDistance bst = new FindDistance();
		Node n = bst.new Node(8);
		bst.root = n;
		n = bst.new Node(3);
		Node a = n;
		bst.root.left = n;
		n = bst.new Node(1);
		bst.root.left.left = n;
		n = bst.new Node(6);
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
		Node b = n;
		bst.root.right.right.left = n;
		
		System.out.println(bst.findDistance(bst.root, a, b));
	}
	
	public int findDistance(Node root, Node a, Node b){
		if(root==null || a==null || b==null)
			return -1;
		
		Node lca = findLCA(root, a,b);
		
		return distance(lca,a)+distance(lca,b);
		
	}

	private int distance(Node source, Node target) {
		return distance(source, target, 0);
	}
	
	private int distance(Node source, Node target, int distance) {
		if(source==null || target==null)
			return -1;
		
		if(source.key==target.key)
			return distance;
		int rDistance=0,lDistance=0;
		 lDistance = distance(source.left,target, distance+1);
		if(lDistance<=0)
		 rDistance = distance(source.right, target, distance+1);
		
		if(lDistance<=0 && rDistance<=0)
			return -1;
		
		return lDistance>0?lDistance:rDistance;
	}

	private Node findLCA(Node root, Node a, Node b) {
		if(root==null)
			return null;
		
		if(root.key==a.key || root.key==b.key)
			return root;
		
		Node l = findLCA(root.left, a, b);
		Node r = findLCA(root.right, a, b);
		
		if(l!=null && r!=null)
			return root;
		
		return l!=null?l:r;
	}
}

