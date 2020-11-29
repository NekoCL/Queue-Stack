public class Main {
	public static void main(String[] args){
		//Create node object
		Node node = new Node();
		
		//Create new stack object
		MyStack stack = new MyStack();
		
		//Create new stack object
		MyQueue queue = new MyQueue();
		
		//Test stack
		node.printNode();
		stack.push(new Node("Bob"));
		System.out.println("Peeking");
		stack.peek();		
		stack.push(new Node("Alice"));
		stack.peek();
		stack.pop();
		stack.peek();
		stack.pop();
		stack.peek();
		stack.pop();
		System.out.println(stack.isEmpty());
		stack.push(new Node("Alice"));
		stack.peek();
		System.out.println(stack.isEmpty());
		
		//Test check brackets
		System.out.println();
		System.out.println("Check brackets");
		System.out.println("()	 " + bracketsMatching("()"));
		System.out.println("{	 " + bracketsMatching("{"));
		System.out.println("(2+2)	 " + bracketsMatching("(2+2)"));
		System.out.println(")	 " + bracketsMatching(")"));
		System.out.println("(}	 " + bracketsMatching("(}"));
		System.out.println("(10)*{5+5}	 " + bracketsMatching("(1)+{5*5}"));

		//Test queue
		System.out.println();
		System.out.println("Check Queues");
		queue.displayQueue();
		System.out.println(queue.isEmpty());
		queue.enqueue(new Node("Bob"));
		queue.displayQueue();
		System.out.println(queue.isEmpty());
		queue.enqueue(new Node("Alice"));
		queue.displayQueue();
		queue.enqueue(new Node("Allie"));
		queue.displayQueue();
		queue.dequeue();
		queue.displayQueue();
		queue.dequeue();
		queue.displayQueue();
		queue.dequeue();
		queue.displayQueue();
		System.out.println(queue.isEmpty());
		queue.enqueue(new Node("Bob"));
		queue.enqueue(new Node("Alice"));
		queue.enqueue(new Node("Allie"));
		queue.displayQueue();
		System.out.println();
		
		System.out.println("Reverse Queue");
		reverseQueue(queue);
		
		queue.enqueue(new Node("Bob"));
		queue.enqueue(new Node("Alice"));
		queue.enqueue(new Node("Allie"));
		queue.enqueue(new Node("John"));
		queue.enqueue(new Node("Ruby"));
		queue.enqueue(new Node("Zoe"));
		System.out.println();

		System.out.println("Another Queue");
		queue.displayQueue();
		System.out.println();

		System.out.println("Reverse Another Queue");
		reverseQueue(queue);
		
	}
	
	//Check for matching brackets
	public static boolean bracketsMatching(String input) {
		MyStack stack = new MyStack();
		String c;
		int bracketCount = 0;
		int curveBracketCount = 0;

		//Clear stack
		while (!stack.isEmpty()) {
			stack.pop();
		}
		
		//Add input to stack and count open vs closed brackets
		for (int i = 0; i < input.length(); i++) {
			c = String.valueOf(input.charAt(i));
			stack.push(new Node(c));

			//Open bracket = +1
			if( c.equals("(") ) {
				bracketCount++;
			}
			if( c.equals("{") ) {
				curveBracketCount++;
			}
			
			//Closed bracket = -1
			if( c.equals(")") ) {
				bracketCount--;
			}
			if( c.equals("}") ) {
				curveBracketCount--;
			}
			
		}
		
		if (bracketCount != 0 || curveBracketCount != 0) {
			return false;
		} else {
			return true;
		}
	}
	
	//Reverse queue method
	public static MyQueue reverseQueue(MyQueue queue) {
		MyQueue queue2 = new MyQueue();

		//Copy node
		while (!queue.isEmpty()) {
			queue2.enqueue(new Node(queue.rear.data)); //add rear of queue to front of queue2
			
			if (queue.rear.next == null) { //only one element in queue
				queue.dequeue();
			} else {
				Node temp = queue.front;
				//Traverse to second last element
				while (temp.prev.prev != null) {
					temp = temp.prev;
				}
				temp.prev = null;  //remove last element
				queue.rear = temp; //second last is now rear
			}
		}
		
		//Print the reversed queue
		queue2.displayQueue();
		return queue2;
		
	}
	
}