package com.chandresh.practice.programs.ds.linkedlist;

class DoublyNode {
	 
    int data;
    DoublyNode next, prev;

    DoublyNode(int d) {
        data = d;
        next = prev = null;
    }
}


public class DoublyLinkedList {
 
    DoublyNode head = null;
 
 
    /*Function to delete a node in a Doubly Linked List.
    head_ref --> pointer to head node pointer.
    del  -->  pointer to node to be deleted. */
    void deleteNode(DoublyNode head_ref, DoublyNode del) {
 
        /* base case */
        if (head == null || del == null) {
            return;
        }
 
        /* If node to be deleted is head node */
        if (head == del) {
            head = del.next;
        }
 
        /* Change next only if node to be deleted is NOT the last node */
        if (del.next != null) {
            del.next.prev = del.prev;
        }
 
        /* Change prev only if node to be deleted is NOT the first node */
        if (del.prev != null) {
            del.prev.next = del.next;
        }
 
        /* Finally, free the memory occupied by del*/
        return;
    }
 
    /* UTILITY FUNCTIONS */
    /* Function to insert a node at the beginning of the Doubly Linked List */
    void push(int new_data) {
 
        /* allocate node */
        DoublyNode new_node = new DoublyNode(new_data);
        
        if(this.head==null){
        	this.head=new_node;
        	return;
        }
        
        DoublyNode temp = this.head;
        
        while(temp.next!=null)
        	temp=temp.next;
        
        temp.next = new_node;
        new_node.prev = temp;
        
        /* since we are adding at the begining,
         prev is always NULL 
        new_node.prev = null;
 
         link the old list off the new node 
        new_node.next = (head);
 
         change prev of head node to new node 
        if ((head) != null) {
            (head).prev = new_node;
        }
 
         move the head to point to the new node 
        (head) = new_node;*/
    }
 
     /*Function to print nodes in a given doubly linked list
     This function is same as printList() of singly linked lsit */
    void printList(DoublyNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
 
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
 
        /* Let us create the doubly linked list 10<->8<->4<->2 */
        list.push(77);
        list.push(5);
        list.push(6);
        list.push(1);
        list.push(76);
        list.push(34);
        list.push(87);
 
        System.out.println("Original Linked list ");
        list.printList(list.head);
 
        new DoublyLinkedList().sort(list.head);
        System.out.println("after sorting");
        list.printList(list.head);
    }

    public void swap(DoublyNode n1, DoublyNode n2){
    	if (n1==null || n2==null)
    		return;

    	int temp = n1.data;
    	n1.data = n2.data;
    	n2.data = temp;
    }
    
	private void sort(DoublyNode head) {
		if(head==null)
			return ;
		
		DoublyNode tail = findTail(head);
		
		quickSort(head,tail);
	}

	private void quickSort(DoublyNode lo, DoublyNode hi) {
		if(lo==null || hi==null)
			return ;
		
		if(lo==hi)
			return ;
		DoublyNode mid = partition(lo,hi);
		if(mid!=lo)
		quickSort(lo, mid.prev);
		
		if(mid!=hi)
		quickSort(mid.next, hi);
		
	}
	
	private DoublyNode partition(DoublyNode lo, DoublyNode hi) {
		DoublyNode i=lo,j=hi;
		i=i.next;
		
		while(i!=j){
			
			while(i.data<lo.data){
				i=i.next;
				if(i==hi)
					break;
			}
			while(j.data>lo.data){
				j=j.prev;
				if(j==lo)
					break;
			}
			
			if(i==j || i.prev==j)
				break;
			
			swap(i, j);
		}
		if(j.data<lo.data)
			swap(j, lo);
		return j;
	}

	private DoublyNode findTail(DoublyNode start) {
		while(start.next!=null){
			start = start.next;
		}
		return start;
	}
}