package aop;

public class Tree {
	Node root;
	
	private Node addRecursive(Node current, int value) {
	    if (current == null) {
	        return new Node(value);
	    }

	    if (value < current.value) {
	        current.left = addRecursive(current.left, value);
	    } else if (value > current.value) {
	        current.right = addRecursive(current.right, value);
	    } else {
	        // value already exists
	        return current;
	    }

	    return current;
	}
	
	public void add(int value) {
	    root = addRecursive(root, value);
	}
	
	private boolean containsNodeRecursive(Node current, int value) {
	    if (current == null) {
	        return false;
	    } 
	    if (value == current.value) {
	        return true;
	    } 
	    return value < current.value
	      ? containsNodeRecursive(current.left, value)
	      : containsNodeRecursive(current.right, value);
	}
	
	public boolean containsNode(int value) {
	    return containsNodeRecursive(root, value);
	}
	
	public void traverseInOrder(Node node) {
	    if (node != null) {
	        traverseInOrder(node.left);
	        System.out.print(" " + node.value);
	        traverseInOrder(node.right);
	    }
	}
	
	public String getInOrder(Node node) {
		String elements = "";
	    if (node != null) {
	        traverseInOrder(node.left);
	        elements += " " + node.value;
	        traverseInOrder(node.right);
	    }
	    return elements;
	}
	
	public String toString() {
		return getInOrder(root) + "\n";
	}
	

}


class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
    
    public String toString() {
    	return value + "\n";
    }
}