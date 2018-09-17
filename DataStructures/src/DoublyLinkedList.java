
public class DoublyLinkedList {
	public static NodeD first;
	public NodeD last;
	
	public void addFirst(NodeD node) {
		if(first==null) {
			first=node;
			last=node;
		}
		else {
			first.prev=node;
			node.prev=null;
			node.next=first;
			first=node;
		}
	}
	public void display() {
		NodeD node=first;
		System.out.println("Values");
		if(node==null) {
			System.out.println("No value found");
		}
		else {
			System.out.println(node.value);
			while(node.next!=null) {
				node=node.next;
				System.out.println(node.value);
			}
		}
	}
	
	public void remove(NodeD node) {
		if(node!=null) {
			if(node.next==null && node.prev!=null) {
				node.prev.next=null;
				last=node.prev;
				node.next=null;
				node.prev=null;
			}
			else if(node.prev==null) {
				first=null;
				last=null;
			}
			else {
				node.prev.next=node.next;
				node.next.prev=node.prev;
				node.next=null;
				node.prev=null;
			}
		}
		
	}
	
	public void removeLast() {
		if(last.prev!=null) {
			last=last.prev;
			last.next=null;
		}
		else {
			last=null;
			first=null;
		}
	}
	
}
