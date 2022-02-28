package NumberRangeSummarizer;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class TestNumberList {

	@Test
	public void collect() throws Exception{
		NumberRangeSummarizer val = new NumberList();
		Collection<Integer> testList = Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31);
		String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
		Collection<Integer> list = val.collect(input);
		assertArrayEquals(list.toArray(),testList.toArray());
		
	}
	
	@Test
	public void summarize() throws Exception {
	
		NumberRangeSummarizer val  = new NumberList();
		String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
		String compare = "1, 3, 6-8, 12-15, 21-24, 31";
		Collection<Integer> output = val.collect(input);
		String Result = val.summarizeCollection(output);
		assertEquals(compare, Result);
		
	}
	
	@Test
	public void sequential() throws Exception{
		NumberRangeSummarizer val  = new NumberList();
		String input = "1,3,4,5,5,7,8,9,10,11";
		String compare = "1, 3-5, 7-11";
		Collection<Integer> output = val.collect(input);
		String Result = val.summarizeCollection(output);
		assertEquals(Result, compare);
		
	}
	
	@Test
	public void duplicate() throws Exception{
		
		NumberRangeSummarizer val  = new NumberList();
		String input = "1,3,3,5,5,7,9,11,12,12,13,14,16";
		String compare = "1, 3, 5, 7, 9, 11-14, 16";
		Collection<Integer> output = val.collect(input);
		String Result = val.summarizeCollection(output);
		assertEquals(Result, compare);
	}
	
	@Test
	public void order() throws Exception{
		
		NumberRangeSummarizer val  = new NumberList();
		String input = "1,11,5,4,5,9,8,7,10,3" ;
        String compare = "1, 3-5, 7-11";
        Collection<Integer> output = val.collect(input);
        String Result = val.summarizeCollection(output);
        assertEquals(Result, compare);
        
	
	}
	
	@Test
	public void negative() throws Exception{
		
		NumberRangeSummarizer val  = new NumberList();
		String input = "-8,-6,-1,1,4,5,6,7,8,9,13";
        String compare= "-8, -6, -1, 1, 4-9, 13";
        Collection<Integer> output = val.collect(input);
        String Result = val.summarizeCollection(output);
        assertEquals(Result, compare);
	}
	

}
