package week1;





public class LinkedList {
	public static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	Node head = null;
	Node tail = null;
	int size = 0;
	public void addData(int data) {
		if (head == null) {
			Node newNode = new Node(data);
			head = newNode;
			tail = head;
			size++;
		}
		else {
			Node newNode = new Node(data);
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	
	public void addDataByIndex(int index, int data) {
		Node newNode = new Node(data);
		if (index==0) {
			Node store = head;
			head = newNode;
			head.next = store;
		}
		else {
			Node prev = head;
			for (int i=1; i<index;i++) {
				prev = prev.next;
			}
			Node temp = prev.next;
			prev.next = newNode;
			newNode.next = temp;
		}
	}
	
	public void deleteData(int value) {
		Node temp = head;
		Node prev = null;
		
		if (temp != null && temp.data == value) {
			head= temp.next;
			return;
		}
		while(temp!=null && temp.data!= value) {
			prev = temp;
			temp = temp.next;
		}
		
		if(temp==null) {
			return;
		}
		prev.next = temp.next;
		
	}
	
	public void deleteDataByIndex(int index, int data) {
		
	}
	
	public void printList() {
		Node current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
		
	}
	
	public int getSize() {
		return size;
	}
	
	public int getDataByIndex(int i) {
		if (getSize()==0 || i>getSize()) {
			System.out.println("invalid input");
			return -69;
		}
		else {
			Node current = head;
			for (int j=0; j<i;j++) {
				current = current.next;
			}
			return current.data;
		}
	}
}
