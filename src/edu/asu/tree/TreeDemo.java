package edu.asu.tree;

public class TreeDemo {

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

		// Tree Traversal
		System.out.print("InOrder Traversal: ");
		treeNodeMethods.inOrderTraversal(root);
		System.out.print("\nPreOrder Traversal: ");
		treeNodeMethods.preOrderTraversal(root);
		System.out.print("\nPostOrder Traversal: ");
		treeNodeMethods.postOrderTraversal(root);
		System.out.print("\nBFS Traversal: ");
		treeNodeMethods.breadthFirstSearch(root);

		System.out.println("\nHeight of Tree is: " + treeNodeMethods.heightOfTree(root));

		// Min and Max Nodes
		TreeNode minTreeNode = treeNodeMethods.minTreeNode(root);
		TreeNode maxTreeNode = treeNodeMethods.maxTreeNode(root);
		if (minTreeNode == null)
			System.out.print("No Element in the Tree");
		else
			System.out.print("\nMinimum Element: " + minTreeNode.data + " Maximum Element: " + maxTreeNode.data);

		// Search Node.
		if (treeNodeMethods.search(4, root))
			System.out.println("Search Complete: 4");

		// searching parent of given Node.
		// TreeNode search = treeNodeMethods.searchForDeletion(4, root);
		// System.out.println("\nSearch Complete returning Parent: " +
		// search.data);

		// delete Nodes and finding successor.
		System.out.println("Finding Successor of root: " + treeNodeMethods.findSuccessor(root).data);
		TreeNode delNode = treeNodeMethods.deleteNode(6, root);
		System.out.print("Tree After Deletion: ");
		treeNodeMethods.breadthFirstSearch(delNode);

		// height of tree
		System.out.println("\nHeight of Tree is: " + treeNodeMethods.heightOfTree(delNode));
	}

}
