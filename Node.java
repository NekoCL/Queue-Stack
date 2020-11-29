public class Node {
	protected String data;
	protected Node next;
	protected Node prev;
	
	//Basic Constructor
	public Node() {
		
	}
	
	//Parameterized Constructor
	public Node(String data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	//Print data in node
	public void printNode() {
		System.out.println("Node data: " + this.data);
	}
	
	//Accessors
	public String getData() {
		return this.data;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public Node getPrev() {
		return this.prev;
	}
	
	//Mutators
	public void setData(String data) {
		this.data = data;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public void setPrev(Node prev) {
		this.prev = prev;
	}
}