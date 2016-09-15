package edu.asu.tree;

public class TreeTopView {
	static TreeNodeMethods treeNodeMethods = new TreeNodeMethods();

	public static void main(String[] args) {
		TreeNode root = null;
		root = treeNodeMethods.insert(6);
		root = treeNodeMethods.insert(2);
		root = treeNodeMethods.insert(7);
		root = treeNodeMethods.insert(1);
		root = treeNodeMethods.insert(4);
		root = treeNodeMethods.insert(9);
		root = treeNodeMethods.insert(3);
		root = treeNodeMethods.insert(8);
		root = treeNodeMethods.insert(5);
		
		System.out.print("Display Top View: ");
		displayTopView(root);
	}
	
	public static void displayTopView(TreeNode root){
		if(root != null)
		{
			displayLeft(root.left);
			treeNodeMethods.displayNode(root);
			displayRight(root.right);
			
		}
	}
	public static void displayLeft(TreeNode root){
		if(root != null)
		{
			displayLeft(root.left);
			treeNodeMethods.displayNode(root);
		}
	}
	public static void displayRight(TreeNode root){
		if(root != null)
		{
			treeNodeMethods.displayNode(root);
			displayRight(root.left);
		}
	}

}
