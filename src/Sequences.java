
public class Sequences {
	public static void main(String args[]){
		number1(2, 10);
		number2(7, 10);
		number3(36, 10);
		number4(22, 10);
		number5(53, 10);
		number6(21, 10);
		number7(58, 10);
		number8(3, 10);
		number9(8, 10);
	}// End of main

	public static void number1(double starting_number, double number_of_Increment){
		System.out.println("Number 1");
		
		for(double i = 1; i <= number_of_Increment; i++){
			System.out.println(starting_number);
			starting_number /= 2;
		}
		System.out.println("\n");
	}
	
	public static void number2(double starting_number, double number_of_Increment){
		System.out.println("Number 2");
		
		for(double i = 1; i <= number_of_Increment; i++){
			System.out.println(starting_number);
			if(i % 2 == 0){
				starting_number -= 1;
			}else{
				starting_number += 2;
			}
		}
		System.out.println("\n");
	}
	
	public static void number3(double starting_number, double number_of_Increment){
		System.out.println("Number 3");
		int Switch = 0; 
		for(double i = 1; i <= number_of_Increment; i++){
			System.out.println(starting_number); 
			if(Switch == 0){
				starting_number -= 2;
				Switch = 1;
			}else{
				starting_number -= 4;
				Switch = 0;
			}
		}
		System.out.println("\n");
	}

	public static void number4(double starting_number, double number_of_Increment){
		System.out.println("Number 4");
		
		int Switch = 0; 
		for(double i = 1; i <= number_of_Increment; i++){
			System.out.println(starting_number); 
			if(Switch == 0){
				starting_number -= 1;
				Switch = 1;
			}else{
				starting_number += 2;
				Switch = 0;
			}
		}
		System.out.println("\n");
	}

	public static void number5(double starting_number, double number_of_Increment){
		System.out.println("Number 5");
		
		int Switch = 0; 
		for(double i = 1; i <= number_of_Increment; i++){
			System.out.println(starting_number); 
			if(Switch == 0){
				starting_number -= 0;
				Switch = 1;
			}else{
				starting_number -= 13;
				Switch = 0;
			}
		}
		System.out.println("\n");
	}
	
	public static void number6(double starting_number, double number_of_Increment){
		System.out.println("Number 6");
		
		int Switch = 0; 
		int diff = 12;
		for(double i = 1; i <= number_of_Increment; i++){
			System.out.println(starting_number); 
			if(Switch == 0){
				starting_number -= diff;
				Switch = 1;
			}else{
				starting_number += diff;
				diff -= 2;
				Switch = 0;
			}
		}
		System.out.println("\n");
	}
	
	public static void number7(double starting_number, double number_of_Increment){
		System.out.println("Number 7");
		
		for(double i = 1; i <= number_of_Increment; i++){
			System.out.println(starting_number); 
			starting_number -=6;
		}
		System.out.println("\n");
	}
	
	public static void number8(double starting_number, double number_of_Increment){
		System.out.println("Number 8");
		
		int Switch = 0; 
		for(double i = 1; i <= number_of_Increment; i++){
			System.out.println(starting_number); 
			if(Switch == 0){
				starting_number += 1;
				Switch = 1;
			}else{
				starting_number += 3;
				Switch = 0;
			}
		}
		System.out.println("\n");
	}
	
	public static void number9(double starting_number, double number_of_Increment){
		System.out.println("Number 9");
		
		int Switch = 0; 
		int diff = 14;
		for(double i = 1; i <= number_of_Increment; i++){
			System.out.println(starting_number); 
			if(Switch == 0){
				starting_number += diff;
				Switch = 1;
			}else{
				starting_number -= diff;
				diff += 6;
				Switch = 0;
			}
		}
		System.out.println("\n");
	}
}// End of class
