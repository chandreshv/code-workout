package com.chandresh.practice.programs.ds.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author CHANDREV
 *  Given a binary search tree (BST) with duplicates, find all
 *         the mode(s) (the most frequently occurred element) in the given BST.
 *
 */
public class ModeFinder {
	
	Map<Integer, Integer> element = new HashMap<Integer, Integer>();
	int max = 0;
	public static void main(String args[]){
		BST<Integer> bst = new BST<Integer>();
		bst.insert(36);
		bst.insert(36);
		bst.insert(10);
		bst.insert(25);
		bst.insert(60);
		bst.insert(50);
		bst.insert(45);
		bst.insert(55);
		bst.insert(70);
		bst.insert(53);
		bst.insert(54);
		
		int[] result = new ModeFinder().findMode(bst.getRoot());
		
		for(Integer i:result){
			System.out.println(i);
		}
	}

	private int[] findMode(BST<Integer>.Node root) {
		List<Integer> result = new ArrayList<Integer>();
		
		if(root==null)
			return result.stream().mapToInt(i -> i).toArray();
		
		inorder(root);
		
		for(Entry<Integer, Integer> each:element.entrySet()){
			if(each.getValue()==max)
				result.add(each.getKey());
		}
		
		return result.stream().mapToInt(i -> i).toArray();
	}

	private void inorder(BST<Integer>.Node root) {
		if(root==null)
			return;
		
		inorder(root.getLeft());
		element.put(root.getData(), element.get(root.getData())==null?1:element.get(root.getData())+1);
		if(element.get(root.getData())>max)
			max = element.get(root.getData());
		
		inorder(root.getRight());
		
	}
	
}
