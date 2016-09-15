package edu.asu.tree;

public class SwapNodes {
	public static void main(String[] args) {
		TreeNode root = null;
		TreeNodeMethods treeNodeMethods = new TreeNodeMethods();
		root = treeNodeMethods.insert(6);
		root = treeNodeMethods.insert(2);
		root = treeNodeMethods.insert(7);
		root = treeNodeMethods.insert(1);
		root = treeNodeMethods.insert(4);
		root = treeNodeMethods.insert(9);
		root = treeNodeMethods.insert(3);
		root = treeNodeMethods.insert(8);
		root = treeNodeMethods.insert(5);
		System.out.print("InOrder Traversal: ");
		treeNodeMethods.inOrderTraversal(root);
		System.out.print("\nBFS Traversal: ");
		treeNodeMethods.breadthFirstSearch(root);
		swapTreeNodes(root, 1, 1);
		System.out.print("\nInOrder Traversal: ");
		treeNodeMethods.inOrderTraversal(root);
		System.out.print("\nBFS Traversal: ");
		treeNodeMethods.breadthFirstSearch(root);
	}
	public static void swapTreeNodes(TreeNode root, int targetDepth, int depth) {
		if (root == null)
			return;
		
		if(depth % targetDepth == 0){
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		swapTreeNodes(root.left, targetDepth, depth+1);
		swapTreeNodes(root.right, targetDepth, depth+1);
	}
}
