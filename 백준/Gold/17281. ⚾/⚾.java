import java.io.*;
import java.util.*;

public class Main {

	static int N;

	static int[][] player;
	static boolean[] visit;
	static int[] orderedPlayer;
		
	static boolean[] ground;

	static int round_score;
	static int final_score;
	static int outCount;
	static int score;

	static int recurCnt =0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		// 구하고자하는 최종 스코어
		final_score = 0;

		// player 배열 생성
		player = new int[10][N];
		visit = new boolean[10];

		orderedPlayer = new int[9];

		for (int i = 0; i < N; i++) {

			round_score = 0;

			// 선수 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				// player 정보 입력
				player[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 순열
		perm(0);

		System.out.println(final_score);
	}

	// player 순서 정하기 순열
	public static void perm(int depth) {
		if (depth == 9) {
			playGame();
			return;
		}
		
		if(depth==3) {
			orderedPlayer[depth] = 1;
			perm(depth+1);
			return;
		}
		
        for (int i = 2; i <= 9; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                orderedPlayer[depth] =i;
                perm(depth + 1);
                visit[i] = false;
            }
        }
	}

	public static void playGame() {
		score = 0;int round = 0;
		outCount = 0;
		ground = new boolean[4];

		for (int j = 0; j < 9; j++) {
			playground(player[orderedPlayer[j]][round]);
			
			if(j==8) j = -1;
			
			if (outCount == 3) {
				ground = new boolean[4];
				round++;
				outCount = 0;
				
				if(round == N) {
					break;
				}
			}
		}
		
		final_score =  Math.max(score, final_score);
	}

	public static void playground(int k) {
		// 모든 주자를 옮겨놓고, 타자를 옮김

		// [3] [2] [1] 사용
		// out이 아닐 때
		if (k != 0) {
			for (int i = 3; i >= 1; i--) {

				// 사람이 있을 때
				if (ground[i] == true) {

					// 홈으로 들어온 경우
					if (i + k > 3) {
						score++;
					}

					// 홈으로 아직 안들어온 경우
					else {
						ground[i + k] = true;
					}

					// 해당 위치 비우기
					ground[i] = false;
				}
			}

			// 1,2,3 루
			if (k <= 3)
				ground[k] = true;

			// 홈런
			else
				score++;
		}

		// out 일떄
		else if (k == 0) {
			outCount++;
		}
	}
}