package dice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dice.Dice2;

public class Dice2Test {
	
	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testRollN(){
		
		int tryTimes = 10000;
		int size = 10000;
		
		int n = 0;
		while(n < tryTimes){
			
			int input = size;
			int[] result = Dice2.rollN(input);
			
			//verify the all results are in [1, 6]
			for (int num : result){
				Assert.assertTrue("Number " + num + " not <= 6", num <= 6);
				Assert.assertTrue("Number " + num + " not >= 1", num >= 1);
			}
			
			n++;
		}
	}
	
	@Test
	public void testMostFrequentSum(){
		int numOfTry = 1000;
/*		for(int i = 0; i < numOfTry; i++){
			int [] result = Dice2.mostFrequentSum(2);
			Assert.assertEquals(7,result[0]);
		}*/
		
		for(int i = 0; i < numOfTry; i++){
			int [] result = Dice2.mostFrequentSum(5);
			Assert.assertTrue(result[0]==17 || result[0]==18);
		}
		
	}
	
	
	
}
