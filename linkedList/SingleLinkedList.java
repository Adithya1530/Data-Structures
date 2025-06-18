package linkedList;

public class SingleLinkedList {
	
	private Node head;
	private Node tail;
	private int size;
	
	public SingleLinkedList() {
		this.size = 0;
	}
	
	// Insert Methods
	public void insertFirst(int val) {
		Node node = new Node(val);
		node.next = head;
		head = node;
		if(tail == null) {
			tail = head;
		}
		size += 1;
	}
	
	public void insertLast(int val) {
		if(tail == null) {
			insertFirst(val);
			return;
		}
		Node node = new Node(val);
		tail.next = node;
		tail = node;
		size ++;
	}
	
	//Optional
	public void insertLastWithoutTail(int val) {
		Node node = new Node(val);
		if(head == null) {
			head = node;
			size ++;
			return;
		}
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;	
		size ++;
	}
	
	public void insert(int val,int index) {
		
		if(index == 0) {
			insertFirst(val);
			return;
		}
		
		if(index == size) {
			insertLast(val);
			return;
		}
		
		if (index < 0 || index > size) throw new IndexOutOfBoundsException("LinkedList index is out of range");
		
		Node temp = head;
		// Traverse to the node just before the target index
		for (int i = 1; i < index; i++) {
			temp = temp.next;
		}												 // using only value const				
		Node node = new Node(val, temp.next);            // Node node = new Node(val);
		temp.next = node;								 // node.next = temp.next;	
		size ++;
	}
	
	// Delete Methods
	public int deleteFirst() {
		if (head == null) {
	        throw new RuntimeException("List is empty, nothing to delete");
	    }
		int val = head.value;
		head = head.next;
		size --;
		// If list becomes empty after deletion
		if(head == null) {
			tail = null;
		}
		return val;
	}
	
	public int deleteLast() {
		if (size <= 1) {
            return deleteFirst();
        }
		int val = tail.value;
		Node temp = head;
		// Traverse to the second-last node
	    while (temp.next.next != null) {
	        temp = temp.next;
	    }
	    tail = temp;
	    tail.next = null; 
	    size--;
		return val;	
	}
	
	public int delete(int index) {
		if (index < 0 || index >= size) {
	        throw new IndexOutOfBoundsException("Invalid index: " + index);
	    }
		if(index == 0) {
			return deleteFirst();
		}
		if(index == size-1) {
			return deleteLast();
		}
		Node prev = head;
		for (int i = 0; i < index - 1; i++) {
			prev = prev.next;
		}
		int val = prev.next.value;
		prev.next = prev.next.next;
		size --;
		return val;
		
	}
	
	public Node find(int value) {
		Node node = head;
		while(node != null) {
			if(node.value == value) {
				return node;
			}
			node = node.next;
		}
		return null;
	}

	//display Method
	public void display() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.value +" -> ");
			temp = temp.next;
		}
		System.out.println("End");
	}

	
	@Override
	public String toString() {
		return "CustomLL : [head=" + head + ", tail=" + tail + ", size=" + size + "]";
	}


	private class Node{
		
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
		}

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		@Override
		public String toString() {
			return ""+value ;
		}
		
		
	}

}