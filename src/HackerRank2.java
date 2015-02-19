
import java.util.ArrayList;
import java.util.Scanner;

public class HackerRank2 {

	//sample input 1,6
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		ArrayList<Integer> nQueue = new ArrayList<Integer>();
		for (int i = 0; i < t; i++)
			nQueue.add(sc.nextInt());

		for(int j =0; j<t;j++){
			int n = nQueue.get(j);
			counterGame(n);
		}

	}

	private static void counterGame(int startNumber) {
		// Louise goes first, Richard plays second
		int turnCount = 0; // Richard wins turn 0 or evens, Louise wins turn 1
							// and odds
		double currentNumber = ((Integer) startNumber).doubleValue();
		while (currentNumber > 1) {

			int doublerValue = 2;

			while (doublerValue <= (currentNumber / 2.0)) {
				doublerValue *= 2;
			}

			System.out.println(turnCount + ": DoublerValue: " + doublerValue+ " Current Number: " + currentNumber);
			if (currentNumber == doublerValue) {
				currentNumber /= 2.0;
			} else {
				currentNumber -= doublerValue;
			}

			turnCount++;
		}

		System.out.println("End turn count: " + turnCount + " Current Number: "+ currentNumber);
		String winner = "Louise";
		if (turnCount % 2 == 0) {
			winner = "Richard";
		}

		System.out.println(winner);
	}

}
