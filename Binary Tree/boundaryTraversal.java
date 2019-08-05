package binaryTree;
import binaryTree.TreeNode;

public class boundaryTraversal {
	
	TreeNode root;
	
	private void printBoundary(TreeNode root)
	{
		printLeft(root);
		printLeaves(root);
		printRight(root.right);
	}
	
	private void printLeft(TreeNode temp)
	{
		if (temp == null)
			return;
		if (temp.left == null && temp.right == null)
			return;
		System.out.print(temp.data+" ");
		printLeft(temp.left);
		if(temp.left== null && temp.right!=null)
			printLeft(temp.right);
	}
	
	private void printLeaves(TreeNode temp)
	{
		if (temp == null)
			return;
		if (temp.left == null && temp.right == null)
		{
			System.out.print(temp.data+" ");
		}
		printLeaves(temp.left);
		printLeaves(temp.right);
		
	}
	
	private void printRight(TreeNode temp)
	{
		if (temp == null)
			return;
		if (temp.left == null && temp.right == null)
			return;
		printRight(temp.right);
		if (temp.right==null && temp.left!=null)
			printRight(temp.left);
		System.out.print(temp.data+" ");
	}
	
	
	public static void main(String[] args)
	{
		boundaryTraversal tree = new boundaryTraversal();
		tree.root = new TreeNode (20);
		tree.root.left = new TreeNode(8); 
        tree.root.left.left = new TreeNode(4); 
        tree.root.left.left.right = new TreeNode(9);
        tree.root.left.left.right.left = new TreeNode(16);
        tree.root.left.right = new TreeNode(12); 
        tree.root.left.right.left = new TreeNode(10); 
        tree.root.left.right.right = new TreeNode(14); 
        tree.root.right = new TreeNode(22); 
        tree.root.right.left = new TreeNode(25);
        tree.root.right.left.left = new TreeNode(29);
        
        tree.printBoundary(tree.root);
	}

}
