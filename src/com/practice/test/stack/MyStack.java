package com.practice.test.stack;

import java.util.function.Consumer;

/**
 * Implementaion of stack
 * @author Abhishek Mondal
 *
 */
public class MyStack {
	private StackNode top;
	private StackNode bottom;
	private int length;
	
	
	public StackNode getTop() {
		return top;
	}

	public void setTop(StackNode top) {
		this.top = top;
	}

	public StackNode getBottom() {
		return bottom;
	}

	public void setBottom(StackNode bottom) {
		this.bottom = bottom;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	

	public class StackNode {
		private String value;
		private StackNode next;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public StackNode getNext() {
			return next;
		}

		public void setNext(StackNode next) {
			this.next = next;
		}

		public StackNode(String value) {
			this.value = value;
		}

	}


	public void push(String value) {
		StackNode node = new StackNode(value);
		node.next = this.top;
		this.top = node;
		length++;
	}

	public String pop() {
		String value = this.top.getValue();
		this.top = this.top.getNext();
		length--;
		return value;
	}
	
	public String peek() {
		return this.top.getValue();
	}

	private static Consumer<MyStack> popAndPrint = stack -> {
		while(stack.length>0) {
			System.out.println("Popping item now:: "+stack.peek());
			stack.pop();
		}		
	};
	


	public static void main(String[] args) {

		MyStack myStack = new MyStack();
		myStack.push("12");
		myStack.push("4");
		myStack.push("3");
		myStack.push("9");

		popAndPrint.accept(myStack);

	}

}
