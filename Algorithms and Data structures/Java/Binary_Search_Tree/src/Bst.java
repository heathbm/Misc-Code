import java.awt.event.FocusAdapter;

import javax.swing.FocusManager;

public class Bst {

	Node root;
	
	Bst(){
		root = null;
	}
	
	public void insert(int key, String data) {
		
		Node newNode = new Node(key, data);
		if(root == null){
			root = newNode;
			return;
		}
		
		Node current = root;
		Node parent = null;
		
		while(true) {
			
			parent = current;
			if(key < current.getKey()) {				
				current = current.left;
				if(current == null) {
					parent.left = newNode;
					return;
				}
				
			} else if (key > current.getKey()) {
				
				current = current.right;
				if(current == null) {
					parent.right = newNode;
					return;
				}
				
			} else { // Stopped duplicate data
				break;
			}
		}
	}
	

	public boolean isKeyPresent(int key) {
		Node currentNode = root;
		
		while(currentNode != null) {
			if(key == currentNode.getKey()) {
				return true;
			} else if(key > currentNode.getKey()) {
				currentNode = currentNode.right;
			} else if(key < currentNode.getKey()) {
				currentNode = currentNode.left;
			}
		}
		
		return false;
	}
	
	public String getDataForKey(int key) {
		Node currentNode = root;
		
		while(currentNode != null) {
			if(key == currentNode.getKey()) {
				return currentNode.getData();
			} else if(key > currentNode.getKey()) {
				currentNode = currentNode.right;
			} else if(key < currentNode.getKey()) {
				currentNode = currentNode.left;
			}
		}
		
		return "KEY NOT FOUND";
	}
	
	public boolean deleteKey(int key) {
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		
		while(key != current.getKey()) {
			parent = current;
			if(key < current.getKey()) {
				isLeftChild = true;
				current = current.left;
			} else {
				isLeftChild = false;
				current = current.right;
			}
			
			if(current ==null){
				return false;
			}
		}
		
		//if i am here that means we have found the node
		//Case 1: if node to be deleted has no children
		
		if(current.left == null && current.right == null) {
			if(current == root) {
				root = null;
			}
			
			if(isLeftChild ==true){
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		
		//Case 2 : if node to be deleted has only one child
		else if(current.right == null) {
			if(current == root) {
				root = current.left;
			} else if(isLeftChild) {
				parent.left = current.left;
			} else { 
				parent.right = current.left;
			}
		}
		
		else if(current.left == null) {
			if(current == root){
				root = current.right;
			} else if(isLeftChild) {
				parent.left = current.right;
			} else{
				parent.right = current.right;
			}
			
		//Case 3 : if node has left and right children	
		} else if(current.left != null && current.right != null) {
			
			//now we have found the minimum element in the right sub tree
			Node successor = getSuccessor(current);
			if(current == root) {
				root = successor;
			} else if(isLeftChild) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;		
	}
	
	public Node getSuccessor(Node deleleNode) {
		Node successsor = null;
		Node successsorParent = null;
		Node current = deleleNode.right;
		
		while(current != null) {
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
		// successsorParent
		if(successsor != deleleNode.right) {
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}
	
	// Min and max keys and data
	
	public int getMin() {
		if(root == null) {
			return -1;
		}
		
		Node currentNode = root;
		
		while(currentNode.left != null) {
			currentNode = currentNode.left;
		}
		
		return currentNode.getKey();
	}
	
	public int getMax() {
		if(root == null) {
			return -1;
		}
		
		Node currentNode = root;
		
		while(currentNode.right != null) {
			currentNode = currentNode.right;
		}
		
		return currentNode.getKey();
	}
	
	// display order of data
	
	public void dataInOrder(){
		dataInOrder(root);
		System.out.println("");
	}
	
	private void dataInOrder(Node root) {
		if(root!=null) {
			dataInOrder(root.left);
			System.out.print(" " + root.getData());
			dataInOrder(root.right);
		}
	}
	
	public void dataPreOrder() {
		dataPreOrder(root);
		System.out.println("");
	}
	
	private void dataPreOrder(Node root) {
		if(root!=null) {
			System.out.print(" " + root.getData());
			dataPreOrder(root.left);
			dataPreOrder(root.right);
		}
	}
	
	public void dataPostOrder() {
		dataPostOrder(root);
		System.out.println("");
	}
	
	private void dataPostOrder(Node root) {
		if(root!=null) {
			dataPostOrder(root.left);
			dataPostOrder(root.right);
			System.out.print(" " + root.getData());
		}
	}
	
	// display order of keys
	
	public void keysInOrder(){
		keysInOrder(root);
		System.out.println("");
	}
	
	private void keysInOrder(Node root) {
		if(root!=null) {
			keysInOrder(root.left);
			System.out.print(" " + root.getKey());
			keysInOrder(root.right);
		}
	}
	
	public void keysPreOrder() {
		keysPreOrder(root);
		System.out.println("");
	}
	
	private void keysPreOrder(Node root) {
		if(root!=null) {
			System.out.print(" " + root.getKey());
			keysPreOrder(root.left);
			keysPreOrder(root.right);
		}
	}
	
	public void keysPostOrder() {
		keysPostOrder(root);
		System.out.println("");
	}
	
	private void keysPostOrder(Node root) {
		if(root!=null) {
			keysPostOrder(root.left);
			keysPostOrder(root.right);
			System.out.print(" " + root.getKey());
		}
	}
	
}

class Node {
	
	private int key;
	private String data;
	Node left;
	Node right;	
	
	Node(int key, String data){
		this.key = key;
		this.data = data;
		left = null;
		right = null;
	}
	
	public int getKey() {
		return key;
	}
	
	public String getData() {
		return data;
	}

}
