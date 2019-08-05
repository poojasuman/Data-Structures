package binaryTree;


/* 
 Given Inorder Traversal of a Special Binary Tree in which key of every node is greater than 
 keys in left and right children, construct the Binary Tree and return root.
 
Input: inorder[] = {5, 10, 40, 30, 28}
Output: root of following tree
         40
       /   \
      10     30
     /         \
    5          28 
 
 */

public class spclTreeFromInorder {
	
	private void inorder(TreeNode root)
	{
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	private int findMax(int[] inorder, int start, int end)
	{
		int max = start;
		for (int i=start;i<=end;i++)
		{
			if (inorder[i]>inorder[max])
				max = i;
		}
		return max;
	}
	
	private TreeNode builtTree(int[] inorder, int start, int end)
	{
		
		if (start>end)
			return null;
		int index = findMax(inorder, start, end);
		TreeNode root = new TreeNode(inorder[index]);
		if (start == end)
			return root;
		root.left = builtTree(inorder, start, index-1);
		root.right = builtTree(inorder, index+1, end);
		
		
		return root;
		
		
	}
	
	public static void main(String[] args)
	{
		spclTreeFromInorder ob = new spclTreeFromInorder();
		int inorder[] = new int[] {1, 5, 10, 40, 30,15, 28, 20};
		int size = inorder.length;
		TreeNode root = ob.builtTree(inorder, 0, size-1);
		ob.inorder(root);
	}

}
