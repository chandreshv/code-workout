package com.chandresh.practice.programs.ds.tree;

import java.util.ArrayList;
import java.util.List;

class Node
{
    int data;
    Node left, right;
 
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class FindPath {
	Node root;
	
    int result = Integer.MIN_VALUE;
    public int maxPathSum(Node root) {
        if(root==null)
            return 0;
        
        maxSum(root);
        return result;
    }
    
    public int maxSum(Node root){
        if(root==null)
            return 0;
        
        int leftSum=maxSum(root.left);
        int rightSum=maxSum(root.right);
        
        int temp = root.data;
        if(leftSum>0)
            temp+=leftSum;
        if(rightSum>0)
            temp+=rightSum;
        if(temp>result)
        	result=temp;
        if(temp>0){
            return Math.max(root.data+leftSum, root.data+rightSum);
        }else
            return 0;
    }

	
	public List<Node> findPath(Node root, int target, List<Node> path){
		if(root==null)
			return null;
		
		
		
		if(root.data==target){
			path.add(root);
			return path;
		}
		
		if(root.left==null && root.right==null)
			return null;
		
		path.add(root);
		List<Node> tempL = findPath(root.left, target, path);
		if(tempL!=null)
			return tempL;
		List<Node> tempR = findPath(root.right, target, path);
		if(tempR!=null)
			return tempR;
		
		return null;
		
	}
	
	public static void main(String args[]){
		FindPath fp = new FindPath();
		fp.root = new Node(1);
		fp.root.left = new Node(2);
		fp.root.right = new Node(3);
		fp.root.left.left = new Node(4);
		fp.root.left.right = new Node(5);
		fp.root.right.left = new Node(6);
		fp.root.right.right = new Node(7);
		fp.root.right.right.left = new Node(8);
		fp.root.right.right.right = new Node(9);
		
		fp.maxPathSum(fp.root);
		System.out.println(fp.result);
		
		/*List<Node> result = fp.findPath(fp.root, 8, new ArrayList<Node>());
		
		for(Node each:result)
			System.out.println(each.data);*/
		
	}
}
