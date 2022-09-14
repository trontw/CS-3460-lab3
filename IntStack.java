import java.util.NoSuchElementException;

public class IntStack {
	// May create private data here. 
	private static Node head;
	private static Node cur;
	private static Node prev;
	private static Node temp;
	private static int count;  //size of stack counter


	public IntStack() {
		// TODO: Code to initialize your stack.
		head = null;
		cur = null;
		prev = null; 
		temp = null;
		count = 0;
	}

	public void push(int x) {
		// TODO: Code to push an item x onto the stack. 
		//The stack will never contain more than 100 elements.
		if (count <= 100) {
			head = new Node(x, head);
			count++;
			}
		}

	public int pop() {
		// TODO: Code to pop and retrun an item from the top 
		// of the stack. If the stack is empty, throw an Exception Error.
		if (head != null) {
			int object = head.object;
			head = head.next;
			count--;//decrement counter
			return object;
		} else {
			throw new NoSuchElementException("Stack Underflow Detected");
		}
	}

	public boolean isEmpty() {
		if (head != null) {
			return false;
		} 
		return true;
	}
} 
