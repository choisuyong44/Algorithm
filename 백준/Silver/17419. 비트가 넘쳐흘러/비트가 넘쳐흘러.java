import java.io.IOException;
import java.util.Scanner;

public class Main {

	/*
	 * K & K의 2의보수 -> K의 이진수 중 가장 오른쪽에 있는(가장 작은) 1
	 * 가장 오른쪽에 있는 1을 하나씩 제거해가는 연산	
	 * 1의 갯수를 세면 끝난다.	
	 */
	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String s = sc.next();
		
		int cnt = 0;
		for(char c : s.toCharArray()) {
			if(c=='1') cnt++;
		}

		System.out.println(cnt);
	}
}