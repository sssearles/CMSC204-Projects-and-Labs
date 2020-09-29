
import java.util.ArrayList;

/**
 * Generic stack data structure implementation
 * CMSC 204 with Professor Alexander
 * Due September 30, 2020
 * @author Susan Searles
 * @param <T> generic data type
 */
public class NotationStack<T> implements StackInterface<T> {

	private ArrayList<T> stack;				// Data structure that serves as the stack
	private int size;						// Holds the maximum size of the stack.

	/**
	 * No-arg constructor with default values for the data fields.
	 */
	public NotationStack() {
		stack = new ArrayList<T>(1000);
		size = 1000;
	}
	
	/**
	 * Single-arg constructor to instantiate the stack and set the size value
	 * @param size maximum size of the stack
	 */
	public NotationStack(int size) {
		stack = new ArrayList<T>(size);
		this.size = size;
	}
	
	/**
	 * This method determines if the stack is empty
	 * @return true if empty and false if not.
	 */
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	/**
	 * This method determines if the stack is full
	 * @return true if full and false if not
	 */
	@Override
	public boolean isFull() {
		return stack.size() == size;
	}

	/**
	 * This method removes the element at the top of the stack
	 * and returns it.
	 * @return the element at the top of the stack
	 */
	@Override
	public T pop() throws StackUnderflowException {
		if (!isEmpty()) {
			T e = stack.get(size()-1);
			stack.remove(size()-1);
			return e;
		}
		else {
			throw new StackUnderflowException();
		}
	}

	/**
	 * This method returns the element at the top of the stack
	 * but does not pop it off. It operates it the same as a 
	 * peek() method would.
	 * @return the top element on the stack
	 */
	@Override
	public T top() throws StackUnderflowException{
		if (!isEmpty()) {
			T e = stack.get(size()-1);
			return e;
		}
		else {
			throw new StackUnderflowException();
		}
	}

	/**
	 * This method adds an element to the stack as long as the
	 * stack is not full. If the stack is full, it throws a
	 * StackOverflowException.
	 */
	@Override
	public int size() {
		return stack.size();
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
		if (!isFull()) {
			return stack.add(e);
		}else {
		throw new StackOverflowException();
		}
	}

	/**
	 * Returns the elements of the Stack in a string from bottom to top. 
	 * The beginning of the String is the bottom of the stack
	 * @return a string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {
		String stackString = "";
		for (T e: stack) {
			stackString = stackString +e;
		}
		return stackString;
}
	
	/**
	 * Returns the string representation of the elements in the Stack and places the 
	 * delimiter between all elements of the Stack. The beginning of the 
	 * string is the bottom of the stack. 
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String stackString = "";
		for (T e: stack) {
			stackString = stackString + e + delimiter;
		}
		return stackString.substring(0, stackString.length()-1);
	}

	 /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  */
	@Override
	public void fill(ArrayList<T> list) throws StackOverflowException{
		for (T e : list) {
			push(e);
		}
		
	}

}
