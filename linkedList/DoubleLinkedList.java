package linkedList;

public class DoubleLinkedList {
	
	private Node head;
	private Node tail;
	private int size;
	
	public DoubleLinkedList() {
		this.size = 0;
	}

	public void insertFirst(int val) {
		Node node = new Node(val);
		node.next = head;
		node.prev = null;
		if(head != null) {
			head.prev = node;
		}
		head = node;
		if(tail == null) {
			tail = node;
		}
		size ++;
	}
	
	public void insertLast(int val) {
		if(tail == null) {
			insertFirst(val);
			return;
		}
		Node node = new Node(val);
		node.prev = tail;
		node.next = null;
		tail.next = node;
		tail = node;
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
		if(index<0 || index>size) {
			throw new IndexOutOfBoundsException("LinkedList index is out of range");
		}
		Node temp = head;
		for(int i=1;i<index;i++) {
			temp = temp.next;
		}
		Node node = new Node(val, temp.next, temp);
		temp.next.prev = node;
		temp.next = node;
		size ++;
	}
	
	public int deleteFirst() {
		if(head == null) {
			throw new RuntimeException("List is empty, nothing to delete");
		}
		int val = head.value;
		head = head.next;
		if (head != null) {
	        head.prev = null;
	    } else {
	        tail = null;
	    }
		size--;
		return val;
	}
	
	public int deleteLast() {
		if(size <= 1) return deleteFirst();
		int val = tail.value;
		tail = tail.prev;
		tail.next = null;
		size --;
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
		Node temp = head;
		for(int i=0;i<index;i++) {
			temp = temp.next;
		}
		int val = temp.value;
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		size --;
		return val;
	}
	
	//Display LL in reverse order also without using tail
	public void display() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.value+" -> ");
			temp = temp.next;
		}
		System.out.println("End");
	}

	@Override
	public String toString() {
		return "DoubleLinkedList : [head=" + head + ", tail=" + tail + ", size=" + size + "]";
	}

	private class Node{
		
		private int value;
		private Node next;
		private Node prev;
		
		public Node(int value) {
			this.value = value;
		}
		
		public Node(int value, Node next, Node prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
		
		@Override
		public String toString() {
			return ""+value;
		}
		
	}

}
