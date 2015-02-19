import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class HackerRank4 {
	
	//sample input 10,3,5,2,4 <enter> //sample output 4
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in)); 
        String line; 

        ArrayList<Integer> paramList = new ArrayList<Integer>();
        while ((line = stdin.readLine()) != null && line.length()!= 0) { 
        
        	try{
        		int param = Integer.parseInt(line);
        		paramList.add(param);
        	}catch(Exception ex){
        		
        	}
        
        }
        
        int n = paramList.remove(0);
        int k = paramList.remove(0);
        Integer[] jumpNumbersArray = paramList.toArray(new Integer[paramList.size()]);
        
        
       int res= countUneatenLeaves(n, jumpNumbersArray);
       System.out.println(res);
        
        
    }
    
    private static int countUneatenLeaves(int N, Integer[] A) {

    	int uneatenCount = N;
    	for (int i=0; i < N; i++){
    		boolean isEatenByOne = false;
    		for(int j=0;j<A.length;j++){
    			if(i%A[j]==0)
    				isEatenByOne=true;
    		}
    		if(isEatenByOne)
    			uneatenCount--;
    	}
		
		return uneatenCount;
	}
}