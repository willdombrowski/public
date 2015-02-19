import java.util.ArrayList;
import java.util.Scanner;


public class HackerRank3 {

	//sample input 5
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		
		String binary = Integer.toBinaryString(n);
		
		int oneCount =0;
		
		ArrayList<Integer> onePosList = new ArrayList<Integer>(); 
		int posCount = 1;
		for(int i = binary.length()-1; i >= 0; i--){
			if(binary.charAt(i)=='1'){
				onePosList.add(binary.length()-i);
				oneCount++;
				
			}
			posCount++;
		}
		
		System.out.println(oneCount);
		for (Integer integer : onePosList) {
			System.out.println(integer);
		}

	}

}
