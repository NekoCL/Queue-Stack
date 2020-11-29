public class MyQueue {
	protected Node front;
	protected Node rear;
	
	//Basic Constructor
	public MyQueue() {
		this.rear = null;
		this.front = null;
	}
	
	//Insert node to back of queue
	public void enqueue(Node node) {
		//If the front is empty, added to front
		if (this.front == null) {
			this.front = node;
			//System.out.println("Front: " + this.front.data);
		} else if (this.rear.next == null) { //only one element in queue
			this.front.prev = node; //new node is now prev of front
		} else {
			this.rear.prev = node; //new node is now prev of old rear
		}
		node.next = this.rear; //old rear is now next of new node
		this.rear = node;	   //newly added node is now rear
	}
	
	//Remove node from front of queue
	public String dequeue() {
		//If queue is empty
		if (this.rear == null) {
			System.out.println("Queue is empty");
			return null;
		} else if (this.rear.next == null) { //only one element in queue
			this.rear = null;
			this.front = null;
			return null;
		} else {
			Node temp = this.rear;
			//Traverse to second element
			while (temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;  //remove first element
			this.front = temp; //second element is now front
		}
		return this.front.data;
	}
	
	//Boolean for true when empty, false when not
	public boolean isEmpty() {
		if (this.rear == null) {
			return true;
		} else {
			return false;
		}
	}
	
	//Print the queue from left to right as front to back
	public void displayQueue() {
		//If queue is empty
		if (this.front == null) {
			System.out.println("Queue is empty");
		} else {
			Node temp = this.front;
			//Traverse and print
			while(temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.prev;
			}
			System.out.println();
		}
	}
	
}