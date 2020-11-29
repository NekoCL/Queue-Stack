public class MyStack {
	private Node top;
	
	//Constructor
	public MyStack() {
		this.top = null;
	}
	
	//Push node to add to stack
	public void push(Node node) {
		node.next = this.top; //make old top next node
		this.top = node;	  //update top with new node
	}
	
	//Pop node to remove from top
	public Node pop() {
		//If stack is empty
		if (this.top == null) {
			System.out.println("Stack is empty");
		} else {
			this.top = this.top.next; //remove top
		}
		return null;
	}
	
	//Peek at the top node
	public Node peek() {
		//If stack is empty
		if (this.top == null) {
			System.out.println("Stack is empty");
			return null;
		} else {
			System.out.println("Top data: " + this.top.data);
			return this.top;
		}	
	}
	
	//Boolean for true when empty, false when not
	public boolean isEmpty() {
		if (this.top == null) {
			return true;
		} else {
			return false;
		}
	}
	
}