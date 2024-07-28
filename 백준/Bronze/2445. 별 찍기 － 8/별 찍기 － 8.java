import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int j;int k;int m;
		for(int i =1;i<N+1;i++) {
			for(j =0 ;j<i;j++) {
				System.out.print("*");
			}
			for(k =0;k<2*(N-i);k++) {
				System.out.print(" ");
			}
			for(m =j+k;m<2*N;m++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i =1;i<N;i++) {
			int tmp = N-i;
			for(j=tmp;j>0;j--) {
				System.out.print("*");
			}
			for(k = 0;k<2*i;k++) {
				System.out.print(" ");
			}
			for(m = k+tmp;m<2*N;m++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}