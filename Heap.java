
import java.util.ArrayList;
import java.util.NoSuchElementException;



public class Heap<T extends Comparable<T>>{
	private ArrayList<T> list;
	public Heap()
	{
		list = new ArrayList<T>();
	}
	
	private void percolateup()
	{
		int k = list.size()-1;
		while(k>0)
		{
			int p = (k-1)/2;
			T item = list.get(k);
			T parent = list.get(p);
			if (item.compareTo(parent)>0)
			{
				list.set(k, parent);
				list.set(p, item);
				
				k=p;
			}
			else
			{
				break;
			}
		}
	}
	
	public void insert (T item)
	{
		list.add(item);
		percolateup();
	}
	
	private void percolatedown()
	{
		int k = 0;
		int l = (2*k +1);
		while (l<list.size())
		{
			int max = l;
			int right = max+1;
			
			if (right<list.size())
			{
				if (list.get(max).compareTo(list.get(right))<0)
				{
					max = right;
				}
			}
			if (list.get(k).compareTo(list.get(max))<0)
			{
				T temp = list.get(k);
				list.set(k, list.get(max));
				list.set(max, temp);
				k=max;
				l = (2*k+1);
			}
			else
			{
				break;
			}
		}
	}
	
	public T delete()
	{
		if (list.size() == 0)
			System.out.println("No such element found");
		if (list.size() == 1)
			return list.remove(0);
		else
		{
			T hold = list.get(0);
			list.set(0, list.remove(list.size()-1));
			percolatedown();
			return hold;
		}
		
	}
	
	public int size()
	{
		return list.size();
	}
	
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	
	public String toString()
	{
		return list.toString();
	}
	
	public static void main(String[] args)
	{
		Heap<Integer> hp = new Heap<>();
		for (int i=3; i<10; i++)
			hp.insert(i);
		System.out.println(hp);
		System.out.println(hp.delete());
		System.out.println(hp);
		hp.delete();
		hp.delete();
		hp.delete();
		System.out.println(hp);
		hp.delete();
		System.out.println(hp);
		hp.delete();
		System.out.println(hp);
		hp.delete();
		System.out.println(hp);
		
	}
	

}
