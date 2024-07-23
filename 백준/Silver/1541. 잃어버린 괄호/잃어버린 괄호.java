import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stMinus;
		String s = br.readLine();

		stMinus = new StringTokenizer(s, "-");
		
		
		int sum =0;
		String onlyPlusOrNot = stMinus.nextToken();
		StringTokenizer firstBlock = new StringTokenizer(onlyPlusOrNot, "+");
		while(firstBlock.hasMoreTokens()) {
			sum += Integer.parseInt(firstBlock.nextToken());
		}
		
		while(stMinus.hasMoreTokens()) {
			
			onlyPlusOrNot = stMinus.nextToken();
			firstBlock = new StringTokenizer(onlyPlusOrNot, "+");
			int middleSum =0;
			while(firstBlock.hasMoreTokens()) {
				middleSum += Integer.parseInt(firstBlock.nextToken());
			}
			sum -= middleSum;
		}
		
		System.out.println(sum);
	}
}