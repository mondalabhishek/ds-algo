package com.practice.test.stack.queue;

import java.util.function.Consumer;

import com.practice.test.stack.MyStack;

/**
 * Implementation of Queue using two stack
 * @author Abhishek Mondal
 *
 */
public class QueueUsingStack {
	
	private  MyStack firstStack= new MyStack();	
	private MyStack lastStack= new MyStack();
	
	private int queueLength;
	
	public void enqueue(String value) {
		final int length=firstStack.getLength();
		for(int i=0;i<length;i++) {
			lastStack.push(firstStack.pop());
		}
		lastStack.push(value);
		
		queueLength++;
				
	}

	public String dequeue() {
		final int length=lastStack.getLength();
		for(int i=0;i<length;i++) {
			firstStack.push(lastStack.pop());
		}
		
		queueLength--;
		return firstStack.pop();
	}
	
	public int getLength() {
		return queueLength;
	}
	
	public String peek() {
		final int length=lastStack.getLength();
		for(int i=0;i<length;i++) {
			firstStack.push(lastStack.pop());
		}
		return firstStack.peek();
	}
	
	private static Consumer<QueueUsingStack> dequeueAndPrint = queue -> {
		while(queue.getLength()>0) {
			System.out.println("Dequeing item now:: "+queue.peek());
			queue.dequeue();
		}		
	};

	public static void main(String[] args) {
		QueueUsingStack myQueue = new QueueUsingStack();
		myQueue.enqueue("12");
		myQueue.enqueue("4");
		myQueue.enqueue("3");
		myQueue.enqueue("9");
		
		dequeueAndPrint.accept(myQueue);
	}

}
