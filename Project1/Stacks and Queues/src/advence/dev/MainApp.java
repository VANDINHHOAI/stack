package advence.dev;

import java.util.Stack;

public class MainApp {
	
	public static int countElements (Stack stack) {
		return stack.size();
	}
	
	public static Object getNthElement(Stack stack, int n) {
		if (n < 1 || n > stack.size()) {
			throw new IndexOutOfBoundsException("Invalid index: " + n);
		}
		
		Stack temp = new Stack();
		
		for (int i = 0; i < n - 1; i++) {
			temp.push(stack.pop());
		}
		
		Object result = stack.peek();
		while(!temp.isEmpty()) {
			stack.push(temp.pop());
		}
		return result;
	}
	
	public static void printStack(Stack stack) {
		System.out.println("Stack content: " + stack);
	}
	
	public static void removeNthElement(Stack stack, int n) {
		if (n < 1 || n > stack.size() ) {
			throw new IndexOutOfBoundsException("Invalid index: " + n);
		}
		
		Stack temp = new Stack();
		for (int i = 0; i < n - 1; i++) {
			temp.push(stack.pop());
		}
		stack.pop();
		while(!temp.isEmpty()) {
			stack.push(temp.pop());
		}
	}
	
	public static Stack<Integer> reverseStack(Stack<Integer> stack) {
		Stack<Integer> reversedStack = new Stack<Integer>();
		while (!stack.isEmpty()) {
			int element = stack.pop();
			reversedStack.push(element);
		}
		
		return reversedStack;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <= 5 ; i++) {
			stack.push(i);
		}
		
		int count = countElements(stack);
		System.out.println("Stack size: " + count);
		
		Object nthElement = getNthElement(stack, 3);
		System.out.println("3rd element: " + nthElement);
		
		printStack(stack);
		
		removeNthElement(stack, 4);
		printStack(stack);
		
		System.out.println("Original stack: " + stack);
		Stack<Integer> reversedStack = reverseStack(stack);
		System.out.println("Reversed stack: " + reversedStack);
	}
	
	
}
