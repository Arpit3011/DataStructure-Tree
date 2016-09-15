package edu.asu.tree;

import java.util.LinkedList;

public class CreateBST {
	public static void main(String[] args) {
		TreeNodeMethods treeNodeMethods = new TreeNodeMethods();
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27,
				28, 29, 30, 31, 32 };
		int length = arr.length;
		TreeNode root = createBinarySearchTree(arr, 0, length - 1);
		System.out.print("BFS Traversal: ");
		treeNodeMethods.breadthFirstSearch(root);
		System.out.print("\nInOrder Traversal: ");
		treeNodeMethods.inOrderTraversal(root);
		

	}

	public static TreeNode createBinarySearchTree(int[] arr, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = createBinarySearchTree(arr, start, mid - 1);
		root.right = createBinarySearchTree(arr, mid + 1, end);
		return root;
	}

}
