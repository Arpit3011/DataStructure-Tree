package edu.asu.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeMethods {

	private TreeNode root;

	public int heightOfTree(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
	}

	public TreeNode insert(int data) {
		TreeNode newNode = new TreeNode(data);

		if (root == null) {
			root = newNode;
			return root;
		}

		TreeNode current = root;
		TreeNode parent;
		while (true) {
			parent = current;
			if (newNode.data > current.data) {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return root;
				}
			} else if (newNode.data < current.data) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return root;
				}
			}
		}
	}

	public TreeNode deleteNode(int data, TreeNode root) {

		boolean isLeftChild = true; // check which side of parent node.
		TreeNode current, parent = null;
		current = root;

		while (current.data != data) {
			parent = current;
			if (current.data < data) {
				current = current.right;
				isLeftChild = false;
			} else {
				
				current = current.left;
				isLeftChild = true;
			}
			if (current == null) // Item Not found.
				return null;
		}
		// if deleteNode has no child
		if (current.left == null && current.right == null) {
			if (current == root) // If it is a root node.
				root = null;
			else if (isLeftChild)
				parent.left = null;
			else
				parent.right = null;
		}

		// if deleteNode has no left child.
		else if (current.left == null) {
			if (current == root)
				root = current.right;
			else if (isLeftChild)
				parent.left = current.right;
			else
				parent.right = current.right;
		}

		// if deleteNode has no right child.
		else if (current.right == null) {
			if (current == root)
				root = current.left;
			else if (isLeftChild)
				parent.left = current.left;
			else
				parent.right = current.left;
		}
		// find successor and connect it to parent - deleteNode has 2 children.
		else {
			TreeNode successor = findSuccessor(current);
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.left = successor;
			else
				parent.right = successor;

			// succesor to left child
			successor.left = current.left;
		}
		return root;

	}

	public TreeNode findSuccessor(TreeNode delNode) {
		TreeNode successorParent = delNode;
		TreeNode successor = delNode;
		TreeNode current = delNode.right;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.left;
		}

		if (successor != delNode.right) {
			successorParent.left = successor.right;
			successor.right = delNode.right;
		}
		return successor;

	}

	public TreeNode minTreeNode(TreeNode root) {
		TreeNode current = root;
		TreeNode last = null;
		if (root == null)
			return null;
		if (root.left == null)
			return root;

		while (current != null) {
			last = current;
			current = current.left;
		}
		return last;
	}

	public TreeNode maxTreeNode(TreeNode root) {
		TreeNode current = root;
		TreeNode last = null;
		if (root == null)
			return null;
		if (root.right == null)
			return root;

		while (current != null) {
			last = current;
			current = current.right;
		}
		return last;
	}

	public boolean search(int data, TreeNode root) {
		if (root == null)
			return false;

		if (root.data == data)
			return true;
		else if (data > root.data)
			return search(data, root.left);
		else
			return search(data, root.right);
	}

	public void inOrderTraversal(TreeNode root) {
		if (root != null) {
			inOrderTraversal(root.left);
			displayNode(root);
			inOrderTraversal(root.right);
		}
	}

	public void preOrderTraversal(TreeNode root) {
		if (root != null) {
			displayNode(root);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	public void postOrderTraversal(TreeNode root) {
		if (root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			displayNode(root);
		}
	}

	public void breadthFirstSearch(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode current = root;
		if (root == null)
			return;

		queue.add(current);
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			displayNode(node);

			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

	public void displayNode(TreeNode root) {
		System.out.print("[" + root.data + "]");
	}

//	public boolean delete(int data, TreeNode root) {
//		Boolean isLeft = true;
//		TreeNode delNode = null;
//
//		if (root.data == data)
//			root = null;
//
//		TreeNode nodeToFindParent = searchForDeletion(data, root);
//		if (nodeToFindParent == null)
//			return false;
//
//		if (nodeToFindParent.left.data == data) {
//			isLeft = true;
//			delNode = nodeToFindParent.left;
//			if (delNode.left == null && delNode.right == null)
//				nodeToFindParent.left = null;
//
//		} else {
//			isLeft = false;
//			delNode = nodeToFindParent.right;
//			if (delNode.left == null && delNode.right == null)
//				nodeToFindParent.right = null;
//		}
//
//		if (delNode.left == null) {
//			if (isLeft)
//				nodeToFindParent.left = delNode.right;
//			else
//				nodeToFindParent.right = delNode.right;
//
//		}
//
//		return false;
//
//	}
//
//	public TreeNode searchForDeletion(int data, TreeNode root) {
//		// Boolean isLeftChild = true;
//		if (root == null)
//			return null;
//
//		TreeNode current = root;
//		TreeNode parent = null;
//
//		while (current.data != data) {
//			parent = current;
//			if (current.data < data) {
//				current = current.right;
//				// isLeftChild = false;
//			} else {
//				current = current.left;
//				// isLeftChild = true;
//			}
//			if (current == null)
//				return null;
//		}
//		return parent;
//	}

}
