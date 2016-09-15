package edu.asu.tree;

public class LeastCommonAncestor {
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
		
		TreeNode anchestor = commonAncestor(root, 1, 5);
		if (anchestor != null)
			System.out.println("Least Common Ancestor is: " + anchestor.data);
		else
			System.out.println("Value Entered is not in tree ");

	}

	public static boolean isInTree(TreeNode root, int data) {
		if (root == null)
			return false;
		if (root.data == data)
			return true;
		return isInTree(root.left, data) || isInTree(root.right, data);
	}

	public static TreeNode commonAncestor(TreeNode root, int data1, int data2) {
		if (root == null)
			return null;
		
		if (isInTree(root, data1) && isInTree(root, data2)) {
			if (root.data == data1 || root.data == data2)
				return root;

			boolean data1IsOnLeft = isInTree(root.left, data1);
			boolean data2IsOnLeft = isInTree(root.left, data2);

			if (data1IsOnLeft != data2IsOnLeft)
				return root;

			TreeNode tempNode;
			if (data1IsOnLeft)
				tempNode = root.left;
			else
				tempNode = root.right;

			return commonAncestor(tempNode, data1, data2);
		} else
			return null;
	}

}
