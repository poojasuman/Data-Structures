package binaryTree;

class Node
{
	char data;
	Node left,right;
	Node(char a)
	{
		data = a;
		left = right = null;
	}
}

public class terExpressionToBinTree {
	
	static int count = 0;
	
	private void printTree(Node root)
	{
		if(root == null)
			return;
		printTree(root.left);
		System.out.print(root.data+" ");
		printTree(root.right);
	}
	
	private Node convert(String str)
	{
		if (count>=str.length())
			return null;
		Node root = new Node (str.charAt(count++));
		if (count<str.length() && str.charAt(count) == '?')
		{
			count++;
			root.left = convert(str);
			if (count<str.length() && str.charAt(count) == ':')
			{
				count++;
				root.right = convert(str);
			}
		}
		
		return root;
	}
	
	
	public static void main(String[] args)
	{
		terExpressionToBinTree ob = new terExpressionToBinTree();
		String str = "a?b?c:d:e";
		Node root = ob.convert(str);
		ob.printTree(root);
		
		
	}

}
