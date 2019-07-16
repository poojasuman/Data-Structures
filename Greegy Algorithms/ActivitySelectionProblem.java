package greedy_algorithms;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.*;

public class ActivitySelectionProblem {
	
	private void sortActivityByFinishTime(int[] start, int[] finish, int n)
	{
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i=0;i<n;i++)
		{
			map.put(finish[i], start[i]);
		}
		int count=0;
		for (Map.Entry<Integer,Integer> entry: map.entrySet())
		{
		finish[count] = entry.getKey();
		count++;
		}
		count = 0;
		for (Map.Entry<Integer,Integer> entry : map.entrySet())
		{
			start[count] = entry.getValue();
			count++;
		}
		
	}
	
	private void select_activity(int[] start, int[] finish, int n)
	{
		if (start.length!=finish.length || n==0)
			return;
		
		sortActivityByFinishTime(start, finish, n);
		for (int i=0;i<n;i++)
			System.out.print("["+ start[i]+" "+ finish[i] + "]");
		List<Integer> list = new ArrayList<>();
		int i=0; 
		list.add(0);
		for (int j=1;j<n;j++)
		{
			if (start[j]>=finish[i])
			{
				list.add(j);
				i++;
			}
		}
		
		System.out.println("Activities chosen are : " + list);
	}
	
	
	
	public static void main(String[] args)
	{
		ActivitySelectionProblem ob = new ActivitySelectionProblem();
		
		System.out.println("Enter the number of activities: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] start = new int[n];
		System.out.println("Enter the elements in start time array:");
		for (int i=0;i<n;i++)
		{
			start[i] = sc.nextInt();
		}
		
		int[] finish = new int[n];
		System.out.println("Enter the elements in finish time array:");
		for (int i=0;i<n;i++)
		{
			finish[i] = sc.nextInt();
		}
		
		ob.select_activity(start,finish,n);
		
	}

}
