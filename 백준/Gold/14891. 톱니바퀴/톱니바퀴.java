import java.io.*;
import java.util.*;

public class Main {
	static int[][] wheel;

	public static void selectCircuit(int w, int i) {
		if (i == 1) {
			clock(w);
		} else {
			oppositeClock(w);
		}
	}

	public static void oppositeClock(int wheelNumber) {
		wheelNumber = wheelNumber-1;
		int tmp = wheel[wheelNumber][0];

		for (int i = 0; i < 7; i++) {
			wheel[wheelNumber][i] = wheel[wheelNumber][i + 1];
		}

		wheel[wheelNumber][7] = tmp;
	}

	public static void clock(int wheelNumber) {
		wheelNumber = wheelNumber - 1;
		int tmp = wheel[wheelNumber][7];

		for (int i = 6; i >=0; i--) {
			wheel[wheelNumber][i + 1] = wheel[wheelNumber][i];
		}

		wheel[wheelNumber][0] = tmp;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		wheel = new int[4][8];

		String s;
		for (int i = 0; i < 4; i++) {
			s = br.readLine();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = s.charAt(j) - '0';
			}
		}

		// K 번 횟수, 돌리는 방향 입력 // -1 : 반시계 1 : 시계
		int k = Integer.parseInt(br.readLine());

		// K번 반복
		// [0][2]-[1][6] , [1][2]-[2,6] , [2,2]-[3,6] , [3,2]-[4,6]
		// 이 같은 지 다른 지 비교해서 돌리기
		// 시계 방향 -> removeLast addFirst
		// 반시계 방향 -> removeFirst addLast;
		int w;
		int d;
		StringTokenizer st;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			// 연쇄적으로 돌리기
			wheel(w,d);
		}

		// 최종적으로 각 바퀴별 0번째 인덱스 가져오기
		int sum = 0; int digit =1;
		for(int i =0;i<4;i++) {
			
			if(wheel[i][0]==1) {
				sum+= digit;
			}
			digit *=2;
		}
		
		System.out.println(sum);
	}

	public static void wheel(int w, int d) {
		int[] check = new int[3];
		// [0][2]-[1][6] , [1][2]-[2,6] , [2,2]-[3,6] , [3,2]-[4,6]
		for (int i = 0; i < 3; i++) {
			if (wheel[i][2] != wheel[i + 1][6]) {
				check[i] = 1;
			}
		}
		if (w == 1) {
			selectCircuit(w, d);

			for (int i = 0; i < 3; i++) {
				if (check[i] == 1) {
					w++;
					d *= -1;
					selectCircuit(w, d);
				} else {
					break;
				}
			}
		}

		else if (w == 2 || w == 3) {
			if(w==2) {
				selectCircuit(w, d);
				
				if(check[0]==1) {
					selectCircuit(1,-d);
				}
				
				for (int i = 1; i <3; i++) {
					if (check[i] == 1) {
						w++;
						d *= -1;
						selectCircuit(w, d);
					} else {
						break;
					}
				}
			}
			
			else if(w==3) {
				selectCircuit(w, d);
				
				if(check[2]==1) {
					selectCircuit(4,-d);
				}
				
				for (int i = 1; i >= 0; i--) {
					if (check[i] == 1) {
						w--;
						d *= -1;
						selectCircuit(w, d);
					} else {
						break;
					}
				}
			}
		}

		else if (w == 4) {
			selectCircuit(w, d);

			for (int i = 2; i >= 0; i--) {
				if (check[i] == 1) {
					w--;
					d *= -1;   
					selectCircuit(w, d);
				} else {
					break;
				}
			}
		}
	}
}