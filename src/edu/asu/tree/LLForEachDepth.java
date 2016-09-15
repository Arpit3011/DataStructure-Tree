package edu.asu.tree;

import java.util.LinkedList;
import java.util.ArrayList;

public class LLForEachDepth {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8};
		int length = arr.length;
		TreeNode root = CreateBST.createBinarySearchTree(arr, 0, length - 1);
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		ArrayList<LinkedList<TreeNode>> solution1 = LLforDepthDFS(root, lists, 0);
		ArrayList<LinkedList<TreeNode>> solution2 = LLforDepthBFS(root);

		printAllList(solution1);
		System.out.println();
		printAllList(solution2);

	}

	public static void printAllList(ArrayList<LinkedList<TreeNode>> solution1) {
		for (LinkedList<TreeNode> sol1 : solution1) {
			System.out.print("List at each Depth: ");
			for (TreeNode nodes : sol1) {
				System.out.print("[" + nodes.data + "]");
			}
			System.out.println();
		}
	}

	public static ArrayList<LinkedList<TreeNode>> LLforDepthDFS(TreeNode root, ArrayList<LinkedList<TreeNode>> lists,
			int level) {

		if (root == null)
			return null;
		LinkedList<TreeNode> list;
		if (lists.size() == level) {
			list = new LinkedList<TreeNode>();
			lists.add(list);
		} else
			list = lists.get(level);

		list.add(root);
		LLforDepthDFS(root.left, lists, level + 1);
		LLforDepthDFS(root.right, lists, level + 1);
		return lists;
	}

	public static ArrayList<LinkedList<TreeNode>> LLforDepthBFS(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if (root != null)
			current.add(root);

		while (current.size() > 0) {
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for (TreeNode parent : parents) {
				if (parent.left != null)
					current.add(parent.left);
				if (parent.right != null)
					current.add(parent.right);
			}
		}
		return result;
	}
	
}
