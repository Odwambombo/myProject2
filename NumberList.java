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
		 
		 String new_input = input.toString();
		 String str = new_input.replaceAll("\\[(.*?)\\]", "$1");
		 str = str.replaceAll("\\s+", "");
		 
		 int[] a = Arrays.stream(str.split(",")).map(Integer::parseInt).mapToInt(i -> i).toArray();
		 
		 int count=0;
		 int start=a[0];
		 String temp=""+a[0];
		 int end=a[0];
		 
		 for (int i = 0; i <a.length -1; i++){
			 if (a[i + 1] == a[i]+1){
				 
				 if (count == 0){
					 start= a[i];
				 }
				 end = a[i+1];
				 count++;
				 }
			 
			 
			 else {
				 if (count>0){
					 count = 0;
					 temp = start+ "-"+ end;
				 }
				 finalstring = finalstring + temp+ ", ";
				 temp= ""+(a[i+1]);
				 
			 }
		 }
		 
		 if (count>0){
			 temp = start + "-" + end;
		 }
		 
		 finalstring = finalstring + temp;
		 return finalstring;
	}
	 
}