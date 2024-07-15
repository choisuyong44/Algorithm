import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int T = sc.nextInt();
		
		int a,b;
		for(int i = 1;i<T+1;i++) {
			System.out.printf("#%d %d\n",i,(sc.nextInt()+sc.nextInt())%24);
			
		}
	}
}