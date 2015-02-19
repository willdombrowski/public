import java.util.Scanner;

public class HackerRank1 {

	//sample input 15
	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
		
		printNumbers(n);

	}
	
	private static void printNumbers(int endNumber){
		int beginNumber = 1;
		printNumbers(beginNumber, endNumber);
	}

	private static void printNumbers(int beginNumber, int endNumber) {
		for(int i = beginNumber; i<=endNumber; i++){
			if(i%3==0 && i%5==0){
				System.out.println("FizzBuzz");
			} else if(i%3==0){
				System.out.println("Fizz");
			} else if(i%5==0){
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
		
	}

}
