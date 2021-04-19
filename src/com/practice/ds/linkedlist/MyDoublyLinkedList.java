package com.practice.ds.linkedlist;

import java.util.function.Consumer;

/**
 * Implementation of Doubly linked list
 * @author Abhishek Mondal
 *
 */
public class MyDoublyLinkedList {
	public MyDoublyLinkedList(String value) {
		DoublyLinkedNode node = new DoublyLinkedNode(value);
		this.head = node;
		this.tail=node;
	}

	public DoublyLinkedNode getHead() {
		return head;
	}

	public void setHead(DoublyLinkedNode head) {
		this.head = head;
	}

	public DoublyLinkedNode getTail() {
		return tail;
	}

	public void setTail(DoublyLinkedNode tail) {
		this.tail = tail;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	private DoublyLinkedNode head;
	private DoublyLinkedNode tail;
	int length;

	public class DoublyLinkedNode {
		String value;
		DoublyLinkedNode next;
		DoublyLinkedNode prev;

		public DoublyLinkedNode(String value) {
			this.value = value;
			length++;
		}

		public DoublyLinkedNode() {

		}

		public DoublyLinkedNode getNext() {
			return next;
		}

		public void setNext(DoublyLinkedNode next) {
			this.next = next;
		}

		public DoublyLinkedNode getPrev() {
			return prev;
		}

		public void setPrev(DoublyLinkedNode prev) {
			this.prev = prev;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}
	
	public void append(String value) {
		DoublyLinkedNode newNode = new DoublyLinkedNode();
		newNode.setValue(value);
		this.getHead().setPrev(newNode);
		newNode.setNext(this.getHead());
		this.setHead(newNode);

		length++;
	}

	public void prepend(String value) {
		DoublyLinkedNode newNode = new DoublyLinkedNode();
		newNode.setValue(value);
		this.getTail().setNext(newNode);
		newNode.setPrev(this.getTail());
		this.setTail(newNode);
		length++;
	}

	// Insert a new node at a target index
	public void insert(String value, int idx) {
		if (idx == 0) {
			prepend(value);
		} else if (length > 1 && idx < length) {
			DoublyLinkedNode newNode = new DoublyLinkedNode();
			newNode.setValue(value);

			DoublyLinkedNode item = this.getHead();
			int count = 1;
			while (item != null) {
				if (count == idx) {
					newNode.setNext(item.getNext());
					item.getNext().setPrev(newNode);
					item.setNext(newNode);
					newNode.setPrev(item);
					
					length++;
					break;
				}
				item = item.getNext();
				count++;
			}

		} else {
			throw new RuntimeException("Index not found");
		}
	}

	// Remove item at target index
	public void remove(int idx) {
		DoublyLinkedNode item = this.getHead();
		if (idx == 0) {
			this.setHead(item.getNext());
			item.getNext().setPrev(null);
			length--;
			return;
		}
		int count = 1;
		while (item != null && count < length) {
			if (count == idx) {
				if(item.getNext().getNext()==null) {
					this.setTail(item);
				}
								
				item.getNext().getNext().setPrev(item);
				item.setNext(item.getNext().getNext());
				length--;
				break;
			}
			item = item.getNext();
			count++;
		}
	}

	private static Consumer<MyDoublyLinkedList> printLinkedList = myLinkedList -> {
		System.out.println("Length of the Linked List: " + myLinkedList.length);

		System.out.println("Printing List Items:");

		MyDoublyLinkedList.DoublyLinkedNode item = myLinkedList.getHead();
		System.out.print(item.getValue());
		while (item.getNext() != null) {
			item = item.getNext();
			System.out.print(" >> " + item.getValue());
		}
		System.out.print(" \n\n");
	};

	private static Consumer<MyDoublyLinkedList> printLinkedListReverse = myLinkedList -> {
		System.out.println("Length of the Linked List: " + myLinkedList.length);

		System.out.println("Printing List Items in Reverese:");

		MyDoublyLinkedList.DoublyLinkedNode item = myLinkedList.getTail();
		System.out.print(item.getValue());
		while (item.getPrev() != null) {
			item = item.getPrev();
			System.out.print(" >> " + item.getValue());
		}
		System.out.print(" \n\n");
	};

	public static void main(String[] args) {
		MyDoublyLinkedList myLinkedList = new MyDoublyLinkedList("10");
		myLinkedList.append("11");
		myLinkedList.prepend("9");
		myLinkedList.prepend("5");
		myLinkedList.append("15");
		printLinkedList.accept(myLinkedList);
		printLinkedListReverse.accept(myLinkedList);

		System.out.println("Inserting 1@3");
		myLinkedList.insert("1", 3);
		printLinkedList.accept(myLinkedList);
		printLinkedListReverse.accept(myLinkedList);

		System.out.println("Removing @4");
		myLinkedList.remove(4);
		printLinkedList.accept(myLinkedList);
		printLinkedListReverse.accept(myLinkedList);
	}

}
