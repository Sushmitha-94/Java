
public class StackUsingLinkedList {

	public LinkedList linkedL;
	public int maxArray;
	public static int top;
	public Node head;
	
	static {
		top=-1;
	}
	
	StackUsingLinkedList(int maxArray){
		this.maxArray=maxArray;
		linkedL=new LinkedList();
	}
	
	public void push(Object Value) {
		if(top==maxArray-1) {
			System.out.println("Stack is full");
		}
		else {
			linkedL.addFirst(Value);
			top++;
		}
	}
	
	public void pop() {
		if(top==-1) {
			System.out.println("List is empty");
		}
		else {
			linkedL.removeFirst();
			top--;
		}
	}
	
	public void display() {
		linkedL.reverseIterative();
		linkedL.display();
		
		}
	
	public static void main(String[] args) {
		
		StackUsingLinkedList stack=new StackUsingLinkedList(3);
		stack.push("One");
		stack.push('2');
		stack.push(3);
		stack.push(4.00);
		stack.display();
		stack.pop();
		stack.display();
		stack.pop();
		stack.display();
		stack.pop();
		stack.display();
		stack.pop();
		stack.display();
	}

}
