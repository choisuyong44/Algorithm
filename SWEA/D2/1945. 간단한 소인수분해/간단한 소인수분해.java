import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c, d, e;
		int n = sc.nextInt();
		a = b = c = d = e = 0;
		int k; 
		for (int i = 1; i < n + 1; i++) {
			a = 0;
			b = 0;
			c = 0;
			d = 0;
			e = 0;
			k = sc.nextInt();
			
			while (k % 2 == 0 && k !=0) {
					a++;
					k /= 2;
			}
			
			while (k % 3 == 0 && k !=0) {
					b++;
					k /= 3;
			}
			
			while (k % 5 == 0 && k !=0) {
					c++;
					k /= 5;
			}
			while (k % 7 == 0 && k !=0) {
					d++;
					k /= 7;
			}
			while (k % 11 == 0 && k !=0) {
					e++;
					k /= 11;
			}
			System.out.printf("#%d %d %d %d %d %d",i,a,b,c,d,e);
			System.out.println();
		}
	}

}