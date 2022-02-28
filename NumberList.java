package NumberRangeSummarizer;

import java.util.*;

public class NumberList implements NumberRangeSummarizer {
	
	 public static void main (String [] args) {
		 boolean completed = false;
		 
		 do{
			 try{
				 System.out.println("Please enter a list of numbers:");
				 Scanner val = new Scanner(System.in);
				 String input = val.nextLine();
				 
				 NumberList obj = new NumberList();
				 Collection<Integer>output = obj.collect(input);
				 String Result = obj.summarizeCollection(output);
				 System.out.println(Result);
				 completed=true;
			 }
			 catch (Exception e) {
				 System.out.println("Incorrect Input. Please enter numbers separated by comma with no spaces");			 
			 }
		 }while(completed==false);
	 }
	 
	

	// Get input and strore in an ArrayList
	@Override
	public Collection<Integer> collect(String input) {
    Collection<Integer> sorted = new ArrayList<>();
		 
		 int [] a = Arrays.stream(input.split(",")).map(Integer::parseInt).mapToInt(i -> i).toArray();
		 Arrays.sort(a);
		 for (int s: a){
			 if(!sorted.contains(s))
				 sorted.add(s);
		 }
		 return sorted;
	 }
	 
	 @Override
	 public String summarizeCollection(Collection<Integer> input) {
		
		 String finalstring = "";
		 
		 // Removes brackets and spaces from ArrayList and convert it to a strings
		 String new_input = input.toString();
		 String str = new_input.replaceAll("\\[(.*?)\\]", "$1");
		 str = str.replaceAll("\\s+", "");
		 
		 // Coverts String to an Array by separating the values by a comma
		 int[] a = Arrays.stream(str.split(",")).map(Integer::parseInt).mapToInt(i -> i).toArray();
		 
		 int count=0; // counter that keeps track of how many numbers are sequential
		 int start=a[0]; //first value of a sequential pattern
		 String temp=""+a[0]; //String that stores the current pattern
		 int end=a[0]; // Last value of sequential pattern
		 
		 for (int i = 0; i <a.length -1; i++){
			 //check  if value is sequential
			 if (a[i + 1] == a[i]+1){
				 
				 if (count == 0){
					 start= a[i];
				 }
				 end = a[i+1];
				 count++;
				 }
			 
			 // Else value is not sequential
			 else {
				
				 if (count>0){
					 count = 0;
					 temp = start+ "-"+ end;
				 }
				 finalstring = finalstring + temp+ ", ";
				 temp= ""+(a[i+1]);
				 
			 }
		 }
		 // check if final value is part of a sequential pattern
		 if (count>0){
			 temp = start + "-" + end;
		 }
		 
		 finalstring = finalstring + temp;
		 return finalstring;
	}
	 
}
