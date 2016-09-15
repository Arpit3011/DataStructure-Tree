package edu.asu.tree;

public class CheckBalanceTree {
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
		if (checkBalance2(root))
			System.out.println("Tree is a balance Binary Tree.");
		else
			System.out.println("Tree is not a balance Binary Tree.");
	}

	public static int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		else
			return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	public static boolean checkBalance1(TreeNode root) {
		if (root == null)
			return true;
		int heightDiff = (getHeight(root.left) - getHeight(root.right));
		if (Math.abs(heightDiff) > 1)
			return false;
		else
			return checkBalance1(root.left) && checkBalance1(root.right);
	}

	public static int getHeight2(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = getHeight2(root.left);
		if (leftHeight == -1)
			return -1;
		int rightHeight = getHeight2(root.right);
		if (rightHeight == -1)
			return -1;

		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1)
			return -1;
		else
			return Math.max(getHeight2(root.left), getHeight2(root.right)) + 1;
	}

	public static boolean checkBalance2(TreeNode root) {
		if (getHeight2(root) == -1)
			return false;
		else
			return true;
	}

}
