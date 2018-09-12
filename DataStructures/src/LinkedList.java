
public class LinkedList {
		

	static Node head;
	private static Node temp;
	
	public void add(Object value) {
		if(head==null) {
			head=new Node(value);
		}
		else {
			Node temp=head;
			while(temp.getNext()!=null) {
				temp=temp.getNext();
			}
			Node newNode=new Node(value);
			temp.setNext(newNode);
		}
	}
	
	public void add(int index,Object value) {
		Node temp=head;
		for(int i=2; i<index; i++) {
			if(temp.getNext()!=null) {
				temp=temp.getNext();
			}
			else{
				break;
			}
		}
		Node newNode=new Node(value);
		newNode.setNext(temp.getNext());
		temp.setNext(newNode);
	}
	
	
	public void addFirst(Object value) {
		Node newNode=new Node(value);
		Node temp=head;
		newNode.setNext(temp);
		head=newNode;
	}
	
	public void remove(Object value) {
		temp = head;
		Node tempPrev=head;
		if(temp.getData()==value) {
			head=temp.getNext();
		}
		else {
			temp=temp.getNext();
			while(temp!=null) {
				if(temp.getData()==value) {
					tempPrev.setNext(temp.getNext());
					break;
				}
				tempPrev=temp;
				temp=temp.getNext();
			}
		}
	}
	
	public void removeFirst() {
		Node temp=head;
		head=temp.getNext();
	}

	public void removeLast() {
		Node temp=head.getNext();
		Node prevTemp=head;
		if(temp==null) {
			head=null;
		}
		else {
			while(temp.getNext()!=null) {
				temp=temp.getNext();
				prevTemp=prevTemp.getNext();
			}
			prevTemp.setNext(null);
		}
	}

	public Node reverseRecursive(Node temp) {
		if(temp==null)
			return null;
		if(temp.getNext()==null)
			return temp;
		
			Node sec=temp.getNext();
			temp.setNext(null);
			Node newHead=reverseRecursive(sec);
			sec.setNext(temp);
			return newHead;
	}
	
	public void reverseIterative() {
		Node temp=head;
		Node prev=null,next=null;
		Node curr=temp;
		while(curr!=null) {
			next=curr.getNext();
			curr.setNext(prev);
			prev=curr;
			curr=next; 
		}
		head=prev;
	}
	
	public void display () {
		Node temp=head;
		System.out.println("Values");
		if(temp==null) {
			System.out.println("No values to display");
		}
		else {
		while(temp.getNext()!=null) {
			System.out.println(temp.getData());
			temp=temp.getNext();
		}
		System.out.println(temp.getData());
		}
	}
	
	
}
