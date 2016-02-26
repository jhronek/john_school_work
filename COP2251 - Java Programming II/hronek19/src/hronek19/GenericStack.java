/* John Hronek															*/
/* COP2251																*/
/* Chapter 19: 19.1 													*/

// This program Revised the GenericStack class in Listing 19.1 to implement
// it using an array rather than an ArrayList.  Because arrays are immutable
// when the program first checks to see if the array is full and then creates
// a separate temporary array that to increase or decrease the size of the
// current array.

package hronek19;

public class GenericStack<E> {

	@SuppressWarnings("unchecked")
	private E[] stack = (E[])new Object[1];
	
	/** This method returns the length of the array*/
	public int getSize() {
		return stack.length;
	}
	
	/** This method returns the value in the final position of the array*/
	public E peek() {
		return stack[this.getSize() - 1];
	}
	
	/** This method creates a temporary array that is bigger than the current array
	 * 	to increase the size of the array.*/
	@SuppressWarnings("unchecked")
	public void push(E o) {
		E[] addToStack = (E[])new Object[(this.getSize() + 1)];
		boolean hasNull = false;
		for (int a = 0; a < this.getSize(); a++) {
			if (stack[a] == null) {
				stack[a] = o;
				hasNull = true;
			}
			else if (hasNull == false){
				for (int b = 0; b < addToStack.length; b++) {
					if (b < stack.length) {
						addToStack[b] = stack[b];
						if (addToStack[b] == null) {
							addToStack[b] = o;
							break;
						}
					}	
				}
				this.stack = addToStack;
			}
		}
	}	
	
	/** This method creates a temporary array that is smaller than the current array to
	 * 	remove the final value from the current array to shrink the size.*/
	@SuppressWarnings("unchecked")
	public void pop() {
		E[] removeFromStack = (E[])new Object[(this.getSize() - 1)];
		for (int i = 0; i < removeFromStack.length; i++) {
			removeFromStack[i] = stack[i];
		}
		this.stack = removeFromStack;
	}
	
	/** This method checks if the array is empty */
	public boolean isEmpty() {
		boolean isNull = true;
		for (int i = 0; i < this.getSize(); i++) {
			if (!((this.stack[i]) == null)) {
				isNull = false;
			}
		}
		return isNull;
	}
	
	/** This method creates a StringBuilder to append and store the values of the array
	 * 	and returns them as a string. */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Items in stack:");
		for (int i = 0; i < this.getSize(); i++) {
			string.append(" ");
			string.append(this.stack[i]);
		}
		return string.toString();
	}
}
