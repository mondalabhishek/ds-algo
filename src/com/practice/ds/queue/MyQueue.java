package com.practice.ds.queue;

import java.util.function.Consumer;

public class MyQueue {
	private QueueNode last;
	private QueueNode first;
	private int length;

	public class QueueNode {
		private String value;
		private QueueNode next;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public QueueNode getNext() {
			return next;
		}

		public void setNext(QueueNode next) {
			this.next = next;
		}

		public QueueNode(String value) {
			this.value = value;
		}

	}

	public MyQueue(String value) {
		QueueNode node = new QueueNode(value);
		this.last = node;
		this.first = node;
		length++;
	}

	public void enqueue(String value) {
		QueueNode node = new QueueNode(value);
		this.getLast().setNext(node);
		this.setLast(node);		
		length++;
	}

	public String dequeue() {
		String value = this.getFirst().getValue();
		this.setFirst(this.getFirst().getNext());
		length--;
		return value;
	}
	
	public QueueNode getLast() {
		return last;
	}

	public void setLast(QueueNode last) {
		this.last = last;
	}

	public QueueNode getFirst() {
		return first;
	}

	public void setFirst(QueueNode first) {
		this.first = first;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String peek() {
		String value = this.getFirst().getValue();
		return value;
	}

	private static Consumer<MyQueue> dequeueAndPrint = queue -> {
		while(queue.length>0) {
			System.out.println("Dequeing item now:: "+queue.peek());
			queue.dequeue();
		}		
	};
	


	public static void main(String[] args) {

		MyQueue myQueue = new MyQueue("10");
		myQueue.enqueue("12");
		myQueue.enqueue("4");
		myQueue.enqueue("3");
		myQueue.enqueue("9");
		
		dequeueAndPrint.accept(myQueue);

	}

}
