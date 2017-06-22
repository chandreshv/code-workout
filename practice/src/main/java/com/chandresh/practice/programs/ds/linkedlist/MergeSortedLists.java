package com.chandresh.practice.programs.ds.linkedlist;

class Node {

	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}


class LinkedList {
	Node head;
}

public class MergeSortedLists {
	
	
	Node MergeLists(Node list1, Node list2) {
		  if (list1 == null) return list2;
		  if (list2 == null) return list1;

		  if (list1.data < list2.data) {
		    list1.next = MergeLists(list1.next, list2);
		    return list1;
		  } else {
		    list2.next = MergeLists(list1, list2.next);
		    return list2;
		  }
		}
	
	public Node mergerList(Node n1, Node n2){
		if(n1==null && n2==null)
			return null;
		
		if(n1==null)
			return n2;
		if(n2==null)
			return n1;
		
		Node result,current1, current2, temp;
		if(n1.data<=n2.data){
			result=n1;current1=n1.next;current2=n2;
		}else{
			result=n2;current1=n1;current2=n2.next;
		}
		
		temp = result;
		
		while(current1!=null && current2!=null){
			if(current1.data<=current2.data){
				temp.next = current1;
				current1 = current1.next;
			}else{
				temp.next = current2;
				current2 = current2.next;
			}
			temp = temp.next;
		}
		
		if(current1==null)
			temp.next = current2;
		else if(current2==null)
			temp.next = current1;
		
		return result;
	}
	
	public static void main(String args[]){
		Node n1 = new Node(1);
		 n1.next = new Node(3);
		 n1.next.next = new Node(4);
		 n1.next.next.next = new Node(7);
		 
		 Node n2 = new Node(2);
		 n2.next = new Node(5);
		 n2.next.next = new Node(6);
		 
		 //Node result = new MergeSortedLists().mergerList(n1, n2);
		 Node result = new MergeSortedLists().MergeLists(n1, n2);
		 Node temp = result;
		 while(temp!=null){
			 System.out.println(temp.data);
			 temp = temp.next;
		 }
		 
	}
	
}
