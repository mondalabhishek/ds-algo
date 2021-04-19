package com.practice.ds.tree;

import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class MyBinarySearchTree {

	private Node root;

	public class Node {
		private Node parent;
		private Node left;
		private Node right;
		private Integer value;

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public Node(Integer value) {
			this.value = value;
		}
	}

	public MyBinarySearchTree(Integer value) {
		root = new Node(value);
	}

	public void insert(Integer value) {
		Node currentNode = this.root;
		Node parentNode = traverse(value, currentNode);
		Node newNode = new Node(value);
		if(parentNode!=null) {
			if (isGreater.test(value, parentNode)) {
				parentNode.setRight(newNode);
			} else {
				parentNode.setLeft(newNode);
			}
		}else {
			System.out.println("Existing Node found for value: "+value);
		}
	}

	public void lookup(Integer value) {
		Node node = traverse(value, this.root);
		System.out.println(node==null? "Node found for value: "+value:"Node not found for value: "+value);
	}

	private Node traverse(Integer value, Node currentNode) {

		if (isGreater.test(value, currentNode)) {
			if (currentNode.getRight() == null) {
				return currentNode;
			} else {
				return traverse(value, currentNode.getRight());
			}
		} else {
			if (currentNode.getValue().compareTo(value) == 0) {
				return null;
			}
			if (currentNode.getLeft() == null) {				
				return currentNode;
			} else {
				return traverse(value, currentNode.getLeft());
			}
		}
	}

	private BiPredicate<Integer, Node> isGreater = (value, node) -> {
		return (value.compareTo(node.getValue()) == 1);
	};

	private static void printBST(Node node) {
		if (node != null) {
			if (node.getLeft() != null || node.getRight() != null) {
				System.out.println("Parent:: " + node.getValue());
			}

			if (node.getLeft() != null) {
				System.err.println("Child(LEFT):: " + node.getLeft().getValue());

			}
			if (node.getRight() != null) {
				System.err.println("Child(RIGHT):: " + node.getRight().getValue());
			}

			printBST(node.getLeft());
			printBST(node.getRight());
		}

	}

	public static void main(String[] args) {
		MyBinarySearchTree bst = new MyBinarySearchTree(20);
		bst.insert(15);
		bst.insert(21);
		bst.insert(10);
		bst.insert(17);
		bst.insert(24);
		bst.insert(25);
		bst.insert(24);

		printBST(bst.getRoot());
		bst.lookup(17);
		bst.lookup(10);
		bst.lookup(21);
		bst.lookup(11);
	}

	private Node getRoot() {
		return this.root;
	}

}
