package com.practice.ds.tree;

import java.util.function.BiPredicate;

/**
 * This is an Implementation of Binary Search Tree.
 * @author Abhishek Mondal
 *
 */
public class MyBinarySearchTree {

	private Node root;

	/**
	 * Node Class for BST
	 * @author Abhishek Mondal
	 *
	 */
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

	/**
	 * Insert a value with node in BST
	 * 
	 * @param value
	 */
	public void insert(Integer value) {
		Node currentNode = this.root;
		Node parentNode = traverse(value, currentNode);
		Node newNode = new Node(value);
		if (parentNode.getValue().compareTo(value) != 0) {
			if (isGreater.test(value, parentNode)) {
				parentNode.setRight(newNode);
			} else {
				parentNode.setLeft(newNode);
			}
			newNode.setParent(parentNode);
		} else {
			System.out.println("Existing Node found for value: " + value);
		}
	}

	/**
	 * Remove a node with Target value from BST
	 * 
	 * @param value
	 */
	public void remove(Integer value) {
		// Traverse and find Target node
		Node nodeToBeDeleted = traverse(value, this.root);

		
		if (nodeToBeDeleted.getValue().compareTo(value) == 0) {
			// Node to be Deleted Found, check for predecessor
			Node replacementNode = findReplacementNode(nodeToBeDeleted);
			
			
			//update Children of NodeToBeDeleted's Parent 
			if (nodeToBeDeleted.getParent() != null && nodeToBeDeleted.getParent().getLeft().getValue().equals(value)) {
				nodeToBeDeleted.getParent().setLeft(replacementNode);
			} else if (nodeToBeDeleted.getParent() != null) {
				nodeToBeDeleted.getParent().setRight(replacementNode);
			}
			
			//If replacement node found/means NodeToBeDeleted is not leaf node
			if (replacementNode != null) {							
				// is the replacementNode is first right child of the NodeToBeDeleted  node
				if (nodeToBeDeleted.getRight()!=null && isSameNode.test(nodeToBeDeleted.getRight(), replacementNode)) {
					replacementNode.setLeft(nodeToBeDeleted.getLeft());
				} else {
					replacementNode.getParent().setLeft(replacementNode.getRight());
					//First update parent of existing child of replacement node
					if(replacementNode.getRight()!=null) {
						replacementNode.getRight().setParent(replacementNode.getParent());
					}
					
					//update children from replacement node
					replacementNode.setRight(nodeToBeDeleted.getRight());
					replacementNode.setLeft(nodeToBeDeleted.getLeft());
				}
				
				//update parent on replacement node and it's children
				replacementNode.setParent(nodeToBeDeleted.getParent());
				if(replacementNode.getRight()!=null) {
					replacementNode.getRight().setParent(replacementNode);
				}
				if(replacementNode.getLeft()!=null) {
					replacementNode.getLeft().setParent(replacementNode);
				}
				
				//id no new parent of replacementNode, then set it root
				if (replacementNode.getParent() == null) {
					this.root = replacementNode;
				}
			}
		} else {
			System.err.println("Node doesn't exist with value:: " + value);
		}
	}
	
	
	/**
	 * Compare id two nodes are same
	 */
	private BiPredicate<Node, Node> isSameNode = (node1, node2) -> node1.getValue().compareTo(node2.getValue()) == 0;

	/**
	 * Find the replacement node for deletion
	 * 
	 * @param node
	 * @return
	 */
	public Node findReplacementNode(Node node) {
		if (node.getLeft() == null && node.getRight() == null) {
			// Leaf Node
			return null;
		} else if (node.getLeft() != null && node.getRight() != null) {
			// Both Child Exist
			// go right, then go extreme left
			Node currentNode = node.getRight();
			currentNode = lookupForLeftMostNode(currentNode);
			return currentNode;
		} else if (node.getLeft() != null) {
			// No right Child, left child node exist, go to extreme left
			return lookupForLeftMostNode(node.getLeft());
		} else {
			// No left Child, return the right node
			return node.getRight();
		}
	}

	public Node lookupForLeftMostNode(Node node) {
		if (node.getLeft() == null) {
			return node;
		} else {
			return lookupForLeftMostNode(node.getLeft());
		}
	}

	public void lookup(Integer value) {
		Node node = traverse(value, this.root);
		System.out.println(node.getValue().compareTo(value) == 0 ? "Node found for value: " + value
				: "Node not found for value: " + value);
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
				return currentNode;
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

	
	/**
	 * Print the Nodes of tree
	 * @param node
	 */
	private static void printTreeNodes(Node node) {
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

			printTreeNodes(node.getLeft());
			printTreeNodes(node.getRight());
		}

	}

	public static void main(String[] args) {
		MyBinarySearchTree bst = new MyBinarySearchTree(25);
		bst.insert(15);
		bst.insert(40);
		bst.insert(20);
		bst.insert(10);
		bst.insert(5);
		bst.insert(12);
		bst.insert(24);
		bst.insert(18);
		bst.insert(35);
		bst.insert(28);
		bst.insert(26);
		bst.insert(27);
		bst.insert(50);
		bst.insert(55);

		printTreeNodes(bst.getRoot());
		bst.lookup(17);
		bst.lookup(20);
		bst.lookup(12);
		bst.lookup(11);

		// Remove and print
		System.out.println("\n\nRemoving -- 25\n\n");
		bst.remove(25);
		System.out.println("Updated tree.................");
		printTreeNodes(bst.getRoot());
		
		
		System.out.println("\n\nRemoving -- 15\n\n");
		bst.remove(15);
		System.out.println("Updated tree.................");
		printTreeNodes(bst.getRoot());
	}

	private Node getRoot() {
		return this.root;
	}

}
