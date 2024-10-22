/*John Raven F. Caduyac
 * Chapter 01: Java Basics Variables, Operators, Control Flows
 * Exercise 01: Mean, Median, and Mode Calculator
 * */

package mmmcalculator;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declare the variables
		int[] numbers = new int[5];
		float mean = 0;
		int mode, median, max_count = 0, num_count = 0, current_max_num =0;
		Scanner sc = new Scanner(System.in);
		
		//This code right here gets input from the user
		System.out.println("=== [Mean Median Mode Calculator] ===");
		for(int i = 0; i<numbers.length; i++) {
			//try catch statement for catching errors from user input
			try {
				System.out.print("Enter Number #"+i+":");
				numbers[i] = sc.nextInt();
				//computing already for the mean while getting every input
				mean = mean + numbers[i];
			}
			catch(Exception e){
				System.out.println("Invalid Input");
				i = i - 1;
			}
		}
		
		// this code right here is for sorting. The algorithm used is selection sort
		int temp_num = 0, sort_count = 0;
		while(sort_count != 4) {
			sort_count = 0;
			for(int i = 0; i<numbers.length; i++) {
				if(i!=(numbers.length-1)) {
					if(numbers[i]<=numbers[i+1]) {
						sort_count = sort_count + 1;
					}
					else {
						temp_num = numbers[i];
						numbers[i] = numbers[i+1];
						numbers[i+1] = temp_num;
					}
				}
			}
		}
		// code for getting the mean in float and median
		mean = (float) mean/5;
		median = numbers[2];
		
		//this the code for getting the mode
		for(int i = 0; i<numbers.length; i++) {
			for(int j = 0; j<numbers.length; j++) {
				if(numbers[j]==numbers[i]) {
					num_count = num_count + 1;
				}
			}
			if(num_count>max_count) {
				current_max_num = numbers[i];
				max_count = num_count;
				num_count = 0;
			}
		}
		
		mode = current_max_num;
		//print out the results
		System.out.println("============ [Results] =============");
		System.out.print("Array: ");
		for(int i = 0; i<numbers.length; i++) {
			System.out.print(numbers[i]+", ");
		}
		System.out.println();
		System.out.println("Mean: "+mean);
		System.out.println("Median: "+median);
		//Just added this code so I can get the bonus for the part where there are no modes scenario
		if(max_count == 1) {
			System.out.println("Mode: There are no modes");
		}
		else {
			System.out.println("Mode: "+mode);
		}
		
		//I just fixed the warning of leading to resource leak of not closing the scanner
		sc.close();
		
	}

}
