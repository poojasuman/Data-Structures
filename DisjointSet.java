
public class DisjointSet {
	
	int n;
	int[] parent, rank;
	
	public DisjointSet(int n)
	{
		this.n = n;
		parent = new int[n];
		rank = new int[n];
		makeSet();
	}
	
	private void makeSet()
	{
		for (int i=0; i<n; i++)
		{
			parent[i] = i;
			rank[i] = 0;
		}
	}
	
	private int find(int x)
	{
		if (x>=n)
			return -1;
		if (parent[x] == x)
			return x;
		else
		{
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	private void union(int x, int y)
	{
		int xroot = this.find(x);
		int yroot = this.find(y);
		
		if(xroot == yroot)
			return;
		else if (rank[xroot]<rank[yroot])
		{
			parent[xroot] = yroot;
			return;
		}
		else if (rank[yroot]<rank[xroot])
		{
			parent[yroot] = xroot;
			return;
		}
		else
		{
			// when (rank of xroot equals rank of yroot
			parent[yroot] = xroot;
			rank[xroot]+=1;
		}
	}
	
	private void printArray()
	{
		for (int i=0;i<parent.length;i++)
		{
			System.out.print(parent[i]+" ");
		}
		System.out.println();
		for (int i=0;i<rank.length;i++)
		{
			System.out.print(rank[i]+" ");
		}
		System.out.println();
	}
	
	public static void main (String[] args)
	{
		DisjointSet ob = new DisjointSet(5);
		ob.union(0,2);
		ob.union(4,2);
		ob.union(3,1);
		
		ob.printArray();
		
	}

}
