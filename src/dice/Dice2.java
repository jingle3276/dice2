package dice;

import java.util.*;
import java.util.Map.Entry;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Random;

/**

 * @author Ying
 *
 */
public class Dice2 {
	
	/**
	 * Question 1:
	 * Roll N: 
	 * Write a function called rollN that takes a single integer parameter N and returns an array of N integers where 
	 * the value of each integer is (randomly) between one and six. 
	 * You should call a standard random number generator to produce the values between one and six - inclusive.
	 * 
	 */
	static int[] rollN(int n) {
		int[] result = new int[n];
		Random ran = new Random();
		for (int i = 0; i < n; i++){
			int num = 1 + ran.nextInt(6); // [1, 6]
			result[i] = num;
		}
		return result;
	}
	
	/**
	 * Question 2:
	 * Most Frequent Sum
	 * It is common knowledge that if you roll two fair dice that the most frequent sum is seven. 
	 * What is the most frequent sum of five dice? 
	 * Write a method called mostFrequentSum that produces the answer to this question. 
	 * The function should take a single integer parameter and return an array of integers. 
	 * In some cases, there might be a tie for the most frequent sum hence the need to return an array 
	 * of integers. One of the test cases will call mostFrequentSum with 5 as a parameter.   
	 */
	static int[] mostFrequentSum(int n) {
		int[] result = {};
		
		//try roll a dice K times 
		int K = 100000;
		
		//use a hashtable to store a list of arrays
		Hashtable<Integer, int[]> table = new Hashtable<Integer, int[]>();
		for(int i = 0; i < n; i++){
			table.put(i, rollN(K));
		}
		
		//build a sum array storing all the sums of length K
		int[] sumArr = new int[K];
		for(int i = 0; i < K ; i++){
			int indexSum = 0;
			//do the sum
			for(int j=0 ; j < n; j++){
				indexSum += table.get(j)[i];
			}
			sumArr[i] = indexSum;
		}

		//find the most frequent sum in the sum array, key=sum, value=count
		Hashtable<Integer, Integer> countTable = new Hashtable<Integer, Integer>();
		for(int i = 0; i < sumArr.length; i++){
			if(countTable.containsKey(sumArr[i])){
				Integer count = countTable.get(sumArr[i]);
				countTable.put(sumArr[i], count + 1);
			}
			else{
				countTable.put(sumArr[i], 1);
			}
		}
 
		return findMostFequentinTable(countTable);
	}
	
	/**
	 * a helper method to find the key which has the max value in the hashtable
	 * @param table
	 * @return
	 */
	static int[] findMostFequentinTable(Hashtable<Integer, Integer> table){
		//determine max value in the table
		int max = 0;
		for(Map.Entry<Integer, Integer> entry : table.entrySet()){
			if(max < entry.getValue()){
				max = entry.getValue();
			}
		}

		ArrayList<Integer> resultList = new ArrayList<Integer>();
		for(Map.Entry<Integer, Integer> entry : table.entrySet()){
			if(entry.getValue() == max){
				resultList.add(entry.getKey());
			}
		}
		int [] result = new int[resultList.size()];
		if(resultList.size()>1){
			System.out.println(resultList.toString());
		}
		for(int i = 0; i < result.length; i++){
			result[i] = resultList.get(i);
		}
		return result;
	}
 
}
