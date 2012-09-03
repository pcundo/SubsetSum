package SubsetSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SubsetSum {
	
	/**
	 * Subset sum algorithm. 
	 * Running time: O((2^n) *n)
	 * 2^n because there's total 2^n subsets including the empty set.
	 * And for each set it takes n to add up all the sum.
	 * The problem is np-complete. It can be verified in polynomial time.
	 * @param args
	 */
	public static void main(String [] args){
		Set<Integer> current_set = new HashSet<Integer>();
		
		Set<Integer> set = new HashSet<Integer>();
		
		set.add(-7);
		set.add(-3);
		set.add(-2);
		set.add(5);
		set.add(8);
		
		subset(current_set, set, 0); 
	}
	
	/**
	 * Generate all the possible subset and check if the set add up to zero.
	 * @param current_set
	 * @param set
	 * @param target
	 */
	public static void subset(Set<Integer> current_set, Set<Integer> set, int target){
		if(!set.isEmpty()){
			
			int temp = set.iterator().next();
			
			Set<Integer> saved_current_set = new HashSet<Integer>(current_set);
			Set<Integer> saved_set = new HashSet<Integer>(set);
			
			current_set.add(temp);
			
			set.remove(temp);
			
			addSum(current_set, target);
			
			
			subset(current_set, set, target);
			
			saved_set.remove(temp);
			subset(saved_current_set, saved_set, target);
			
		}
	}
	
	/**
	 * Print a set that its sum equals to the target. 
	 * @param current_set
	 * @param target
	 */
	public static void addSum(Set<Integer> current_set, int target){
		Iterator<Integer> i = current_set.iterator();
		ArrayList<Integer> set = new ArrayList<Integer>();
		int sum = 0;
		int current = 0;
		while(i.hasNext()){
			current = i.next();
			sum += current;
			set.add(current);
		}
		if(sum == target){
			System.out.println(Arrays.toString(set.toArray()));
		}
	}
	
	public static void print(Set<Integer> current_set){
		Iterator<Integer> i = current_set.iterator();
		while(i.hasNext()){
			System.out.print(i.next() + " ");
		}
		System.out.println();
	}
}
